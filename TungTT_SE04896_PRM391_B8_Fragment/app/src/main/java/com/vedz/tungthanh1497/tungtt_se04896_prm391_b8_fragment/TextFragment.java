package com.vedz.tungthanh1497.tungtt_se04896_prm391_b8_fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {

    private FragmentActivity myContext;
    private static TextView textview;
    private static Button btShow;
    private static Button btHide;

    public TextFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);


        textview = (TextView) view.findViewById(R.id.tv_text_show);
        btShow = (Button) view.findViewById(R.id.bt_show);
        btHide = (Button) view.findViewById(R.id.bt_hide);
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                IDFragment fragment = new IDFragment();
                fragmentTransaction.add(R.id.fl_frame_layout, fragment);
                fragmentTransaction.commit();
            }
        });
        btHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Fragment fragment : myContext.getSupportFragmentManager().getFragments()) {
//                    if (fragment instanceof NavigationDrawerFragment) {
//                        continue;
//                    }
//                    else
                    if (fragment != null) {
                        myContext.getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                    }
                }
            }
        });
        return view;
    }

    public void changeTextProperties(int fontsize, String text) {
        textview.setTextSize(fontsize);
        textview.setText(text);
    }

}
