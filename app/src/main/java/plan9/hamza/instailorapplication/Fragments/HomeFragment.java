package plan9.hamza.instailorapplication.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import plan9.hamza.instailorapplication.Activities.ShoppingActivity;
import plan9.hamza.instailorapplication.R;

public class HomeFragment extends Fragment {
    LinearLayout MenSelection, WomenSelection;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        MenSelection = view.findViewById(R.id.linear_men_selection);
        WomenSelection = view.findViewById(R.id.linear_women_selection);
        MenSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                intent.putExtra("type", "Men");
                startActivity(intent);
            }
        });
        WomenSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                intent.putExtra("type", "Women");

                startActivity(intent);

            }
        });
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
