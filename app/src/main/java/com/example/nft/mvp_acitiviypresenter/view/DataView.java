package com.example.nft.mvp_acitiviypresenter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nft.mvp_acitiviypresenter.R;

/**
 * Created by nft on 18-10-19.
 */

public class DataView implements IView {
    private View mAdapterView;
    private TextView mItemView;
    @Override
    public void init(LayoutInflater layoutInflater, ViewGroup container) {

        mAdapterView = layoutInflater.inflate(R.layout.item_view,null);
        mItemView = mAdapterView.findViewById(R.id.adapter_item);
    }

    @Override
    public View getView() {
        return mAdapterView;
    }
    public void setItemView(String text){
        mItemView.setText(text);
    }
}
