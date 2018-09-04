package com.example.ellilim.wowdva.utilities;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    final static private String DEV_BATTLE_NET = "https://us.api.battle.net";

    final static private String BLIZZARD_GAME = "wow";

    final static private String PARAM_APIKEY = "apikey";
    final static private String apiKey = "uvj7bkpc4ak2m53jw679y3ysrmdxtchz";

    final static private String PARAM_LOCALE = "locale";
    final static private String locale = "en_US";

    /**
     * We build a URL By starting with the bear necessity then depending on the criteria that we
     * give in the activity we can go to other parts of the api yet keep using the same NetworkUtils
     *
     * @param criteria Criteria given from the page that activates NetworkUtils
     * @return The URL that will be used to query information
     */
    public static URL buildUrl(String[] criteria){
        //Start of the builder that takes the api and game of choice
        String URLBuilder = Uri.parse(DEV_BATTLE_NET).buildUpon()
                .appendPath(BLIZZARD_GAME).toString();

        //Criteria are being added as parts of the URL
        if(criteria != null){
            for (String item : criteria) {
                URLBuilder = Uri.parse(URLBuilder).buildUpon()
                        .appendPath(item).toString();
            }
        }

        //Add the language in which to return and add the API Key
        Uri builtUri = Uri.parse(URLBuilder).buildUpon()
                .appendPath("")
                .appendQueryParameter(PARAM_LOCALE,locale)
                .appendQueryParameter(PARAM_APIKEY,apiKey).build();

        URL url = null;

        try{
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try{
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if(hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}

