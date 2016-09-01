package com.ashokslsk.ravi.gallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    double count = 0.0;

    Button orient;
    boolean clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null

        orient = (Button) toolbar.findViewById(R.id.orient);
        setSupportActionBar(toolbar);

        initViews();

        orient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked = true;
                if(clicked) {
                    Orientation(1, layoutManager);
                }else{
                    Orientation(2, layoutManager);
                }
            }
        });
    }

    private void Orientation(int spanCount, RecyclerView.LayoutManager layoutManager) {
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getApplicationContext(), spanCount);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<AndroidVersion> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), androidVersions);
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        Orientation(2, layoutManager);

    }

    private ArrayList<AndroidVersion> prepareData() {

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for (int i = 0; i < android_version_names.length; i++) {
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
