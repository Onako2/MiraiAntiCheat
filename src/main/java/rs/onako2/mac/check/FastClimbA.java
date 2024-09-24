package rs.onako2.mac.check;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPositionAndRotation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class FastClimbA {
    public static void checkFastClimbA(PacketReceiveEvent event) {
        WrapperPlayClientPlayerPositionAndRotation wrapper = new WrapperPlayClientPlayerPositionAndRotation(event);
        Player user = event.getPlayer();

        // deltas
        Location userLocation = user.getLocation();
        if (userLocation.getBlock().getType() != org.bukkit.Material.LADDER && userLocation.getBlock().getType() != org.bukkit.Material.VINE) {
            return;
        }

        com.github.retrooper.packetevents.protocol.world.Location newLocationRaw = wrapper.getLocation();
        Location newLocation = new Location(user.getWorld(), newLocationRaw.getX(), newLocationRaw.getY(), newLocationRaw.getZ(), userLocation.getYaw(), userLocation.getPitch());
        double deltaY = newLocation.getY() - userLocation.getY();
        System.out.println(" Delta Y: " + deltaY);
        if (deltaY > 0.8 || deltaY < -0.7) {
            //System.out.println("Flagged");
            user.sendMessage("You have been flagged for fast climb!");
        }
    }
}
