package com.asuper.abocha.cs_go.Model;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapHolder> {

    private List<Map> mapList;
    private Context mContext;

    public MapAdapter(Context context, List<Map> mapList){
        this.mapList = mapList;
        this.mContext = context;
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
        holder.bindView(map, mContext);
    }

    @Override
    public int getItemCount() {
        return mapList.size();
    }


    static class MapHolder extends RecyclerView.ViewHolder{

        //@BindView(R.id.textview_in_card_map_list) TextView textView;
       // @BindView(R.id.imageview_in_card_map_list) ImageView imageView;
        TextView textView;
        ImageView imageView;

        public MapHolder(View itemView) {
            super(itemView);
             textView = (TextView) itemView.findViewById(R.id.textview_in_card_map_list);
            imageView = (ImageView) itemView.findViewById(R.id.imageview_in_card_map_list);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Map map, Context context){
            textView.setText(map.getShortDescription());
            Glide.with(context)
                    .load(map.getImage())
                    .override(800, 600)
                    .centerCrop()
                    .into(imageView);
        }
    }

}
