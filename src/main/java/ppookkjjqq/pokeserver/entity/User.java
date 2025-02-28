package ppookkjjqq.pokeserver.entity;

import java.util.UUID;

public class User {
    private UUID uuid;
    private String displayname;

    private Long money;

    public User(UUID uuid, String displayname, Long money){
        this.uuid = uuid;
        this.displayname = displayname;
        this.money = money;
    }

    public UUID getUuid(){
        return uuid;
    }

    public void setUuid(UUID uuid){
        this.uuid = uuid;
    }

    public String getUdisplayname(){
        return displayname;
    }

    public void setDisplayname(String displayname){
        this.displayname = displayname;
    }

    public Long getMoney(){
        return money;
    }

    public void setMoney(Long money){
        this.money = money;
    }


}
