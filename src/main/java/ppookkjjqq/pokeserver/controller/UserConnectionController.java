package ppookkjjqq.pokeserver.controller;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ppookkjjqq.pokeserver.service.UserManager;

public class UserConnectionController implements Listener {
    private final UserManager userManager;


    public UserConnectionController(UserManager userManager) {
        this.userManager = userManager;
    }

    @EventHandler
    public void onUserJoinServer(PlayerJoinEvent event){
        userManager.addUser(event.getPlayer());
    }

    @EventHandler
    public void onUserQuitFroServer(PlayerQuitEvent event){
        userManager.removeUser(event.getPlayer());
    }
}
