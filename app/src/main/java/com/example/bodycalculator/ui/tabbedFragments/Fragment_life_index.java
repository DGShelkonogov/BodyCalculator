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


public class Fragment_life_index extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_life_index, container, false);

        TabbedActivity activity = (TabbedActivity) getActivity();
        TextView txt_life_index_res = v.findViewById(R.id.txt_life_index_res);
        EditText edtNumMass = v.findViewById(R.id.edtNumBodyMass);
        EditText edtNumJEL = v.findViewById(R.id.edtNumJEL);
        Button btn_life_index_define = v.findViewById(R.id.btn_life_index_define);


        btn_life_index_define.setOnClickListener(v1 -> {
            try{
                double mass = Double.parseDouble(edtNumMass.getText().toString());
                double JEL = Double.parseDouble(edtNumJEL.getText().toString());
                if(mass > 0 && JEL > 0){
                    double ji = JEL / mass;
                    String result = String.format("%.2f",ji);

                    activity.user.setJEL(JEL);
                    activity.user.setBodyMass(mass);

                    if(ji >= 51 && ji <= 61){
                        result += ": норма";
                    }
                    if(ji < 51){
                        result += ": недостаточно кислорода для обеспечения организма " +
                                "или избыточная масса тела ";
                    }
                    txt_life_index_res.setText(result);

                    DBHelper dbHelper = new DBHelper(getActivity());
                    TestResult testResult = new TestResult(getResources().getString(R.string.life_index), result);
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