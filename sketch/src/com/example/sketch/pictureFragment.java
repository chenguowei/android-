package com.example.sketch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class pictureFragment extends Fragment implements OnClickListener{
	private Button rectangle;   //������
	private Button line;		//��ֱ��
	private Button oval;		//��Բ
	private Button roundRect;   //Բ�Ǿ���
	private Button circle;		//Բ
	private Button arc;			//����
	
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
		/*��ȡfragment*/
		View rootView=inflater.inflate(R.layout.picture_fragment, null);
		
		/*��ʼ��Commdate��*/
		commondata=new Commdata();
		
		/*���ΰ�ť*/
		rectangle=(Button)rootView.findViewById(R.id.rectangle);
		rectangle.setOnClickListener(this);
		
		/*ֱ�߰�ť*/
		line=(Button)rootView.findViewById(R.id.line);
		line.setOnClickListener(this);
		
		/*��Բ��ť*/
		oval=(Button)rootView.findViewById(R.id.oval);
		oval.setOnClickListener(this);
		
		/*Բ�Ǿ��ΰ�ť*/
		roundRect=(Button)rootView.findViewById(R.id.roundRect);
		roundRect.setOnClickListener(this);
		
		/*Բ��ť*/
		circle=(Button)rootView.findViewById(R.id.circle);
		circle.setOnClickListener(this);
		
		/*���ΰ�ť*/
		arc=(Button)rootView.findViewById(R.id.arc);
		arc.setOnClickListener(this);
		return rootView;
	}
	
	/*��ť�¼�*/
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
