package com.example.mymusicapp;

public class Song {
    /** Get song name*/
    private String mSongName;

    /** Miwok song artist*/
    private String mSongArtist;

    /**Get the song*/
    private int mAudioResourceId;

    /** Image resource ID for the song */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this song*/
    private static final int NO_IMAGE_PROVIDED = -1;

    public Song(String songName, String songArtist, int audioResourceId) {
        mSongName= songName;
        mSongArtist= songArtist;
        mAudioResourceId = audioResourceId;
    }

    public Song(String songName, String songArtist, int audioResourceId, int albumImageResourceId) {
        mSongName= songName;
        mSongArtist= songArtist;
        mAudioResourceId = audioResourceId;
        mImageResourceId = albumImageResourceId;
    }


    public String getmSongName() {
        return mSongName;
    }

    public String getmSongArtist() {
        return mSongArtist;
    }

    /**
     * Return the image resource ID of the song.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this song.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getmAudioResourceId(){ return mAudioResourceId; }
}
