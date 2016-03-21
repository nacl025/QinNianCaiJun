package com.edmund.qingniancaijun.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.edmund.qingniancaijun.Control.ClickImageView;
import com.edmund.qingniancaijun.R;

/**
 * Created by edmund on 2015/12/31.
 */
public class HomeFragment extends Fragment {

    private View rootView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.menu_item,
                container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //=====================Test=================================
        ClickImageView imageView = (ClickImageView)getActivity().findViewById(R.id.add_imageview);
        TextView addflagTextView = (TextView) getActivity().findViewById(R.id.addflag_textview);
        imageView.setmTextView(addflagTextView);
        try{
            imageView.setClickListener(new ClickImageView.ClickListener() {
                @Override
                public void onClick(TextView textView) {
                    textView.setVisibility(View.VISIBLE);

                    // 透明
                    AlphaAnimation animation1 = new AlphaAnimation(1f, 0.01f);
                    animation1.setDuration(1000);
                    // 位移
                    TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -100);
                    animation.setDuration(1000);
                    AnimationSet set = new AnimationSet(true);
                    set.addAnimation(animation1);
                    set.addAnimation(animation);
                    textView.startAnimation(set);

                    textView.setVisibility(View.GONE);
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
