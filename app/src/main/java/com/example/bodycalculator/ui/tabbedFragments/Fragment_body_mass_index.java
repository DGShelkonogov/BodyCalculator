package com.example.bodycalculator.ui.tabbedFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

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
import com.example.bodycalculator.models.User;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class Fragment_body_mass_index extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_body_mass_index, container, false);

        TabbedActivity activity = (TabbedActivity) getActivity();

        DBHelper dbHelper = new DBHelper(getActivity());


        TextView txt_body_mass_res = v.findViewById(R.id.txt_body_mass_res);
        EditText edtNumBodyMass = v.findViewById(R.id.edtNumBodyMass);
        EditText edtNumHeight = v.findViewById(R.id.edtNumHeight);
        Button btn = v.findViewById(R.id.btn_body_mass_define);

        btn.setOnClickListener(v1 -> {
            try{
                double bodyMass = Double.parseDouble(edtNumBodyMass.getText().toString());
                double height  = Double.parseDouble(edtNumHeight.getText().toString());
                if(bodyMass > 0 && height > 0){
                    double i = bodyMass / Math.pow(height, 2);
                    String result = String.format("%.2f",i);

                    activity.user.setBodyMass(bodyMass);
                    activity.user.setHeight(height);

                    if(i < 18.5){
                        result += ": наблюдается недостаток массы тела";
                    }
                    if(i >= 18.5 && i < 25){
                        result += ": норма";
                    }
                    if(i >= 25 && i < 30){
                        result += ": избыточная масса тела";
                    }
                    if(i >= 30 && i < 35){
                        result += ": первая степень ожирения";
                    }
                    if(i >= 35 && i < 40){
                        result += ": вторая степень ожирения";
                    }
                    if(i >= 40){
                        result += ": третья степень ожирения";
                    }
                    txt_body_mass_res.setText(result);

                    TestResult testResult = new TestResult(getResources().getString(R.string.body_mass_index), result);
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