package com.mechonot.fiddle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import com.mechonot.fiddle.scrolling.FidScrollingActivity;
import com.mechonot.fiddle.utils.OnSwipeTouchListener;

public class MainActivity extends AppCompatActivity{

    private OnSwipeTouchListener swipeTouchListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        //Initialize GestureDetector
        this.swipeTouchListener = new OnSwipeTouchListener(MainActivity.this) {
            @Override
            public void onSwipeRight() {
                Intent intent = new Intent(MainActivity.this, FidScrollingActivity.class);
                startActivity(intent);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
            }
        };
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        swipeTouchListener.onTouch(getCurrentFocus(), event);
        return super.onTouchEvent(event);
    }
}