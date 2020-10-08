package plan9.hamza.instailorapplication.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import plan9.hamza.instailorapplication.Fragments.FaqFragment;
import plan9.hamza.instailorapplication.Fragments.GetMeasuredFragment;
import plan9.hamza.instailorapplication.Fragments.HomeFragment;
import plan9.hamza.instailorapplication.Fragments.LearnMoreFragment;
import plan9.hamza.instailorapplication.Fragments.MyAccountFragment;
import plan9.hamza.instailorapplication.Fragments.MyCartFragment;
import plan9.hamza.instailorapplication.Fragments.MyWishlistFragment;
import plan9.hamza.instailorapplication.Fragments.PrivacyPolicyFragment;
import plan9.hamza.instailorapplication.Fragments.SettingsFragment;
import plan9.hamza.instailorapplication.R;

import static plan9.hamza.instailorapplication.Fragments.LoginFragment.PREFERENCE;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences mSharedPreferences;
    public static int navItemIndex = 0;
    // tags used to attach the fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_MEASURED = "measured";
    private static final String TAG_LEARNMORE = "learnmore";
    private static final String TAG_LOGOUT = "logout";
    private static final String TAG_FAQ = "faq";
    private static final String TAG_PRIVACYPOLICY = "privacy";
    private static final String TAG_ACCOUNT = "account";
    private static final String TAG_WISHLIST = "wishlist";
    private static final String TAG_SETTINGS = "settings";
    private static final String TAG_CART = "cart";
    private static final String TAG_NO = "no";
    public static String CURRENT_TAG = TAG_HOME;
    public static String CURRENT_TAG_NEW = TAG_NO;
    private NavigationView mNavigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private boolean shouldLoadHomeFragOnBackPress = true;
    //Textview Declaration
    private TextView textView;
    //Global Handler
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        textView = toolbar.findViewById(R.id.toolbar_title);
        textView.setText("HOME");
        setSupportActionBar(toolbar);
        mSharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        mHandler = new Handler();
//
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorAccent));
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();

        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawers();
            return;
        }

        // This code loads home fragment when back key is pressed
        // when user is in other fragment than home
        if (shouldLoadHomeFragOnBackPress) {
            // checking if user is on other navigation menu
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;

                CURRENT_TAG = TAG_HOME;

                loadHomeFragment();

                return;
            }
        }

        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            Intent i = new Intent(MainActivity.this, LoginRegistrationActivity.class);
            SharedPreferences.Editor mEditor = mSharedPreferences.edit();
            mEditor.clear();
            mEditor.apply();
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            //Replacing the main content with ContentFragment Which is our Inbox View;
            case R.id.nav_home:
                textView.setText("HOME");
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));

                break;
            case R.id.nav_getmeasured:
                textView.setText("Get Measured");
                navItemIndex = 1;
                CURRENT_TAG = TAG_MEASURED;
                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));

                break;
            case R.id.nav_learnmore:
                textView.setText("Learn More");
                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));
                navItemIndex = 2;
                CURRENT_TAG = TAG_LEARNMORE;
                break;
            case R.id.nav_faq:
                navItemIndex = 3;
                textView.setText("FaQ");
                CURRENT_TAG = TAG_FAQ;
                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));

                break;
            case R.id.nav_privacypolicy:
                textView.setText("Privacy Policy");
                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));

                navItemIndex = 4;
                CURRENT_TAG = TAG_PRIVACYPOLICY;
                break;


            case R.id.nav_my_cart:
                textView.setText("My Cart");
                navItemIndex = 5;
                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));
                CURRENT_TAG = TAG_CART;
                break;
            case R.id.nav_my_account:
                textView.setText("My Account");

                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));
                navItemIndex = 6;
                CURRENT_TAG = TAG_ACCOUNT;
                break;
            case R.id.nav_my_wishlist:
                textView.setText("My Whishlist");

                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));
                navItemIndex = 7;
                CURRENT_TAG = TAG_WISHLIST;
                break;
            case R.id.nav_settings:
                textView.setText("Settings");
                navItemIndex = 8;
                setNavMenuItemThemeColors(getResources().getColor(R.color.colorAccent));
                CURRENT_TAG = TAG_SETTINGS;
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(MainActivity.this, LoginRegistrationActivity.class);
                SharedPreferences preferences = getSharedPreferences("preference", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();
                startActivity(intent);
                finish();
                break;
            default:
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
        }
        //Checking if the item is in checked state or not, if not make it in checked state
        if (menuItem.isChecked()) {
            menuItem.setChecked(false);
        } else {
            menuItem.setChecked(true);
        }
        menuItem.setChecked(true);

        //  if (navItemIndex==0)
        loadHomeFragment();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home fragment
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                // getmeasured fragment
                GetMeasuredFragment getMeasuredFragment = new GetMeasuredFragment();
                return getMeasuredFragment;
            case 2:
                // learnmore fragment
                LearnMoreFragment learnMoreFragment = new LearnMoreFragment();
                return learnMoreFragment;
            case 3:
                // faq fragment
                FaqFragment faqFragment = new FaqFragment();
                return faqFragment;
            case 4:
                // privacypolicy fragment
                PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
                return privacyPolicyFragment;
            case 5:
                // mycart fragment
                MyCartFragment myCartFragment = new MyCartFragment();
                return myCartFragment;
            case 6:
                // account fragment
                MyAccountFragment accountFragment = new MyAccountFragment();
                return accountFragment;
            case 7:
                // whishlist fragment
                MyWishlistFragment myWishlistFragment = new MyWishlistFragment();
                return myWishlistFragment;
            case 8:
                // settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;


            default:
                return new HomeFragment();
        }
    }


    private void loadHomeFragment() {
        selectNavMenu();
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            return;
        }
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();

    }

    private void selectNavMenu() {
        mNavigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void loadNavHeader() {


    }

    public void setNavMenuItemThemeColors(int color) {
        //Setting default colors for menu item Text and Icon
        int navDefaultTextColor = Color.parseColor("#202020");
        int navDefaultIconColor = Color.parseColor("#737373");

        //Defining ColorStateList for menu item Text
        ColorStateList navMenuTextList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_focused},
                        new int[]{android.R.attr.state_pressed}
                },
                new int[]{
                        color,
                        navDefaultTextColor,
                        navDefaultTextColor,
                        navDefaultTextColor,
                        navDefaultTextColor
                }
        );

        //Defining ColorStateList for menu item Icon
        ColorStateList navMenuIconList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_checked},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_pressed},
                        new int[]{android.R.attr.state_focused},
                        new int[]{android.R.attr.state_pressed}
                },
                new int[]{
                        color,
                        navDefaultIconColor,
                        navDefaultIconColor,
                        navDefaultIconColor,
                        navDefaultIconColor
                }
        );

        mNavigationView.setItemTextColor(navMenuTextList);
        mNavigationView.setItemIconTintList(navMenuIconList);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

            // Setting Dialog Message
            alertDialog.setMessage("Do you want to Exit the Application");

            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event
                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();

            return true;
        } else {
            Log.e("TGED", "BACK PRESSED USED NOT ELSE");

            return super.onKeyDown(keyCode, event);
        }
    }

}
