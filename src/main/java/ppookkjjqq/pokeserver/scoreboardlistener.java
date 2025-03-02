package ppookkjjqq.pokeserver;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class scoreboardlistener implements Listener {
    private final scoreboardmanager scoreboardmanager;
    private final Pokeserver plugin;

    public scoreboardlistener(scoreboardmanager scoreboardmanager, Pokeserver plugin) {
        this.scoreboardmanager = scoreboardmanager;
        this.plugin = plugin;
    }


    @EventHandler
    public void playerjoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        scoreboardmanager.setScoreboard(player);
        scoreboardmanager.startupdating(player);
    }
}
