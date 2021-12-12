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

public class Fragment_kerdo_index extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kerdo_index, container, false);

        TextView txt_kerdo_res = v.findViewById(R.id.txt_kerdo_res);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        EditText edtNumDAD = v.findViewById(R.id.edtNumDAD);
        Button btn_kerdo_define = v.findViewById(R.id.btn_kerdo_define);

        btn_kerdo_define.setOnClickListener(v1 -> {
            double CSS = Double.parseDouble(edtNumCSS.getText().toString());
            double DAD = Double.parseDouble(edtNumDAD.getText().toString());
            double vi = 100 * (1 - (DAD / CSS));
            String result = String.format("%.2f", vi);

            if(vi >= 31){
                result += ": выраженная симпатикотония";
            }

            if(vi >= 16 && vi <= 30){
                result += ": симпатикотония";
            }

            if(vi >= -15 && vi <= 15){
                result += ": уравновешенность симпатических и парасимпатических влияний";
            }

            if(vi >= -30 && vi <= -16){
                result += ": парасимпатикотония";
            }

            if(vi <= -30){
                result += ": выраженная парасимпатикотония";
            }
            txt_kerdo_res.setText(result);

        });

        return v;
    }
}