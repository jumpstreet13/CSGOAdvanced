package com.asuper.abocha.cs_go.Stream;

import android.app.ProgressDialog;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.asuper.abocha.cs_go.App;
import com.asuper.abocha.cs_go.BaseActivity;
import com.asuper.abocha.cs_go.R;

import javax.inject.Inject;

import butterknife.BindView;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class StreamActivity extends BaseActivity {


    @Inject ProgressDialog mProgressDialog;
    @BindView(R.id.videoView) VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        mProgressDialog.show();
        String httpLiveUrl = "";  // TODO: 14.04.17 https://www.reddit.com/r/DotA2/comments/3dy316/small_website_to_extract_raw_stream_urls_from/ where i can get link to stream
        videoView.setVideoURI(Uri.parse(httpLiveUrl));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.setVideoChroma(MediaPlayer.VIDEOCHROMA_RGB565);
        videoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);
        videoView.start();
        while (true){
            if(videoView.isPlaying()){
                mProgressDialog.dismiss();
                break;
            }
        }

        // TODO: 14.04.17 Add slide transition appear http://stackoverflow.com/questions/10243557/how-to-apply-slide-animation-between-two-activities-in-android
    }


    @Override
    public void injectComponent() {
        App.get(this).getComponent().inject(this);
    }
}