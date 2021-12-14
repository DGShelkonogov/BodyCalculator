package com.example.bodycalculator.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.bodycalculator.R;
import com.example.bodycalculator.TabbedActivity;
import com.example.bodycalculator.models.TestResult;

import java.util.List;

public class ResultAdapter extends BaseAdapter {
    private List<TestResult> list;
    private LayoutInflater layoutInflater;

    public ResultAdapter(Context context, List<TestResult> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.result_item, parent, false);
        }

        TestResult res = (TestResult) getItem(position);
        TextView txtMessage = view.findViewById(R.id.txtMessage);
        TextView txtTitle = view.findViewById(R.id.txtTitle);
        txtTitle.setText(res.getTitle());
        txtMessage.setText(res.getMessage());
        return view;


    }
}
