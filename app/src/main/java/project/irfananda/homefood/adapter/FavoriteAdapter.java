package project.irfananda.homefood.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import project.irfananda.homefood.R;
import project.irfananda.homefood.object.Food;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.MyViewHolder>  {

    private List<Food> foodList;
    private Context context;

    public FavoriteAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_grid_favorite, parent, false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.txt_title.setText(food.getName());
        holder.txt_price.setText("Rp. "+food.getPrice());
        holder.img_poster.setImageResource(food.getImg());
        if (food.isOrdered()){
            holder.btn_add.setImageResource(R.drawable.ic_remove_shopping_cart_red_500_24dp);
        }else{
            holder.btn_add.setImageResource(R.drawable.ic_add_shopping_cart_amber_500_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_title, txt_price;
        public ImageView img_poster;
        public CardView cv;
        public RelativeLayout rl_card;
        public ImageButton btn_add;

        public MyViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv);
            rl_card = (RelativeLayout) view.findViewById(R.id.rl_title);
            txt_title= (TextView) view.findViewById(R.id.txt_title);
            txt_price= (TextView) view.findViewById(R.id.txt_price);
            img_poster= (ImageView) view.findViewById(R.id.img_poster);
            btn_add = (ImageButton)view.findViewById(R.id.btn_add);
        }
    }

}
