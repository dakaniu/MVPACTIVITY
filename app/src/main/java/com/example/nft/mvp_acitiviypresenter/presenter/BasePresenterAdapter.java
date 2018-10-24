package com.example.nft.mvp_acitiviypresenter.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.example.nft.mvp_acitiviypresenter.view.IView;

/**
 * Created by nft on 18-10-19.
 */

public abstract class BasePresenterAdapter<V extends IView> extends BaseAdapter{
    protected V mDataView;
    protected View mView;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            try {
                mDataView = getAdapterClassView().newInstance();
                mDataView.init(inflater,parent);
                convertView = mDataView.getView();
                convertView.setTag(mDataView);
            }catch (IllegalAccessException e ){

            }catch (InstantiationException e ){

            }
        } else {
            mDataView = (V)convertView.getTag();
        }

        if (convertView!=null){
            onBindItem(position);
        }
        return convertView;
    }
    protected abstract Class<V> getAdapterClassView();
    protected void onBindItem(int position){};
}
