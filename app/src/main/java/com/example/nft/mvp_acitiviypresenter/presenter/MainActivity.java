package com.example.nft.mvp_acitiviypresenter.presenter;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nft.mvp_acitiviypresenter.data.Event;
import com.example.nft.mvp_acitiviypresenter.presenter.BasePresenterActivity;
import com.example.nft.mvp_acitiviypresenter.view.IView;
import com.example.nft.mvp_acitiviypresenter.view.MainView;
import com.example.nft.mvp_acitiviypresenter.view.OnLoadDateListener;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BasePresenterActivity<MainView> implements OnLoadDateListener{

    private final static String TAG = "MainActivity";
    @Override
    protected void OnBind() {
        super.OnBind();
//        mMainView.setMainText("dsdfsdg");
        mMainView.setOnloadDateListener(this);
       FragmentTransaction fm= mFm.beginTransaction();
        mFm.beginTransaction().add(mMainView.getListContainer(),ListFragment.newInstance(),ListFragment.class.getName()).add(mMainView.getDetailContainer(),DetailFragment.newInstance(),DetailFragment.class.getName()).commit();
//        mFm.beginTransaction().replace(mMainView.getContainer(),DetailFragment.newInstance(),DetailFragment.class.getName()).commit();
    }

    @Override
    protected Class<MainView> getMainViewClass() {
        return MainView.class;
    }

    @Override
    protected void OnResumeIView() {
        bus.register(this);
        super.OnResumeIView();
    }

    @Override
    protected void OnPauseIView() {
        bus.unregister(this);
        super.OnPauseIView();
    }

    @Override
    protected void OnDestroyIView() {
        bus.removeAllStickyEvents();
        super.OnDestroyIView();
    }

    @Override
    public void setButtonString(String buttonString) {
//        mMainView.setMainButtonText(buttonString);
    }

    @Override
    public void setTextviewString(String textviewString) {
//        mMainView.setMainText(textviewString);
    }
    @Subscribe
    public void onEvent(Event event){
//        mMainView.setMainText(text);
        Log.i(TAG,"MainActivity onEvent");

    }
}
