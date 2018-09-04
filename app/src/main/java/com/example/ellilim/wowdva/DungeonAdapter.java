package com.example.ellilim.wowdva;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ellilim.wowdva.utilities.Dungeon;

import org.w3c.dom.Text;

public class DungeonAdapter extends RecyclerView.Adapter<DungeonAdapter.DungeonAdapterViewHolder>{

    private Dungeon[] mDungeonData;
    private final DungeonAdapterOnClickHandler mClickHandler;

    public interface DungeonAdapterOnClickHandler {
        void onDungeonItemClick(String clickedDungeonItemIndex);
    }

    public DungeonAdapter(DungeonAdapterOnClickHandler param) {mClickHandler = param;}

    public class DungeonAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView mDungeonTextView;

        public DungeonAdapterViewHolder(View view) {
            super(view);
            mDungeonTextView = (TextView) view.findViewById(R.id.tv_dungeon_data);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String dungeonName = mDungeonData[adapterPosition].name;
            mClickHandler.onDungeonItemClick(dungeonName);
        }
    }

    @Override
    public DungeonAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.dungeon_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        return new DungeonAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DungeonAdapterViewHolder dungeonAdapterViewHolder, int i) {
        String dungeonName = mDungeonData[i].name;
        dungeonAdapterViewHolder.mDungeonTextView.setText(dungeonName);
    }

    public int getItemCount() {
        if(mDungeonData == null){
            return 0;
        } else {
            return mDungeonData.length;
        }

    }

    public void setDungeonData(Dungeon[] dungeons) {
        mDungeonData = dungeons;
        notifyDataSetChanged();
    }
}
