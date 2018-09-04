package com.example.ellilim.wowdva;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ellilim.wowdva.utilities.Dungeon;
import com.example.ellilim.wowdva.utilities.DungeonUtils;
import com.example.ellilim.wowdva.utilities.NetworkUtils;

import java.net.URL;

public class DungeonViewer extends AppCompatActivity implements DungeonAdapter.DungeonAdapterOnClickHandler {

    private RecyclerView mRecyclerView;
    private DungeonAdapter mDungeonAdapter;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dungeon_viewer);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_dungeons);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mDungeonAdapter = new DungeonAdapter(this);
        mRecyclerView.setAdapter(mDungeonAdapter);
        loadDungeonData();
    }

    private void loadDungeonData() {
        showDungeonDataView();
        String[] locationQuery = {"zone"};
        new DungeonQuery().execute(locationQuery);
    }

    private void showDungeonDataView(){
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    public void onDungeonItemClick(String clickedDungeonItemIndex) {
        if(mToast != null){
            mToast.cancel();
        }
        mToast = Toast.makeText(this,"Dungeon: " + clickedDungeonItemIndex + "Clicked", Toast.LENGTH_LONG);
        mToast.show();
    }


    public class DungeonQuery extends AsyncTask<String, Void, Dungeon[]> {

        @Override
        protected Dungeon[] doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }
            URL dungeonSearchResults = NetworkUtils.buildUrl(params);

            try {
                String dungeonResults = NetworkUtils.getResponseFromHttpUrl(dungeonSearchResults);
                Dungeon[] test = DungeonUtils.getDungeonListFromJson(DungeonViewer.this, dungeonResults);
                return test;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Dungeon[] s) {
            if (s != null) {
                showDungeonDataView();
                mDungeonAdapter.setDungeonData(s);
            }
        }
    }
}
