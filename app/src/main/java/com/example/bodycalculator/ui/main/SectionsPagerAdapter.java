package com.example.bodycalculator.ui.main;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bodycalculator.R;
import com.example.bodycalculator.TabbedActivity;
import com.example.bodycalculator.models.User;
import com.example.bodycalculator.ui.result.ResultFragment;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_body_mass_index;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_endurance_coefficient;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_functional_change_index;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_kerdo_index;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_level_of_physical_activity;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_life_index;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_regulation_heart;
import com.example.bodycalculator.ui.tabbedFragments.Fragment_skibinski_coefficient;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public Fragment[] fragments = new Fragment[]{
            new Fragment_body_mass_index(),
            new Fragment_level_of_physical_activity(),
            new Fragment_endurance_coefficient(),
            new Fragment_regulation_heart(),
            new Fragment_life_index(),
            new Fragment_skibinski_coefficient(),
            new Fragment_kerdo_index(),
            new Fragment_functional_change_index()
    };
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }


    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       TabbedActivity activity = (TabbedActivity) fragments[position].getActivity();

       try{
           User user = activity.user;
           if(user.getBodyMass() != 0.0){
               EditText edt = fragments[position].getView().findViewById(R.id.edtNumBodyMass);
               edt.setText(String.valueOf(user.getBodyMass()));
           }

       }catch (NullPointerException ex){

       }



    }




    @Override
    public int getCount() {
        // Show 2 total pages.
        return 8;
    }
}