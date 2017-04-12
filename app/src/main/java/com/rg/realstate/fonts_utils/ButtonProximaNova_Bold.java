package com.rg.realstate.fonts_utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Created by kishor on 14/03/17.
 */

public class ButtonProximaNova_Bold extends android.support.v7.widget.AppCompatButton {


    public static Typeface face = null;


    public ButtonProximaNova_Bold(Context context) {
        super(context);
    }

    private void initializeFont(Context context) {

        if(face==null) {
            face = Typeface.createFromAsset(context.getAssets(), "ProximaNova-Bold.otf");
            this.setTypeface(face);
        }else{
            this.setTypeface(face);
        }
    }

    public ButtonProximaNova_Bold(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeFont(context);
    }

    public ButtonProximaNova_Bold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeFont(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
