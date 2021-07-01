package com.example.nguyenducmanh_day7_android43;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTime, tvDate, tvSave, tvTags, tvWeek, tvTagsMenu, tvWeekMenu;
    LinearLayout layoutTypeMenu;
    Button btnTune;

    int hour, minute;
    int day, month, year;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.tvTime);
        tvDate = findViewById(R.id.tvDate);
        tvSave = findViewById(R.id.tvSave);

        //set time
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTime();
            }
        });

        //set date
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });

        //set save
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Thông báo");
                builder.setMessage("Lưu những thay đổi ?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        //set type
        layoutTypeMenu = findViewById(R.id.layoutTypeMenu);
        layoutTypeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_type,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        TextView tvTypeMenu;
                        tvTypeMenu = findViewById(R.id.tvTypeMenu);

                        switch (item.getItemId()){
                            case R.id.mnWork:
                                tvTypeMenu.setText("Work");
                                break;
                            case R.id.mnFriend:
                                tvTypeMenu.setText("Friend");
                                break;
                            case R.id.mnFamily:
                                tvTypeMenu.setText("Family");
                                break;
                        }
                        return false;
                    }
                });


            }
        });

        //set tune button

        btnTune = findViewById(R.id.btnTune);
        btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_tune,popupMenu.getMenu());
                popupMenu.show();

            }
        });

        //set tags



        tvTags = findViewById(R.id.tvTags);
        tvTagsMenu = findViewById(R.id.tvTagsMenu);

        tvTagsMenu.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                String[] strings = {"Family","Game","Android","VTC","Friend"};
                ArrayList al = new ArrayList();
                boolean[] booleans = {false,false,false,false,false};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Choose tags: ");
                builder.setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked)
                            al.add(strings[which]);

                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       String new1 = al.toString().replace("[","");
                        String new2 = new1.replace("]","");

                            tvTagsMenu.setText(""+new2);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });

               AlertDialog alertDialog = builder.create();
               alertDialog.show();
            }
        });


        //set weeks

        tvWeek = findViewById(R.id.tvWeek);
        tvWeekMenu = findViewById(R.id.tvWeekMenu);

        tvWeekMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
                ArrayList al = new ArrayList();
                boolean[] booleans = {false,false,false,false,false,false,false};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Choose tags: ");
                builder.setMultiChoiceItems(strings, booleans, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked)
                            al.add(strings[which]);

                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String new1 = al.toString().replace("[","");
                        String new2 = new1.replace("]","");

                        tvWeekMenu.setText(""+new2);

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });




    }

    public void selectTime(){
        final boolean is24HourView = true;
        tvTime = findViewById(R.id.tvTime);
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvTime.setText(hourOfDay+":"+minute);

            }


        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,timeSetListener,hour,minute,is24HourView);
        timePickerDialog.show();
    }

    public void selectDate(){
        tvDate = findViewById(R.id.tvDate);

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tvDate.setText(dayOfMonth+"/"+month+"/"+year);
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,day,month,year);
        datePickerDialog.show();
    }


}