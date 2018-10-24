package com.example.nft.mvp_acitiviypresenter.presenter;

import android.nfc.Tag;
import android.util.Log;

import com.example.nft.mvp_acitiviypresenter.data.Event;
import com.example.nft.mvp_acitiviypresenter.view.ListCallback;
import com.example.nft.mvp_acitiviypresenter.view.ListFragmentView;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by nft on 18-10-19.
 */

public class ListFragment extends BasePresenterFragement<ListFragmentView> {
    private final static String TAG = "ListFragment";
    private Adapter adapter = new Adapter();
    private ListCallback callback = new ListCallback() {
        @Override
        public void excute(int position) {
            mBus.post(new Event((String) adapter.getItem(position)));
        }
    };

    @Override
    protected void onBind() {
        super.onBind();
        mIView.setFragmentAdapter(adapter);
        mIView.setCallback(callback);
    }

    @Override
    protected Class<ListFragmentView> getClassView() {
        return ListFragmentView.class;
    }

    @Override
    protected void onBeforePause() {
        mBus.unregister(this);
        super.onBeforePause();
    }

    @Override
    protected void onBeforeResume() {
        mBus.register(this);
        super.onBeforeResume();
    }

    @Override
    protected void onDestroyFragment() {
        mBus.removeAllStickyEvents();
        super.onDestroyFragment();
    }

    @Subscribe
    public void onEvent(Event event) {
        Log.i(TAG, "ListFragment onEvent ");
    }

    public static ListFragment newInstance() {
        Log.i(TAG, "ListFragment newInstance ");
        return new ListFragment();
    }
}
