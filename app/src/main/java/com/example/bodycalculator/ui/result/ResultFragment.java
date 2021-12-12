package com.example.bodycalculator.ui.result;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bodycalculator.R;
import com.example.bodycalculator.databinding.FragmentResultBinding;
import com.example.bodycalculator.databinding.FragmentSelectIndexBinding;
import com.example.bodycalculator.ui.select_index.SelectIndexViewModel;


public class ResultFragment extends Fragment {

    private FragmentResultBinding binding;
    private ResultViewModel resultViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        resultViewModel =
                new ViewModelProvider(this).get(ResultViewModel.class);

        binding = FragmentResultBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtRes;
        resultViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}