package net.asherchurch.book.intro;

import android.support.v4.app.Fragment;

import net.asherchurch.book.BaseFragmentActivity;
import net.asherchurch.book.R;
import net.asherchurch.book.utils.CustomSecurityManager;

import java.util.List;

public class IntroActivity extends BaseFragmentActivity {
    @Override
    protected void createFragment(List<Fragment> list) {
        list.add(IntroFragment.getInstance(CustomSecurityManager.isRooting()));
    }

    @Override
    protected int getActivityLayoutResId() {
        return R.layout.activity_intro;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.introFragmentContainer;
    }
}

