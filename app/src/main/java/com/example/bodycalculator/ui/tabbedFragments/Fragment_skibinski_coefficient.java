package com.example.bodycalculator.ui.tabbedFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodycalculator.R;
import com.example.bodycalculator.TabbedActivity;
import com.example.bodycalculator.database.DBHelper;
import com.example.bodycalculator.database.JSONHelper;
import com.example.bodycalculator.database.SQLlite;
import com.example.bodycalculator.models.TestResult;


public class Fragment_skibinski_coefficient extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_skibinski_coefficient, container, false);

        TabbedActivity activity = (TabbedActivity) getActivity();

        TextView txt_skibinski_res = v.findViewById(R.id.txt_skibinski_res);
        EditText edtNumPS = v.findViewById(R.id.edtNumPS);
        EditText edtNumJEL = v.findViewById(R.id.edtNumJEL);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        TextView btn_skibinski_define = v.findViewById(R.id.btn_skibinski_define);

        btn_skibinski_define.setOnClickListener(v1 -> {
            try{
                double PS = Double.parseDouble(edtNumPS.getText().toString());
                double JEL = Double.parseDouble(edtNumJEL.getText().toString());
                double CSS = Double.parseDouble(edtNumCSS.getText().toString());

                if(PS > 0 && JEL > 0 && CSS > 0){
                    double kv = ((JEL / 100) * PS) / CSS;

                    activity.user.setPS(PS);
                    activity.user.setJEL(JEL);
                    activity.user.setCSS(CSS);


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

                    DBHelper dbHelper = new DBHelper(getActivity());
                    TestResult testResult = new TestResult(getResources().getString(R.string.skibinski), result);
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