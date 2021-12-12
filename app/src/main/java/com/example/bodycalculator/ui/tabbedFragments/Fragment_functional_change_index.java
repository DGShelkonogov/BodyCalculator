package com.example.bodycalculator.ui.tabbedFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bodycalculator.R;

public class Fragment_functional_change_index extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_functional_change_index, container, false);

        TextView txt_change_index_res = v.findViewById(R.id.txt_change_index_res);
        TextView txt_change_index_rec = v.findViewById(R.id.txt_change_index_rec);

        int age = 19;

        EditText edtNumBodyMass = v.findViewById(R.id.edtNumBodyMass);
        EditText edtNumHeight = v.findViewById(R.id.edtNumHeight);
        EditText edtNumCSS = v.findViewById(R.id.edtNumCSS);
        EditText edtNumSAD = v.findViewById(R.id.edtNumSAD);
        EditText edtNumDAD = v.findViewById(R.id.edtNumDAD);
        Button btn_change_index_define = v.findViewById(R.id.btn_change_index_define);
        btn_change_index_define.setOnClickListener(v1 -> {
            double CSS = Double.parseDouble(edtNumCSS.getText().toString());
            double SAD = Double.parseDouble(edtNumSAD.getText().toString());
            double DAD = Double.parseDouble(edtNumDAD.getText().toString());
            double bodyMass = Double.parseDouble(edtNumBodyMass.getText().toString());
            double height  = Double.parseDouble(edtNumHeight.getText().toString());

            double ifi = (0.011 * CSS) + (0.014 * SAD) + (0.008 * DAD) + (0.014 * age) +
                    (0.009 * bodyMass) - (0.009 * height) - 0.27;
            String result = String.format("%.2f",ifi);
            String rec = "";


            if(ifi < 2.6){
                rec = "функциональные возможности системы кровообращения хорошие. " +
                        "Механизмы адаптации устойчивы: действие неблагоприятных факторов" +
                        " студенческого образа жизни успешно компенсируется мобилизацией " +
                        "внутренних резервов организма, эмпирически подобранными " +
                        "профилактическими мероприятиями (увлечение спортом, " +
                        "рациональное распределение времени на работу и " +
                        "отдых, адекватная организация питания).";
            }

            if(ifi >= 2.6 && ifi <=3.09){
                rec = "удовлетворительные функциональные возможности системы кровообращения " +
                        "с умеренным напряжением механизмов регуляции. Эта категория " +
                        "практически здоровых людей, имеющих скрытые или " +
                        "нераспознанные заболевания, нуждающихся в дополнительном " +
                        "обследовании. Скрытые или неясно выраженные нарушения " +
                        "процессов адаптации могут быть восстановлены с помощью методов " +
                        "нелекарственной коррекции (массаж, мышечная релаксация, дыхательная" +
                        " гимнастика, аутотренинг), компенсирующих недостаточность или слабость " +
                        "внутреннего звена саморегуляции функций.";
            }

            if(ifi > 3.09){
                rec = "сниженные, недостаточные возможности системы кровообращения, " +
                        "наличие выраженных нарушений процессов адаптации. " +
                        "Необходима полноценная диагностика, квалифицированное " +
                        "лечение и индивидуальный подбор профилактических мероприятий " +
                        "в период ремиссии. ";
            }
            txt_change_index_res.setText(result);
            txt_change_index_rec.setText(rec);
        });

        return v;
    }
}