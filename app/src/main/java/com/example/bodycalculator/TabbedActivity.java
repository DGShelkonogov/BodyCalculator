package com.example.bodycalculator;

import android.os.Bundle;

import com.example.bodycalculator.models.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.bodycalculator.ui.main.SectionsPagerAdapter;
import com.example.bodycalculator.databinding.ActivityTabbedBinding;

public class TabbedActivity extends AppCompatActivity {

    private ActivityTabbedBinding binding;
    public User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        user = new User();

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            int position = arguments.getInt("position");
            viewPager.setCurrentItem(position );
        }
    }
}