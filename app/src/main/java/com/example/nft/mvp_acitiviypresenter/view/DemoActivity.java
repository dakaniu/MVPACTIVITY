package com.example.nft.mvp_acitiviypresenter.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.nft.mvp_acitiviypresenter.R;
import com.example.nft.mvp_acitiviypresenter.data.Event;

/**
 * Created by nft on 18-10-19.
 */

public class DemoActivity extends Activity {
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.main_view);
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_view);
    }
    public void onEvent(Event event){
        Log.i("MainActivity","Demo event");
    }
}
