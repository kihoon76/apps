package net.asherchurch.book.intro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.asherchurch.book.R;
import net.asherchurch.book.domain.AlertDialogDomain;
import net.asherchurch.book.login.LoginActivity;
import net.asherchurch.book.utils.CustomDialogManager;
import net.asherchurch.book.utils.ExtraKeys;

public class IntroFragment extends Fragment {

    private boolean mRootingDevice;

    public static IntroFragment getInstance(boolean isRooting) {
        Bundle args = new Bundle();
        args.putBoolean(ExtraKeys.ROOTING_YN.valueOf(), isRooting);
        IntroFragment introFragment = new IntroFragment();
        introFragment.setArguments(args);

        return introFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootingDevice = getArguments().getBoolean(ExtraKeys.ROOTING_YN.valueOf());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
       // View v = inflater.inflate(R.layout.f_intro, parent, false);
        View v = null;

        if(mRootingDevice) {
            AlertDialogDomain domain = new AlertDialogDomain();
            domain.setTitle("알림");
            domain.setMsg(getActivity().getString(R.string.warn_rooting));
            CustomDialogManager.show(domain, getActivity(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getActivity().finish();
                }
            });
        }
        else {
            v = inflater.inflate(R.layout.f_intro, parent, false);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(getContext(), LoginActivity.class);
                    i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(i);
                }
            }, 2000);
        }

        return v;
    }
}
