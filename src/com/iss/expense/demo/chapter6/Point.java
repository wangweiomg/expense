package com.iss.expense.demo.chapter6;

/**
 *	
 * @author wangwei
 * @date 2015年8月30日  下午5:35:27
 * @version	v1.0
 */
public class Point {
	private final int x;
	private final int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point p = (Point) obj;
		return p.x == x && p.y == y;
	}
}
