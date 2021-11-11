package com.androidstudio.gym;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class AdvancedTextView extends TextView {
    private int mMaxValue = 100;

    public AdvancedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public AdvancedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdvancedTextView(Context context) {
        super(context);
    }

    public void setMaxValue(int maxValue) {
        mMaxValue = maxValue;
    }

    public synchronized void setValue(float value) {
        this.setText(String.valueOf(value) + " %");

        this.setTextColor(getResources().getColor(R.color.titleclr));
        LayerDrawable background = (LayerDrawable) this.getBackground();
        ClipDrawable barValue = (ClipDrawable) background.getDrawable(1);
        int newClipLevel = (int) (value * 10000 / mMaxValue);
        barValue.setLevel(newClipLevel);
        drawableStateChanged();
    }

}
