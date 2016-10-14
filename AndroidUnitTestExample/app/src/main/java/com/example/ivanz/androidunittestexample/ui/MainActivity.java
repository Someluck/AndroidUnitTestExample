package com.example.ivanz.androidunittestexample.ui;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ivanz.androidunittestexample.BuildConfig;
import com.example.ivanz.androidunittestexample.R;

public class MainActivity extends AppCompatActivity implements Contract.View {
    private  Contract.Presenter presenter;
    private TextView responseView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainPresenter(this);
        setContentView(R.layout.activity_main);
        responseView=(TextView)findViewById(R.id.responseView);
        progressBar = ((ProgressBar) findViewById(R.id.progresBar));
        presenter.onReady();
    }

    @Override
    public void showData(String data) {
        responseView.setText(data);
    }

    @Override
    public void showError(String message) {
        new AlertDialog.Builder(this).setMessage(message).create().show();
    }

    @Override
    public void showProgress(boolean isInProgress) {
        progressBar.setVisibility(isInProgress ? View.VISIBLE : View.GONE);
    }
}
