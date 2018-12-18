package com.yoie.com.mvptest.viewmodel;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yoie.com.mvptest.FontApplication;
import com.yoie.com.mvptest.R;
import com.yoie.com.mvptest.data.FontResponse;
import com.yoie.com.mvptest.data.FontService;
import com.yoie.com.mvptest.model.Font;
import com.yoie.com.mvptest.model.Item;
import com.yoie.com.mvptest.view.FontActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class FontViewModel extends Observable {
    private ArrayList<Item> fontList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ProgressDialog progressDoalog;
    Timer timer = new Timer();

    TimerTask mTimerTask = new TimerTask() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            fetchPeopleList();
        }
    };


    public FontViewModel(@NonNull Context context) {
        this.context = context;
        this.fontList = new ArrayList<>();
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Its loading....");
        progressDoalog.setTitle("ProgressDialog bar example");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDoalog.setIndeterminate(true);
        begin();
    }

    public void begin() {
        timer.schedule(mTimerTask, 1000, 1000*10);
    }
    public ArrayList<Item> getFontList() {
        return fontList;
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
    private void fetchPeopleList() {

        FontApplication fontApplication = FontApplication.create(context);
        FontService fontService = fontApplication.getFontService();
        Disposable disposable = fontService.fetchFont()
                .subscribeOn(fontApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Font>() {
                    @Override public void accept(Font fontResponse) {
                        progressDoalog.setMessage("download finish");
                        changeFontDataSet(fontResponse.getItems());

                        progressDoalog.cancel();

                    }
                }, new Consumer<Throwable>() {
                    @Override public void accept(Throwable throwable) {
                    }
                });

        compositeDisposable.add(disposable);
    }
    private void changeFontDataSet(ArrayList<Item> fonts) {
        fontList = fonts ;
        setChanged();
        notifyObservers();
    }


    public void onClickFabLoad() {
        progressDoalog.setMessage("start download");
        progressDoalog.show();
        fetchPeopleList();
    }
}
