/* Código realizado por: Abner Emmanuel Becerra Valencia 
   */


package com.example.pc.proyectofinal.AccountActivity;

import android.app.TimePickerDialog; 
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.pc.proyectofinal.BottomNavigationViewHelper;
import com.example.pc.proyectofinal.Main;
import com.example.pc.proyectofinal.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Atwo extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atwo);


    
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListAdapter.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

                        Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " ListView Open.",
                        Toast.LENGTH_SHORT).show();

            }

        });


        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {

                        Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " ListView Closed.",
                        Toast.LENGTH_SHORT).show();

            }
        });


        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                        Toast.makeText(getApplicationContext(),
                        expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition)+ "xd", Toast.LENGTH_SHORT).show();
                String stringg =expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition);
switch (stringg){
                            case "Every Day":
                                Timer t = new Timer();
                                t.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                FirebaseDatabase database = FirebaseDatabase.getInstance();

                                DatabaseReference myRef = database.getReference("LED_STATUS");



                                myRef.setValue(1);
                                try {
                                    TimeUnit.SECONDS.sleep(1);
                                    myRef.setValue(0);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                    }
                                },0,10000);
                                break;
                            case "Every Two Days":
                                Timer t2 = new Timer();
                                t2.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        FirebaseDatabase database = FirebaseDatabase.getInstance();

                                        DatabaseReference myRef = database.getReference("LED_STATUS");



                                        myRef.setValue(1);
                                        try {
                                            TimeUnit.SECONDS.sleep(1);
                                            myRef.setValue(0);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },0,20000);
                                break;
                            case "Every three Days":
                                Timer t3 = new Timer();
                                t3.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        FirebaseDatabase database = FirebaseDatabase.getInstance();

                                        DatabaseReference myRef = database.getReference("LED_STATUS");
myRef.setValue(1);
                                        try {
                                            TimeUnit.SECONDS.sleep(1);
                                            myRef.setValue(0);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },0,30000);
                                break;
                            case "Every Four Days":
                                Timer t4 = new Timer();
                                t4.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        FirebaseDatabase database = FirebaseDatabase.getInstance();

                                        DatabaseReference myRef = database.getReference("LED_STATUS");



                                        myRef.setValue(1);
                                        try {
                                            TimeUnit.SECONDS.sleep(1);
                                            myRef.setValue(0);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },0,40000);
                                break;
                            case "Every Five Days":
                                Timer t5 = new Timer();
                                t5.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        FirebaseDatabase database = FirebaseDatabase.getInstance();

                                        DatabaseReference myRef = database.getReference("LED_STATUS");



                                        myRef.setValue(1);
                                        try {
                                            TimeUnit.SECONDS.sleep(1);
                                            myRef.setValue(0);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },0,50000);
                                break;
                                default:


                        }
                return false;
            }
        });



        /////////////////////////////////////////////////////////

        Button button = (Button) findViewById(R.id.selecthour);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment TIMEPICKER = new TimePickerFragment();
                TIMEPICKER.show(getSupportFragmentManager(), "Time picker");
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.BOTTOM);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.ic_arrow:

                        break;

                    case R.id.ic_android:
                        Intent intent1 = new Intent(Atwo.this, aone.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(Atwo.this, Atwo.class);
                        startActivity(intent2);
                        break;

case R.id.ic_center_focus:
                        Intent intent3 = new Intent(Atwo.this, Athree.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_backup:
                        Intent intent4 = new Intent(Atwo.this, Afour.class);
                        startActivity(intent4);
                        break;
                }

                return false;

            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {

        TextView textView = (TextView) findViewById(R.id.timetext);
        textView.setText("Hour: " + hour + "   Minutes:" + minute);

        
        final String time2 = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        final String time = format.format(calendar.getTime());
        Toast.makeText(getApplicationContext(), "vlaue is " + time, Toast.LENGTH_LONG).show();



        if (time.equals(time2)) {
           
            runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(getApplicationContext(), "SAME VALUE: " + time, Toast.LENGTH_LONG).show();
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("LED_STATUS");
                    myRef.setValue(1);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        myRef.setValue(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {

        }
    }
}
