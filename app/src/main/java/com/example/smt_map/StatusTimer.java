package com.example.smt_map;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.Timer;
import java.util.TimerTask;

public class StatusTimer {

    private final TextView text;
    private final Context context;
    private Status status = Status.MostlyOccupied;

    public StatusTimer(TextView text, Context context) {
        System.out.println("StatusTimer - text" + text);
        this.text = text;
        this.context = context;
        System.out.println("StatusTimer - Constructor");
        changeColor(getStatus());
        start();
    }

    public void start () {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                //refresh your textview
                if (Math.random() > 0.3) {
                    int time = 0;

                    setStatus(status.nextStatus(status));
                    changeColor(getStatus());
                    System.out.println("StatusTimer - run");
                }
            }
        };
        int time = ((int) (Math.random() * 15) + 10)* 1000;
        System.out.println("StatusTimer - random" + time);
        timer.schedule(timerTask, 0, time);
    }

    private void changeColor(Status status) {
        LayerDrawable border = (LayerDrawable) ContextCompat.getDrawable(context,R.drawable.border);

        GradientDrawable gradientDrawable = (GradientDrawable) border.findDrawableByLayerId(R.id.shapeList);

//        gradientDrawable.setStroke(2, Color.BLACK);

        switch (status) {
            case FullyOccupied:
                gradientDrawable.setColor(context.getColor(R.color.red));
                System.out.println("StatusTimer - FullyOccupied");
                break;
            case MostlyOccupied:
                gradientDrawable.setColor(context.getColor(R.color.yellow));
                System.out.println("StatusTimer - MostlyOccupied");
                break;
            case PartiallyOccupied:
                gradientDrawable.setColor(context.getColor(R.color.green));
                System.out.println("StatusTimer - PartiallyOccupied");
                break;
        }

        System.out.println("StatusTimer - " + text);
        System.out.println("StatusTimer - " + R.drawable.border);
        System.out.println("StatusTimer - " + context);
        text.setBackground(context.getDrawable(R.drawable.border));
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
