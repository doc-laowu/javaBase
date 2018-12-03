package com.neusoft.javaClass;

import java.io.UnsupportedEncodingException;

public class StringSplit {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String str = "我a爱中华abc我爱荣耀def";
//      String str = "我ABC汉";
		
      int num =trimGBK(str.getBytes("GBK"),5);
      
      System.out.println(str.substring(0,num));

	}

	public static int trimGBK(byte[] buf, int n) {
        
        int num = 0;
        
        boolean bChineseFirstHalf = false;

        for (int i = 0; i < n; i++) 
        {
            if (buf[i] < 0 && !bChineseFirstHalf)
            {
                bChineseFirstHalf = true;
            } 
            else 
            {
                num++;
                bChineseFirstHalf = false;
            }
        }
        return num;
    }

	
}
