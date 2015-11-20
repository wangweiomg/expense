package com.iss.expense.demo.chapter6;

import java.awt.Color;

/**
 *	
 * @author wangwei
 * @date 2015年8月30日  下午5:38:11
 * @version	v1.0
 */
public class ColorPoint{
	private final Point point;
	private final Color color;
	

	public ColorPoint(int x, int y, Color color) {
		if (color == null) {
			throw new NullPointerException();
		}
		point = new Point(x, y);
		this.color = color;
	}
	public Point asPoint(){
		return point;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ColorPoint)) {
			return false;
		}
		ColorPoint cp  = (ColorPoint) obj;
		return  cp.point.equals(point)&&cp.color.equals(color);
	}
}
