package com.example.sketch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class strokeFragment extends Fragment implements OnClickListener{
	private Button width_1,width_3,width_5,width_7;
	private static final int WIDTH_1=1;
	private static final int WIDTH_3=3;
	private static final int WIDTH_5=5;
	private static final int WIDTH_7=7;
	private Commdata commondata;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
	{
		View rootView=inflater.inflate(R.layout.stroke_fragment, null);
		commondata=new Commdata();
		width_1=(Button)rootView.findViewById(R.id.width1);
		width_3=(Button)rootView.findViewById(R.id.width3);
		width_5=(Button)rootView.findViewById(R.id.width5);
		width_7=(Button)rootView.findViewById(R.id.width7);
		width_1.setOnClickListener(this);
		width_3.setOnClickListener(this);
		width_5.setOnClickListener(this);
		width_7.setOnClickListener(this);
		return rootView;
	}
	@Override
	public void onClick(View view)
	{
		switch(view.getId())
		{
		case R.id.width1:
			commondata.setPaintStroke(WIDTH_1);
			break;
		case R.id.width3:
			commondata.setPaintStroke(WIDTH_3);
			break;
		case R.id.width5:
			commondata.setPaintStroke(WIDTH_5);
			break;
		case R.id.width7:
			commondata.setPaintStroke(WIDTH_7);
			break;
		default:
			break;
			
		}
	}
	

}
