package com.bex.nptunes.models;

/**
 * Created by Robus on 7/20/2015.
 */
public class Album {

    private int albumId;
    private String albumName;
    private String albumDescription;
    private String albumReleaseYear;
    private String albumPhotoFileName;

    public Album(int albumId, String albumName, String albumDescription, String albumReleaseYear, String albumPhotoFileName) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumDescription = albumDescription;
        this.albumReleaseYear = albumReleaseYear;
        this.albumPhotoFileName = albumPhotoFileName;
    }


    public Album(){

    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }

    public String getAlbumReleaseYear() {
        return albumReleaseYear;
    }

    public void setAlbumReleaseYear(String albumReleaseYear) {
        this.albumReleaseYear = albumReleaseYear;
    }

    public String getAlbumPhotoFileName() {
        return albumPhotoFileName;
    }

    public void setAlbumPhotoFileName(String albumPhotoFileName) {
        this.albumPhotoFileName = albumPhotoFileName;
    }
}
