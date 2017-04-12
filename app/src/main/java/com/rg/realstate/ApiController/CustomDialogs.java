package com.rg.realstate.ApiController;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import com.rg.realstate.R;


/**
 * Created by kishor on 02/04/17.
 */

public class CustomDialogs {

    public static Dialog progressDialog(Context context, String msg) {
        Dialog d = new Dialog(context);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d.setContentView(R.layout.custom_progress);
        d.setCancelable(false);
        TextView titleView = (TextView) d.findViewById(R.id.progressTextView);
        titleView.setText(msg);
        return d;

    }
}
