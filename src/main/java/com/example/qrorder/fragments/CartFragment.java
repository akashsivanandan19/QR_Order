package com.example.qrorder.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qrorder.R;
import com.example.qrorder.adapter.CartItemAdapter;
import com.example.qrorder.dataModel.MenuItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Random;

public class CartFragment extends Fragment {


    private View rootView;
    private TextView sb_ttlv_txt,sgst_vl_txt,cgst_vl_txt,total_pay_vl,chk_out_txt;
    private RecyclerView cart_recycler;
    private List<MenuItem> orderList;
    CartItemAdapter cartAdapter;

    public void setAurguments(List<MenuItem> orderList){

        this.orderList = orderList;
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.cart_fragment,container,false);

        getViewIds();

        cart_recycler = (RecyclerView) rootView.findViewById(R.id.cart_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        cart_recycler.setLayoutManager(manager);

        cartAdapter  =  new CartItemAdapter(getActivity(),orderList);

        cartAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                setTaxes();
            }
        });

        setTaxes();


        chk_out_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
                builder1.setMessage("Sure! Want to checkout?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Launch your home Activity and finish this activity
                                getActivity().finish();

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


        return  rootView;
    }


    private void getViewIds(){

        sb_ttlv_txt = (TextView) rootView.findViewById(R.id.sb_ttlv_txt);
        sgst_vl_txt = (TextView) rootView.findViewById(R.id.sgst_vl_txt);
        cgst_vl_txt = (TextView) rootView.findViewById(R.id.cgst_vl_txt);
        total_pay_vl = (TextView) rootView.findViewById(R.id.total_pay_vl);
        chk_out_txt = (TextView) rootView.findViewById(R.id.chk_out_txt);
    }


    @Override
    public void onResume() {
        super.onResume();

        cart_recycler.setAdapter(cartAdapter);

    }

    private void setTaxes(){

        float subTotal = 0;

        //Get Total amount of order
        for (MenuItem itm : orderList) {

            subTotal = subTotal + itm.getPrice();

        }

        double gst = subTotal*0.025;
        double payble = subTotal+(2*gst);



        sb_ttlv_txt.setText(subTotal+"");
        sgst_vl_txt.setText(gst+"");
        cgst_vl_txt.setText(gst+"");
        total_pay_vl.setText(payble+"");
    }
}
