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
import com.example.bodycalculator.database.DBHelper;
import com.example.bodycalculator.database.JSONHelper;
import com.example.bodycalculator.database.SQLlite;
import com.example.bodycalculator.models.TestResult;

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
            try{
                double sum = Double.parseDouble(edt_sum.getText().toString());
                if(sum > 0){
                    String result =  String.format("%.2f",sum);

                    if(sum < 5000){
                        result += ": сидячая работа";
                    }
                    if(sum >= 5000 && sum < 10000){
                        result += ": несколько активная работа";
                    }

                    if(sum >= 10000 && sum < 12000){
                        result += ": несколько активная работа";
                    }

                    if(sum > 12000){
                        result += ": очень активный образ жизни";
                    }

                    txt_lvl_activity_res.setText(result);

                    DBHelper dbHelper = new DBHelper(getActivity());
                    TestResult testResult = new TestResult(getResources().getString(R.string.level_of_physical_activity), result);
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