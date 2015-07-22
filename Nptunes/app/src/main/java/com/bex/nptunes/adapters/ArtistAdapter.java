package com.bex.nptunes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.bex.nptunes.R;
import com.bex.nptunes.models.Artist;
import com.bex.nptunes.networks.MySingleton;

import java.util.List;

/**
 * Created by Robus on 7/21/2015.
 */
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> {

    LayoutInflater layoutInflater;
    List<Artist> artistList;
    ImageLoader imageLoader;

    public ArtistAdapter(Context context,List<Artist> artistList){

        layoutInflater = LayoutInflater.from(context);
        this.artistList = artistList;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.artist_row,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;


    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Artist artist = artistList.get(position);
        holder.artistName.setText(artist.getArtistName());
        holder.artistCountry.setText(artist.getArtistCountry());

        imageLoader = MySingleton.getInstance().getImageLoader();
        holder.artistView.setImageUrl(artist.getArtistPhotoFileName(),imageLoader);

    }

    @Override
    public int getItemCount() {
        return artistList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        NetworkImageView artistView;
        TextView artistName,artistCountry;

        public MyViewHolder(View itemView) {
            super(itemView);
            artistView = (NetworkImageView)itemView.findViewById(R.id.artist_image);
            artistName = (TextView)itemView.findViewById(R.id.artist_name);
            artistCountry=(TextView)itemView.findViewById(R.id.artist_country);

        }
    }
}
