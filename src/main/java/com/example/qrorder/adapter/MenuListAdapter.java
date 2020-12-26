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
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.example.qrorder.R;
import com.example.qrorder.dataModel.MenuItem;
import com.example.qrorder.fragments.ListFragment;

import java.text.NumberFormat;
import java.util.List;



 
public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.ItemViewHolder> {

    private Context mContext;
    private List<MenuItem> list;
    private MenuItem info;
    List<MenuItem> orderList;
    private ListFragment listner;
    private static int[] imgs = { R.drawable.one, R.drawable.two, R.drawable.three,R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven,R.drawable.eight,
            R.drawable.nine, R.drawable.ten, R.drawable.eleven};

    public MenuListAdapter() {}

    public MenuListAdapter(Context con, List<MenuItem> itemList,
                           List<MenuItem> orderList, ListFragment lis) {
        this.mContext = con;
        this.list = itemList;
        this.orderList = orderList;
        this.listner = lis;


    }


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(MenuListAdapter.ItemViewHolder holder, final int position) {

        info = list.get(position);

        //holder.menu_img.setImageDrawable(R.drawable.1);

        holder.menu_name_txt.setText(info.getName());

        holder.menu_price.setText(/*mContext.getResources().getString(R.string.rs_symb) +*/
                NumberFormat.getInstance().format(info.getPrice()));


        if(info.getDesc()!=null && !info.getDesc().isEmpty())
            holder.menu_desc_txt.setText(String.valueOf(info.getDesc().trim()));
        else
            holder.menu_desc_txt.setText("....................");

        if(position<imgs.length){
            holder.menu_img.setImageResource(imgs[position]);
        }

        holder.menu_img.setTag(position);

        holder.menu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos  = (int)v.getTag();

                openImgDialog(pos);
            }
        });

        holder.add_txt.setTag(info);
        holder.add_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MenuItem itm = (MenuItem)v.getTag();
                itm.setQty(1);
                addItem(itm);
                listner.updateCart();

                Toast.makeText(mContext,itm.getName()+" Added successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.menu_list_item, viewGroup, false);

        return new ItemViewHolder(itemView);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView menu_name_txt,menu_price,add_txt,
                menu_desc_txt;
        protected ImageView menu_img;
        protected View container;

        public ItemViewHolder(View v) {
            super(v);
            menu_name_txt = (TextView) v.findViewById(R.id.menu_name_txt);
            add_txt = (TextView) v.findViewById(R.id.add_txt);
            menu_price = (TextView) v.findViewById(R.id.menu_price);
            menu_desc_txt = (TextView) v.findViewById(R.id.menu_desc_txt);
            menu_img = (ImageView) v.findViewById(R.id.menu_img);
            container = v;
        }
    }


    private void addItem(MenuItem item){

        boolean isPresent = false;

        for (MenuItem item1 : orderList) {

            if(item1.getItmId().equalsIgnoreCase(item.getItmId())){
                item1.setQty(item1.getQty()+1);
                isPresent = true;
                break;
            }

        }

        if(!isPresent){
            orderList.add(item);
        }

    }

    private void openImgDialog(int pos){

        AlertDialog.Builder alertadd = new AlertDialog.Builder(mContext);
        LayoutInflater factory = LayoutInflater.from(mContext);
        final View view = factory.inflate(R.layout.menu_image, null);

        ImageView img = (ImageView) view.findViewById(R.id.dialog_imageview);
        if(pos<imgs.length){
            img.setImageResource(imgs[pos]);
        }

        alertadd.setView(view);

        alertadd.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dlg, int sumthing) {

                dlg.dismiss();
            }
        });

        alertadd.show();
    }


}
