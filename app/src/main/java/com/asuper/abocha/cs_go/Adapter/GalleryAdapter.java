package com.asuper.abocha.cs_go.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.R;
import com.asuper.abocha.cs_go.Tacticks;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by abakarmagomedov on 28.03.17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryHolder> {

    private List<Integer> mapView;
    private GalleryClickListener listener;
    private Tacticks tacticks;

    public GalleryAdapter(List<Integer> mapView, GalleryClickListener listener, Tacticks tacticks) {
        this.mapView = mapView;
        this.listener = listener;
        this.tacticks = tacticks;
    }

    @Override
    public GalleryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.gallery_list, parent, false);
        return new GalleryHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryHolder holder, int position) {
        Integer nextImage = mapView.get(position);
        holder.bindView(nextImage, listener, tacticks);
    }

    @Override
    public int getItemCount() {
        return mapView.size();
    }

    public interface GalleryClickListener {
        void onGalleryItemClick(ImageView imageView, Tacticks tacticks);
    }


    static class GalleryHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageview_in_card_gallery_list) ImageView imageView;
        private Animation mAnimation;
        private GalleryClickListener listener;
        private Tacticks tacticks;

        @OnClick(R.id.cardview_in_gallery_list)
        void onGalleryItemClick() {
            // TODO: 28.03.17 Creating activity with transparent black background and show the image in the big size
            switch (tacticks) {
                case MOLOTOVS:
                    listener.onGalleryItemClick(imageView, Tacticks.MOLOTOVS);
                    break;
                case FLASHBANGS:
                    listener.onGalleryItemClick(imageView, Tacticks.FLASHBANGS);
                    break;
                case SMOKES:
                    listener.onGalleryItemClick(imageView, Tacticks.SMOKES);
                    break;
            }
        }

        public GalleryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Integer nextImage, GalleryClickListener listener, Tacticks tacticks) {
            Glide.with(imageView.getContext())
                    .load(nextImage)
                    .centerCrop()
                    .override(800, 600)
                    .into(imageView);
            this.listener = listener;
            this.tacticks = tacticks;
        }
    }

}
