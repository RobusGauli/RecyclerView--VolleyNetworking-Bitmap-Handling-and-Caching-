package com.bex.nptunes.models;

/**
 * Created by Robus on 7/21/2015.
 */
public class Artist {
    private int artistId;
    private String artistName;
    private String artistBio;
    private String artistCountry;
    private String artistPhotoFileName;
    private String artistDateOfBirth;
    private String artistDateOfDeceased;


    public Artist(int artistId, String artistName, String artistBio, String artistCountry, String artistPhotoFileName, String artistDateOfBirth, String artistDateOfDeceased) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistBio = artistBio;
        this.artistCountry = artistCountry;
        this.artistPhotoFileName = artistPhotoFileName;
        this.artistDateOfBirth = artistDateOfBirth;
        this.artistDateOfDeceased = artistDateOfDeceased;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistBio() {
        return artistBio;
    }

    public void setArtistBio(String artistBio) {
        this.artistBio = artistBio;
    }

    public String getArtistCountry() {
        return artistCountry;
    }

    public void setArtistCountry(String artistCountry) {
        this.artistCountry = artistCountry;
    }

    public String getArtistPhotoFileName() {
        return artistPhotoFileName;
    }

    public void setArtistPhotoFileName(String artistPhotoFileName) {
        this.artistPhotoFileName = artistPhotoFileName;
    }

    public String getArtistDateOfBirth() {
        return artistDateOfBirth;
    }

    public void setArtistDateOfBirth(String artistDateOfBirth) {
        this.artistDateOfBirth = artistDateOfBirth;
    }

    public String getArtistDateOfDeceased() {
        return artistDateOfDeceased;
    }

    public void setArtistDateOfDeceased(String artistDateOfDeceased) {
        this.artistDateOfDeceased = artistDateOfDeceased;
    }
}
