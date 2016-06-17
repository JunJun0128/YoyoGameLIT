package com.example.junekelectric.yoyofishing;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class PlayActivity extends ActionBarActivity {

    private static final int PROGRESS_MAX = 300;

    private ProgressBar mProgressBar;
    private int mProgress;
    private int mVaritation = 14;
    private Timer mTimer;
    private Handler mHandler = new Handler();

    private Button mFishingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setMax(PROGRESS_MAX);
        mFishingButton = (Button) findViewById(R.id.button2);
    }

    /*public void fishing(View view) {
        Random random = new Random();
        int result = random.nextInt(5);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", result);
        startActivity(intent);
    }*/

    @Override
    protected void onResume() {
        super.onResume();
        mProgress = 0;
        mProgressBar.setProgress(mProgress);
        mFishingButton.setText("釣りスタート！");
    }

    private void fishingStart() {
        if (mTimer == null) {
            mProgress = 0;
            mTimer = new Timer();
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgress += mVaritation;
                            if (mProgress > PROGRESS_MAX) {
                                mVaritation = mVaritation * -1;
                                mProgress = PROGRESS_MAX;
                            } else if(mProgress < 0) {
                                mVaritation = mVaritation * -1;
                                mProgress = 0;}
                            mProgressBar.setProgress(mProgress);}});}}, 100, 30);}}



    private void fishingEnd() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;

            int progress = mProgressBar.getProgress();
            int point = Math.abs(mProgressBar.getMax() - progress);
            Random random = new Random();
            int result = random.nextInt(5);

            if (point < 10) {
                result = 4;
            } else if (point < 30) {
                result = 3;
            } else if (point < 60) {
                result = 2;
            } else if (point < 100) {
                result = 1;
            } else {
                result = 0;
            }

            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);}}

    public void fishing(View view) {
        if (mTimer == null) {
            fishingStart();
            mFishingButton.setText("ストップ！");
        } else {
            fishingEnd();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;}
        return super.onOptionsItemSelected(item);}}
