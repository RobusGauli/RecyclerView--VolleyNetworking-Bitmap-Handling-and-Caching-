package com.bex.nptunes.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import com.bex.nptunes.R;
import com.bex.nptunes.fragments.CollectionFragment;

;


public class CollectionActivity extends ActionBarActivity {
    public static final String FRAG_COLLECTION_TAG = "fragmentCollection";
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.collection_container, new CollectionFragment(), FRAG_COLLECTION_TAG);
        fragmentTransaction.commit();


    }


}
