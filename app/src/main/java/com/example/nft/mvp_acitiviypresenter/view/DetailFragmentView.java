package com.example.nft.mvp_acitiviypresenter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nft.mvp_acitiviypresenter.R;
import com.example.nft.mvp_acitiviypresenter.data.DataMap;

/**
 * Created by nft on 18-10-23.
 */

public class DetailFragmentView implements IView {
    private View mDetailView;
    private TextView mTitle,mBody;
    @Override
    public void init(LayoutInflater layoutInflater, ViewGroup container) {

        mDetailView = layoutInflater.inflate(R.layout.deatil_view,null);
        mTitle = mDetailView.findViewById(R.id.text_title);
        mBody = mDetailView.findViewById(R.id.text_body);
    }

    @Override
    public View getView() {
        return mDetailView;
    }

    public void setDetailView(DataMap map) {
        mTitle.setText(map.title+":");
        mBody.setText(map.body);
    }
}
