import java.util.concurrent.CopyOnWriteArrayList;

class ConfigManager1{

    private final CopyOnWriteArrayList<String> configList;

    public ConfigManager1(){
        this.configList = new CopyOnWriteArrayList<>();
        this.configList.add("Setting 1 : ENALED");
        this.configList.add("Setting 2 : DISABLED");
    }

    void ReadConfig(String threadName){
        for(String list : configList){
           System.out.println("---------" + list);
        }
    }

    void updateConfiguration(String newConfig, String threadName){
        System.out.println(threadName + "updating configuration...");
        configList.add(newConfig);
        System.out.println(threadName + " added new configuration: " + newConfig);
    }
}

class ConfigReader implements Runnable{

    private final ConfigManager1 configManager;

    public ConfigReader(ConfigManager1 configManager){
        this.configManager = configManager;
    }

    @Override
    public void run(){
        String threadName = Thread.currentThread().getName();
        configManager.ReadConfig(threadName);
    }

}

class ConfigUpdater implements Runnable{

    private final ConfigManager1 configManager;
    private final String newConfig;

    public ConfigUpdater(ConfigManager1 configManager, String newConfig){
        this.configManager = configManager;
        this.newConfig = newConfig;
    }

    @Override
    public void run(){  
        String threadName = Thread.currentThread().getName();
        configManager.updateConfiguration(newConfig, threadName);
    }

}

public class SharedConfig1{
    public static void main(String[] args){
        
        ConfigManager1 configManager = new ConfigManager1();

        Thread t1 = new Thread(new ConfigReader(configManager), "reader-1");

        Thread t2 = new Thread(new ConfigReader(configManager) , "reader-2");

        Thread updater1 = new Thread(new ConfigUpdater(configManager, "Setting 3 : RUNNING"), "reader-3");

        t1.start();
        t2.start();
        updater1.start();

    }
}