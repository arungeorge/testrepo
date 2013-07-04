package com.training;

import java.util.ArrayList;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends ArrayAdapter<String> implements SpinnerAdapter {

	ArrayList<String> items;
	Context mContext;
	
	
	
	public CustomAdapter(Context context, ArrayList<String> items) {
		super(context, R.layout.rowspinner, items);
		this.items = items;
		this.mContext = context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position) ;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView tx = null;
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = (LinearLayout) inflater.inflate(R.layout.rowspinner, null);
			//A simple text view
			tx = (TextView) convertView.findViewById(R.id.textView1);
		}
		
		tx.setText(items.get(position));
		
		return convertView;
	}
	
	@Override
	public View getDropDownView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView tx = null;
		if(convertView == null){
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.rowspinner, null);
			
		}
		tx = (TextView) convertView.findViewById(R.id.textView1);
		tx.setText(items.get(position));
		
		tx.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "Drop Down Listener " +items.get(position) , Toast.LENGTH_SHORT);
				SpinnerTestActivity.sp.getOnItemSelectedListener().onItemSelected(null, null, position, 0);
			}
		});
		
		return convertView;
	}
}
