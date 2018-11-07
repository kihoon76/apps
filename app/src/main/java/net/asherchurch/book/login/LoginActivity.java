package net.asherchurch.book.login;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.asherchurch.book.BaseFragmentActivity;
import net.asherchurch.book.R;
import net.asherchurch.book.utils.BackPressCloseHandler;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseFragmentActivity {

    private BackPressCloseHandler backPressCloseHandler;
    @Override
    protected int getActivityLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.loginFragmentContainer;
    }

    @Override
    protected void createFragment(List<Fragment> list) {
        list.add(LoginFragment.getInstance());
        //list.add(LoginFragment2.getInstance());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backPressCloseHandler = new BackPressCloseHandler(this);

    }

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed();
    }
}
