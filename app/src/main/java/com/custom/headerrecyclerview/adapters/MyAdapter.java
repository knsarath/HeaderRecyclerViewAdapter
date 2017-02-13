package com.custom.headerrecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.custom.headerrecyclerview.widget.HeaderFooterAdapter;
import com.custom.headerrecyclerview.R;

import java.util.List;

/**
 * Created by sarath on 10/2/17.
 */

public class MyAdapter extends HeaderFooterAdapter<String> {


    public MyAdapter(Context context, int headerResId, int footerResId, List<String> list) {
        super(context, headerResId, footerResId, list);
    }

    public MyAdapter(View headerView, View footerView, List<String> list) {
        super(headerView, footerView, list);
    }

    public MyAdapter(List<String> list) {
        super(null, null, list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, Integer viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public int getItemViewType(Integer position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, Integer position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mTextView.setText(getItem(position));
        }
    }

    public class ItemViewHolder extends HeaderFooterAdapter.ViewHolder implements View.OnClickListener {

        private TextView mTextView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
            mTextView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Cliked item " + getActualAdapterPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
