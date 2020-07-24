package eu.cubix.mc.hub.task;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.queue.AvantageQueue;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AvantageQueueTask extends BukkitRunnable {

    private int timer;
    private final AvantageQueue queue;

    public AvantageQueueTask(AvantageQueue queue) {
        this.queue = queue;
        this.timer = queue.getTimer();
    }

    @Override
    public void run() {

        if(timer == 0){
            for(Player player : queue.getPlayers().keySet()){
                int place = queue.getPlayers().get(player);
                if(place == 0){
                    player.sendMessage("§eCubixMC §6» §eConnexion au serveur en cours... §6(§e" + queue.getName() +"§6)");
                    queue.getPlayers().remove(player);
                    teleport(player, queue.getName());
                    break;
                }
            }
            for(Player player : queue.getPlayers().keySet()){
                int currentPlace = queue.getPlayers().get(player);
                queue.getPlayers().put(player, currentPlace - 1);

            }
            timer = 1;
        }

        if(queue.getPlayers().size() == 0){
            this.cancel();
        }

        timer--;
    }


    private void teleport(Player player, String server){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());
    }
}
