package com.musicplayer.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable {
    private long id;
    private String title;
    private String artist;
    private long duration;
    private Uri uri;

    public Song(long id, String title, String artist, long duration, Uri uri) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.uri = uri;
    }

    protected Song(Parcel in) {
        id = in.readLong();
        title = in.readString();
        artist = in.readString();
        duration = in.readLong();
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) { return new Song(in); }
        @Override
        public Song[] newArray(int size) { return new Song[size]; }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeLong(duration);
        dest.writeParcelable(uri, flags);
    }

    public long getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public long getDuration() { return duration; }
    public Uri getUri() { return uri; }

    public String getDurationText() {
        long min = duration / 1000 / 60;
        long sec = duration / 1000 % 60;
        return String.format("%d:%02d", min, sec);
    }
}
