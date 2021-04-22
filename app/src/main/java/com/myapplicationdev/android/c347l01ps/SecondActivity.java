package com.myapplicationdev.android.c347l01ps;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tvSecular;
    ListView lvHoliday;
    ArrayList<Holiday> secularList;
    ArrayList<Holiday> ethnicAndReligionList;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvSecular = findViewById(R.id.tvSecular);
        lvHoliday = findViewById(R.id.lvHoliday);

        secularList = new ArrayList<Holiday>();
        ethnicAndReligionList = new ArrayList<Holiday>();

        secularList.add(new Holiday("New Year's Day", "1 Jan 2021"));
        secularList.add(new Holiday("Labour Day", "1 May 2021"));

        ethnicAndReligionList.add(new Holiday("Chinese New Year", "12-13 Feb 2021"));
        ethnicAndReligionList.add(new Holiday("Good Friday", "2 April 2021"));

        Intent intent = getIntent();
        String category = intent.getStringExtra(Intent.EXTRA_TEXT);
        tvSecular.setText(category);

        if(category.equals("Secular")){
            aa = new HolidayAdapter(this, R.layout.row, secularList);
        }
        else if(category.equals("Ethnic & Religion")){
            aa = new HolidayAdapter(this, R.layout.row, ethnicAndReligionList);
        }

        lvHoliday.setAdapter(aa);

    }
}
