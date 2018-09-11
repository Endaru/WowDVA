package com.example.ellilim.wowdva.utilities;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.Comparator;

public class Dungeon implements Parcelable {
    public int id = 0;
    public String name = "";
    public String description = "";
    public int expansionId = 0;
    public Bos[] bosses = null;

    public Dungeon(int id, String name, String description, int expansionId, Bos[] bosses){
        this.id = id;
        this.name = name;
        this.description = description;
        this.expansionId = expansionId;
        this.bosses = bosses;
    }

    public int getExpansionId(){
        return expansionId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(expansionId);
        parcel.writeTypedArray(bosses,i);
    }

    public static final Parcelable.Creator<Dungeon> CREATOR = new Parcelable.Creator<Dungeon>() {
        public Dungeon createFromParcel(Parcel in){
            return new Dungeon(in);
        }

        public Dungeon[] newArray(int size){
            return new Dungeon[size];
        }
    };

    private Dungeon(Parcel in){
        this.id = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.expansionId = in.readInt();
    }
}
