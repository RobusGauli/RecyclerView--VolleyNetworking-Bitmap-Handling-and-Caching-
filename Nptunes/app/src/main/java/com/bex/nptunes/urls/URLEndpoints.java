package com.bex.nptunes.urls;

import com.bex.nptunes.urls.Endpoints;

public class URLEndpoints {

    public static String AlbumUrl(){

        String url = Endpoints.BASE_URL+Endpoints.ALBUM_URL;
        return url;
    }

    public static String ArtistUrl(){

        String url = Endpoints.BASE_URL+Endpoints.ARTIST_URL;
        return url;
    }
}
