package com.myapplicationdev.android.c347l01ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holidayArrayList;
    private Context context;
    private TextView tvHolidayName, tvHolidayDate;
    private ImageView iv;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holidayArrayList = objects;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvHolidayName = (TextView) rowView.findViewById(R.id.tvHolidayName);
        tvHolidayDate = (TextView) rowView.findViewById(R.id.tvHolidayDate);
        iv = (ImageView) rowView.findViewById(R.id.ivHoliday);


        Holiday currentModule = holidayArrayList.get(position);

        tvHolidayName.setText(currentModule.getHoliday());
        tvHolidayDate.setText(currentModule.getDate());

        if(currentModule.getHoliday() == "New Year's Day") {
            iv.setImageResource(R.drawable.newyear);
        }
        else if(currentModule.getHoliday() == "Labour Day") {
            iv.setImageResource(R.drawable.labourday);
        }
        else if(currentModule.getHoliday() == "Chinese New Year") {
            iv.setImageResource(R.drawable.cny);
        }
        else if(currentModule.getHoliday() == "Good Friday") {
            iv.setImageResource(R.drawable.goodfriday);
        }

        return rowView;
    }
}
