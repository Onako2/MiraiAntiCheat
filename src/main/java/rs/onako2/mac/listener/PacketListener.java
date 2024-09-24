package rs.onako2.mac.listener;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import org.bukkit.entity.Player;

public class PacketListener implements com.github.retrooper.packetevents.event.PacketListener {
    @Override
    public void onPacketReceive(PacketReceiveEvent event) {
        if (event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION || event.getPacketType() == PacketType.Play.Client.PLAYER_POSITION_AND_ROTATION) {
            Player user = event.getPlayer();
            if (user.isFlying()) {
                return;
            }
            rs.onako2.mac.check.SpeedA.checkSpeedA(event);
            rs.onako2.mac.check.FastClimbA.checkFastClimbA(event);
            rs.onako2.mac.check.HighJumpA.checkHighJumpA(event);
        }
    }
}
