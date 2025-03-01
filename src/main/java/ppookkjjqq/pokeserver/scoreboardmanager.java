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

    public String time(){
        long time = plugin.getServer().getWorld("world").getTime();

        if(time < 12300 || time > 23850){
            return "낮";
        }
        else return "저녁";
    }

    public void setScoreboard(Player player){
        int money = plugin.getConfig().getInt(player.getName());
        String formatmoney = NumberFormat.getInstance().format(money);
        int maxplayer = plugin.getServer().getMaxPlayers();
        int playernum = plugin.getServer().getOnlinePlayers().size();
        String biome =  player.getLocation().getBlock().getBiome().toString();


        ScoreboardManager manager = plugin.getServer().getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("board","poke", ChatColor.BLUE + "■□■" + ChatColor.YELLOW + " 포켓몬 서버 " + ChatColor.RED + "■□■");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score s1 = objective.getScore("================== ");
        Score s2 = objective.getScore(ChatColor.YELLOW + "▶ " + ChatColor.AQUA + ChatColor.BOLD + "당신의 닉네임");
        Score s3 = objective.getScore("- " + player.getName());
        Score s4 = objective.getScore(ChatColor.YELLOW+ " ");
        Score s5 = objective.getScore(ChatColor.YELLOW + "▶ " + ChatColor.AQUA + ChatColor.BOLD + "보유한 돈");
        Score s6 = objective.getScore("- " + formatmoney);
        Score s7 = objective.getScore(" ");
        Score s8 = objective.getScore(ChatColor.YELLOW + "▶ " + ChatColor.AQUA + ChatColor.BOLD + "현재 접속자 수");
        Score s9 = objective.getScore("- " + playernum + "/" + maxplayer);
        Score s10 = objective.getScore(ChatColor.YELLOW+ "    ");
        Score s11 = objective.getScore(ChatColor.YELLOW + "▶ " + ChatColor.AQUA + ChatColor.BOLD + "현재 바이옴 및 시간");
        Score s12 = objective.getScore("- " + biome + " " + time());
        Score s13 = objective.getScore("==================");

        s1.setScore(13);
        s2.setScore(12);
        s3.setScore(11);
        s4.setScore(10);
        s5.setScore(9);
        s6.setScore(8);
        s7.setScore(7);
        s8.setScore(6);
        s9.setScore(5);
        s10.setScore(4);
        s11.setScore(3);
        s12.setScore(2);
        s13.setScore(1);


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
