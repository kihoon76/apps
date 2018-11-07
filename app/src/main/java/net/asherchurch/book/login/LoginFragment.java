package net.asherchurch.book.login;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import net.asherchurch.book.R;

public class LoginFragment extends Fragment {

    public static LoginFragment getInstance() {
        Bundle args = new Bundle();
        LoginFragment loginFragment = new LoginFragment();
        loginFragment.setArguments(args);

        return loginFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_login, parent, false);

        //넥서스 시리즈 영문키워드 우선적용 예외처리
        if(Build.MODEL.contains("Nexus") || Build.MODEL.contains("nexus")) {
            EditText txtID = (EditText)v.findViewById(R.id.memberID);
            txtID.setInputType(InputType.TYPE_CLASS_TEXT);
        }

        return v;
    }
}
