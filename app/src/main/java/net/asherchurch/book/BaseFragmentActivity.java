package net.asherchurch.book;

import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFragmentActivity extends FragmentActivity {
    protected abstract void createFragment(List<Fragment> list);
    protected abstract int getActivityLayoutResId();
    protected abstract int getFragmentContainerId();

    protected boolean isDebuggable() {
        return (0 != (getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getActivityLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        int fragmentContainerId = getFragmentContainerId();
        Fragment fragment = fm.findFragmentById(fragmentContainerId);

        if(fragment == null) {
            List<Fragment> fragmentList = new ArrayList<>();
            createFragment(fragmentList);

            try {
                if(fragmentList.size() > 0) {
                    FragmentTransaction ft = fm.beginTransaction();
                    for (Fragment f : fragmentList) {
                        ft.add(fragmentContainerId, f);
                    }

                    ft.commit();
                }
            }
            catch(Exception e) {
                if(isDebuggable()) {
                    Log.e("BaseFragmentActivity", e.getMessage());
                }
            }

        }




    }
}
