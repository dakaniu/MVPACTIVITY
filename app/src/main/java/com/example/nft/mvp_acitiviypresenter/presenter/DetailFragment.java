package com.example.nft.mvp_acitiviypresenter.presenter;

import android.util.Log;

import com.example.nft.mvp_acitiviypresenter.data.DataMap;
import com.example.nft.mvp_acitiviypresenter.data.Event;
import com.example.nft.mvp_acitiviypresenter.view.DetailFragmentView;

import org.greenrobot.eventbus.Subscribe;

import java.util.Map;

/**
 * Created by nft on 18-10-23.
 */

public class DetailFragment extends BasePresenterFragement<DetailFragmentView> {
    private final static String TAG = "DetailFragment";
    Map<String, DataMap> Datas = DataMap.VALUES_MAP;

    @Override
    protected Class<DetailFragmentView> getClassView() {
        return DetailFragmentView.class;
    }

    @Override
    protected void onBind() {
        super.onBind();
    }

    @Override
    protected void onDestroyFragment() {
        mBus.removeAllStickyEvents();
        super.onDestroyFragment();
    }

    @Override
    protected void onBeforeResume() {
        mBus.register(this);
        super.onBeforeResume();
    }

    @Override
    protected void onBeforePause() {
        mBus.unregister(this);
        super.onBeforePause();
    }

    @Subscribe
    public void onEvent(Event event) {
        Log.i(TAG, " String title" + event.getTitle() + "  data " + Datas.get(event.getTitle()));
        mIView.setDetailView(Datas.get(event.getTitle()));
    }

    public static DetailFragment newInstance() {
        Log.i(TAG,"DetailFragment newInstance ");
        return new DetailFragment();
    }
}

