package eu.cubix.mc.hub;

import eu.cubix.mc.hub.commands.Key;
import eu.cubix.mc.hub.cosmetics.gadgets.SheepExplode;
import eu.cubix.mc.hub.crates.Vote;
import eu.cubix.mc.hub.events.InteractEvent;
import eu.cubix.mc.hub.events.Jump;
import eu.cubix.mc.hub.events.PlayerEvent;
import eu.cubix.mc.hub.events.Protect;
import eu.cubix.mc.hub.inventory.*;
import eu.cubix.mc.hub.inventory.Particles;
import eu.cubix.mc.hub.manager.CosmeticsManager;
import eu.cubix.mc.hub.queue.AvantageQueue;
import eu.cubix.mc.hub.queue.Queue;
import eu.cubix.mc.hub.queue.VIPQueue;
import eu.cubix.mc.hub.queue.VIPplusQueue;
import eu.cubix.mc.hub.scoreboard.ScoreboardManager;
import eu.cubix.mc.hub.task.AntiAFK;
import eu.cubix.mc.hub.tools.*;
import eu.cubixmc.com.CubixAPI;
import eu.cubixmc.com.data.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends JavaPlugin implements Listener {

    public String prefix = ChatColor.YELLOW+"CubixMC "+ChatColor.GOLD+"» ";
    public String prefixError = ChatColor.RED+"CubixMC "+ChatColor.DARK_RED+"» ";
    public String verticalBarreUnicode = "\u2758";

    private GuiManager guiManager;
    private final Map<Class<? extends GadgetBuilder>, GadgetBuilder> registerGadgets = new HashMap<>();
    private Map<Class<? extends GuiBuilder>, GuiBuilder> registeredMenus;

    private final Map<Player, AntiAFK> antiAFK = new HashMap<>();
    private final Map<Player, Integer> antiAFKTime = new HashMap<>();

    private final ArrayList<Queue> queues = new ArrayList<>();
    private final ArrayList<VIPQueue> vipqueues = new ArrayList<>();
    private final ArrayList<VIPplusQueue> vipplusqueues = new ArrayList<>();
    private final ArrayList<AvantageQueue> avantagequeues = new ArrayList<>();
    private final ArrayList<String> games = new ArrayList<>();

    private CosmeticsManager cosmeticsManager;

    private ScoreboardManager scoreboardManager;

    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;

    public GuiManager getGuiManager() {
        return guiManager;
    }

    //public Bossbar bar;

    public Map<Class<? extends GuiBuilder>, GuiBuilder> getRegisteredMenus() {
        return registeredMenus;
    }

    @Override
    public void onEnable() {
        loadChannels();
        setQueues();
        loadGui();
        loadGadgets();

        System.out.println("[CubixHub] Le plugin est ON");

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new PlayerEvent(this), this);
        getServer().getPluginManager().registerEvents(new Protect(), this);
        getServer().getPluginManager().registerEvents(new InteractEvent(this), this);
        getServer().getPluginManager().registerEvents(new GadgetsListener(this), this);
        getServer().getPluginManager().registerEvents(new Jump(this), this);
        getServer().getPluginManager().registerEvents(new Vote(this), this);

        getCommand("key").setExecutor(new Key(this));

        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager(this);

        cosmeticsManager = new CosmeticsManager(this);
    }

    @Override
    public void onDisable() {
        System.out.println("[CubixHub] Le plugin est OFF");

        getScoreboardManager().onDisable();
    }

    public CubixAPI getAPI() {
        return (CubixAPI) Bukkit.getPluginManager().getPlugin("CubixAPI");
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    private void loadGui(){
        guiManager = new GuiManager(this);
        Bukkit.getPluginManager().registerEvents(guiManager, this);
        registeredMenus = new HashMap<>();
        guiManager.addMenu(new Profile(this));
        guiManager.addMenu(new Settings(this));
        guiManager.addMenu(new Friends(this));
        guiManager.addMenu(new Languages(this));
        guiManager.addMenu(new Menu(this));
        guiManager.addMenu(new UHCs(this));
        guiManager.addMenu(new Cosmetics(this));
        guiManager.addMenu(new Pets(this));
        guiManager.addMenu(new Gadgets(this));
        guiManager.addMenu(new Particles(this));
        guiManager.addMenu(new Mounts(this));
        guiManager.addMenu(new Effects(this));
        guiManager.addMenu(new Shop(this));
        guiManager.addMenu(new ShopGrades(this));
        guiManager.addMenu(new ShopParticles(this));
        guiManager.addMenu(new ShopGadgets(this));
        guiManager.addMenu(new ShopMounts(this));
        guiManager.addMenu(new ShopPets(this));
        guiManager.addMenu(new HubChanger(this));
        guiManager.addMenu(new GadgetSheepExplodeConfirm(this));
        guiManager.addMenu(new GradeVIPConfirm(this));
        guiManager.addMenu(new GradeVIPplusConfirm(this));
    }

    private void loadChannels(){
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    private void setQueues(){
        games.add("DeACoudre");
        games.add("Punch");
        games.add("Pvp");
        games.add("UHCRun01");
        games.add("DeathNoteUHC01");
        games.add("SG01");
        games.add("PlantTheBomb01");
        for(String game : games){
            VIPplusQueue vipplusqueue = new VIPplusQueue(game, new HashMap<>());
            VIPQueue vipqueue = new VIPQueue(game, new HashMap<>());
            Queue queue = new Queue(game, new HashMap<>());
            AvantageQueue avantagequeue = new AvantageQueue(game, new HashMap<>());
            queues.add(queue);
            vipqueues.add(vipqueue);
            vipplusqueues.add(vipplusqueue);
            avantagequeues.add(avantagequeue);
        }
    }

    private void loadGadgets() {
        addGadget(new SheepExplode(this));
    }

    public Queue getQueueByName(String name){
        Queue queue = null;

        for (Queue value : queues) {
            String queueName = value.getName();
            if (name.equalsIgnoreCase(queueName)) {
                queue = value;
            }
        }
        return queue;
    }

    public VIPQueue getVIPQueueByName(String name){
        VIPQueue queue = null;

        for (VIPQueue vipqueue : vipqueues) {
            String queueName = vipqueue.getName();
            if (name.equalsIgnoreCase(queueName)) {
                queue = vipqueue;
            }
        }
        return queue;
    }
    
    public VIPplusQueue getVIPplusQueueByName(String name){
        VIPplusQueue queue = null;

        for(int i = 0; i < vipqueues.size(); i++){
            String queueName = vipqueues.get(i).getName();
            if(name.equalsIgnoreCase(queueName)){
                queue = vipplusqueues.get(i);
            }
        }
        return queue;
    }

    public AvantageQueue getAvantageQueueByName(String name){
        AvantageQueue queue = null;

        for(int i = 0; i < avantagequeues.size(); i++){
            String queueName = avantagequeues.get(i).getName();
            if(name.equalsIgnoreCase(queueName)){
                queue = avantagequeues.get(i);
            }
        }
        return queue;
    }

    public void addGadget(GadgetBuilder gadget){
        this.registerGadgets.put(gadget.getClass(), gadget);
    }

    public void give(Class<? extends GadgetBuilder> gClass, Player player){

        if(!this.registerGadgets.containsKey(gClass)) return;

        GadgetBuilder g = this.registerGadgets.get(gClass);
        g.give(player, 6);
    }

    public Collection<GadgetBuilder> getGadgets(){
        return this.registerGadgets.values();
    }

    public CosmeticsManager getCosmeticsManager() {
        return cosmeticsManager;
    }

    public Map<Player, AntiAFK> getAntiAFK() {
        return antiAFK;
    }

    public Map<Player, Integer> getAntiAFKTime() {
        return antiAFKTime;
    }
}
