package com.example.bodycalculator.ui.tabbedFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bodycalculator.R;


public class Fragment_skibinski_coefficient extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_skibinski_coefficient, container, false);

        TextView txt_skibinski_res = v.findViewById(R.id.txt_skibinski_res);
        EditText edtNumPS = v.findViewById(R.id.edtNumPS);
        EditText edtNumJEL = v.findViewById(R.id.edtNumJEL);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        TextView btn_skibinski_define = v.findViewById(R.id.btn_skibinski_define);

        btn_skibinski_define.setOnClickListener(v1 -> {
            double PS = Double.parseDouble(edtNumPS.getText().toString());
            double JEL = Double.parseDouble(edtNumJEL.getText().toString());
            double CSS = Double.parseDouble(edtNumCSS.getText().toString());
            double kv = ((JEL / 100) * PS) / CSS;

            String result = String.format("%.2f",kv);

            if(kv < 5){
                result += ": очень плохо (низкий уровень выносливость сердечно-сосудистой и дыхательной систем)";
            }
            if(kv >= 5 && kv < 10){
                result += ": неудовлетворительно";
            }

            if(kv >= 10 && kv < 30){
                result += ": удовлетворительно";
            }

            if(kv >= 30 && kv < 60){
                result += ": хорошо";
            }

            if(kv > 60){
                result += ": очень хорошо (высокий уровень выносливости). ";
            }
            txt_skibinski_res.setText(result);
        });

        return v;
    }
}