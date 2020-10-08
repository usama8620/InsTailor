package plan9.usama.instailorapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;

import plan9.usama.instailorapplication.Models.Shopping;
import plan9.usama.instailorapplication.R;

public class ShoppingActivity extends AppCompatActivity {
    private List<Shopping> menShoppingList = new ArrayList<>();
    private List<Shopping> womenShoppingList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SlimAdapter mSlimAdapter;

    String selectionCategory;
    private ImageView Back;
    private TextView ToolbarTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        selectionCategory = getIntent().getStringExtra("type");
        Back = findViewById(R.id.back);
        ToolbarTextView = findViewById(R.id.toolbar_textivew);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ToolbarTextView.setText("" + selectionCategory + " Category");
        mRecyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        if (selectionCategory.equalsIgnoreCase("Men")) {
            mRecyclerView.removeAllViews();
            mSlimAdapter = SlimAdapter.create().register(R.layout.shopping_item, new SlimInjector<Shopping>() {
                        @Override
                        public void onInject(final Shopping data, IViewInjector injector) {
                            injector.text(R.id.selected_category_text, data.getShoppingtitle());
                            injector.with(R.id.selected_category_image, new IViewInjector.Action() {
                                @Override
                                public void action(View view) {
                                    Picasso.with(ShoppingActivity.this).load(data.getShoppingimage()).into((ImageView) view);
                                }
                            });
                            injector.clicked(R.id.shoppingitem, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ShoppingActivity.this, CategoriesActivity.class);
                                    intent.putExtra("category", "" + data.getShoppingtitle());
                                    startActivity(intent);
                                }
                            });

                        }


                    })
                    .attachTo(mRecyclerView).updateData(menShoppingList);
            prepareMenShoppingData();

        } else if (selectionCategory.equalsIgnoreCase("Women")) {
            mRecyclerView.removeAllViews();
            mSlimAdapter = SlimAdapter.create()
                    .register(R.layout.shopping_item, new SlimInjector<Shopping>() {
                        @Override
                        public void onInject(final Shopping data, IViewInjector injector) {
                            injector.text(R.id.selected_category_text, data.getShoppingtitle());
                            injector.with(R.id.selected_category_image, new IViewInjector.Action() {
                                @Override
                                public void action(View view) {
                                    Picasso.with(ShoppingActivity.this).load(data.getShoppingimage()).into((ImageView) view);
                                }
                            });
                            injector.clicked(R.id.shoppingitem, new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(ShoppingActivity.this, CategoriesActivity.class);
                                    intent.putExtra("category", "" + data.getShoppingtitle());
                                    startActivity(intent);
                                }
                            });
                        }

                    })

                    .attachTo(mRecyclerView).updateData(womenShoppingList);
            prepareWomenShoppingData();

        }

    }

    private void prepareMenShoppingData() {
        Shopping shopping = new Shopping("MenShirts", R.mipmap.men);
        menShoppingList.add(shopping);

        shopping = new Shopping("MenSuits", R.mipmap.men);
        menShoppingList.add(shopping);

        shopping = new Shopping("MenPants", R.mipmap.men);
        menShoppingList.add(shopping);
        mSlimAdapter.updateData(menShoppingList);

    }

    private void prepareWomenShoppingData() {
        Shopping shopping = new Shopping("WomenShirts", R.mipmap.women);
        womenShoppingList.add(shopping);

        shopping = new Shopping("WomenTrousers", R.mipmap.women);
        womenShoppingList.add(shopping);

        shopping = new Shopping("WomenPants", R.mipmap.women);
        womenShoppingList.add(shopping);

        shopping = new Shopping("Lehnga", R.mipmap.women);
        womenShoppingList.add(shopping);

        shopping = new Shopping("Maxsi", R.mipmap.women);
        womenShoppingList.add(shopping);
        mSlimAdapter.updateData(womenShoppingList);


    }
}
