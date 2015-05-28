package com.example.sketch;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class colorFragment extends Fragment implements OnClickListener{

	
	public static final int WHITE=0;  //��ɫ
	public static final int YELLOW=1; //��ɫ
	public static final int BLUE=2;	  //��ɫ
	public static final int BLACK=3;  //��ɫ
	public static final int RED=4;    //��ɫ
	public static final int AQUA=5;
	public static final int GAINSBORO=6;
	public static final int LIGHTSKYBLUE=7;
	public static final int GREEN=8;
	public static final int ORANGE=9;
	public static final int ORCHID=10;
	public static final int TURQUOISE=11;
	
	private Button white;
	private Button yellow;
	private Button blue;
	private Button black;
	private Button red;
	private Button aqua;
	private Button gainsboro;
	private Button lightskyblue;
	private Button green;
	private Button orange;
	private Button orchid;
	private Button turquoise;
	private Commdata data;
	
	//private static final int LAVENDERBLUSH=4;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		data=new Commdata();
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
	{
		/*
		 * ��ȡ��ť
		 */
		View rootView=inflater.inflate(R.layout.color_fragment, null);
		/*��ɫ*/
		white=(Button)rootView.findViewById(R.id.white);
		
		/*��ɫ*/
		yellow=(Button)rootView.findViewById(R.id.yellow);
		
		/*��ɫ*/
		blue=(Button)rootView.findViewById(R.id.blue);
		
		/*��ɫ*/
		black=(Button)rootView.findViewById(R.id.black);
		
		/*��ɫ*/
		red=(Button)rootView.findViewById(R.id.red);
		
		/*ǳ��ɫ*/
		aqua=(Button)rootView.findViewById(R.id.aqua);
		
		/*����ɫ */
		gainsboro=(Button)rootView.findViewById(R.id.gainsboro);
		
		/*�����*/
		lightskyblue=(Button)rootView.findViewById(R.id.lightskyblue);
		
		/*��ɫ*/
		green=(Button)rootView.findViewById(R.id.green);
		
		/*�ٻ�ɫ*/
		orange=(Button)rootView.findViewById(R.id.orange);
		
		/*����ɫ*/
		orchid=(Button)rootView.findViewById(R.id.orchid);
		
		/*ǳ��ɫ*/
		turquoise=(Button)rootView.findViewById(R.id.turquoise);
		/*
		 * ����ť����¼�
		 */
		white.setOnClickListener(this);
		yellow.setOnClickListener(this);
		blue.setOnClickListener(this);
		black.setOnClickListener(this);
		red.setOnClickListener(this);
		gainsboro.setOnClickListener(this);
		lightskyblue.setOnClickListener(this);
		green.setOnClickListener(this);
		aqua.setOnClickListener(this);
		orange.setOnClickListener(this);
		orchid.setOnClickListener(this);
		turquoise.setOnClickListener(this);
		
		return rootView;
	}
	@Override
	public void onClick(View view)
	{
		switch(view.getId())
		{
		case R.id.white:
			data.setPaintColor(WHITE);
			
			
			break;
		case R.id.yellow:
			data.setPaintColor(YELLOW);
			
			break;
		case R.id.blue:
			data.setPaintColor(BLUE);
			
			break;
		case R.id.black:
			data.setPaintColor(BLACK);
			break;
			
		case R.id.red:
			data.setPaintColor(RED);
			break;
			
		case R.id.aqua:
			data.setPaintColor(AQUA);
			break;
			
		case R.id.gainsboro:
			data.setPaintColor(GAINSBORO);
			
			
			break;
		case R.id.lightskyblue:
			data.setPaintColor(LIGHTSKYBLUE);
			
			break;
		case R.id.green:
			data.setPaintColor(GREEN);
			
			break;
		case R.id.orange:
			data.setPaintColor(ORANGE);
			break;
			
		case R.id.orchid:
			data.setPaintColor(ORCHID);
			break;
			
		case R.id.turquoise:
			data.setPaintColor(TURQUOISE);
			break;
		default:
			break;
		}
	}
	
}
