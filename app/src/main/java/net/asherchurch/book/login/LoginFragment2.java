package net.asherchurch.book.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.asherchurch.book.R;

public class LoginFragment2 extends Fragment {

    Button mBtn;
    public static LoginFragment2 getInstance() {

        Bundle args = new Bundle();
        LoginFragment2 loginFragment2 = new LoginFragment2();
        loginFragment2.setArguments(args);

        return loginFragment2;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.f2_login, parent, false);
       mBtn = (Button)v.findViewById(R.id.toggleButton2);
       mBtn.setText("oooo");

        return v;
    }
}
