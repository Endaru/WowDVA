package com.example.ellilim.wowdva.utilities;

import android.content.Context;
import android.hardware.camera2.DngCreator;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DungeonUtils {

    public static Dungeon[] getDungeonListFromJson(Context context, String JsonStr) throws JSONException {
        final String WDI_List = "zones";
        final String WDI_NAME = "name";
        final String WDI_DES = "description";
        final String WDI_ID = "id";
        final String WDI_EID = "expansionId";

        Dungeon[] parsedDungeonData = null;
        JSONObject DungeonList = new JSONObject(JsonStr);

        JSONArray dungeonArray = DungeonList.getJSONArray(WDI_List);
        parsedDungeonData = new Dungeon[dungeonArray.length()];

        for (int i = 0; i < dungeonArray.length(); i++){
            JSONObject dungeon = dungeonArray.getJSONObject(i);

            Dungeon DungeonInfo = new Dungeon(dungeon.getInt(
                    WDI_ID),dungeon.getString(WDI_NAME),
                    dungeon.getString(WDI_DES),
                    dungeon.getInt(WDI_EID)
            );

            parsedDungeonData[i] = DungeonInfo;
        }
        return parsedDungeonData;
    }
}
