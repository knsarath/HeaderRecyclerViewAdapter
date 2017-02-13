package com.custom.headerrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.custom.headerrecyclerview.adapters.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class SimpleRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));

/**
 * below are different ways to set header and footer from xml layout. un comment each line to see how it works
 */

        /* both header and footer from an xml layout*/
        // recyclerView.setAdapter(new MyAdapter(this.getBaseContext(), R.layout.header, R.layout.footer, getList()));

        /*  header from an xml layout , no footer*/
        //recyclerView.setAdapter(new MyAdapter(this.getBaseContext(), R.layout.header, HeaderFooterAdapter.NO_FOOTER, getList()));

        /*  no header ,  footer from an xml layout*/
        //  recyclerView.setAdapter(new MyAdapter(this.getBaseContext(), HeaderFooterAdapter.NO_HEADER, R.layout.footer, getList()));

        /* no header and no footer */
        //   recyclerView.setAdapter(new MyAdapter(this.getBaseContext(), HeaderFooterAdapter.NO_HEADER, HeaderFooterAdapter.NO_FOOTER, getList()));
        // recyclerView.setAdapter(new MyAdapter(getList()));


        /**
         * below are different ways to set header and footer from existing view. un comment each line to see how it works
         */
        /** add header and footer from existing view*/


        View header = LayoutInflater.from(this.getBaseContext()).inflate(R.layout.header, null);
        View footer = LayoutInflater.from(this.getBaseContext()).inflate(R.layout.footer, null);

        recyclerView.setAdapter(new MyAdapter(header, footer, getList())); /* you can pass null if you dont want either header or footer*/


        /**
         * access the header and footer later
         */
        MyAdapter myAdapter = (MyAdapter) recyclerView.getAdapter();
        myAdapter.getHeaderView();
        myAdapter.getFooterView();


    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("Item " + i);
        }
        return list;
    }
}
