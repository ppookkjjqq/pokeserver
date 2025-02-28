package ppookkjjqq.pokeserver.service;

import org.bukkit.entity.Player;
import ppookkjjqq.pokeserver.entity.User;

import java.util.HashMap;

public class UserManager {
    private HashMap<Player, User> onlineUserData = new HashMap<>();

    public void addUser(Player player){
        User newUser = new User(
                player.getUniqueId(),
                player.getDisplayName(),
                100L
        );
        onlineUserData.put(player, newUser);
    }

    public void removeUser(Player player){
        onlineUserData.remove(player);
    }

    public User getUserData(Player player){
        return onlineUserData.get(player);
    }
}
