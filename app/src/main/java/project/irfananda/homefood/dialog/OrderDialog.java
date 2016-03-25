package project.irfananda.homefood.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import project.irfananda.homefood.R;
import project.irfananda.homefood.object.Food;

/**
 * Created by irfananda on 25/03/16.
 */
public class OrderDialog extends DialogFragment {

    private Food food;

    public OrderDialog() {
        super();
    }

    @SuppressLint("ValidFragment")
    public OrderDialog(Food food) {
        this.food = food;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_order, container,false);
        getDialog().setTitle("Confirm Order");

        TextView txt_title = (TextView)v.findViewById(R.id.txt_title);
        txt_title.setText("Name : " + food.getName());
        TextView txt_price = (TextView)v.findViewById(R.id.txt_price);
        txt_price.setText("Price : Rp. "+food.getPrice());
        TextView txt_seller= (TextView)v.findViewById(R.id.txt_seller);
        txt_seller.setText("Seller : "+food.getSeller());
        TextView txt_qty= (TextView)v.findViewById(R.id.txt_qty);
        txt_qty.setText("Quantity : "+food.getQuantity());
        TextView txt_total= (TextView)v.findViewById(R.id.txt_total);
        txt_total.setText("Total : Rp. "+food.getQuantity()*food.getPrice());
        EditText edt_notes = (EditText)v.findViewById(R.id.edt_notes);

        Button btn_yes = (Button)v.findViewById(R.id.btn_yes);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        Button btn_no = (Button)v.findViewById(R.id.btn_no);
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return v;
    }
}
