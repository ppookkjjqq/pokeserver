package ppookkjjqq.pokeserver;

import org.bukkit.plugin.java.JavaPlugin;
import ppookkjjqq.pokeserver.commands.moneyset;
import ppookkjjqq.pokeserver.commands.moneyup;

public final class Pokeserver extends JavaPlugin {

    private static Pokeserver serverInstance;

    @Override
    public void onEnable() {
        serverInstance = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        getServer().getPluginCommand("moneyup").setExecutor(new moneyup(this));
        getServer().getPluginCommand("moneyset").setExecutor(new moneyset(this));
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        serverInstance = null;
        saveConfig();
        // Plugin shutdown logic
    }

    public static Pokeserver getServerInstance(){
        return serverInstance;
    }

}
