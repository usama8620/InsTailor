package plan9.usama.instailorapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import plan9.usama.instailorapplication.CustomViewPager;
import plan9.usama.instailorapplication.R;
import plan9.usama.instailorapplication.Tabs.BackButtonFragment;
import plan9.usama.instailorapplication.Tabs.ButtonArrangmentFragment;
import plan9.usama.instailorapplication.Tabs.CollarStyleFragment;
import plan9.usama.instailorapplication.Tabs.CuffStyleFragment;
import plan9.usama.instailorapplication.Tabs.LapelsFragment;
import plan9.usama.instailorapplication.Tabs.LegsOpeningFragment;
import plan9.usama.instailorapplication.Tabs.LiningColorFragment;
import plan9.usama.instailorapplication.Tabs.PocketFragment;
import plan9.usama.instailorapplication.Tabs.ShirtLengthFragment;
import plan9.usama.instailorapplication.Tabs.ThreadFragment;
import plan9.usama.instailorapplication.Tabs.VentsFragment;
import plan9.usama.instailorapplication.Tabs.WomenLehngaSleevesFragment;
import plan9.usama.instailorapplication.Tabs.WomenLehngaStyleFragment;
import plan9.usama.instailorapplication.Tabs.WomenMaxsiSleevesFragment;
import plan9.usama.instailorapplication.Tabs.WomenMaxsiStyleFragment;
import plan9.usama.instailorapplication.Tabs.WomenNecklineFragment;
import plan9.usama.instailorapplication.Tabs.WomenPantsCutFragment;
import plan9.usama.instailorapplication.Tabs.WomenPantsLengthFragment;
import plan9.usama.instailorapplication.Tabs.WomenPantsThreadFragment;
import plan9.usama.instailorapplication.Tabs.WomenRisePantsFragment;
import plan9.usama.instailorapplication.Tabs.WomenShirtFittingFragment;
import plan9.usama.instailorapplication.Tabs.WomenShirtsLengthFragment;
import plan9.usama.instailorapplication.Tabs.WomenSleevesFragment;
import plan9.usama.instailorapplication.Tabs.WomenTrousersFittingFragment;
import plan9.usama.instailorapplication.Tabs.WomenTrousersLengthFragment;

import static plan9.usama.instailorapplication.Activities.CategoriesActivity.CategoryActivity;

public class StylesSelectActivity extends AppCompatActivity {
    private CustomViewPager mCustomViewPager;
    String Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styles_select);
        Intent i = getIntent();
        Type = i.getStringExtra("type");
        CategoryActivity.finish();

        mCustomViewPager = (CustomViewPager) findViewById(R.id.viewpager);
        mCustomViewPager.setPagingEnabled(false);
        setupViewPager(mCustomViewPager);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            int curent = mCustomViewPager.getCurrentItem();
            Toast.makeText(this, "CUREENT" + curent, Toast.LENGTH_SHORT).show();
            if (curent == 0) {
                mCustomViewPager.removeAllViews();

            }
            if (curent == 1) {
                mCustomViewPager.removeAllViews();
            }
            if (curent == 2) {
                mCustomViewPager.removeAllViews();
            }
            if (curent == 3) {
                mCustomViewPager.removeAllViews();
            }
            if (curent == 4) {
                mCustomViewPager.removeAllViews();
            }
            if (mCustomViewPager.getCurrentItem() == curent) {
                mCustomViewPager.removeAllViews();
                if (Type.equalsIgnoreCase("menshirt")) {
                    Intent i = new Intent(this, CategoriesActivity.class);
                    i.putExtra("category", "MenShirts");
                    CategoryActivity.finish();
                    startActivity(i);
                    finish();
                } else if (Type.equalsIgnoreCase("mensuit")) {

                    Intent i = new Intent(this, CategoriesActivity.class);
                    i.putExtra("category", "MenSuits");
                    CategoryActivity.finish();
                    startActivity(i);
                    finish();
                } else if (Type.equalsIgnoreCase("womenshirts")) {

                    Intent i = new Intent(this, CategoriesActivity.class);
                    i.putExtra("category", "WomenShirts");
                    CategoryActivity.finish();
                    startActivity(i);
                    finish();
                }
                else if (Type.equalsIgnoreCase("womentrousers")) {

                    Intent i = new Intent(this, CategoriesActivity.class);
                    i.putExtra("category", "WomenTrousers");
                    CategoryActivity.finish();
                    startActivity(i);
                    finish();
                }
                else if (Type.equalsIgnoreCase("womenpants")) {

                    Intent i = new Intent(this, CategoriesActivity.class);
                    i.putExtra("category", "WomenPants");
                    CategoryActivity.finish();
                    startActivity(i);
                    finish();
                }

                else if (Type.equalsIgnoreCase("lehnga")) {

                    Intent i = new Intent(this, CategoriesActivity.class);
                    i.putExtra("category", "Lehnga");
                    CategoryActivity.finish();
                    startActivity(i);
                    finish();
                }

                else if (Type.equalsIgnoreCase("maxsi")) {

                    Intent i = new Intent(this, CategoriesActivity.class);
                    i.putExtra("category", "Maxsi");
                    CategoryActivity.finish();
                    startActivity(i);
                    finish();
                }

            }
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        CategoryActivity.finish();

    }

    private void setupViewPager(CustomViewPager viewPager) {
        if (Type.equalsIgnoreCase("menshirt")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new CollarStyleFragment());
            adapter.addFragment(new CuffStyleFragment());
            adapter.addFragment(new ShirtLengthFragment());
            adapter.addFragment(new PocketFragment());
            viewPager.setAdapter(adapter);

        } else if (Type.equalsIgnoreCase("mensuit")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new LapelsFragment());
            adapter.addFragment(new VentsFragment());
            adapter.addFragment(new ButtonArrangmentFragment());
            viewPager.setAdapter(adapter);
        } else if (Type.equalsIgnoreCase("menpants")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new ThreadFragment());
            adapter.addFragment(new LegsOpeningFragment());
            adapter.addFragment(new LiningColorFragment());
            adapter.addFragment(new BackButtonFragment());
            viewPager.setAdapter(adapter);
        }
        else if (Type.equalsIgnoreCase("womenshirts")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new WomenShirtsLengthFragment());
            adapter.addFragment(new WomenSleevesFragment());
            adapter.addFragment(new WomenShirtFittingFragment());
            adapter.addFragment(new WomenNecklineFragment());
            viewPager.setAdapter(adapter);
        }
        else if (Type.equalsIgnoreCase("womentrousers")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new WomenTrousersLengthFragment());
            adapter.addFragment(new WomenTrousersFittingFragment());

            viewPager.setAdapter(adapter);
        }
        else if (Type.equalsIgnoreCase("womenpants")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new WomenPantsCutFragment());
            adapter.addFragment(new WomenRisePantsFragment());
            adapter.addFragment(new WomenPantsLengthFragment());
            adapter.addFragment(new WomenPantsThreadFragment());


            viewPager.setAdapter(adapter);
        }
        else if (Type.equalsIgnoreCase("lehnga")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new WomenLehngaStyleFragment());
            adapter.addFragment(new WomenLehngaSleevesFragment());


            viewPager.setAdapter(adapter);
        }

        else if (Type.equalsIgnoreCase("maxsi")) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new WomenMaxsiStyleFragment());
            adapter.addFragment(new WomenMaxsiSleevesFragment());


            viewPager.setAdapter(adapter);
        }
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

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
            //mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }


}
