package com.integrals.demo_main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {
    private DrawView drawView;
    private TextView textView;

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView=findViewById(R.id.drawview);
        textView=findViewById(R.id.pixels);
        getSupportActionBar().hide();

        drawView.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction()==MotionEvent.ACTION_MOVE){
                textView.setText("Region= "+drawView.getRegion()+"\n DP X="+drawView.getxDp()+"DP Y="+drawView.getyDp()
                        +"\n Quadrant ="+drawView.getQuadrant()+"\n Direction ="+drawView.getDirection()+" " +
                        "\n Start(x,y) = ("+drawView.getStartDpX()+","+drawView.getStartDpY()+")"+
                        "\n End(x,y) = ("+drawView.getEndPixelX()+","+drawView.getEndPixelY()+")" +
                        "\n color = "+drawView.getBgColor()+
                        "\n Size ="+drawView.getPixelSize()
                );
            }
            return false;
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                drawView.detectErrorsAndSave();
                return false;
            }
        });

    }

}