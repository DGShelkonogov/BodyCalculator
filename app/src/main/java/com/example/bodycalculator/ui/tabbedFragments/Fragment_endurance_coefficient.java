package com.example.bodycalculator.ui.tabbedFragments;

import android.content.res.Resources;
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

import java.util.concurrent.ExecutionException;

public class Fragment_endurance_coefficient extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_endurance_coefficient, container, false);

        TextView txt_endurance_coefficient_res = v.findViewById(R.id.txt_endurance_coefficient_res);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        EditText edtNumSAD = v.findViewById(R.id.edtNumSAD);
        EditText edtNumDAD = v.findViewById(R.id.edtNumDAD);

        TabbedActivity activity = (TabbedActivity) getActivity();

        Button btn_endurance_coefficient_define = v.findViewById(R.id.btn_endurance_coefficient_define);
        btn_endurance_coefficient_define.setOnClickListener(v1 -> {
            try{
                double CSS = Double.parseDouble(edtNumCSS.getText().toString());
                double SAD = Double.parseDouble(edtNumSAD.getText().toString());
                double DAD = Double.parseDouble(edtNumDAD.getText().toString());

                if(CSS > 0 && SAD > 0 && DAD > 0){

                    activity.user.setCSS(CSS);
                    activity.user.setSAD(SAD);
                    activity.user.setDAD(DAD);

                    DBHelper dbHelper = new DBHelper(getActivity());

                    if(SAD - DAD <= 0){
                        txt_endurance_coefficient_res.setText("САД - ДАД не может быть <= 0");
                    }else{
                        double kv = (CSS * 10) / (SAD - DAD);

                        activity.user.setCSS(CSS);
                        activity.user.setSAD(SAD);
                        activity.user.setDAD(DAD);

                        String result = String.format("%.2f",kv);

                        if(kv == 16){
                            result += ": норма";
                        }

                        if(kv > 16){
                            result += ": ослабление деятельности сердечно-сосудистой системы";
                        }

                        if(kv < 16){
                            result += ": усиление кардиореспираторной системы";
                        }
                        txt_endurance_coefficient_res.setText(result);




                        TestResult testResult = new TestResult(getResources().getString(R.string.endurance_coefficient), result);
                        SQLlite.add(JSONHelper.exportTestResultToJSON(testResult),
                                DBHelper.TABLE_RESULTS, DBHelper.KEY_RESULT_JSON , dbHelper);
                    }
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