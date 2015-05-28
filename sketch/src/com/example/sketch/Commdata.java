package com.example.sketch;

public  class Commdata {
	private  static int paintColor=3;
	private static int paintStroke;
	private  static int tool;
	private static int picture=0;
	public  static void setPaintColor(int color)
	{
		paintColor=color;
	}
	public  static void setPaintStroke(int stroke)
	{
		paintStroke=stroke;
	}
	public  static void setTool(int tool1)
	{
		tool=tool1;
	}
	public  static void setPicture(int picture1)
	{
		picture=picture1;
	}
	public   static int getPaintColor()
	{
		return paintColor;
	}
	public  static int getPaintStroke()
	{
		return paintStroke;
	}
	public  static int getTool()
	{
		return tool;
	}
	public  static int getPicture()
	{
		return picture;
	}

}
