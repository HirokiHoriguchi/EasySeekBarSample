package com.example.easyseekbarsampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private SeekBar[] seekBars = new SeekBar[4];
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        //LinearLayoutのインスタンス生成、それに縦並びと、レイアウトの指定をする
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));

        //Gravityを指定
        linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);

        //背景色の指定
        linearLayout.setBackgroundColor(Color.rgb(220, 255, 220));
        setContentView(linearLayout);


        float dp = getResources().getDisplayMetrics().density;

        //マージンを20dpに指定
        int margins = (int) (20 * dp);


        textView = new TextView(this);

        LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.setMargins(margins, margins, margins, margins);

        textView.setLayoutParams(textViewLayoutParams);
        linearLayout.addView(textView);
        String str = String.valueOf(0) + " %";
        textView.setText(str);

        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        int seekBarHeight = (int) (50 * dp);
        for (int i = 0; i < seekBars.length; i++) {
            seekBars[i] = new SeekBar(this);

            LinearLayout.LayoutParams seekbarlayoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, seekBarHeight);

            seekbarlayoutParams.setMargins(margins, margins, margins, margins);

            seekBars[i].setLayoutParams(seekbarlayoutParams);
            linearLayout.addView(seekBars[i]);

            seekBars[i].setProgress(0);
            seekBars[i].setMax(100);
            seekBars[i].setBackgroundColor(Color.rgb(191, 191, 191));

            switch (i) {
                case 1:
                    Drawable icon = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_launcher_background, null);
                    seekBars[i].setThumb(icon);
                    break;
                case 2:
                    ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                    shapeDrawable.getPaint().setColor(Color.BLUE);
                    shapeDrawable.setIntrinsicWidth(30 * (int) dp);
                    shapeDrawable.setIntrinsicHeight(50 * (int) dp);
                    seekBars[i].setThumb(shapeDrawable);
                    break;
                case 3:
                    Drawable icon2 = ResourcesCompat.getDrawable(getResources(), R.drawable.custom_progress, null);
                    seekBars[i].setProgressDrawable(icon2);
                    break;
                default:
                    break;
            }

            seekBars[i].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    String str = progress + " %";
                    textView.setText(str);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }
    }
}
