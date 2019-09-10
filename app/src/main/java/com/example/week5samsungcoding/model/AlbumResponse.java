package com.example.week5samsungcoding.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

//TODO set this class to be used with ROOM
public class AlbumResponse implements Parcelable {

	@SerializedName("albumId")
	private Integer albumId;
	@SerializedName("id")
	private Integer id;
	@SerializedName("title")
	private String title;
	@SerializedName("url")
	private String url;
	@SerializedName("thumbnailUrl")
	private String thumbnailUrl;

	protected AlbumResponse(Parcel in) {
		if (in.readByte() == 0) {
			albumId = null;
		} else {
			albumId = in.readInt();
		}
		if (in.readByte() == 0) {
			id = null;
		} else {
			id = in.readInt();
		}
		title = in.readString();
		url = in.readString();
		thumbnailUrl = in.readString();
	}

	public static final Creator<AlbumResponse> CREATOR = new Creator<AlbumResponse>() {
		@Override
		public AlbumResponse createFromParcel(Parcel in) {
			return new AlbumResponse(in);
		}

		@Override
		public AlbumResponse[] newArray(int size) {
			return new AlbumResponse[size];
		}
	};

	public void setAlbumId(int albumId){
		this.albumId = albumId;
	}

	public int getAlbumId(){
		return albumId;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setThumbnailUrl(String thumbnailUrl){
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getThumbnailUrl(){
		return thumbnailUrl;
	}

	@Override
 	public String toString(){
		return 
			"AlbumResponse{" + 
			"albumId = '" + albumId + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",thumbnailUrl = '" + thumbnailUrl + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		if (albumId == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(albumId);
		}
		if (id == null) {
			parcel.writeByte((byte) 0);
		} else {
			parcel.writeByte((byte) 1);
			parcel.writeInt(id);
		}
		parcel.writeString(title);
		parcel.writeString(url);
		parcel.writeString(thumbnailUrl);
	}
}
