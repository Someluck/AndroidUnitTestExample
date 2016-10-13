package com.example.ivanz.androidunittestexample.ui;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.example.ivanz.androidunittestexample.data.api.ApiManager;
import com.example.ivanz.myapplication.backend.myApi.MyApi;
import com.example.ivanz.myapplication.backend.myApi.model.MyBean;

import java.io.IOException;


public class MainPresenter implements Contract.Presenter {

    private Contract.View view;
    private Handler handler;

    public MainPresenter(@NonNull Contract.View view) {
        this.view=view;
        handler=new Handler(Looper.getMainLooper());
    }

    @Override
    public void onReady() {
        view.showProgress(true);
        loadData();
    }

    private void loadData() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MyApi.GetFootballData call = ApiManager.get().myApi().getFootballData();
                    MyBean bean = call.execute();
                    String response = bean.getData();
                    notifyResponse(response);

                } catch (IOException e) {
                   notifyError(e);
                }
            }
        });
    }

    private void notifyResponse(final String response) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.showProgress(false);
                view.showData(response);
            }
        });
    }
    private void notifyError(final Throwable e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                view.showProgress(false);
                view.showError(e.getMessage());
            }
        });
    }
}
