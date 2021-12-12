package com.example.bodycalculator.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.bodycalculator.R;
import com.example.bodycalculator.TabbedActivity;

import java.util.List;


public class SimpleAdapter extends BaseAdapter {

    private List<String> list;
    private LayoutInflater layoutInflater;

    public SimpleAdapter(Context context, List<String> list) {
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
        if(view == null){
            view = layoutInflater.inflate(R.layout.item_list_select_index, parent, false);
        }

        String str = (String) getItem(position);
        TextView textView = (TextView) view.findViewById(R.id.txt_select_index);
        Button button = (Button) view.findViewById(R.id.btn_define);
        textView.setText(str);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(layoutInflater.getContext(), TabbedActivity.class);
                intent.putExtra("position", position);
                layoutInflater.getContext().startActivity(intent);
            }
        });

        return view;
    }




}
