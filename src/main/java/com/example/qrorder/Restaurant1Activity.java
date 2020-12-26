package com.example.qrorder;

import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.qrorder.adapter.MenuListAdapter;
import com.example.qrorder.dataModel.MenuItem;
import com.example.qrorder.dataModel.MenuJson;
import com.example.qrorder.fragments.ListFragment;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Restaurant1Activity extends AppCompatActivity {

    private TextView rest_title;
    public List<MenuItem> orderList;
    public List<MenuItem> menuList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant1);


        rest_title = (TextView)findViewById(R.id.rest_title);

        menuList = new Gson().fromJson(MenuJson.menuJson1,MenuJson.menu_list_type);


        orderList = new ArrayList<>();

        ListFragment fragment = new ListFragment();
        fragment.setAurguments(orderList,menuList);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.addToBackStack(ListFragment.class.getName());
        fragmentTransaction.replace(R.id.menu_main_fragment, fragment)
                .commit();


    }

}