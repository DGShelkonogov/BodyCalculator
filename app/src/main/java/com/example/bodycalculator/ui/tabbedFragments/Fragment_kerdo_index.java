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

public class Fragment_kerdo_index extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kerdo_index, container, false);

        TextView txt_kerdo_res = v.findViewById(R.id.txt_kerdo_res);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        EditText edtNumDAD = v.findViewById(R.id.edtNumDAD);
        Button btn_kerdo_define = v.findViewById(R.id.btn_kerdo_define);

        TabbedActivity activity = (TabbedActivity) getActivity();

        btn_kerdo_define.setOnClickListener(v1 -> {
            try{
                double CSS = Double.parseDouble(edtNumCSS.getText().toString());
                double DAD = Double.parseDouble(edtNumDAD.getText().toString());
                if(CSS > 0 && DAD > 0){
                    double vi = 100 * (1 - (DAD / CSS));
                    String result = String.format("%.2f", vi);

                    activity.user.setCSS(CSS);
                    activity.user.setDAD(DAD);

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

                    DBHelper dbHelper = new DBHelper(getActivity());
                    TestResult testResult = new TestResult(getResources().getString(R.string.kerdo), result);
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