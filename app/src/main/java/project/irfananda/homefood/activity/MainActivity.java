package project.irfananda.homefood.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import project.irfananda.homefood.R;
import project.irfananda.homefood.fragment.DiscoverFragment;
import project.irfananda.homefood.fragment.FavoriteFragment;
import project.irfananda.homefood.fragment.OrderFragment;
import project.irfananda.homefood.fragment.WishlistFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
//    private int currMenu;

    private final int[] activeIcons = {
            R.drawable.ic_favorite_white_36dp,
            R.drawable.ic_restaurant_menu_white_36dp,
            R.drawable.ic_shopping_cart_white_36dp,
            R.drawable.ic_notifications_white_36dp
    };
    private final int[] inactiveIcons = {
            R.drawable.ic_favorite_deep_orange_300_36dp,
            R.drawable.ic_restaurant_menu_deep_orange_300_36dp,
            R.drawable.ic_shopping_cart_deep_orange_300_36dp,
            R.drawable.ic_notifications_deep_orange_300_36dp
    };

    private final String[] title = new String[]{
            "Favorite",
            "Menu",
            "Cart",
            "Order"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        currMenu = R.menu.menu_chat;
//        invalidateOptionsMenu();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title[0]);

        FloatingActionButton fab_order = (FloatingActionButton)findViewById(R.id.fab_order);
        fab_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomOrderActivity.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0;i<=3;i++){
            tabLayout.getTabAt(i).setIcon(inactiveIcons[i]);
        }
        tabLayout.getTabAt(0).setIcon(activeIcons[0]);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //when on active tab
                switch (tab.getPosition()){
                    case 0:
                        getSupportActionBar().setTitle(title[0]);
                        tabLayout.getTabAt(0).setIcon(activeIcons[0]);
                        viewPager.setCurrentItem(0);
//                        currMenu = R.menu.menu_chat;
                        break;
                    case 1:
                        getSupportActionBar().setTitle(title[1]);
                        tabLayout.getTabAt(1).setIcon(activeIcons[1]);
                        viewPager.setCurrentItem(1);
//                        currMenu = R.menu.menu_timeline;
                        break;
                    case 2:
                        getSupportActionBar().setTitle(title[2]);
                        tabLayout.getTabAt(2).setIcon(activeIcons[2]);
                        viewPager.setCurrentItem(2);
//                        currMenu = R.menu.menu_account;
                        break;
                    case 3:
                        getSupportActionBar().setTitle(title[3]);
                        tabLayout.getTabAt(3).setIcon(activeIcons[3]);
                        viewPager.setCurrentItem(3);
//                        currMenu = R.menu.menu_account;
                        break;
                }
                invalidateOptionsMenu();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //when on inactive tab
                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(inactiveIcons[0]);
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(inactiveIcons[1]);
                        break;
                    case 2:
                        tabLayout.getTabAt(2).setIcon(inactiveIcons[2]);
                        break;
                    case 3:
                        tabLayout.getTabAt(3).setIcon(inactiveIcons[3]);
                        break;
                }
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        menu.clear();
//        getMenuInflater().inflate(currMenu, menu);
//        return super.onPrepareOptionsMenu(menu);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Log.i("infoirfan", "setting clicked");
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FavoriteFragment(), title[0]);
        adapter.addFragment(new DiscoverFragment(), title[1]);
        adapter.addFragment(new WishlistFragment(), title[2]);
        adapter.addFragment(new OrderFragment(), title[3]);
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
//             return mFragmentTitleList.get(position);
            return null;
        }
    }
}

