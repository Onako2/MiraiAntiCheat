package rs.onako2.mac.check;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerPositionAndRotation;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class HighJumpA {
    public static void checkHighJumpA(PacketReceiveEvent event) {
        WrapperPlayClientPlayerPositionAndRotation wrapper = new WrapperPlayClientPlayerPositionAndRotation(event);
        Player user = event.getPlayer();
        // deltas
        Location userLocation = user.getLocation();
        com.github.retrooper.packetevents.protocol.world.Location newLocationRaw = wrapper.getLocation();
        Location newLocation = new Location(user.getWorld(), newLocationRaw.getX(), newLocationRaw.getY(), newLocationRaw.getZ(), userLocation.getYaw(), userLocation.getPitch());
        double deltaY = newLocation.getY() - userLocation.getY();
        if (deltaY > 1.5) {
            user.sendMessage("You have been flagged for highjump!");
        }
    }
}
