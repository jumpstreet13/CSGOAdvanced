package com.asuper.abocha.cs_go.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abakarmagomedov on 29.03.17.
 */

public class GalleryBigAdapter extends RecyclerView.Adapter<GalleryBigAdapter.GalleryBigHolder> {

    private List<Integer> mapView;
    private GalleryBigAdapter.GalleryBigClickListener listener;

    public GalleryBigAdapter(List<Integer> mapView, GalleryBigAdapter.GalleryBigClickListener listener){
        this.mapView = mapView;
        this.listener = listener;
    }


    @Override
    public GalleryBigAdapter.GalleryBigHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.big_image_for_gallery, parent, false);
        return  new GalleryBigAdapter.GalleryBigHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryBigAdapter.GalleryBigHolder holder, int position) {
        Integer nextImage = mapView.get(position);
        holder.bindView(nextImage,listener);
    }

    @Override
    public int getItemCount() {
        return mapView.size();
    }

    public interface GalleryBigClickListener{
        void onGalleryItemClick(ImageView imageView);
    }


    static class GalleryBigHolder extends RecyclerView.ViewHolder{

        Animation mAnimation;
        GalleryBigClickListener listener;
        @BindView(R.id.big_gallery_image) ImageView imageView;

        @OnClick(R.id.big_gallery_image)
        void onGalleryItemClick(){
            listener.onGalleryItemClick(imageView);
            // TODO: 28.03.17 Creating activity with transparent black background and show the image in the big size
        }

        public GalleryBigHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Integer nextImage, GalleryBigAdapter.GalleryBigClickListener listener){
            Glide.with(imageView.getContext())
                    .load(nextImage)
                    .centerCrop()
                    .override(1800, 2200)
                    .into(imageView);
            this.listener = listener;
        }
    }

}
