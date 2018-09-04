package com.example.ellilim.wowdva.utilities;

public class Bos {
    public int id = 0;
    public String name = "";
    public String description = "";
    public boolean availableInNormalMode = false;
    public boolean availableInHeroicMode = false;

    public Bos(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Bos(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Bos(int id, String name, String description, boolean normal){
        this.id = id;
        this.name = name;
        this.description = description;
        this.availableInNormalMode = normal;
    }

    public Bos(int id, String name, String description, boolean normal, boolean heroic){
        this.id = id;
        this.name = name;
        this.description = description;
        this.availableInNormalMode = normal;
        this.availableInHeroicMode = heroic;
    }
}
