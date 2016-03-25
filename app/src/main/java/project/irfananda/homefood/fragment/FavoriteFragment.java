package project.irfananda.homefood.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.List;

import project.irfananda.homefood.ClickListener;
import project.irfananda.homefood.adapter.FavoriteAdapter;
import project.irfananda.homefood.R;
import project.irfananda.homefood.object.DefineListFood;
import project.irfananda.homefood.object.Food;
import project.irfananda.homefood.recyclerView.DividerItemDecoration;
import project.irfananda.homefood.recyclerView.RecyclerTouchListener;

public class FavoriteFragment extends Fragment {

    private List<Food> foodList;
    private RecyclerView rv;
    private FavoriteAdapter favoriteAdapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DefineListFood defineListFood = new DefineListFood();
        foodList = defineListFood.getFoodDiscover();
        favoriteAdapter = new FavoriteAdapter(foodList,getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        rv = (RecyclerView) v.findViewById(R.id.rv);

        rv.setHasFixedSize(true);
        final GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(),2);
        mLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        rv.setLayoutManager(mLayoutManager);

//        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(favoriteAdapter);

        rv.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rv, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final Food food = foodList.get(position);
                final ImageButton btn_add = (ImageButton) view.findViewById(R.id.btn_add);
                if (food.isOrdered()) {
                    btn_add.setImageResource(R.drawable.ic_add_shopping_cart_amber_500_24dp);
                    food.setOrdered(false);
                } else {
                    btn_add.setImageResource(R.drawable.ic_remove_shopping_cart_red_500_24dp);
                    food.setOrdered(true);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return v;
    }
}
