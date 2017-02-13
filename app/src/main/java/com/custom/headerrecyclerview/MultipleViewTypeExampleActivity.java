package com.custom.headerrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.custom.headerrecyclerview.adapters.MultpleViewTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MultipleViewTypeExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_view_type_example);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final MultpleViewTypeAdapter adapter = new MultpleViewTypeAdapter(this.getBaseContext(), R.layout.header, R.layout.footer, getList());
        recyclerView.setAdapter(adapter);
        ((TextView) adapter.getFooterView().findViewById(R.id.txt)).setText("This is footer");
        ((TextView) adapter.getHeaderView().findViewById(R.id.txt)).setText("This is Header");
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("Item " + i);
        }
        return list;
    }
}
