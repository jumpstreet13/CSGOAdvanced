package com.asuper.abocha.cs_go.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.asuper.abocha.cs_go.Model.Map;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abakarmagomedov on 28.03.17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryHolder> {

    private List<Map> mapList;
    private MapAdapter.MapClickListener listener;

    public GalleryAdapter(List<Map> mapList, MapAdapter.MapClickListener listener){
        this.mapList = mapList;
        this.listener = listener;
    }


    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.map_list, parent, false);
        return  new GalleryHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryHolder holder, int position) {
        Map map = mapList.get(position);
        holder.bindView(map,listener);
    }

    @Override
    public int getItemCount() {
        return mapList.size();
    }

    public interface GalleryClickListener{
        void onGalleryItemClick(ImageView imageView);
    }


    static class GalleryHolder extends RecyclerView.ViewHolder{

        Animation mAnimation;
        MapAdapter.MapClickListener listener;
        @BindView(R.id.imageview_in_card_gallery_list) ImageView imageView;

        @OnClick(R.id.cardview_in_map_list)
        void onGalleryItemClick(){
            // TODO: 28.03.17 Creating activity with transparent black background and show the image in the big size
        }

        public GalleryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Map map, MapAdapter.MapClickListener listener){
            Glide.with(imageView.getContext())
                    .load(map.getImage())
                    .centerCrop()
                    .override(1200,800)
                    .into(imageView);
            this.listener = listener;
        }
    }

}
