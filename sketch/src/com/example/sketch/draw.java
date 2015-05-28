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
	public float radius;    //圆的半径
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
	
	private boolean roundRect_flag=false;     //判断是否画圆角矩形
	private boolean oval_flag=false;		 //判断是否画椭圆
	private boolean arc_flag=false;			 //判断是否画弧形
	private boolean rectangle_flag=false;	//判断是否画矩形
	private boolean circle_flag=false;		 //判断是否画圆
	
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
	
	/*设置画笔的颜色*/
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
	/*设置画笔的线宽*/
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
	 * 构造函数
	 */
	public draw(Context context)
	{
		super(context);
		/*初始化Commdate类*/
		data=new Commdata();
		/*初始化位图*/
		bitmap=Bitmap.createBitmap(view_width,view_height,Config.RGB_565);
		/*初始画布*/
		canva=new Canvas();
		
		canva.setBitmap(bitmap);
		/*设置画布的背景颜色*/
		canva.drawColor(Color.WHITE);
		/*初始化路径*/
		path=new Path();
		/*初始化画笔*/
		paint=new Paint(Paint.DITHER_FLAG);
		/*设置画笔的颜色*/
		paint.setColor(Color.BLACK);
		/*空心效果*/
		paint.setStyle(Paint.Style.STROKE);
		/*画笔的线宽*/
		paint.setStrokeWidth(5);
		/*设置画笔为无锯齿*/
		paint.setAntiAlias(true);
		/*设置图像具有抖动效果*/
		paint.setDither(true);
	}
	public draw(Context context,AttributeSet set)
	{
		super(context,set);
		data=new Commdata();
		/*初始化位图*/
		bitmap=Bitmap.createBitmap(view_width,view_height,Config.RGB_565);
		/*初始画布*/
		canva=new Canvas();
		
		canva.setBitmap(bitmap);
		/*设置画布的背景颜色*/
		canva.drawColor(Color.WHITE);
		/*初始化路径*/
		path=new Path();
		/*初始化画笔*/
		paint=new Paint(Paint.DITHER_FLAG);
		/*设置画笔的颜色*/
		paint.setColor(Color.BLACK);
		/*空心效果*/
		paint.setStyle(Paint.Style.STROKE);
		/*画笔的线宽*/
		paint.setStrokeWidth(1);
		/*设置画笔为无锯齿*/
		paint.setAntiAlias(true);
		/*设置图像具有抖动效果*/
		paint.setDither(true);
	}
	/*
	 * 触屏事件
	 * @see android.view.View#onTouchEvent(android.view.MotionEvent)
	 */
	public boolean  onTouchEvent(MotionEvent event)
	{
			getColorState();
			getStrokeState();
			getPictuteState();
			setPaintColor(colorState);
			setPaintStroke(strokeState);
			
			/*获取点击坐标*/
			float x=event.getX();
			float y=event.getY();
			
			switch(event.getAction())
			{	
				/*鼠标按下事件*/
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
					
					/*鼠标移动事件*/
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
				/*鼠标松开事件*/
				case MotionEvent.ACTION_UP:
				{
					switch(pictureState)
					{
					/*画直线*/
					case 0:
						canva.drawPath(path,paint);
						path.reset();
						invalidate();
						break;
						
					/*画矩形*/
					case 1:																		
						if(rectangle_flag)
						{
							canva.drawRect(prex,prey,tempx,tempy,paint);
							invalidate();
						}						
						break;
						
						/*画椭圆*/
					case 2:
						if(oval_flag)
						{
							RectF rec=new RectF(prex,prey,tempx,tempy);
							canva.drawOval(rec,paint);
							invalidate();
						}						
						break;
						
						/*画圆角矩形*/
					case 3:
						if(roundRect_flag)
						{
							RectF f2 = new RectF(prex,prey,tempx,tempy);
							canva.drawRoundRect(f2,10,10,paint);
							invalidate();
						}						
						break;
						
						/*画圆*/
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
						
						/*画弧形*/
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
		/*画直线*/
		case 0:			
			canva.drawBitmap(bitmap,0,0,paint);
			canva.drawPath(path,paint);
			break;
			
			/*画矩形*/
		case 1:
			canva.drawBitmap(bitmap,0,0,paint);
			canva.drawRect(prex,prey,tempx,tempy,paint);
			break;
			
			/*画椭圆*/		
		case 2:
			canva.drawBitmap(bitmap,0,0,paint);
			RectF rec=new RectF(prex,prey,tempx,tempy);
			canva.drawOval(rec,paint);
			break;
			
			/*画圆角矩形*/
		case 3:
			canva.drawBitmap(bitmap,0,0,paint);
			RectF f2 = new RectF(prex,prey,tempx,tempy);
			canva.drawRoundRect(f2,10,10,paint);
			break;
			
			/*画圆*/
		case 4:
			canva.drawBitmap(bitmap,0,0,paint);
			
			if(tempx != prex && tempy!=prey){
				cx = Math.abs(tempx-prex)/2 + (tempx < prex? tempx:prex);
				cy = Math.abs(tempy-prey)/2 + (tempy < prey? tempy:prey);
				radius = (float) Math.sqrt(Math.abs(cx * cx) + Math.abs(cy*cy));
				canva.drawCircle(cx,cy, radius, paint);
			}
			break;
			
			/*画弧线*/
		case 5:
			canva.drawBitmap(bitmap,0,0,paint);
			RectF f = new RectF(prex,prey,tempx,tempy);
			canva.drawArc(f, 225, 90, false, paint);
			break;
		}
		
	}

}
