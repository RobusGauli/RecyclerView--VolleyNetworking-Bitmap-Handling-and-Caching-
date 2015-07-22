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
import com.bex.nptunes.models.Album;
import com.bex.nptunes.networks.MySingleton;

import java.util.List;


/**
 * Created by Robus on 7/20/2015.
 */
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.MyViewHolder> {

    List<Album> list;
    LayoutInflater layoutInflater;
    ImageLoader imageLoader;

    public AlbumAdapter(Context context,List<Album> list){
        layoutInflater = LayoutInflater.from(context);
        this.list = list;


    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = layoutInflater.inflate(R.layout.album_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Album album = list.get(position);
        holder.albumName.setText(album.getAlbumName());
        holder.artistName.setText(album.getAlbumReleaseYear());
        imageLoader = MySingleton.getInstance().getImageLoader();
        holder.albumView.setImageUrl(album.getAlbumPhotoFileName(),imageLoader);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        NetworkImageView albumView;
        TextView  albumName,artistName;

        public MyViewHolder(View itemView) {
            super(itemView);
            albumView = (NetworkImageView)itemView.findViewById(R.id.album_image);
            albumName = (TextView)itemView.findViewById(R.id.album_name);
            artistName = (TextView)itemView.findViewById(R.id.album_artist_name);

        }
    }
}
