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


public class Fragment_life_index extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_life_index, container, false);

        TextView txt_life_index_res = v.findViewById(R.id.txt_life_index_res);
        EditText edtNumMass = v.findViewById(R.id.edtNumMass);
        EditText edtNumJEL = v.findViewById(R.id.edtNumJEL);
        Button btn_life_index_define = v.findViewById(R.id.btn_life_index_define);
        btn_life_index_define.setOnClickListener(v1 -> {
            double mass = Double.parseDouble(edtNumMass.getText().toString());
            double JEL = Double.parseDouble(edtNumJEL.getText().toString());
            double ji = JEL / mass;
            String result = String.format("%.2f",ji);
            if(ji >= 51 && ji <= 61){
                result += ": норма";
            }
            if(ji < 51){
                result += ": недостаточно кислорода для обеспечения организма " +
                        "или избыточная масса тела ";
            }
            txt_life_index_res.setText(result);
        });

        return v;
    }
}