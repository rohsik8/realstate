package com.rg.realstate.fonts_utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by utsavstha on 3/15/17.
 */

public class Rondalo extends android.support.v7.widget.AppCompatTextView {

    public static Typeface face = null;


    public Rondalo(Context context) {
        super(context);
    }

    private void initializeFont(Context context) {

        if(face==null) {
            face = Typeface.createFromAsset(context.getAssets(), "rondalo.ttf");
            this.setTypeface(face);
        }else{
            this.setTypeface(face);
        }
    }

    public Rondalo(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeFont(context);
    }

    public Rondalo(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeFont(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
