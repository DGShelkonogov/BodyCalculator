package com.example.bodycalculator.ui.tabbedFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bodycalculator.R;

import javax.xml.transform.Result;

public class Fragment_level_of_physical_activity extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_level_of_physical_activity, container, false);
        EditText edt_sum = v.findViewById(R.id.edt_sum);
        TextView txt_lvl_activity_res = v.findViewById(R.id.txt_lvl_activity_res);
        Button btn_lvl_activity_define = v.findViewById(R.id.btn_lvl_activity_define);
        btn_lvl_activity_define.setOnClickListener(v1 -> {
            double sum = Double.parseDouble(edt_sum.getText().toString());
            String res =  String.format("%.2f",sum);

            if(sum < 5000){
                res += ": сидячая работа";
            }
            if(sum >= 5000 && sum < 10000){
                res += ": несколько активная работа";
            }

            if(sum >= 10000 && sum < 12000){
                res += ": несколько активная работа";
            }

            if(sum > 12000){
                res += ": очень активный образ жизни";
            }

            txt_lvl_activity_res.setText(res);


        });


        return v;
    }
}