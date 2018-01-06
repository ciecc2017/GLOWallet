package com.ghl.wuhan.glowallet;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;


import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ghl.wuhan.glowallet.R;
import com.ghl.wuhan.glowallet.home.HomeFragment;
import com.ghl.wuhan.glowallet.me.MeFragment;
import com.ghl.wuhan.glowallet.transaction.TransactionFragment;
import com.ghl.wuhan.glowallet.utils.BaseActivity;

/**
 * 项目名称：GLOWallet
 * 类描叙：MainActivity
 * 创建人：chenmin
 * 创建时间： 2017-12-12 15:30：20
 * 修改人：chenmin
 * 修改时间： 2017-12-12 15:30：20
 * 修改备注：
 * 版本：
 */
public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_main);
//        ActivityManagerUtil.getInstance().addActivity(this);
//        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_more_title);



        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        /*** the setting for BadgeItem ***/
        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("10")
                .setBackgroundColorResource(R.color.orange)
                .setBorderWidth(0);

        /*** the setting for BottomNavigationBar ***/

       mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
//        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBar.setBarBackgroundColor(R.color.blue);//set background color for navigation bar
        mBottomNavigationBar.setInActiveColor(R.color.white);//unSelected icon color
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.main_home, R.string.tab_one).setActiveColorResource(R.color.green).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.main_transaction, R.string.tab_two).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.main_me, R.string.tab_three).setActiveColorResource(R.color.lime))

                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * set the default fragment
     */
    private void setDefaultFragment() {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        mFragmentOne = FragmentOne.newInstance("First Fragment");
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();

        transaction.replace(R.id.ll_content, homeFragment).commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (position) {
            case 0:

                    HomeFragment homeFragment = new HomeFragment();
                    transaction.replace(R.id.ll_content, homeFragment);

                break;
            case 1:

                    TransactionFragment transactionFragment = new TransactionFragment();
                    transaction.replace(R.id.ll_content, transactionFragment);

                break;
            case 2:

                    MeFragment meFragment = new MeFragment();
                    transaction.replace(R.id.ll_content, meFragment);

                break;
            default:

                    homeFragment = new HomeFragment();
                    transaction.replace(R.id.ll_content, homeFragment);

                break;
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
