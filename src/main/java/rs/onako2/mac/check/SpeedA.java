package rs.onako2.mac.check;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPositionAndRotation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpeedA {
    public static void checkSpeedA(PacketReceiveEvent event) {
        WrapperPlayClientPlayerPositionAndRotation wrapper = new WrapperPlayClientPlayerPositionAndRotation(event);
        Player user = event.getPlayer();
        // deltas
        Location userLocation = user.getLocation();
        com.github.retrooper.packetevents.protocol.world.Location newLocationRaw = wrapper.getLocation();
        Location newLocation = new Location(user.getWorld(), newLocationRaw.getX(), newLocationRaw.getY(), newLocationRaw.getZ(), userLocation.getYaw(), userLocation.getPitch());
        double deltaX = newLocation.getX() - userLocation.getX();
        double deltaY = newLocation.getY() - userLocation.getY();
        double deltaZ = newLocation.getZ() - userLocation.getZ();
        //System.out.println("Delta X: " + deltaX + " Delta Y: " + deltaY + " Delta Z: " + deltaZ);
        if (Math.abs(deltaX) > 1.4 || Math.abs(deltaY) > 4 || Math.abs(deltaZ) > 1.4) {
            //System.out.println("Flagged");
            user.sendMessage("You have been flagged for speed!");
        }
    }
}
