package com.asuper.abocha.cs_go.MapDetail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.asuper.abocha.cs_go.Adapter.GalleryAdapter;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapDetail extends BaseActivity implements GalleryAdapter.GalleryClickListener {

    @BindView(R.id.image_collapse) ImageView mapImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_detail);
        ButterKnife.bind(this);
        Glide.with(this)
                .load(R.drawable.de_inferno)
                .centerCrop()
                .into(mapImage);

    }

    @Override
    public void onGalleryItemClick(ImageView imageView) {

    }
}
