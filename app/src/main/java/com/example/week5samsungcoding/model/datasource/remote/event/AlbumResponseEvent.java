package com.example.week5samsungcoding.model.datasource.remote.event;

import com.example.week5samsungcoding.model.AlbumResponse;

import java.util.ArrayList;
import java.util.List;

public class AlbumResponseEvent {
    List<AlbumResponse> albums;

    //This returns the album response
    public List<AlbumResponse> getAlbumResponse(){
        return albums;
    }

    public void setAlbumResponse(List<AlbumResponse> albums){
        this.albums = albums;
    }
    //constructor
    public AlbumResponseEvent(List<AlbumResponse> albums){
        this.albums = albums;
    }
}
