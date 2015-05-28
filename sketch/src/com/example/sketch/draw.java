package com.example.sketch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class draw extends View{
	
	public float prex;
	public float prey;
	public float tempx;
	public float tempy;
	public float radius;    //Բ�İ뾶
	public float cx;
	public float cy;
	public Bitmap bitmap=null;
	public Path path;
	public static final int view_height=500;
	public static final int view_width=500;
	public Canvas canva;
	public Paint paint;
	private  int colorState=3;
	private int strokeState;
	private int pictureState;
	
	private boolean roundRect_flag=false;     //�ж��Ƿ�Բ�Ǿ���
	private boolean oval_flag=false;		 //�ж��Ƿ���Բ
	private boolean arc_flag=false;			 //�ж��Ƿ񻭻���
	private boolean rectangle_flag=false;	//�ж��Ƿ񻭾���
	private boolean circle_flag=false;		 //�ж��Ƿ�Բ
	
	private  Commdata data;
	public void getPictuteState()
	{
		pictureState=data.getPicture();
	}
	public  void getColorState()
	{
		colorState=data.getPaintColor();
	}
	public void getStrokeState()
	{
		strokeState=data.getPaintStroke();
	}
	
	/*���û��ʵ���ɫ*/
	public void setPaintColor(int colorState)
	{
		switch(colorState)
		{
		case 0:
			paint.setColor(getResources().getColor(R.color.white));
			break;
		case 1:
			
			paint.setColor(getResources().getColor(R.color.yellow));
			break;
		case 2:
			paint.setColor(getResources().getColor(R.color.blue));
			break;
		case 3:
			paint.setColor(getResources().getColor(R.color.black));
			break;
		case 4:
			paint.setColor(getResources().getColor(R.color.red));
			break;
		case 5:
			paint.setColor(getResources().getColor(R.color.aqua));
			break;
		case 6:	
			paint.setColor(getResources().getColor(R.color.gainsboro));
			break;
		case 7:
			paint.setColor(getResources().getColor(R.color.lightskyblue));
			break;
		case 8:
			paint.setColor(getResources().getColor(R.color.green));
			break;
		case 9:
			paint.setColor(getResources().getColor(R.color.orange));
			break;
		case 10:
			paint.setColor(getResources().getColor(R.color.orchid));
			break;
		case 11:
			paint.setColor(getResources().getColor(R.color.turquoise));
			break;
		default:
			break;

		}
	}
	/*���û��ʵ��߿�*/
	public void setPaintStroke(int strokeState)
	{
		switch(strokeState)
		{
		case 1:
			paint.setStrokeWidth(1);
			break;
		case 3:
			paint.setStrokeWidth(3);
			break;
		case 5:
			paint.setStrokeWidth(5);
			break;
		case 7:
			paint.setStrokeWidth(7);
			break;
		default:
			break;
		}
		
	}
	/*
	 * ���캯��
	 */
	public draw(Context context)
	{
		super(context);
		/*��ʼ��Commdate��*/
		data=new Commdata();
		/*��ʼ��λͼ*/
		bitmap=Bitmap.createBitmap(view_width,view_height,Config.RGB_565);
		/*��ʼ����*/
		canva=new Canvas();
		
		canva.setBitmap(bitmap);
		/*���û����ı�����ɫ*/
		canva.drawColor(Color.WHITE);
		/*��ʼ��·��*/
		path=new Path();
		/*��ʼ������*/
		paint=new Paint(Paint.DITHER_FLAG);
		/*���û��ʵ���ɫ*/
		paint.setColor(Color.BLACK);
		/*����Ч��*/
		paint.setStyle(Paint.Style.STROKE);
		/*���ʵ��߿�*/
		paint.setStrokeWidth(5);
		/*���û���Ϊ�޾��*/
		paint.setAntiAlias(true);
		/*����ͼ����ж���Ч��*/
		paint.setDither(true);
	}
	public draw(Context context,AttributeSet set)
	{
		super(context,set);
		data=new Commdata();
		/*��ʼ��λͼ*/
		bitmap=Bitmap.createBitmap(view_width,view_height,Config.RGB_565);
		/*��ʼ����*/
		canva=new Canvas();
		
		canva.setBitmap(bitmap);
		/*���û����ı�����ɫ*/
		canva.drawColor(Color.WHITE);
		/*��ʼ��·��*/
		path=new Path();
		/*��ʼ������*/
		paint=new Paint(Paint.DITHER_FLAG);
		/*���û��ʵ���ɫ*/
		paint.setColor(Color.BLACK);
		/*����Ч��*/
		paint.setStyle(Paint.Style.STROKE);
		/*���ʵ��߿�*/
		paint.setStrokeWidth(1);
		/*���û���Ϊ�޾��*/
		paint.setAntiAlias(true);
		/*����ͼ����ж���Ч��*/
		paint.setDither(true);
	}
	/*
	 * �����¼�
	 * @see android.view.View#onTouchEvent(android.view.MotionEvent)
	 */
	public boolean  onTouchEvent(MotionEvent event)
	{
			getColorState();
			getStrokeState();
			getPictuteState();
			setPaintColor(colorState);
			setPaintStroke(strokeState);
			
			/*��ȡ�������*/
			float x=event.getX();
			float y=event.getY();
			
			switch(event.getAction())
			{	
				/*��갴���¼�*/
				case MotionEvent.ACTION_DOWN:
					{
						switch(pictureState)
						{
						case 0:
							path.moveTo(x, y);
							prex=x;
							prey=y;
							invalidate();
							break;
						case 1:
							rectangle_flag=false;
							prex=x;
							prey=y;
							break;
						case 2:
							oval_flag=false;
							prex=x;
							prey=y;
							break;
						case 3:
							roundRect_flag=false;
							prex=x;
							prey=y;
							break;
						case 4:
							circle_flag=false;
							prex=x;
							prey=y;
							break;
						case 5:
							arc_flag=false;
							prex=x;
							prey=y;
							break;
						default:
							break;
						}
						
						
					}
					break;
					
					/*����ƶ��¼�*/
				case MotionEvent.ACTION_MOVE:
				{

					switch(pictureState)
					{
					case 0:					
						path.quadTo(prex, prey, x, y);
						prex=x;
						prey=y;
						invalidate();
						break;
					case 1:
						rectangle_flag=true;
						tempx=x;
						tempy=y;
						invalidate();
						break;
					case 2:
						oval_flag=true;
						tempx=x;
						tempy=y;
						invalidate();
						break;
					case 3:
						roundRect_flag=true;
						tempx=x;
						tempy=y;
						invalidate();
						break;
					case 4:
						circle_flag=true;
						tempx=x;
						tempy=y;
						invalidate();
						break;
					case 5:
						arc_flag=true;
						tempx=x;
						tempy=y;
						invalidate();
						break;
					}
					
				}
				break;
				/*����ɿ��¼�*/
				case MotionEvent.ACTION_UP:
				{
					switch(pictureState)
					{
					/*��ֱ��*/
					case 0:
						canva.drawPath(path,paint);
						path.reset();
						invalidate();
						break;
						
					/*������*/
					case 1:																		
						if(rectangle_flag)
						{
							canva.drawRect(prex,prey,tempx,tempy,paint);
							invalidate();
						}						
						break;
						
						/*����Բ*/
					case 2:
						if(oval_flag)
						{
							RectF rec=new RectF(prex,prey,tempx,tempy);
							canva.drawOval(rec,paint);
							invalidate();
						}						
						break;
						
						/*��Բ�Ǿ���*/
					case 3:
						if(roundRect_flag)
						{
							RectF f2 = new RectF(prex,prey,tempx,tempy);
							canva.drawRoundRect(f2,10,10,paint);
							invalidate();
						}						
						break;
						
						/*��Բ*/
					case 4:
						if(circle_flag)
						{
							if(tempx != prex && tempy!=prey){
								cx = Math.abs(tempx-prex)/2 + (tempx < prex? tempx:prex);
								cy = Math.abs(tempy-prey)/2 + (tempy < prey? tempy:prey);
								radius = (float) Math.sqrt(Math.abs(cx * cx) + Math.abs(cy*cy));
								canva.drawCircle(cx,cy, radius, paint);
							}
							
							invalidate();
						}						
						break;
						
						/*������*/
					case 5:
						if(arc_flag)
						{
							RectF f = new RectF(prex,prey,tempx,tempy);
							canva.drawArc(f, 225, 90, false, paint);
							invalidate();
						}						
						break;
					}
				}
				break;
				
			}
			
			return true;
	}
	public void onDraw(Canvas canva)
	{
		super.onDraw(canva);
		switch(pictureState)
		{
		/*��ֱ��*/
		case 0:			
			canva.drawBitmap(bitmap,0,0,paint);
			canva.drawPath(path,paint);
			break;
			
			/*������*/
		case 1:
			canva.drawBitmap(bitmap,0,0,paint);
			canva.drawRect(prex,prey,tempx,tempy,paint);
			break;
			
			/*����Բ*/		
		case 2:
			canva.drawBitmap(bitmap,0,0,paint);
			RectF rec=new RectF(prex,prey,tempx,tempy);
			canva.drawOval(rec,paint);
			break;
			
			/*��Բ�Ǿ���*/
		case 3:
			canva.drawBitmap(bitmap,0,0,paint);
			RectF f2 = new RectF(prex,prey,tempx,tempy);
			canva.drawRoundRect(f2,10,10,paint);
			break;
			
			/*��Բ*/
		case 4:
			canva.drawBitmap(bitmap,0,0,paint);
			
			if(tempx != prex && tempy!=prey){
				cx = Math.abs(tempx-prex)/2 + (tempx < prex? tempx:prex);
				cy = Math.abs(tempy-prey)/2 + (tempy < prey? tempy:prey);
				radius = (float) Math.sqrt(Math.abs(cx * cx) + Math.abs(cy*cy));
				canva.drawCircle(cx,cy, radius, paint);
			}
			break;
			
			/*������*/
		case 5:
			canva.drawBitmap(bitmap,0,0,paint);
			RectF f = new RectF(prex,prey,tempx,tempy);
			canva.drawArc(f, 225, 90, false, paint);
			break;
		}
		
	}

}
