package com.example.bodycalculator.ui.tabbedFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodycalculator.R;
import com.example.bodycalculator.TabbedActivity;
import com.example.bodycalculator.database.DBHelper;
import com.example.bodycalculator.database.JSONHelper;
import com.example.bodycalculator.database.SQLlite;
import com.example.bodycalculator.models.TestResult;

public class Fragment_regulation_heart extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_regulation_heart, container, false);

        TabbedActivity activity = (TabbedActivity) getActivity();

        TextView txt_regulation_heart_res = v.findViewById(R.id.txt_regulation_heart_res);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        EditText edtNumSAD = v.findViewById(R.id.edtNumSAD);
        Button btn_regulation_heart_define = v.findViewById(R.id.btn_regulation_heart_define);

        btn_regulation_heart_define.setOnClickListener(v1 -> {
            try{
                double CSS = Double.parseDouble(edtNumCSS.getText().toString());
                double SAD = Double.parseDouble(edtNumSAD.getText().toString());
                if(CSS > 0 && SAD > 0){
                    double kr = (CSS * SAD) / 100;
                    String result = String.format("%.2f",kr);

                    activity.user.setCSS(CSS);
                    activity.user.setSAD(SAD);

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

                    DBHelper dbHelper = new DBHelper(getActivity());
                    TestResult testResult = new TestResult(getResources().getString(R.string.regulation_heart), result);
                    SQLlite.add(JSONHelper.exportTestResultToJSON(testResult),
                            DBHelper.TABLE_RESULTS, DBHelper.KEY_RESULT_JSON , dbHelper);

                }else{
                    Toast.makeText(getActivity(), "Поля не могут быть отрицательные", Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                Toast.makeText(getActivity(), "Поля заполнены неккоректно", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}