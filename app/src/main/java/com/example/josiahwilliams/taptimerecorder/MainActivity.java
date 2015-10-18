package com.example.josiahwilliams.taptimerecorder;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.SimpleTimeZone;

public class MainActivity extends AppCompatActivity {

    private Button mRecordTimeButton;
    private ListView mRecordTimeListView;
    private ArrayList<String> mRecordedTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecordTimeListView = (ListView) findViewById(R.id.recorded_time_list_view);

        //create button based on id
        mRecordTimeButton = (Button) findViewById(R.id.record_time_button);
        //Create onclick listener for when the button is pressed
        mRecordTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creates a format for the time
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                //creates an instance of Calendar to store time from when button was pressed
                Calendar c = Calendar.getInstance();
                //store time in string in the previously defined format
                String timeRecorded = df.format(c.getTime());
                //add the new time string to the list
                mRecordedTimes.add(timeRecorded);
                //adapter for string of times
                ArrayAdapter<String> adapter;
                //formats adaptert
                adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1,
                        mRecordedTimes.toArray(new String[mRecordedTimes.size()]));
                //fills list with adapter
                mRecordTimeListView.setAdapter(adapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
