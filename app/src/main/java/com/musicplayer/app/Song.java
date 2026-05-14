package com.musicplayer.app;

import android.net.Uri;

public class Song {
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
