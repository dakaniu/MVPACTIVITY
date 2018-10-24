package com.example.nft.mvp_acitiviypresenter.view;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nft.mvp_acitiviypresenter.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by nft on 18-10-18.
 */

public class MainView implements IView{
    public View mView;
    protected FrameLayout mListContainer,mDetailContainer;
    public Button mButton;
    public TextView mTextView;
    private EventBus mBus;
    int i = 1;
    private OnLoadDateListener mOnloadDateListener;
    @Override
    public void init(LayoutInflater layoutInflater, ViewGroup container) {
        mView = layoutInflater.inflate(R.layout.main_view,container,false);
        mListContainer = (FrameLayout) mView.findViewById(R.id.list_fragment);
        mDetailContainer = (FrameLayout) mView.findViewById(R.id.detail_fragment);
//        mTextView = mView.findViewById(R.id.tv_main_view);
//        mButton= mView.findViewById(R.id.button);
//        mBus = EventBus.getDefault();
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String buttonString = " button"+i;
////                String text = "mainview"+i;
////                mOnloadDateListener.setButtonString(buttonString);
////                mOnloadDateListener.setTextviewString(text);
//                i++;
//                mBus.post("string from bus " +i);
//            }
//        });
    }

    public int getListContainer(){
        return mListContainer.getId();
    }
    public int getDetailContainer(){
        return mDetailContainer.getId();
    }
    @Override
    public View getView() {
        return mView;
    }

//    public void setMainText(String text){
//        mTextView.setText(text);
//        mTextView.setTextColor(Color.GREEN);
//    }
//    public void setMainButtonText(String text){
//        mButton.setText(text);
//        mButton.setTextColor(Color.GREEN);
//    }
    public void setOnloadDateListener(OnLoadDateListener listener){
        this.mOnloadDateListener = listener;
    }
}
