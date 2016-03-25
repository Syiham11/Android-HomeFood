package project.irfananda.homefood.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import project.irfananda.homefood.R;
import project.irfananda.homefood.object.Food;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>  {

    private List<Food> foodList;
    private Context context;

    public OrderAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_linear_order, parent, false);

        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.txt_title.setText(food.getName());
        holder.txt_time.setText(food.getTime());
        holder.txt_seller.setText(food.getSeller());
        holder.txt_qty.setText(""+food.getQuantity());
        holder.txt_price.setText("Rp. " + food.getPrice());
        holder.img_poster.setImageResource(food.getImg());
        switch (food.getNotif()){
            case 0:
                holder.img_info.setImageResource(R.drawable.circle_pending);
                break;
            case 1:
                holder.img_info.setImageResource(R.drawable.circle_prepare);
                break;
            case 2:
                holder.img_info.setImageResource(R.drawable.circle_send);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_title, txt_price, txt_seller, txt_time, txt_qty;
        public ImageView img_poster, img_info;

        public MyViewHolder(View view) {
            super(view);
            txt_title= (TextView) view.findViewById(R.id.txt_title);
            txt_price= (TextView) view.findViewById(R.id.txt_price);
            img_poster= (ImageView) view.findViewById(R.id.img_poster);
            txt_seller = (TextView) view.findViewById(R.id.txt_seller);
            txt_qty = (TextView) view.findViewById(R.id.txt_qty);
            txt_time = (TextView) view.findViewById(R.id.txt_time);
            img_info= (ImageView) view.findViewById(R.id.img_info);
        }
    }

}
