package com.shop.util;

import java.text.DecimalFormat;


public class NumberUtil {

	public static double format(double num){
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(num));
	}
}
