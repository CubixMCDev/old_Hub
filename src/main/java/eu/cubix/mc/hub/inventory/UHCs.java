package eu.cubix.mc.hub.inventory;

import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.queue.Queue;
import eu.cubix.mc.hub.queue.VIPQueue;
import eu.cubix.mc.hub.queue.VIPplusQueue;
import eu.cubix.mc.hub.task.QueueTask;
import eu.cubix.mc.hub.task.VIPQueueTask;
import eu.cubix.mc.hub.task.VIPplusQueueTask;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class UHCs implements GuiBuilder {

    private final Main main;

    public UHCs(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Menu » UHCs";
    }

    @Override
    public int getSize() {
        return 45;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        ItemsBuilder Separateur = new ItemsBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4)
                .setName(" ");
        inv.setItem(0,Separateur.toItemStack());
        inv.setItem(1,Separateur.toItemStack());
        inv.setItem(2,Separateur.toItemStack());
        inv.setItem(3,Separateur.toItemStack());
        inv.setItem(4,Separateur.toItemStack());
        inv.setItem(5,Separateur.toItemStack());
        inv.setItem(6,Separateur.toItemStack());
        inv.setItem(7,Separateur.toItemStack());
        inv.setItem(8,Separateur.toItemStack());
        inv.setItem(9,Separateur.toItemStack());
        inv.setItem(17,Separateur.toItemStack());
        inv.setItem(18,Separateur.toItemStack());
        inv.setItem(26,Separateur.toItemStack());
        inv.setItem(27,Separateur.toItemStack());
        inv.setItem(35,Separateur.toItemStack());
        inv.setItem(36,Separateur.toItemStack());
        inv.setItem(37,Separateur.toItemStack());
        inv.setItem(38,Separateur.toItemStack());
        inv.setItem(39,Separateur.toItemStack());
        inv.setItem(40,Separateur.toItemStack());
        inv.setItem(41,Separateur.toItemStack());
        inv.setItem(42,Separateur.toItemStack());
        inv.setItem(43,Separateur.toItemStack());

        ItemsBuilder UHCRun = new ItemsBuilder(Material.GOLDEN_APPLE)
                .setName("§6§nUHC Run")
                .setLore(Arrays.asList(" ",
                        "§eEn jeu: §60",
                        "§e» Clic gauche pour jouer",
                        " ",
                        "§eDéveloppeur: §6ZelphixSama"));;
        inv.setItem(21,UHCRun.toItemStack());

        ItemsBuilder DeathNoteUHC = new ItemsBuilder(Material.BOOK)
                .setName("§6§nDeathNoteUHC")
                .setLore(Arrays.asList(" ",
                        "§eEn jeu: §60",
                        "§e» Clic gauche pour jouer",
                        " ",
                        "§eDéveloppeur: §6ZelphixSama"));;
        inv.setItem(23,DeathNoteUHC.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(44,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        switch (current.getType()) {
            case DARK_OAK_DOOR_ITEM:
                main.getGuiManager().open(player, Menu.class);
                break;

            case GOLDEN_APPLE:
                player.closeInventory();
                if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip")) {
                    VIPQueue uhcrunQueue = main.getVIPQueueByName("UHCRun01");
                    if(uhcrunQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    uhcrunQueue.getPlayers().put(player, uhcrunQueue.getPlayers().size() + 1);
                    VIPQueueTask queueTask = new VIPQueueTask(main, uhcrunQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = uhcrunQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + uhcrunQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder boutique = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(4,boutique.toItemStack());
                }else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip+")) {
                    VIPplusQueue uhcrunQueue = main.getVIPplusQueueByName("UHCRun01");
                    if(uhcrunQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    uhcrunQueue.getPlayers().put(player, uhcrunQueue.getPlayers().size() + 1);
                    VIPplusQueueTask queueTask = new VIPplusQueueTask(main, uhcrunQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = uhcrunQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la file d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + uhcrunQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder boutique = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(4,boutique.toItemStack());

                }else if (player.hasPermission("queues.bypass")) {
                    player.sendMessage("§eCubixMC §6» §eConnexion au serveur en cours... §6(§eUHCRun§6)");
                    Menu.teleport(main, player, "UHCRun01");
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("player+")) {
                    Queue uhcrunQueue = main.getQueueByName("UHCRun01");
                    if (uhcrunQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    uhcrunQueue.getPlayers().put(player, uhcrunQueue.getPlayers().size() + 1);
                    QueueTask queueTask = new QueueTask(main, uhcrunQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = uhcrunQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la file d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + uhcrunQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder boutique = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(4,boutique.toItemStack());
                }
                break;

            case BOOK:
                player.closeInventory();
                if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip")) {
                    VIPQueue uhcrunQueue = main.getVIPQueueByName("DeathNoteUHC01");
                    if(uhcrunQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    uhcrunQueue.getPlayers().put(player, uhcrunQueue.getPlayers().size() + 1);
                    VIPQueueTask queueTask = new VIPQueueTask(main, uhcrunQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = uhcrunQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la file d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + uhcrunQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder boutique = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(4,boutique.toItemStack());
                }else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip+")) {
                    VIPplusQueue uhcrunQueue = main.getVIPplusQueueByName("DeathNoteUHC01");
                    if(uhcrunQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    uhcrunQueue.getPlayers().put(player, uhcrunQueue.getPlayers().size() + 1);
                    VIPplusQueueTask queueTask = new VIPplusQueueTask(main, uhcrunQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = uhcrunQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + uhcrunQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder boutique = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(4,boutique.toItemStack());

                }else if (player.hasPermission("queues.bypass")) {
                    player.sendMessage("§eCubixMC §6» §eConnexion au serveur en cours... §6(§eDeathNoteUHC§6)");
                    Menu.teleport(main, player, "DeathNoteUHC01");
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("player+")) {
                    Queue uhcrunQueue = main.getQueueByName("DeathNoteUHC01");
                    if (uhcrunQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    uhcrunQueue.getPlayers().put(player, uhcrunQueue.getPlayers().size() + 1);
                    QueueTask queueTask = new QueueTask(main, uhcrunQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = uhcrunQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + uhcrunQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder boutique = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(4,boutique.toItemStack());
                }
                break;

            default: break;
        }
    }
}
