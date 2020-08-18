package eu.cubix.mc.hub.task;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.queue.Queue;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class QueueTask extends BukkitRunnable {

    private final Main main;
    private int timer;
    private final Queue queue;

    public QueueTask(Main main, Queue queue) {
        this.main = main;
        this.queue = queue;
        this.timer = queue.getTimer();
    }

    @Override
        public void run() {
           
            if(timer == 0){
                for(Player player : queue.getPlayers().keySet()){
                    int place = queue.getPlayers().get(player);
                    if(place == 0){
                        queue.getPlayers().remove(player);
                        teleport(main, player, queue.getName());
                        break;
                    }
                }
                for(Player player : queue.getPlayers().keySet()){
                    int currentPlace = queue.getPlayers().get(player);
                    queue.getPlayers().put(player, currentPlace - 1);
                    
                }
                timer = 3;
            }

            if(queue.getPlayers().size() == 0){
                this.cancel();
            }

            timer--;            
        }


        private void teleport(Main main, Player player, String server){
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Connect");
            out.writeUTF(server);
            player.sendPluginMessage(main, "BungeeCord", out.toByteArray());
    }

}
