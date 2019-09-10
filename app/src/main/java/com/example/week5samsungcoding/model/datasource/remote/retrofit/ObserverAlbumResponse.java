package com.example.week5samsungcoding.model.datasource.remote.retrofit;

import android.util.Log;

import com.example.week5samsungcoding.model.AlbumResponse;
import com.example.week5samsungcoding.model.datasource.remote.event.AlbumResponseEvent;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ObserverAlbumResponse implements Observer<List<AlbumResponse>> {
    //Hold object to get ready to post this.
    List<AlbumResponse> albums;

    @Override
    public void onSubscribe(Disposable d) {
        // Optional: Log this
    }

    @Override
    public void onNext(List<AlbumResponse> albums) {
        this.albums = albums;
    }

    @Override
    public void onError(Throwable e) {
        Log.e("ERROR ", "onError: ", e);
    }

    @Override
    public void onComplete() {
        //When it is done then pass the results along the event bus
        EventBus.getDefault().post(new AlbumResponseEvent(albums));
    }
}
