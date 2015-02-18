package com.chjvps.hengjiechen.chjapp;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.app.UiAutomation;



public class MainActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener {
    private static final String TAG = "chenhengjie123";

    //declare text and seekBar
    private TextView mTvDef;
    private SeekBar mSeekBarDef;
    private ListView mLvDef;
    private UiAutomation uiAutomation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        mTvDef = (TextView) findViewById(R.id.tv_def);
        mSeekBarDef = (SeekBar) findViewById(R.id.seekBar_def);
        mSeekBarDef.setOnSeekBarChangeListener(this);

        mLvDef = (ListView) findViewById(R.id.lv_def);
        mLvDef.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));

    }

    private List<String> getData(){

        List<String> data = new ArrayList<String>();
        for (int i=0; i<20; i++) {
            data.add("test view"+i);
        }

        return data;
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d(TAG, "seekid: "+seekBar.getId()+", progress:"+progress);
        switch (seekBar.getId()){
            case R.id.seekBar_def:{
                mTvDef.setText(getResources().getString(R.string.text_def)+" : "
                        +String.valueOf(seekBar.getProgress()));
                break;
            }
            default:
                break;
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
