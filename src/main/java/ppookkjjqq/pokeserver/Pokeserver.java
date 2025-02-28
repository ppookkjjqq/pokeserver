package ppookkjjqq.pokeserver;

import org.bukkit.plugin.java.JavaPlugin;
import ppookkjjqq.pokeserver.controller.UserConnectionController;
import ppookkjjqq.pokeserver.controller.UserManagementController;

public final class Pokeserver extends JavaPlugin {

    private static Pokeserver serverInstance;
    private static UserManagementController userManagement;

    @Override
    public void onEnable() {
        serverInstance = this;
        userManagement = new UserManagementController();

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        serverInstance = null;
        userManagement = null;
        // Plugin shutdown logic
    }

    public static Pokeserver getServerInstance(){
        return serverInstance;
    }

    public static UserManagementController getUserManagement(){
        return userManagement;
    }


}
