package com.example.week5samsungcoding.model.datasource.remote.retrofit;

import com.example.week5samsungcoding.model.AlbumResponse;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.example.week5samsungcoding.model.datasource.remote.retrofit.CONSTANTS.API_PATH;

public interface AlbumResponseService {

    @GET(API_PATH)
    //Calling observable to set up the scheme
    Observable <List<AlbumResponse>> getAlbumResponse();
}
