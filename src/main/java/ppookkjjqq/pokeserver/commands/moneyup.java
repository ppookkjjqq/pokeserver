package ppookkjjqq.pokeserver.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import ppookkjjqq.pokeserver.Pokeserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class moneyup implements CommandExecutor {

    Pokeserver plugin;

    public moneyup(Pokeserver instance){
        plugin = instance;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;


        if(commandSender.isOp()){
            if (strings.length == 2){
                if(!plugin.getServer().matchPlayer(strings[0]).isEmpty()){
                    int amount = Integer.parseInt(strings[1]);
                    String playername = strings[0];

                    List<Player> players = plugin.getServer().matchPlayer(strings[0]);

                    for (Player e : players){
                        int money = plugin.getConfig().getInt(e.getName());
                        plugin.getConfig().set(playername, money + amount);
                        plugin.saveConfig();
                    }
                    return false;
                }

            }
            return false;
        }
        return false;
    }
}
