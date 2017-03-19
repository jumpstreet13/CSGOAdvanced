package com.asuper.abocha.cs_go;

import android.app.Application;
import android.content.Context;


public class App extends Application {
    private static App sApp;

    public static App getApp(){
        if(sApp == null){
            sApp = new App();
            return sApp;
        }else{
            return sApp;
        }
    }

    public Context getContext(){
        return sApp.getApplicationContext();
    }

}
