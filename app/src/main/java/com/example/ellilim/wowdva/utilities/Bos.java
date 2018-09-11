package com.example.ellilim.wowdva.utilities;

import android.os.Parcel;
import android.os.Parcelable;

public class Bos implements Parcelable{
    public int id = 0;
    public String name = "";
    public String description = "";

    public Bos(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }

    public static final Parcelable.Creator<Bos> CREATOR = new Parcelable.Creator<Bos>() {
        public Bos createFromParcel(Parcel in){
            return new Bos(in);
        }

        public Bos[] newArray(int size){
            return new Bos[size];
        }
    };

    private Bos(Parcel in){
        this.id = in.readInt();
        this.name = in.readString();
    }
}
