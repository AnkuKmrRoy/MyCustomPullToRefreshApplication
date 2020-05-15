package com.example.mycustompulltorefreshapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.reginald.swiperefresh.CustomSwipeRefreshLayout;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity implements CustomSwipeRefreshLayout.OnRefreshListener {
    private LinearLayout llPullToRefresh;
    private RelativeLayout rlPullDownRefresh;
    boolean isVisible = false;
    CustomSwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeRefreshLayout = findViewById(R.id.swipe_to_refresh_profile);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setCustomHeadview(new MyCustomHeadView(this));
        llPullToRefresh = findViewById(R.id.llPullToRefresh);
        mSwipeRefreshLayout.enableTopProgressBar(false);
        mSwipeRefreshLayout.setRefreshCompleteTimeout(100);
        mSwipeRefreshLayout.setReturnToHeaderDuration(100);

    }


    @Override
    public void onRefresh() {
        if(mSwipeRefreshLayout.isRefreshing()){
            mSwipeRefreshLayout.refreshComplete();
        }
    }
}
