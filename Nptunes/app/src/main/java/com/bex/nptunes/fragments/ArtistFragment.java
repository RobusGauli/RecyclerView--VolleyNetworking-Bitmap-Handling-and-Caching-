package com.bex.nptunes.fragments;


import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bex.nptunes.R;
import com.bex.nptunes.adapters.ArtistAdapter;
import com.bex.nptunes.contexts.MyApplication;
import com.bex.nptunes.models.Artist;
import com.bex.nptunes.networks.MySingleton;
import com.bex.nptunes.urls.URLEndpoints;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistFragment extends Fragment {

    RequestQueue requestQueue;
    JsonArrayRequest jsonArrayRequest;
    List<Artist> artistList = new ArrayList<>();
    public ArtistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_artist, container, false);
        final  RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.artist_recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        requestQueue = MySingleton.getInstance().getRequestQueue();

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URLEndpoints.ArtistUrl(), new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for(int i =0; i<response.length();i++){



                    try {
                        JSONObject o = response.getJSONObject(i);
                        Artist artist = new Artist(o.getInt("artistid"),o.getString("artistname"),o.getString("artistbio"),o.getString("artistcountry"),o.getString("artistphotofilename"),o.getString("artistdateofbirth"),o.getString("artistdateofdeceased"));
                        artistList.add(artist);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                     ArtistAdapter artistAdapter = new ArtistAdapter(getActivity(),artistList);
                    recyclerView.setAdapter(artistAdapter);


                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyApplication.getMyApplicationContext(), "coudltn fetch the data", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
        return view;



    }

}



