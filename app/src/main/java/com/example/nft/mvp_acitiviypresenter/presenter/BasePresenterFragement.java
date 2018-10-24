package com.example.nft.mvp_acitiviypresenter.presenter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nft.mvp_acitiviypresenter.view.IView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by nft on 18-10-19.
 */

public abstract class BasePresenterFragement<V extends IView> extends Fragment {
    protected V mIView;
    protected View mView;
    protected EventBus mBus;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        try {
            mBus = EventBus.getDefault();
            mIView = getClassView().newInstance();
            mIView.init(inflater,container);
            mView = mIView.getView();
            onBind();
        }catch (java.lang.InstantiationException e){

        }catch (IllegalAccessException e ){

        }
        return mView;
    }
    protected abstract Class<V> getClassView();
    protected void onBind(){};
    protected void onBeforeResume(){};
    protected void onBeforePause(){};
    protected void onDestroyFragment(){};
    @Override
    public void onResume() {
        onBeforeResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        onDestroyFragment();
        mView = null;
        super.onDestroy();
    }

    @Override
    public void onPause() {
        onBeforePause();
        super.onPause();
    }
}
