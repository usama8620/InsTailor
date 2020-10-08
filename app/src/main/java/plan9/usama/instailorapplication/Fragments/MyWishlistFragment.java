package plan9.usama.instailorapplication.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import plan9.usama.instailorapplication.Models.WishListBox;
import plan9.usama.instailorapplication.MyApp;
import plan9.usama.instailorapplication.R;

public class MyWishlistFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SlimAdapter mSlimAdapter;
    private List<WishListBox> wishListBoxArrayList = new ArrayList<>();
    private LinearLayoutManager mLinearLayoutManager;
    Box<WishListBox> wishListBox;

    public MyWishlistFragment() {
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
        View view = inflater.inflate(R.layout.fragment_my_wishlist, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
//        wishListBox.removeAll();
        wishListBoxArrayList = wishListBox.getAll();

        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.removeAllViews();
        mSlimAdapter = SlimAdapter.create()
                .register(R.layout.wishlist_item, new SlimInjector<WishListBox>() {
                    @Override
                    public void onInject(final WishListBox data, IViewInjector injector) {
                        injector.text(R.id.wishlist_item_title, data.getName());
                        injector.text(R.id.wishlist_item_price, data.getItem_type());
                        injector.clicked(R.id.delete_wishlst_item, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());

                                // Setting Dialog Message
                                alertDialog.setMessage("Are you sure you want to remove this item from Wishlist?");

                                // Setting Positive "Yes" Button
                                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {

                                        Log.e("TGED", "REMOVE BEFORE SIZE  : " + wishListBoxArrayList.size());

                                        wishListBoxArrayList.remove(wishListBoxArrayList.indexOf(data));
                                        Log.e("TGED", "REMOVER POSITION:  " + data.getId());
                                        wishListBox.remove(data.getId());
                                        wishListBox.put(wishListBoxArrayList);
                                        mSlimAdapter.updateData(wishListBoxArrayList);
                                        dialog.cancel();
                                        Toast.makeText(getActivity(), " Item removed Successfully", Toast.LENGTH_SHORT).show();
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

                            }
                        });
                    }
                })
                .attachTo(mRecyclerView).updateData(wishListBoxArrayList);
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

}
