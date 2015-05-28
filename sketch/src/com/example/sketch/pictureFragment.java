package com.example.sketch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class pictureFragment extends Fragment implements OnClickListener{
	private Button rectangle;   //画矩形
	private Button line;		//画直线
	private Button oval;		//椭圆
	private Button roundRect;   //圆角矩形
	private Button circle;		//圆
	private Button arc;			//弧线
	
	private static final int LINE=0;
	private static final int RECTANGLE=1;	
	private static final int OVAL=2;
	private static final int ROUNDRECT=3;
	private static final int CIRCLE=4;
	private static final int ARC=5;
	
	private Commdata commondata;
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
	{
		/*获取fragment*/
		View rootView=inflater.inflate(R.layout.picture_fragment, null);
		
		/*初始化Commdate类*/
		commondata=new Commdata();
		
		/*矩形按钮*/
		rectangle=(Button)rootView.findViewById(R.id.rectangle);
		rectangle.setOnClickListener(this);
		
		/*直线按钮*/
		line=(Button)rootView.findViewById(R.id.line);
		line.setOnClickListener(this);
		
		/*椭圆按钮*/
		oval=(Button)rootView.findViewById(R.id.oval);
		oval.setOnClickListener(this);
		
		/*圆角矩形按钮*/
		roundRect=(Button)rootView.findViewById(R.id.roundRect);
		roundRect.setOnClickListener(this);
		
		/*圆按钮*/
		circle=(Button)rootView.findViewById(R.id.circle);
		circle.setOnClickListener(this);
		
		/*弧形按钮*/
		arc=(Button)rootView.findViewById(R.id.arc);
		arc.setOnClickListener(this);
		return rootView;
	}
	
	/*按钮事件*/
	public void onClick(View view)
	{
		switch(view.getId())
		{
		case R.id.rectangle:
			commondata.setPicture(RECTANGLE);
			break;
		case R.id.line:
			commondata.setPicture(LINE);
			break;
		case R.id.oval:
			commondata.setPicture(OVAL);
			break;
		case R.id.roundRect:
			commondata.setPicture(ROUNDRECT);
			break;
		case R.id.circle:
			commondata.setPicture(CIRCLE);
			break;
		case R.id.arc:
			commondata.setPicture(ARC);
		default:
			break;
			
		}
	}
	

}
