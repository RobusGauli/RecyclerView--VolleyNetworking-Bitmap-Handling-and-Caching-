package com.bex.nptunes.fragments;


import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bex.nptunes.R;
import com.bex.nptunes.adapters.AlbumAdapter;
import com.bex.nptunes.contexts.MyApplication;
import com.bex.nptunes.models.Album;
import com.bex.nptunes.networks.MySingleton;
import com.bex.nptunes.urls.URLEndpoints;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlbumFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlbumFragment extends Fragment {

   public  RequestQueue requestQueue;
    public JsonArrayRequest jsonArrayRequest;



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlbumFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlbumFragment newInstance(String param1, String param2) {
        AlbumFragment fragment = new AlbumFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view =  inflater.inflate(R.layout.fragment_album, container, false);


        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.album_recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //networking starts here......
        requestQueue  = MySingleton.getInstance().getRequestQueue();
        jsonArrayRequest = new JsonArrayRequest(URLEndpoints.AlbumUrl(),new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<Album> list= new ArrayList<>();

                for(int i=0;i<response.length();i++){
                    try {
                        JSONObject o = response.getJSONObject(i);
                        Album album = new Album(o.getInt("albumid"),o.getString("albumname"),o.getString("albumdescription"),o.getString("albumreleaseyear"),o.getString("albumphotofilename"));
                        list.add(album);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
                AlbumAdapter albumAdapter = new AlbumAdapter(getActivity(),list);
                recyclerView.setAdapter(albumAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MyApplication.getMyApplicationContext(), "coudltn fetch the data", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
        return view;

    }




}
