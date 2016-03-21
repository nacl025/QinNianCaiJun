package com.edmund.qingniancaijun.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edmund.qingniancaijun.Control.ClickImageView;
import com.edmund.qingniancaijun.Model.MenuItem;
import com.edmund.qingniancaijun.R;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by edmund on 2016/1/6.
 */
public class MenuAdapter<T> extends ArrayAdapter<MenuItem> {

    private static final String price_ex = "￥";
    private List<MenuItem> mDataSources ;
    public List<MenuItem> getmDataSources(){
        return  mDataSources;
    }

    public MenuAdapter(Context context, int resource, List<MenuItem> objects) {
        super(context, resource, objects);
        mDataSources = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MenuItem item = mDataSources.get(position);
        View view;
        if (TextUtils.isEmpty(item.getmCategoryName())) {
            view = View.inflate(getContext(), R.layout.menu_item, null);
            if(item.getmIsSellout()){//售完
                view.findViewById(R.id.sellout_imageView).setVisibility(View.VISIBLE);//已售完图标
                view.findViewById(R.id.add_imageview).setVisibility(View.GONE);//增加按钮

                TextView textView1 = (TextView)view.findViewById(R.id.price_textview);
                textView1.setText(price_ex + item.getmPrice());

                TextView textView2 = (TextView)view.findViewById(R.id.foodname_textview);
                textView2.setText(item.getmName());

                //TODO 加载图片
                //ImageView imageView = (ImageView)view.findViewById(R.id.food_imageView);
            }else{
                if(item.getmIsBargain()){//特价
                    view.findViewById(R.id.special_textView).setVisibility(View.VISIBLE);
                    view.findViewById(R.id.prime_price_layout).setVisibility(View.VISIBLE);
                    TextView textView = (TextView)view.findViewById(R.id.prime_price_textView);
                    DecimalFormat df0 = new DecimalFormat(".00");
                    String primeprice = df0.format(item.getmPrimePrice());
                    textView.setText(price_ex + primeprice);
                }
                TextView textView1 = (TextView)view.findViewById(R.id.price_textview);
                DecimalFormat df = new DecimalFormat(".00");
                String price = df.format(item.getmPrice());
                textView1.setText(price_ex + price);

                TextView textView2 = (TextView)view.findViewById(R.id.foodname_textview);
                textView2.setText(item.getmName());

                //TODO 加载图片
                //ImageView imageView = (ImageView)view.findViewById(R.id.food_imageView);
            }
            ClickImageView imageView = (ClickImageView)view.findViewById(R.id.add_imageview);
            TextView addflagtextView = (TextView) view.findViewById(R.id.addflag_textview);
            addflagtextView.setTag(item.getmID());//Click事件与MenuItem id 绑定，以便于处理
            imageView.setmTextView(addflagtextView);

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
                    String vv = textView.getTag().toString();
                }
            });
        } else {//类标题栏
            view = View.inflate(getContext(), R.layout.menu_item_title, null);
            TextView tv1 = (TextView) view.findViewById(R.id.categoryID_textView);
            tv1.setText(item.getmCategoryID());
            TextView tv2 = (TextView) view.findViewById(R.id.categoryName_textView);
            tv2.setText(item.getmCategoryName());
        }
        return view;

    }
}
