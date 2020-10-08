package plan9.hamza.instailorapplication.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import plan9.hamza.instailorapplication.Fragments.AllStylesShirtsFragment;
import plan9.hamza.instailorapplication.Fragments.BridalLehngaFragment;
import plan9.hamza.instailorapplication.Fragments.CasualLehngaFragment;
import plan9.hamza.instailorapplication.Fragments.CasualSuitsFragment;
import plan9.hamza.instailorapplication.Fragments.CheckShirtFragment;
import plan9.hamza.instailorapplication.Fragments.ChinosFragment;
import plan9.hamza.instailorapplication.Fragments.CigretPantTrousers;
import plan9.hamza.instailorapplication.Fragments.DoubleBreastedFragment;
import plan9.hamza.instailorapplication.Fragments.DressPantsFragmnet;
import plan9.hamza.instailorapplication.Fragments.FormalSuitsFragment;
import plan9.hamza.instailorapplication.Fragments.FrocksFragment;
import plan9.hamza.instailorapplication.Fragments.HeavyEmbroideryMaxiFragment;
import plan9.hamza.instailorapplication.Fragments.JeansFragment;
import plan9.hamza.instailorapplication.Fragments.KnickersFragment;
import plan9.hamza.instailorapplication.Fragments.KurtasFragment;
import plan9.hamza.instailorapplication.Fragments.LightEmbroideryMaxiFragment;
import plan9.hamza.instailorapplication.Fragments.NonIronShirtFragment;
import plan9.hamza.instailorapplication.Fragments.PartyPantsFragment;
import plan9.hamza.instailorapplication.Fragments.PlazoFragment;
import plan9.hamza.instailorapplication.Fragments.RuggedFragment;
import plan9.hamza.instailorapplication.Fragments.ShalwarsFragment;
import plan9.hamza.instailorapplication.Fragments.SingleBreastedFragment;
import plan9.hamza.instailorapplication.Fragments.SolidShirtsFragment;
import plan9.hamza.instailorapplication.Fragments.StripeShirtFragment;
import plan9.hamza.instailorapplication.Fragments.TShirtsFragment;
import plan9.hamza.instailorapplication.Fragments.TopsFragment;
import plan9.hamza.instailorapplication.Fragments.TrousersFragment;
import plan9.hamza.instailorapplication.Fragments.UnderWearsFragment;
import plan9.hamza.instailorapplication.Fragments.WomenJeansFragment;
import plan9.hamza.instailorapplication.R;

public class CategoriesActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    String Category;
    private ImageView Back;
    public static Activity CategoryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categories);
        CategoryActivity = this;

        Category = getIntent().getStringExtra("category");
        //variable declaration
        viewPager = (ViewPager) findViewById(R.id.categories_view_pager);
        Back = findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.categories_tab_layout);
        tabLayout.removeAllTabs();
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        if (Category.equalsIgnoreCase("MenShirts")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new AllStylesShirtsFragment(), "All Styles");
            adapter.addFragment(new SolidShirtsFragment(), "Solid");
            adapter.addFragment(new CheckShirtFragment(), "Check");
            adapter.addFragment(new StripeShirtFragment(), "Stripe");
            adapter.addFragment(new NonIronShirtFragment(), "NonIron");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(5);
        } else if (Category.equalsIgnoreCase("MenSuits")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new SingleBreastedFragment(), "Single Breasted");
            adapter.addFragment(new DoubleBreastedFragment(), "Double Breasted");
            adapter.addFragment(new FormalSuitsFragment(), "Formal Suits");
            adapter.addFragment(new CasualSuitsFragment(), "Casual Suits");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(4);

        } else if (Category.equalsIgnoreCase("MenPants")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new TrousersFragment(), "Trousers");
            adapter.addFragment(new UnderWearsFragment(), "UnderWears");
            adapter.addFragment(new DressPantsFragmnet(), "Dress Pants");
            adapter.addFragment(new KnickersFragment(), "Knickers");
            adapter.addFragment(new JeansFragment(), "Jeans");
            adapter.addFragment(new ChinosFragment(), "Chinos");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(6);

        } else if (Category.equalsIgnoreCase("WomenShirts")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new TopsFragment(), "Tops");
            adapter.addFragment(new FrocksFragment(), "Frocks");
            adapter.addFragment(new TShirtsFragment(), "T-Shirts");
            adapter.addFragment(new KurtasFragment(), "Kurtas");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(4);
        } else if (Category.equalsIgnoreCase("WomenTrousers")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new ShalwarsFragment(), "Shalwars");
            adapter.addFragment(new CigretPantTrousers(), "Cigret Pant Trousers");
            adapter.addFragment(new PlazoFragment(), "Plazo");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(3);
        } else if (Category.equalsIgnoreCase("WomenPants")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new WomenJeansFragment(), "Jeans ");
            adapter.addFragment(new RuggedFragment(), "Rugged Pants");
            adapter.addFragment(new PartyPantsFragment(), "Party Pants");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(3);
        } else if (Category.equalsIgnoreCase("Lehnga")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new BridalLehngaFragment(), "Bridal Lehnga ");
            adapter.addFragment(new CasualLehngaFragment(), "Casual Lehnga");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(2);
        } else if (Category.equalsIgnoreCase("Maxsi")) {
            Adapter adapter = new Adapter(getSupportFragmentManager());
            adapter.addFragment(new HeavyEmbroideryMaxiFragment(), "Heavy Embroidery Maxi ");
            adapter.addFragment(new LightEmbroideryMaxiFragment(), "Light  Embroidery Maxi");
            viewPager.setAdapter(adapter);
            viewPager.setOffscreenPageLimit(2);
        }
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
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
            return mFragmentTitleList.get(position);
        }
    }

}
