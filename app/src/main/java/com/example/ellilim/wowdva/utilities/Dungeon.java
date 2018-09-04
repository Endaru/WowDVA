package com.example.ellilim.wowdva.utilities;

public class Dungeon {
    public int id = 0;
    public String name = "";
    public String description = "";
    public int expansionId = 0;
    public boolean isDungeon = false;
    public boolean isRaid = false;

    public Dungeon(int id, String name, String description, int expansionId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.expansionId = expansionId;
    }
}
