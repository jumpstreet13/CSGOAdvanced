package com.asuper.abocha.cs_go.Di;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.transition.TransitionManager;
import android.widget.ProgressBar;

import com.asuper.abocha.cs_go.Data.DaoMaster;
import com.asuper.abocha.cs_go.Data.GameDaoMapDao;
import com.asuper.abocha.cs_go.Managers.MyTransitionManager;
import com.asuper.abocha.cs_go.R;
import com.asuper.abocha.cs_go.StopwatchTextView;
import com.google.gson.Gson;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abakarmagomedov on 31.03.17.
 */

@Module
public class UtilsModule {


    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    GameDaoMapDao provideDao(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "cs-db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession().getGameDaoMapDao();
    }

    @Provides
    @Singleton
    ProgressDialog provideProgressBar(Context context){
        ProgressDialog progressDialog = new ProgressDialog(context, R.style.ProgressBarStyle);
        progressDialog.setCancelable(false);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //progressDialog.setContentView(R.layout.progress_splash);
        return progressDialog;
    }

    @NonNull
    @Provides
    @Singleton
    MyTransitionManager provideManager() {
        return new MyTransitionManager();
    }

    @Provides
    @Singleton
    StopwatchTextView provideStopWatch(){return  new StopwatchTextView();}

}
