package com.example.ivanz.androidunittestexample.ui;

public interface Contract {
    interface View{
        void showData(String data);

        void showError(String message);

        void showProgress(boolean isInProgress);
    }

    interface Presenter{
        void onReady();
    }
}
