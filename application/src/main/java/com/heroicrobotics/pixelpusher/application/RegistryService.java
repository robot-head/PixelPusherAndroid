package com.heroicrobotics.pixelpusher.application;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.heroicrobot.dropbit.registry.DeviceRegistry;

import java.util.Observable;
import java.util.Observer;

public class RegistryService extends Service {

    private final IBinder mBinder = new LocalBinder();
    public DeviceRegistry registry;
    private PixelPusherObserver observer;

    // final Messenger mMessenger = new Messenger(new IncomingHandler());

    @Override
    public IBinder onBind(Intent arg0) {
        // return mMessenger.getBinder();
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        registry.stopPushing();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registry = new DeviceRegistry();
        observer = new PixelPusherObserver();
        registry.addObserver(observer);
        registry.setAntiLog(true);
    }

    // class IncomingHandler extends Handler {
    //
    // @Override
    // public void handleMessage(Message msg) {
    // super.handleMessage(msg);
    // }
    //
    // }

    public DeviceRegistry getRegistry() {
        return registry;
    }

    class PixelPusherObserver implements Observer {

        @Override
        public void update(Observable registry, Object updatedDevice) {

        }

    }

    public class LocalBinder extends Binder {
        RegistryService getService() {
            return RegistryService.this;
        }
    }

}