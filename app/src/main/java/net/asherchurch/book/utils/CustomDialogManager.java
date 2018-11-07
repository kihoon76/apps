package net.asherchurch.book.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import net.asherchurch.book.R;
import net.asherchurch.book.domain.AlertDialogDomain;


public class CustomDialogManager {

    public static void show(AlertDialogDomain domain, Context context, DialogInterface .OnClickListener positiveListener) {
        new AlertDialog.Builder(context, R.style.AlertDialogTheme)
                .setTitle(domain.getTitle())
                .setMessage(domain.getMsg())
                .setCancelable(false)
                .setPositiveButton(domain.getPositiveButtonText(), positiveListener)
                .create()
                .show();

    }
}
