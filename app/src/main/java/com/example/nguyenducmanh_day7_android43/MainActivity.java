package com.example.nguyenducmanh_day7_android43;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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

import com.example.nguyenducmanh_day7_android43.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;



    int hour, minute;
    int day, month, year;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);


        //set time thoi gian thu
        binding.tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTime();
            }
        });

        //set date
        binding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();
            }
        });

        //set save
        binding.tvSave.setOnClickListener(new View.OnClickListener() {
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

        binding.layoutTypeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_type,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {


                        switch (item.getItemId()){
                            case R.id.mnWork:
                                binding.tvTypeMenu.setText("Work");
                                break;
                            case R.id.mnFriend:
                                binding.tvTypeMenu.setText("Friend");
                                break;
                            case R.id.mnFamily:
                                binding.tvTypeMenu.setText("Family");
                                break;
                        }
                        return false;
                    }
                });


            }
        });

        //set tune button


        binding.btnTune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getBaseContext(),v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.menu_tune,popupMenu.getMenu());
                popupMenu.show();

            }
        });

        //set tags





        binding.tvTagsMenu.setOnClickListener(new View.OnClickListener() {



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

                            binding.tvTagsMenu.setText(""+new2);

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



        binding.tvWeekMenu.setOnClickListener(new View.OnClickListener() {
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

                        binding.tvWeekMenu.setText(""+new2);

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
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                binding.tvTime.setText(hourOfDay+":"+minute);

            }


        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,timeSetListener,hour,minute,is24HourView);
        timePickerDialog.show();
    }

    public void selectDate(){


        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                binding.tvDate.setText(dayOfMonth+"/"+month+"/"+year);
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,day,month,year);
        datePickerDialog.show();
    }


}