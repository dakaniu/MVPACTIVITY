package com.example.nft.mvp_acitiviypresenter.presenter;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.nft.mvp_acitiviypresenter.R;
import com.example.nft.mvp_acitiviypresenter.view.IView;
import com.example.nft.mvp_acitiviypresenter.view.MainView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by nft on 18-10-18.
 */

public abstract class BasePresenterActivity <V extends IView> extends Activity{
    protected V mMainView;
    protected EventBus bus;
    protected FragmentManager mFm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mMainView =  getMainViewClass().newInstance();
            bus = EventBus.getDefault();
            mFm = getFragmentManager();
            mMainView.init(getLayoutInflater(), null);
            OnBind();
            setContentView(mMainView.getView());
        } catch (IllegalAccessException e) {

        } catch (InstantiationException e) {

        }
    }

    @Override
    protected void onResume() {
        OnResumeIView();
        super.onResume();
    }

    @Override
    protected void onPause() {
        OnPauseIView();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        OnDestroyIView();
        mMainView = null;
        super.onDestroy();
    }

    protected void OnDestroyIView(){};
    protected void OnResumeIView(){};
    protected void OnPauseIView(){};
    protected abstract Class<V> getMainViewClass();

    protected void OnBind(){};
}
