package com.asuper.abocha.cs_go.Adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asuper.abocha.cs_go.Model.GameMap;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapHolder> {

    private List<GameMap> mGameDaoMapList;
    private MapClickListener listener;

    public MapAdapter(List<GameMap> gameDaoMapList, MapClickListener listener){
        this.mGameDaoMapList = gameDaoMapList;
        this.listener = listener;
    }


    @Override
    public MapHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.map_list, parent, false);
        return  new MapHolder(view);
    }

    @Override
    public void onBindViewHolder(MapHolder holder, int position) {
        GameMap gameMap = mGameDaoMapList.get(position);
        holder.bindView(gameMap,listener);
    }

    @Override
    public int getItemCount() {
        return mGameDaoMapList.size();
    }

    public interface MapClickListener{
        void onMapClick(ImageView imageView, Long id);
    }


    static class MapHolder extends RecyclerView.ViewHolder{

        MapClickListener listener;
        GameMap mGameMap;
        @BindView(R.id.cardview_in_map_list) CardView mCardView;
        @BindView(R.id.textview_in_card_map_list) TextView textView;
        @BindView(R.id.imageview_in_card_map_list) ImageView imageView;

        @OnClick(R.id.cardview_in_map_list)
        void onItemClick(){
            listener.onMapClick(imageView, mGameMap.getId());
        }

        public MapHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(GameMap gameMap, MapClickListener listener){
            mGameMap = gameMap;
            textView.setText(gameMap.getShortDescription());
            Glide.with(imageView.getContext())
                    .load(gameMap.getImage())
                    .centerCrop()
                    .override(1200,800) // TODO: 29.03.17 Find optimal size
                    .into(imageView);
            this.listener = listener;
        }
    }

}
