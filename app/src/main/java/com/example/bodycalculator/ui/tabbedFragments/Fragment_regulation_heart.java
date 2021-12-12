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

public class Fragment_regulation_heart extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_regulation_heart, container, false);

        TextView txt_regulation_heart_res = v.findViewById(R.id.txt_regulation_heart_res);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        EditText edtNumSAD = v.findViewById(R.id.edtNumSAD);
        Button btn_regulation_heart_define = v.findViewById(R.id.btn_regulation_heart_define);

        btn_regulation_heart_define.setOnClickListener(v1 -> {
            double CSS = Double.parseDouble(edtNumCSS.getText().toString());
            double SAD = Double.parseDouble(edtNumSAD.getText().toString());
            double kr = (CSS * SAD) / 100;
            String result = String.format("%.2f",kr);

            if(kr < 75){
                result += ": высокий уровень регуляции сердечно-сосудистой системы";
            }

            if(kr >= 75 && kr <=80){
                result += ": выше среднего";
            }

            if(kr >= 81 && kr <=90){
                result += ": средний";
            }

            if(kr >= 91 && kr <=100){
                result += ": ниже среднего";
            }


            if(kr > 100){
                result += ": низкое значение регуляции";
            }
            txt_regulation_heart_res.setText(result);

        });



        return v;
    }
}