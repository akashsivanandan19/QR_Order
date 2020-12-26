package com.example.qrorder.adapter;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qrorder.R;
import com.example.qrorder.dataModel.MenuItem;

import java.text.NumberFormat;
import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ItemViewHolder> {

    private Context mContext;
    private MenuItem info;
    List<MenuItem> orderList;

    public CartItemAdapter() {}

    public CartItemAdapter(Context con,
                           List<MenuItem> orderList) {
        this.mContext = con;
        this.orderList = orderList;


    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(CartItemAdapter.ItemViewHolder holder, final int position) {

        info = orderList.get(position);

        //holder.menu_img.setImageDrawable(R.drawable.1);

        holder.menu_name_txt.setText(info.getName());

        holder.qty.setText(info.getQty()+"");

        holder.menu_price.setText(/*mContext.getResources().getString(R.string.rs_symb) +*/
                NumberFormat.getInstance().format(info.getPrice()));

        holder.remv_icon.setTag(info);
        holder.remv_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final MenuItem itm = (MenuItem)v.getTag();

                AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                builder1.setMessage("Sure! Want to remove "+itm.getName()+" ?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Launch your home Activity and finish this activity
                                orderList.remove(itm);
                                notifyDataSetChanged();

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();


            }
        });

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cart_list_item, viewGroup, false);

        return new ItemViewHolder(itemView);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        protected  TextView menu_name_txt,menu_price,qty;
        protected ImageView remv_icon;
        protected View container;

        public ItemViewHolder(View v) {

            super(v);
            menu_name_txt = (TextView) v.findViewById(R.id.menu_name_txt);
            menu_price = (TextView) v.findViewById(R.id.menu_price);
            qty = (TextView) v.findViewById(R.id.qty);
            remv_icon = (ImageView) v.findViewById(R.id.remv_icon);
            container = v;

        }
    }

}
