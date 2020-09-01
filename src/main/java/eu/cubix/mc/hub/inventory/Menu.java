package eu.cubix.mc.hub.inventory;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import eu.cubix.mc.hub.Main;
import eu.cubix.mc.hub.queue.AvantageQueue;
import eu.cubix.mc.hub.queue.Queue;
import eu.cubix.mc.hub.queue.VIPQueue;
import eu.cubix.mc.hub.queue.VIPplusQueue;
import eu.cubix.mc.hub.task.AvantageQueueTask;
import eu.cubix.mc.hub.task.QueueTask;
import eu.cubix.mc.hub.task.VIPQueueTask;
import eu.cubix.mc.hub.task.VIPplusQueueTask;
import eu.cubix.mc.hub.tools.GuiBuilder;
import eu.cubix.mc.hub.tools.ItemsBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;

import static eu.cubix.mc.hub.tools.ItemsBuilder.setSkullID;

public class Menu implements GuiBuilder {

    private final Main main;

    public Menu(Main main) {
        this.main = main;
    }

    @Override
    public String name() {
        return "§0Menu";
    }

    @Override
    public int getSize() {
        return 54;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        ItemsBuilder Separateur = new ItemsBuilder(Material.STAINED_GLASS_PANE, 1, (byte) 4)
                .setName(" ");
        inv.setItem(1,Separateur.toItemStack());
        inv.setItem(2,Separateur.toItemStack());
        inv.setItem(3,Separateur.toItemStack());
        inv.setItem(6,Separateur.toItemStack());
        inv.setItem(7,Separateur.toItemStack());
        inv.setItem(8,Separateur.toItemStack());
        inv.setItem(10,Separateur.toItemStack());
        inv.setItem(17,Separateur.toItemStack());
        inv.setItem(19,Separateur.toItemStack());
        inv.setItem(26,Separateur.toItemStack());
        inv.setItem(28,Separateur.toItemStack());
        inv.setItem(35,Separateur.toItemStack());
        inv.setItem(37,Separateur.toItemStack());
        inv.setItem(44,Separateur.toItemStack());
        inv.setItem(46,Separateur.toItemStack());
        inv.setItem(47,Separateur.toItemStack());
        inv.setItem(48,Separateur.toItemStack());
        inv.setItem(49,Separateur.toItemStack());
        inv.setItem(50,Separateur.toItemStack());
        inv.setItem(51,Separateur.toItemStack());
        inv.setItem(52,Separateur.toItemStack());

        ItemsBuilder Spawn = new ItemsBuilder(Material.BED)
                .setName("§6§nSpawn")
                .setLore("§eSe téléporter au spawn.");
        inv.setItem(4,Spawn.toItemStack());

        ItemsBuilder HubChanger = new ItemsBuilder(Material.ENDER_PORTAL_FRAME)
                .setName("§6§nHubs")
                .setLore("§eChanger de hub.");
        inv.setItem(5,HubChanger.toItemStack());

        ItemsBuilder Facebook = new ItemsBuilder(setSkullID("deb46126904463f07ecfc972aaa37373a22359b5ba271821b689cd5367f75762"))
                .setName("§6§nFacebook")
                .setLore("§ehttps://www.facebook.com/CubixMC");
        inv.setItem(0,Facebook.toItemStack());

        ItemsBuilder YouTube = new ItemsBuilder(setSkullID("fb95209d36c5aa1bf6c6f307f09b16d9058844ac560340c88f8394682ef57a0a"))
                .setName("§6§nYouTube")
                .setLore("§ehttps://www.youtube.com/CubixMC");
        inv.setItem(9,YouTube.toItemStack());

        ItemsBuilder Twitter = new ItemsBuilder(setSkullID("cc745a06f537aea80505559149ea16bd4a84d4491f12226818c3881c08e860fc"))
                .setName("§6§nTwitter")
                .setLore("§ehttps://www.twitter.com/CubixMCFR");
        inv.setItem(18,Twitter.toItemStack());

        ItemsBuilder Instagram = new ItemsBuilder(setSkullID("ac88d6163fabe7c5e62450eb37a074e2e2c88611c998536dbd8429faa0819453"))
                .setName("§6§nInstagram")
                .setLore("§ehttps://www.instagram.com/cubixmc");
        inv.setItem(27,Instagram.toItemStack());

        ItemsBuilder Discord = new ItemsBuilder(setSkullID("7873c12bffb5251a0b88d5ae75c7247cb39a75ff1a81cbe4c8a39b311ddeda"))
                .setName("§6§nDiscord")
                .setLore("§ehttps://discord.gg/UFd3eRh");
        inv.setItem(36,Discord.toItemStack());

        ItemsBuilder WebSite = new ItemsBuilder(setSkullID("be3db27cbd1789310409081ad8c42d690b08961b55cadd45b42d46bca28b8"))
                .setName("§6§nSite")
                .setLore("§ehttps://cubixmc.fr");
        inv.setItem(45,WebSite.toItemStack());

        ItemsBuilder Pvpbox = new ItemsBuilder(Material.IRON_SWORD)
                .setName("§6§nPvpbox")
                .setFlags(ItemFlag.HIDE_ATTRIBUTES)
                .setLore(Arrays.asList(" ",
                        "§eEn jeu: §60",
                        "§e Clic gauche pour jouer",
                        " ",
                        "§eDéveloppeur: §6Eliviel"));
        inv.setItem(21,Pvpbox.toItemStack());

        ItemsBuilder DeACoudre = new ItemsBuilder(Material.WOOL, 1, (byte) 1)
                .setName("§6§nDéACoudre")
                .setLore(Arrays.asList(" ",
                        "§eEn jeu: §60",
                        "§e» Clic gauche pour jouer",
                        " ",
                        "§eDéveloppeur: §6ZelphixSama"));
        inv.setItem(22,DeACoudre.toItemStack());

        ItemsBuilder Punch = new ItemsBuilder(Material.STICK)
                .setName("§6§nPunch")
                .setLore(Arrays.asList(" ",
                        "§eEn jeu: §60",
                        "§e» Clic gauche pour jouer",
                        " ",
                        "§eDéveloppeur: §6Karamouche"));
        inv.setItem(23,Punch.toItemStack());

        ItemsBuilder UHCRun = new ItemsBuilder(Material.GOLDEN_APPLE)
                .setName("§6§nUHCs")
                .setLore(Arrays.asList(" ",
                        "§eEn jeu au total: §60",
                        "§e» Clic gauche pour ouvrir",
                        "§ele menu des jeux UHC",
                        " ",
                        "§eDéveloppeur: §6ZelphixSama"));
        inv.setItem(24,UHCRun.toItemStack());

        ItemsBuilder SurvivalGames = new ItemsBuilder(Material.APPLE)
                .setName("§6§nSurvival Games")
                .setLore(Arrays.asList(" ",
                        "§eEn jeu: §60",
                        "§e» Clic gauche pour jouer",
                        " ",
                        "§eDéveloppeur: §6Eliviel"));
        inv.setItem(30,SurvivalGames.toItemStack());

        ItemsBuilder HideAndSeek = new ItemsBuilder(Material.SLIME_BLOCK)
                .setName("§6§nHide And Seek")
                .setLore(Arrays.asList(" ",
                        "§eEn jeu: §60",
                        "§e» Clic gauche pour jouer",
                        " ",
                        "§eDéveloppeur: §6Eliviel"));
        inv.setItem(31,HideAndSeek.toItemStack());

        ItemsBuilder CubixGames7 = new ItemsBuilder(Material.BARRIER)
                .setName("§4§n§kCubixGame")
                .setLore("§cComing Soon");
        inv.setItem(32,CubixGames7.toItemStack());

        ItemsBuilder CubixGames8 = new ItemsBuilder(Material.BARRIER)
                .setName("§4§n§kCubixGame")
                .setLore("§cComing Soon");
        inv.setItem(33,CubixGames8.toItemStack());

        ItemsBuilder Return = new ItemsBuilder(Material.DARK_OAK_DOOR_ITEM)
                .setName("§6§nRetour");
        inv.setItem(53,Return.toItemStack());
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        Location spawn = new Location(Bukkit.getServer().getWorld("Hub"), 110.5, 16, 772.5, 180, 0);

        if(current != null && current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nFacebook")){
            player.sendMessage("\n§eCubixMC §6» §eVoici notre Facebook: §nhttps://www.facebook.com/CubixMC§r\n ");
            player.closeInventory();
        }

        if(current != null && current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nYouTube")){
            player.sendMessage("\n§eCubixMC §6» §eVoici notre chaîne YouTube: §nhttps://www.youtube.com/CubixMC§r\n ");
            player.closeInventory();
        }

        if(current != null && current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nTwitter")){
            player.sendMessage("\n§eCubixMC §6» §eVoici notre compte Twitter: §nhttps://twitter.com/CubixMCFR§r\n ");
            player.closeInventory();
        }

        if(current != null && current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nInstagram")){
            player.sendMessage("\n§eCubixMC §6» §eVoici notre compte Instagram: §nhttps://www.instagram.com/cubixmc§r\n ");
            player.closeInventory();
        }

        if(current != null && current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nDiscord")){
            player.sendMessage("\n§eCubixMC §6» §eVoici notre serveur Discord: §nhttps://discord.gg/UFd3eRh§r\n ");
            player.closeInventory();
        }

        if(current != null && current.getType() == Material.SKULL_ITEM && current.getItemMeta().getDisplayName().equalsIgnoreCase("§6§nSite")){
            player.sendMessage("\n§eCubixMC §6» §eVoici notre site: §nhttps://cubixmc.fr§r\n ");
            player.closeInventory();
        }

        switch (Objects.requireNonNull(current).getType()) {
            case BED:
                player.teleport(spawn);
                player.sendMessage("§eCubixMC §6» §eVous avez été téléporté au spawn.");
                break;

            case ENDER_PORTAL_FRAME:
                main.getGuiManager().open(player, HubChanger.class);
                break;

            case DARK_OAK_DOOR_ITEM:
                player.closeInventory();
                break;
                
            case IRON_SWORD:
            	player.closeInventory();
            	if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip")) {
                	VIPQueue pvpQueue = main.getVIPQueueByName("Pvp");
                    if(pvpQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    pvpQueue.getPlayers().put(player, pvpQueue.getPlayers().size() + 1);
                    VIPQueueTask queueTask = new VIPQueueTask(main, pvpQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = pvpQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + pvpQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip+")){
                    VIPplusQueue pvpQueue = main.getVIPplusQueueByName("Pvp");
                    if(pvpQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    pvpQueue.getPlayers().put(player, pvpQueue.getPlayers().size() + 1);
                    VIPplusQueueTask queueTask = new VIPplusQueueTask(main, pvpQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = pvpQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + pvpQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                    
                }else if (player.hasPermission("queues.bypass")  || player.hasPermission("*")) {
                	player.sendMessage("§eCubixMC §6» §eConnexion au serveur en cours... §6(§ePvp§6)");
                    teleport(main, player, "Pvp");
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("youtube")){
                    AvantageQueue pvpQueue = main.getAvantageQueueByName("Pvp");
                    if(pvpQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    pvpQueue.getPlayers().put(player, pvpQueue.getPlayers().size() + 1);
                    AvantageQueueTask queueTask = new AvantageQueueTask(main, pvpQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = pvpQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + pvpQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("player")){
                    Queue pvpQueue = main.getQueueByName("Pvp");
                    if(pvpQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    pvpQueue.getPlayers().put(player, pvpQueue.getPlayers().size() + 1);
                    QueueTask queueTask = new QueueTask(main, pvpQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = pvpQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + pvpQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }
            	break;
            
            case WOOL:
                player.closeInventory();
                if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip")) {
                	VIPQueue dacQueue = main.getVIPQueueByName("DeACoudre");
                    if(dacQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    dacQueue.getPlayers().put(player, dacQueue.getPlayers().size() + 1);
                    VIPQueueTask queueTask = new VIPQueueTask(main, dacQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = dacQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + dacQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip+")){
                    VIPplusQueue dacQueue = main.getVIPplusQueueByName("DeACoudre");
                    if(dacQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    dacQueue.getPlayers().put(player, dacQueue.getPlayers().size() + 1);
                    VIPplusQueueTask queueTask = new VIPplusQueueTask(main, dacQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = dacQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + dacQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                    
                }else if (player.hasPermission("queues.bypass")  || player.hasPermission("*")) {
                	player.sendMessage("§eCubixMC §6» §eConnexion au serveur en cours... §6(§eDeACoudre§6)");
                    teleport(main, player, "DeACoudre");
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("youtube")){
                    AvantageQueue dacQueue = main.getAvantageQueueByName("DeACoudre");
                    if(dacQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    dacQueue.getPlayers().put(player, dacQueue.getPlayers().size() + 1);
                    AvantageQueueTask queueTask = new AvantageQueueTask(main, dacQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = dacQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + dacQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("player")){
                    Queue dacQueue = main.getQueueByName("DeACoudre");
                    if(dacQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    dacQueue.getPlayers().put(player, dacQueue.getPlayers().size() + 1);
                    QueueTask queueTask = new QueueTask(main, dacQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = dacQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + dacQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }
                break;
                
            case STICK:
            	player.closeInventory();
            	if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip")) {
                	VIPQueue punchQueue = main.getVIPQueueByName("Punch");
                    if(punchQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    punchQueue.getPlayers().put(player, punchQueue.getPlayers().size() + 1);
                    VIPQueueTask queueTask = new VIPQueueTask(main, punchQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = punchQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + punchQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip+")) {
                    VIPplusQueue punchQueue = main.getVIPplusQueueByName("Punch");
                    if(punchQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    punchQueue.getPlayers().put(player, punchQueue.getPlayers().size() + 1);
                    VIPplusQueueTask queueTask = new VIPplusQueueTask(main, punchQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = punchQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + punchQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                    
                }else if (player.hasPermission("queues.bypass")  || player.hasPermission("*")) {
                	player.sendMessage("§eCubixMC §6» §eConnexion au serveur en cours... §6(§ePunch§6)");
                    teleport(main, player, "Punch");
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("youtube")){
                    AvantageQueue punchQueue = main.getAvantageQueueByName("Punch");
                    if(punchQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    punchQueue.getPlayers().put(player, punchQueue.getPlayers().size() + 1);
                    AvantageQueueTask queueTask = new AvantageQueueTask(main, punchQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = punchQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + punchQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("player")){
                    Queue punchQueue = main.getQueueByName("Punch");
                    if(punchQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    punchQueue.getPlayers().put(player, punchQueue.getPlayers().size() + 1);
                    QueueTask queueTask = new QueueTask(main, punchQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = punchQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + punchQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }
            	break;

            case GOLDEN_APPLE:
                main.getGuiManager().open(player, UHCs.class);
                break;

            case APPLE:
                player.closeInventory();
                if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip")) {
                    VIPQueue sgQueue = main.getVIPQueueByName("SG01");
                    if(sgQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    sgQueue.getPlayers().put(player, sgQueue.getPlayers().size() + 1);
                    VIPQueueTask queueTask = new VIPQueueTask(main, sgQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = sgQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + sgQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if(main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("vip+")) {
                    VIPplusQueue sgQueue = main.getVIPplusQueueByName("SG01");
                    if(sgQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    sgQueue.getPlayers().put(player, sgQueue.getPlayers().size() + 1);
                    VIPplusQueueTask queueTask = new VIPplusQueueTask(main, sgQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = sgQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + sgQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());

                }else if (player.hasPermission("queues.bypass")  || player.hasPermission("*")) {
                    player.sendMessage("§eCubixMC §6» §eConnexion au serveur en cours... §6(§eSurvival Games§6)");
                    teleport(main, player, "SG01");
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("youtube")){
                    AvantageQueue sgQueue = main.getAvantageQueueByName("SG01");
                    if(sgQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    sgQueue.getPlayers().put(player, sgQueue.getPlayers().size() + 1);
                    AvantageQueueTask queueTask = new AvantageQueueTask(main, sgQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = sgQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + sgQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }else if (main.getAPI().get().getRankID(player.getUniqueId()).equalsIgnoreCase("player")){
                    Queue sgQueue = main.getQueueByName("SG01");
                    if(sgQueue.getPlayers().containsKey(player)) {
                        player.sendMessage("§cCubixMC §4» §cErreur: vous êtes déjà dans la file d'attente.");
                        return;
                    }
                    sgQueue.getPlayers().put(player, sgQueue.getPlayers().size() + 1);
                    QueueTask queueTask = new QueueTask(main, sgQueue);
                    queueTask.runTaskTimer(main, 0, 20);
                    int place = sgQueue.getPlayers().get(player);
                    player.sendMessage("§eCubixMC §6» §eVous avez bien été ajouté(e) à la §efile d'attente.");
                    player.sendMessage("§eCubixMC §6» §eVous êtes §6" + place + "§e/§6" + sgQueue.getPlayers().size() + " §ejoueur(s) dans la file d'attente.");
                    ItemsBuilder quitQueue = new ItemsBuilder(Material.BARRIER).setName("§6Quitter la file d'attente").setLore("§eClic droit");
                    player.getInventory().setItem(2,quitQueue.toItemStack());
                }
                break;

            default: break;
        }
    }

    public static void teleport(Main main, Player player, String server){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(server);
        player.sendPluginMessage(main, "BungeeCord", out.toByteArray());
    }
}