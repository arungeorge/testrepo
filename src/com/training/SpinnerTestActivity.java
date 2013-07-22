package com.training;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerTestActivity extends Activity {
    /** Called when the activity is first created. */
	
	public static Spinner sp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ArrayList<String> items = new ArrayList<String>();
        items.add("Hello");
        items.add("World");
        items.add("Happy");
        items.add("Boy");
        
        ArrayAdapter<String> adapter = new CustomAdapter(this, items);
        
        sp =(Spinner) findViewById(R.id.spinner1);
        sp.setAdapter(adapter);
        
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(SpinnerTestActivity.this , "Spinner On Item Selected" + items.get(position), Toast.LENGTH_LONG).show() ;
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
    }
}