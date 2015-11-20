package com.iss.expense.demo.chapter6;

import java.util.HashSet;
import java.util.Set;

/**
 *	
 * @author wangwei
 * @date 2015年9月1日  下午2:28:12
 * @version	v1.0
 */
public class CircleUnit {
	private static final Set<Point> unitCircle;
	static{
		unitCircle = new HashSet<Point>();
		unitCircle.add(new Point(1, 0));
		unitCircle.add(new Point(0, 1));
		unitCircle.add(new Point(-1, 0));
		unitCircle.add(new Point(0, -1));
	}
	public static boolean onUnitCircle(Point p){
		return unitCircle.contains(p);
	}
}
