package com.iss.expense.demo.test;

import java.util.Arrays;



/**
 * 找出数组中第k大的数
 * @author wangwei
 * @date 2015年9月7日  下午2:55:39
 * @version	v1.0
 */
public class SortTest {
	private static int[] a = {1,4,5,6,9,2};
	private static int k = 4;
	public static void main(String[] args) {
		// 冒泡法
		System.out.println(waterBall());
		// 
	
	}
	
	public static void selectArray(){
		int[] b = Arrays.copyOfRange(a, 0, k-1);
		for (int i = 0; i < b.length-1; i++) {
			for (int j = 0; j < b.length-1-i; j++) {
				if (b[j] < b[j+1]) {
					swap(b, j, j+1);
				}
			}
		}
		for(int i = k; i < a.length; i++){
			if (a[i]<=b[k-1]){
				continue;
			}else{
				for (int j = 0; j < b.length; j++) {
					// 把a[j]插入b[]合适位置
				}
			}
		}
	}
	

	/**
	 * 冒泡法
	 * @return 第k大元素
	 */
	public static int waterBall(){
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-1-i; j++) {
				if (a[j] < a[j+1]) {
					swap(a, j, j+1);
				}
			}
		}
		return a[k-1];
	}
	/**
	 * @param a
	 * @param j
	 * @param i
	 */
	private static void swap(int[] a, int j, int i) {
		// TODO Auto-generated method stub
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}
}
