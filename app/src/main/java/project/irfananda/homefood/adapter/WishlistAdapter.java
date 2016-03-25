package project.irfananda.homefood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import project.irfananda.homefood.R;
import project.irfananda.homefood.object.Food;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.MyViewHolder>  {

    private List<Food> foodList;
    private Context context;

    public WishlistAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_card_wishlist, parent, false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.txt_title.setText(food.getName());
        holder.txt_qty.setText(""+food.getQuantity());
        holder.txt_price.setText("Rp. "+food.getPrice());
        holder.img_poster.setImageResource(food.getImg());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_title, txt_price, txt_qty;
        public ImageView img_poster, btn_add, btn_remove;
        public ImageButton btn_confirm;

        public MyViewHolder(View view) {
            super(view);
            txt_title= (TextView) view.findViewById(R.id.txt_title);
            txt_price= (TextView) view.findViewById(R.id.txt_price);
            txt_qty= (TextView) view.findViewById(R.id.txt_qty);
            img_poster= (ImageView) view.findViewById(R.id.img_poster);
            btn_add= (ImageView) view.findViewById(R.id.btn_add);
            btn_remove= (ImageView) view.findViewById(R.id.btn_remove);
            btn_confirm= (ImageButton) view.findViewById(R.id.btn_confirm);
        }
    }

}
