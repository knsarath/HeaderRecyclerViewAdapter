package com.custom.headerrecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.custom.headerrecyclerview.R;
import com.custom.headerrecyclerview.widget.HeaderFooterAdapter;

import java.util.List;

/**
 * Created by sarath on 13/2/17.
 */

public class MultpleViewTypeAdapter extends HeaderFooterAdapter<String> {
    private static final int FIRST_VIEW = 4;
    private static final int SECOND_VIEW = 5;

    public MultpleViewTypeAdapter(Context context, int headerResId, int footerResId, List<String> list) {
        super(context, headerResId, footerResId, list);
    }

    public MultpleViewTypeAdapter(View headerView, View footerView, List<String> list) {
        super(headerView, footerView, list);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, Integer viewType) {
        switch (viewType) {
            case FIRST_VIEW:
                return new FirstViewType(LayoutInflater.from(parent.getContext()).inflate(R.layout.first_view_type, parent, false));


        }
        return new SecondViewType(LayoutInflater.from(parent.getContext()).inflate(R.layout.second_view_type, parent, false));
    }

    @Override
    public int getItemViewType(Integer position) {
        switch (position % 2) {
            case 0:
                return FIRST_VIEW;
        }
        return SECOND_VIEW;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, Integer position) {
        if (holder instanceof FirstViewType) {
            FirstViewType firstViewType = (FirstViewType) holder;
            firstViewType.mTextView.setText(getItem(position));
        }
        if (holder instanceof SecondViewType) {
            SecondViewType firstViewType = (SecondViewType) holder;
            firstViewType.mTextView.setText(getItem(position));
        }
    }

    class FirstViewType extends HeaderFooterAdapter.ViewHolder {
        TextView mTextView;

        public FirstViewType(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.txt1);
        }
    }

    class SecondViewType extends HeaderFooterAdapter.ViewHolder {

        TextView mTextView;

        public SecondViewType(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.txt2);
        }
    }
}
