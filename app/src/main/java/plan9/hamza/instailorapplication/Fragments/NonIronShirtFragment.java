package plan9.hamza.instailorapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import plan9.hamza.instailorapplication.Activities.StylesSelectActivity;
import plan9.hamza.instailorapplication.Models.Shopping;
import plan9.hamza.instailorapplication.Models.WishListBox;
import plan9.hamza.instailorapplication.MyApp;
import plan9.hamza.instailorapplication.R;

import static plan9.hamza.instailorapplication.Activities.CategoriesActivity.CategoryActivity;

public class NonIronShirtFragment extends Fragment {
    private List<Shopping> NonIronShirtList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SlimAdapter mSlimAdapter;
    GridLayoutManager mGridLayoutManager;
    Box<WishListBox> wishListBox;

    WishListBox wishListitem;

    public NonIronShirtFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wishListBox = ((MyApp) getActivity().getApplication()).getBoxStore().boxFor(WishListBox.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_non_iron_shirt, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.removeAllViews();
        mSlimAdapter = SlimAdapter.create()
                .register(R.layout.allstylesshirts_item, new SlimInjector<Shopping>() {
                    @Override
                    public void onInject(final Shopping data, IViewInjector injector) {
                        injector.text(R.id.allstylesshirt_item_title, data.getShoppingtitle());
                        injector.clicked(R.id.cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i = new Intent(getActivity(), StylesSelectActivity.class);
                                i.putExtra("type", "menshirt");
                                CategoryActivity.finish();
                                startActivity(i);
                            }
                        });
                        injector.clicked(R.id.allstylesshirt_wishlist_image, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Picasso.with(getActivity()).load(R.drawable.heart_red).into((ImageView) view);
                                //adding values to local database
                                wishListitem = new WishListBox();
                                wishListitem.setItem_type("Non Iron");
                                wishListitem.setName(data.getShoppingtitle());
                                wishListBox.put(wishListitem);
                            }
                        });
                    }
                })
                .attachTo(mRecyclerView).updateData(NonIronShirtList);
        prepareSolidShoppingData();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void prepareSolidShoppingData() {
        Shopping shopping = new Shopping("MenShirts1", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts2", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts3", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts4", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts5", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts6", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts7", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts8", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        shopping = new Shopping("MenShirts9", R.mipmap.shrt2);
        NonIronShirtList.add(shopping);
        mSlimAdapter.updateData(NonIronShirtList);

    }
}
