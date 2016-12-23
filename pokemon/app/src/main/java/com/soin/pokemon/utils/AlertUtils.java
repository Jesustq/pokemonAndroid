package com.soin.pokemon.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Jesus Torres on 22/12/2016.
 */

public class AlertUtils {

    /**
     * Show a toaster witht message
     * @param con
     * @param message
     */
    public static void showToaster(Context con, String message) {
        Toast toast = Toast.makeText(con, message, Toast.LENGTH_LONG);
        toast.show();
    }

    public static void showAlertError(Context context, String Error){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(Error);
        alertDialog.show();
    }
}
