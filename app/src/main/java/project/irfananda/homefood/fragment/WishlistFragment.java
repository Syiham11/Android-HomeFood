package project.irfananda.homefood.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import project.irfananda.homefood.ClickListener;
import project.irfananda.homefood.R;
import project.irfananda.homefood.adapter.FavoriteAdapter;
import project.irfananda.homefood.adapter.WishlistAdapter;
import project.irfananda.homefood.dialog.OrderDialog;
import project.irfananda.homefood.object.DefineListFood;
import project.irfananda.homefood.object.Food;
import project.irfananda.homefood.recyclerView.DividerItemDecoration;
import project.irfananda.homefood.recyclerView.RecyclerTouchListener;

public class WishlistFragment extends Fragment {

    private List<Food> foodList;
    private RecyclerView rv;
    private WishlistAdapter wishlistAdapter;

    public WishlistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DefineListFood defineListFood = new DefineListFood();
        foodList = defineListFood.getFoodWishlist();
        wishlistAdapter = new WishlistAdapter(foodList,getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        rv = (RecyclerView) v.findViewById(R.id.rv);

        rv.setHasFixedSize(true);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(mLayoutManager);

//        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(wishlistAdapter);

        rv.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rv, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final Food food = foodList.get(position);
                final TextView txt_qty = (TextView) view.findViewById(R.id.txt_qty);
                final ImageView btn_add = (ImageView)view.findViewById(R.id.btn_add);
                btn_add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        food.setQuantity(food.getQuantity()+1);
                        txt_qty.setText(""+food.getQuantity());
                    }
                });
                final ImageView btn_remove = (ImageView)view.findViewById(R.id.btn_remove);
                btn_remove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        food.setQuantity(food.getQuantity()-1);
                        txt_qty.setText(""+food.getQuantity());
                    }
                });
                final ImageButton btn_confirm = (ImageButton)view.findViewById(R.id.btn_confirm);
                btn_confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        OrderDialog orderDialog = new OrderDialog(food);
                        orderDialog.show(getFragmentManager(),"OrderDialog Fragment");
                    }
                });
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return v;
    }
}
