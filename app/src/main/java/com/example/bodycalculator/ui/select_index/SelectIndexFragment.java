package com.example.bodycalculator.ui.select_index;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.bodycalculator.Adapters.SimpleAdapter;
import com.example.bodycalculator.R;
import com.example.bodycalculator.databinding.FragmentSelectIndexBinding;

import java.util.ArrayList;
import java.util.List;

public class SelectIndexFragment extends Fragment {

    private SelectIndexViewModel selectIndexViewModel;
    private FragmentSelectIndexBinding binding;

    private ListView listView;
    SimpleAdapter adapter;
    List<String> list = new ArrayList<>();

    Button btnStart;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        selectIndexViewModel =
                new ViewModelProvider(this).get(SelectIndexViewModel.class);

        binding = FragmentSelectIndexBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        btnStart = root.findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {

        });

        listView = root.findViewById(R.id.list_select_index);
        list.add("Индекс массы тела");
        list.add("Уровень двигательный активности");
        list.add("Коэффициент выносливости");
        list.add("Уровень регуляции сердечно-сосудистой системы");
        list.add("Жизненный индекс");
        list.add("Циркулярно-респираторный коэффициент Скибински");
        list.add("Вегетативный индекс Кердо");
        list.add("Индекс функциональных изменений");
        adapter = new SimpleAdapter(getActivity(), list);
        listView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}