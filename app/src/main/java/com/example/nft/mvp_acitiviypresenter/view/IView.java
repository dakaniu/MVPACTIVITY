package com.example.nft.mvp_acitiviypresenter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nft on 18-10-18.
 */

public interface IView {
    public abstract void init(LayoutInflater layoutInflater, ViewGroup container);
    public abstract View getView();
}
