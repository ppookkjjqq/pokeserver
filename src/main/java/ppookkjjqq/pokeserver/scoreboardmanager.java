package ppookkjjqq.pokeserver;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class scoreboardmanager {
    private final Pokeserver plugin;

    public scoreboardmanager(Pokeserver instance){
        plugin = instance;
    }

    public void setScoreboard(Player player){
        int money = plugin.getConfig().getInt(player.getName());
        String formatmoney = NumberFormat.getInstance().format(money);
        int maxplayer = plugin.getServer().getMaxPlayers();
        int playernum = plugin.getServer().getOnlinePlayers().size();

        ScoreboardManager manager = plugin.getServer().getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("board","poke", ChatColor.BLUE + "■□■" + ChatColor.YELLOW + " 포켓몬 서버 " + ChatColor.RED + "■□■");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score s1 = objective.getScore("==================== ");
        Score s2 = objective.getScore(ChatColor.YELLOW + "▶ " + ChatColor.AQUA + ChatColor.BOLD + "당신의 닉네임");
        Score s3 = objective.getScore("- " + player.getName());
        Score s4 = objective.getScore(ChatColor.YELLOW+ " ");
        Score s5 = objective.getScore(ChatColor.YELLOW + "▶ " + ChatColor.AQUA + ChatColor.BOLD + "보유한 돈");
        Score s6 = objective.getScore("- " + formatmoney);
        Score s7 = objective.getScore(" ");
        Score s8 = objective.getScore(ChatColor.YELLOW + "▶ " + ChatColor.AQUA + ChatColor.BOLD + "현재 접속자 수");
        Score s9 = objective.getScore("- " + playernum + "/" + maxplayer);
        Score s10 = objective.getScore("====================");

        s1.setScore(10);
        s2.setScore(9);
        s3.setScore(8);
        s4.setScore(7);
        s5.setScore(6);
        s6.setScore(5);
        s7.setScore(4);
        s8.setScore(3);
        s9.setScore(2);
        s10.setScore(1);


        player.setScoreboard(board);
    }

    public void startupdating(Player player){
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()){
                    cancel();
                    return;
                }
                setScoreboard(player);
            }
        }.runTaskTimer(plugin,0,10);
    }
}
