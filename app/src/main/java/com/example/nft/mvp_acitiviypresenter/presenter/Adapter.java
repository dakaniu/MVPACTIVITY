package com.example.nft.mvp_acitiviypresenter.presenter;

import com.example.nft.mvp_acitiviypresenter.data.DataMap;
import com.example.nft.mvp_acitiviypresenter.view.DataView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nft on 18-10-19.
 */

public class Adapter extends BasePresenterAdapter<DataView> {
    List<String> titles = new ArrayList<>(DataMap.VALUES_MAP.keySet());
    @Override
    protected void onBindItem(int position) {
        super.onBindItem(position);
        mDataView.setItemView(titles.get(position));
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    public String getTitle(){
//
//    }
    @Override
    protected Class<DataView> getAdapterClassView() {
        return DataView.class;
    }
}
