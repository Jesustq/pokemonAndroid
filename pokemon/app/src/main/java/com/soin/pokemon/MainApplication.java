package com.soin.pokemon;

import android.app.Application;
import android.content.Context;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Chus on 18/12/2016.
 */

public class MainApplication extends Application{

    private static MainApplication instance;

    private Scheduler mScheduler;

    public MainApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }

    public static MainApplication get(Context context) {
        return (MainApplication) context.getApplicationContext();
    }

    public static Application getApplication() {
        return instance;
    }

    public Scheduler SubscribeScheduler() {
        if (mScheduler == null) mScheduler = Schedulers.io();

        return mScheduler;
    }

    //User to change scheduler from tests
    public void setScheduler(Scheduler scheduler) {
        this.mScheduler = scheduler;
    }
}
