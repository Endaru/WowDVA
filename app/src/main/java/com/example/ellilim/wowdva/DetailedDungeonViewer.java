package com.example.ellilim.wowdva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.ellilim.wowdva.utilities.Dungeon;

public class DetailedDungeonViewer extends AppCompatActivity {

    private TextView mDungeonName;
    private TextView mDungeonDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_dungeon_viewer);
        mDungeonName = (TextView) findViewById(R.id.tv_dungeon_name);
        mDungeonDescription = (TextView) findViewById(R.id.tv_dungeon_description);
        Intent i = getIntent();
        Dungeon d = (Dungeon) i.getParcelableExtra("name");
        mDungeonName.setText(d.name);
        mDungeonDescription.setText(d.description);
        Log.i("INFORmATION","" + d.bosses[0].name);
        }
}
