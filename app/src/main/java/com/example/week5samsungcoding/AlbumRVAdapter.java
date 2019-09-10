package com.example.week5samsungcoding;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week5samsungcoding.model.AlbumResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AlbumRVAdapter extends RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>{
    private List<AlbumResponse> albums;
    //constructor for Adapter
    public AlbumRVAdapter(List<AlbumResponse> albums){
        this.albums = albums;
        }

    public void setListItems(List<AlbumResponse> albums){
        this.albums = albums;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AlbumRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_list_item,parent,false);
        return new ViewHolder(inflated);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlbumResponse albumResponse = albums.get(position);
        holder.populate(albumResponse);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView cardImg;
        TextView cardTitle;
        TextView cardInfo;

        //object bound to the View
        AlbumResponse albumResponse;

        public ViewHolder(View itemView){
            super(itemView);
            //Bind the objects
            cardImg = itemView.findViewById(R.id.ivCardListItem);
            cardTitle = itemView.findViewById(R.id.tvCardListTitle);
            cardInfo = itemView.findViewById(R.id.tvCardListDescription);

            itemView.setOnClickListener(this);
        }

        public void setAlbum(AlbumResponse albumResponse){ this.albumResponse = albumResponse; }

        public void populate(AlbumResponse albumResponse){
            //todo set with picasso
            Picasso.get().load(albumResponse.getUrl()).into(cardImg);
            cardTitle.setText(albumResponse.getTitle());
            cardInfo.setText("Album "+albumResponse.getAlbumId() + " ID:" + albumResponse.getId());
        }

        @Override
        public void onClick(View view) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("album", albumResponse);
            Intent detail = new Intent(view.getContext(), DetailActivity.class);
            detail.putExtras(bundle);

        }
    }
}
