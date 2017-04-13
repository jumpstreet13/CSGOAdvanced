package com.asuper.abocha.cs_go;

import android.Manifest;
import android.media.MediaRecorder;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class VoiceRecordActivity extends BaseActivity {

    @Inject StopwatchTextView stopWatch;
    @BindView(R.id.record) StateImageView record;
    @BindView(R.id.time_stamp) TextView timeStamp;
    @BindView(R.id.activity_voice_recordLayout) CoordinatorLayout layout;
    private MediaRecorder mRecorder = null;
    private static String mFileName = null;

    @OnClick(R.id.record)
    void onRecordClick() {
        if (record.isStateTurnOn()) {
            stopRecord();
            // record.setStateTurnOn(false, ); // TODO: 13.04.17 Add here imageResource
            Snackbar.make(layout, "Succesfully recorded", 3000);
        } else {
            startRecord();
            // record.setStateTurnOn(true, );
        }
    }

    // TODO: 13.04.17 Handle moments when user recording audion and press back button in the same moment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_record);
        ButterKnife.bind(this);
        mFileName = getExternalCacheDir().getAbsolutePath();   // TODO: 13.04.17 Refactor this with Dagger!
        mFileName += StringUtils.FILE_WITH_HELLO;
        injectComponent();
        stopWatch.setUpdateInterval(1);
        stopWatch.setWidget(timeStamp);
    }

    @Override
    public void injectComponent() {
        App.get(this).getComponent().inject(this);
    }

    @NeedsPermission({Manifest.permission.RECORD_AUDIO, Manifest.permission_group.STORAGE})
    private void startRecord() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e("Fail", "prepare() failed");
        }
        mRecorder.start();
    }

    private void stopRecord() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }

    @Override
    public void onBackPressed() {
        if (record.isStateTurnOn()) {
            Snackbar.make(layout, "Recording is turning on, you can not go away!", 2000);
        } else {
            super.onBackPressed();
        }
    }
}
