package com.edmund.qingniancaijun.Activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.edmund.qingniancaijun.Fragment.HomeFragment;
import com.edmund.qingniancaijun.Fragment.MenuFragment;
import com.edmund.qingniancaijun.Fragment.SettingFragment;
import com.edmund.qingniancaijun.Fragment.ShoppingFragment;
import com.edmund.qingniancaijun.R;

public class MainActivity extends Activity implements View.OnClickListener {

    private static String TAG = "MainActivity";
    private static String defaultFontColor = "#7f7f7f";
    private static String selectedFontColor = "#7aa410";

    private ImageView homeImage;
    private ImageView orderImage;
    private ImageView shoppingImage;
    private ImageView settingImage;

    private TextView homeText;
    private TextView orderText;
    private TextView shoppingText;
    private TextView settingText;

    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private MenuFragment menuFragment;
    private ShoppingFragment shoppingFragment;
    private SettingFragment settingFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initViews();
        fragmentManager = getFragmentManager();
        setTabSelection(0);
    }

    private void initViews(){
        findViewById(R.id.home_layout).setOnClickListener(this);
        findViewById(R.id.order_layout).setOnClickListener(this);
        findViewById(R.id.shopping_layout).setOnClickListener(this);
        findViewById(R.id.setting_layout).setOnClickListener(this);

        homeImage = (ImageView) findViewById(R.id.home_image);
        orderImage = (ImageView) findViewById(R.id.order_image);
        shoppingImage = (ImageView) findViewById(R.id.shopping_image);
        settingImage = (ImageView) findViewById(R.id.setting_image);

        homeText = (TextView)findViewById(R.id.home_text);
        orderText = (TextView)findViewById(R.id.order_text);
        shoppingText = (TextView)findViewById(R.id.shopping_text);
        settingText = (TextView)findViewById(R.id.setting_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout:
                setTabSelection(0);
                break;
            case R.id.order_layout:
                setTabSelection(1);
                break;
            case R.id.shopping_layout:
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                setTabSelection(3);
                break;
        }
    }

    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 改变控件的图片和文字颜色
                homeImage.setImageResource(R.drawable.home_selected);
                homeText.setTextColor(Color.parseColor(selectedFontColor));
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                orderImage.setImageResource(R.drawable.order_selected);
                orderText.setTextColor(Color.parseColor(selectedFontColor));
                if (menuFragment == null) {
                    menuFragment = new MenuFragment();
                    transaction.add(R.id.content, menuFragment);
                } else {
                    transaction.show(menuFragment);
                }
                break;
            case 2:
                shoppingImage.setImageResource(R.drawable.shopping_selected);
                shoppingText.setTextColor(Color.parseColor(selectedFontColor));
                if (shoppingFragment == null) {
                    shoppingFragment = new ShoppingFragment();
                    transaction.add(R.id.content, shoppingFragment);
                } else {
                    transaction.show(shoppingFragment);
                }
                break;
            case 3:
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.parseColor(selectedFontColor));
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                    transaction.add(R.id.content, settingFragment);
                } else {
                    transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }

    private void clearSelection() {
        homeImage.setImageResource(R.drawable.home_unselected);
        homeText.setTextColor(Color.parseColor(defaultFontColor));
        orderImage.setImageResource(R.drawable.order_unselected);
        orderText.setTextColor(Color.parseColor(defaultFontColor));
        shoppingImage.setImageResource(R.drawable.shopping_unselected);
        shoppingText.setTextColor(Color.parseColor(defaultFontColor));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor(defaultFontColor));
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (menuFragment != null) {
            transaction.hide(menuFragment);
        }
        if (shoppingFragment != null) {
            transaction.hide(shoppingFragment);
        }
        if (settingFragment != null) {
            transaction.hide(settingFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
