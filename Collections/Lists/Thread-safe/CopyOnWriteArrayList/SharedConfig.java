import java.util.concurrent.CopyOnWriteArrayList;

class ConfigManager{
    private final CopyOnWriteArrayList<String> configList;

    public ConfigManager(){
        this.configList = new CopyOnWriteArrayList<>();
        this.configList.add("Setting 1 : ENABLED");
        this.configList.add("Setting 2 : DISABLED");
    }

    void readConfig(String threadName){
        System.out.println("class ConfigManager -------- [IV] : " + threadName);
        
        for(String config : configList){
            System.out.println(threadName + " reading " + config);
        }
    }

    void updateConfiguration(String newConfig, String threadName){
            System.out.println(threadName + "updating configuration...");
            configList.add(newConfig);
            System.out.println(threadName + " added new configuration: " + newConfig);
    }
}

class ConfigReader implements Runnable{
    private final ConfigManager configManager;
    //System.out.println("class ConfigReader -------- [I]");
    public ConfigReader(ConfigManager configManager){
        System.out.println("class ConfigReader -------- [I]");
        this.configManager = configManager;
    }

    @Override
    public void run(){
        System.out.println("class ConfigReader -------- [II]");
        String threadName = Thread.currentThread().getName();
        System.out.println("class ConfigReader -------- [III] : " + threadName);
        configManager.readConfig(threadName);
    }
}

class ConfigUpdater implements Runnable{
    private final ConfigManager configManager;
    private final String newConfig;

    public ConfigUpdater(ConfigManager configManager, String newConfig){
        this.configManager = configManager;
        this.newConfig = newConfig;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        configManager.updateConfiguration(newConfig, threadName);
    }
}

public class SharedConfig{
    public static void main(String[] args){
        ConfigManager configManager = new ConfigManager();//initilize the configurManager class, and set the list with three configuration

        Thread thread1 = new Thread(new ConfigReader(configManager), "reader-1");

        //Thread thread2 = new Thread(new ConfigReader(configManager), "reader-2");
        
        //Thread updater = new Thread(new ConfigUpdater(configManager, "Setting 3: ENABLED"), "Updater");

        thread1.start();
        //thread2.start();
        //updater.start();
    }
}