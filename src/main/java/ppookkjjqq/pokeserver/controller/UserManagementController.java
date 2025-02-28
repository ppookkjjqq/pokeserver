package ppookkjjqq.pokeserver.controller;

import ppookkjjqq.pokeserver.Pokeserver;
import ppookkjjqq.pokeserver.service.UserManager;

public class UserManagementController {

    private static UserManager userManager;

    private final Pokeserver serverInstance;

    private UserConnectionController userConnectionController;

    public UserManagementController() {
        this.userManager = new UserManager();
        this.serverInstance = Pokeserver.getServerInstance();

        this.userConnectionController = new UserConnectionController(userManager);

        registerEvents();
    }

    private void registerEvents() {
        serverInstance.getServer().getPluginManager().registerEvents(userConnectionController, serverInstance);
    }
}
