package com.example.week5samsungcoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.week5samsungcoding.model.AlbumResponse;
import com.example.week5samsungcoding.model.datasource.remote.event.AlbumResponseEvent;
import com.example.week5samsungcoding.model.datasource.remote.retrofit.ObserverAlbumResponse;
import com.example.week5samsungcoding.model.datasource.remote.retrofit.RetrofitHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<AlbumResponse> albums;
    AlbumRVAdapter albumRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind

        recyclerView = findViewById(R.id.rvMain);
        //albumRVAdapter = new AlbumRVAdapter(albums);
        //Making network call
        makeCall();

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(albumRVAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAlbumEvent(AlbumResponseEvent event){
        if(event.getAlbumResponse() != null){

            albums = (event.getAlbumResponse());
            albumRVAdapter = new AlbumRVAdapter(albums);
            recyclerView.setAdapter(albumRVAdapter);
        }
    }
    public void makeCall(){
        RetrofitHelper retrofitHelper = new RetrofitHelper();
        //dont need the extra term
        retrofitHelper.getService().getAlbumResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new ObserverAlbumResponse());
    }
}
