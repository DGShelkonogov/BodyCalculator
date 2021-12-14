package com.example.bodycalculator.ui.result;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bodycalculator.Adapters.ResultAdapter;
import com.example.bodycalculator.Adapters.SimpleAdapter;
import com.example.bodycalculator.R;
import com.example.bodycalculator.database.DBHelper;
import com.example.bodycalculator.database.JSONHelper;
import com.example.bodycalculator.database.SQLlite;
import com.example.bodycalculator.models.TestResult;

import java.util.ArrayList;


public class ResultFragment extends Fragment {


    private ResultViewModel resultViewModel;

    ResultAdapter adapter;
    DBHelper dbHelper;
    ListView listViewResults;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_result, container, false);

        dbHelper = new DBHelper(getActivity());



        ArrayList<String> JSONResults = SQLlite.get_all_value(DBHelper.TABLE_RESULTS, DBHelper.KEY_RESULT_JSON , dbHelper);
        ArrayList<TestResult> list = new ArrayList<>();
        for(String JSONResult : JSONResults){
            list.add(JSONHelper.importTestResultFromJSON(JSONResult));
        }

        listViewResults = v.findViewById(R.id.listViewResults);
        adapter = new ResultAdapter(v.getContext(), list);
        listViewResults.setAdapter(adapter);

        Button btnClearAll = v.findViewById(R.id.btnClearAll);
        btnClearAll.setOnClickListener(v1 -> {
            DBHelper dbHelper = new DBHelper(getActivity());
            SQLlite.delete_all(DBHelper.TABLE_RESULTS, dbHelper);
            adapter.notifyDataSetChanged();
        });

        return v;
    }
}