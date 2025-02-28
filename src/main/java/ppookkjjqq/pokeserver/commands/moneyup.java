package ppookkjjqq.pokeserver.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import ppookkjjqq.pokeserver.Pokeserver;

public class moneyup implements CommandExecutor {

    Pokeserver plugin;

    public moneyup(Pokeserver instance){
        plugin = instance;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        String playername = player.getName();
        int money = plugin.getConfig().getInt(playername);
        plugin.getConfig().set(playername,money + 1);
        plugin.saveConfig();
        return false;
    }
}
