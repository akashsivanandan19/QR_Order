package com.example.qrorder.fragments;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.qrorder.R;
import com.example.qrorder.adapter.MenuListAdapter;
import com.example.qrorder.dataModel.MenuItem;
import com.example.qrorder.util.ItemListener;
import com.google.gson.Gson;

import java.util.List;

public class ListFragment extends Fragment implements ItemListener {


    private View rootView;
    private RecyclerView menu_recycler;
    MenuListAdapter listdapter;
    public List<MenuItem> orderList;
    private TextView item_count;
    private RelativeLayout cart_layout;
    private List<MenuItem> menuList;


    public void setAurguments(List<MenuItem> orderList, List<MenuItem> menuList){

        this.orderList = orderList;
        this.menuList = menuList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.list_fragment,container,false);

        menu_recycler = (RecyclerView) rootView.findViewById(R.id.menu_recycler);
        item_count = (TextView) rootView.findViewById(R.id.item_count);
        cart_layout = (RelativeLayout) rootView.findViewById(R.id.cart_layout);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        menu_recycler.setLayoutManager(manager);

        //Get menu list from Json
        //List<MenuItem> itmList = new Gson().fromJson(MenuJson.menuJson1,MenuJson.menu_list_type);

        listdapter  =  new MenuListAdapter(getActivity(),
                menuList,orderList, ListFragment.this);


        cart_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(orderList.size()>0){
                    callCartFragment();
                }else {

                    Toast.makeText(getActivity(),"Cart is Empty", Toast.LENGTH_SHORT).show();
                }


            }
        });


        return  rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        menu_recycler.setAdapter(listdapter);
        item_count.setText(orderList.size()+"");

    }

    private void callCartFragment(){

        CartFragment fragment = new CartFragment();
        fragment.setAurguments(orderList);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(CartFragment.class.getName());
        fragmentTransaction.replace(R.id.menu_main_fragment, fragment)
                .commit();
    }

    @Override
    public void updateCart() {

        item_count.setText(orderList.size()+"");
    }
}
