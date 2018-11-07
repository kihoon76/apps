package net.asherchurch.book.utils;

import android.app.Activity;
import android.widget.Toast;

import net.asherchurch.book.R;

public class BackPressCloseHandler {
    private long backPressedTime = 0;
    private Toast toast;
    private Activity activity;

    public BackPressCloseHandler(Activity activity) {
        this.activity = activity;
    }

    public void onBackPressed() {
        if(System.currentTimeMillis() > backPressedTime + 2000) {
            backPressedTime = System.currentTimeMillis();
            showGuide();
            return;
        }

        if(System.currentTimeMillis() <= backPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }

    private void showGuide() {
        toast = Toast.makeText(activity, R.string.guide_back_end, Toast.LENGTH_SHORT);
        toast.show();
    }
}
