package com.example.nft.mvp_acitiviypresenter.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.nft.mvp_acitiviypresenter.R;
import com.example.nft.mvp_acitiviypresenter.presenter.Adapter;

/**
 * Created by nft on 18-10-19.
 */

public class ListFragmentView implements IView {
    private View mListFragementView;
    private ListView mListView;
    private ListCallback mCallback;
    @Override
    public void init(LayoutInflater layoutInflater, ViewGroup container) {
        mListFragementView = layoutInflater.inflate(R.layout.list_fragment,null);
        mListView = mListFragementView.findViewById(R.id.listview);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.excute(position);
            }
        });
    }

    @Override
    public View getView() {
        return mListFragementView;
    }

    public void setFragmentAdapter(Adapter adapter){
        mListView.setAdapter(adapter);
    }
    public void setCallback(ListCallback callback){
        this.mCallback = callback;
    }
}
