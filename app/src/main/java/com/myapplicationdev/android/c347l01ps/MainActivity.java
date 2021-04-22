package com.myapplicationdev.android.c347l01ps;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvCategory);


        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                switch( position )
                {
                    case 0:
                        i.putExtra("category","Secular");
                        break;
                    case 1:
                        i.putExtra("category","Ethnic & Religion");
                        break;
                }
                startActivity(i);
            }
        });



    }
}
