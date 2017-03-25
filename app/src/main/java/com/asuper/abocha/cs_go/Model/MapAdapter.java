package com.asuper.abocha.cs_go.Model;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapHolder> {

    private List<Map> mapList;
    private MapClickListener listener;

    public MapAdapter(List<Map> mapList, MapClickListener listener){
        this.mapList = mapList;
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
        Map map = mapList.get(position);
        holder.bindView(map,listener);
    }

    @Override
    public int getItemCount() {
        return mapList.size();
    }

    public interface MapClickListener{
        void onMapClick(ImageView imageView);
    }


    static class MapHolder extends RecyclerView.ViewHolder{

        Animation mAnimation;
        MapClickListener listener;
        @BindView(R.id.textview_in_card_map_list) TextView textView;
        @BindView(R.id.imageview_in_card_map_list) ImageView imageView;

        @OnClick(R.id.cardview_in_map_list)
        void onClick(){
            // TODO: 18.03.2017 Перенести процесс анимации в активити, а также сделать анимацию по z оси
          //  mAnimation = AnimationUtils.loadAnimation(imageView.getContext(), R.anim.shake_card);
          //  imageView.startAnimation(mAnimation);
            listener.onMapClick(imageView);
        }

        public MapHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Map map, MapClickListener listener){
            textView.setText(map.getShortDescription());
            Glide.with(imageView.getContext())
                    .load(map.getImage())
                    .centerCrop()
                    .override(1200,800)
                    .into(imageView);
            this.listener = listener;
        }
    }

}
