package com.example.ellilim.wowdva.utilities;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BossUtils {

    public static Bos[] getBosListFromJson(JSONArray JsonArray) throws JSONException {
        final String WBI_ID = "id";
        final String WBI_NAME = "name";
        final String WBI_DES = "description";
        final String WBI_AIN = "availableInNormalMode";
        final String WBI_AIH = "availableInHeroicMode";

        Bos[] parsedBosData = null;
        parsedBosData = new Bos[JsonArray.length()];

        for(int i = 0; i < JsonArray.length(); i++){
            JSONObject boss = JsonArray.getJSONObject(i);
            Bos BosInfo = null;
            BosInfo = new Bos(
                    boss.getInt(WBI_ID),
                    boss.getString(WBI_NAME)
            );

            parsedBosData[i] = BosInfo;
        }

        return null;
    }
}
