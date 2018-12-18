package com.yoie.com.mvptest.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableInt;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.yoie.com.mvptest.FontApplication;
import com.yoie.com.mvptest.data.FontService;
import com.yoie.com.mvptest.databinding.ContentFontBinding;

import com.yoie.com.mvptest.R;
import com.yoie.com.mvptest.model.Font;
import com.yoie.com.mvptest.model.Item;
import com.yoie.com.mvptest.viewmodel.FontViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FontActivity extends AppCompatActivity implements Observer {
    private FontViewModel fontViewModel;
    private RecyclerView mRecyclerView;
    private FontAdapter mAdapter;
    private ArrayList<Item> mItems = new ArrayList<>();
    private ContentFontBinding mContentFontBinding;
    private int count = 0;
    private FontViewModel mFontViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);
        initDataBinding();
        setupListFontView();
        setupObserver(mFontViewModel);
    }
    public void setupObserver(Observable observable) {
        observable.addObserver(this);
    }
    private void setupListFontView() {
        mRecyclerView = findViewById(R.id.list_font);
        mAdapter = new FontAdapter(mItems);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initDataBinding() {
        mContentFontBinding = DataBindingUtil.setContentView(this, R.layout.content_font);
        mFontViewModel = new FontViewModel(this);
        mContentFontBinding.setVm(mFontViewModel);
    }
    @Override public void update(Observable observable, Object data) {
        if (observable instanceof FontViewModel) {
            FontViewModel fontViewModel = (FontViewModel) observable;
            mItems = fontViewModel.getFontList();
            mItems.get(count).setKind("refresh tag");
            mAdapter.setFontList(mItems);
            mAdapter.notifyDataSetChanged();
            count ++;
            mAdapter.notifyDataSetChanged();
        }
    }



}
