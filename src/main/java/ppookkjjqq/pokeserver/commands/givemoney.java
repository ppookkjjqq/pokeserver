package ppookkjjqq.pokeserver.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ppookkjjqq.pokeserver.Pokeserver;

public class givemoney implements CommandExecutor {

    Pokeserver plugin;

    public givemoney(Pokeserver instance){
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        int sendermoney = plugin.getConfig().getInt(player.getName());

        if (strings.length == 2){
            if (!plugin.getServer().matchPlayer(strings[0]).isEmpty()){
                if (sendermoney >= Integer.parseInt(strings[1])) {
                    if (Integer.parseInt(strings[0]) > 0) {
                        int mount = Integer.parseInt(strings[1]);
                        int receivermoney = plugin.getConfig().getInt(strings[0]);

                        plugin.getConfig().set(player.getName(), sendermoney - mount);
                        plugin.getConfig().set(strings[0], receivermoney + mount);
                        plugin.saveConfig();
                        return false;
                    }
                }
            }
        }

        return false;
    }
}
