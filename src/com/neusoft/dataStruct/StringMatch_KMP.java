package com.neusoft.dataStruct;

public class StringMatch_KMP {
	public static void main(String[] args) {
		
		String pattern = "ABABCABAA";
		String content = "ABABABCABAABABABABABABCABAA";
		StringMatch_KMP ptr = new StringMatch_KMP();
		ptr.KMP(content, pattern);
	}
	
	public void prefix_table(String pattern, int[] prefix)
	{
		prefix[0] = 0;
		int len = 0;
		int i = 1;
		int n = pattern.length();
		
		while(i < n)
		{
			if(pattern.charAt(i) == pattern.charAt(len))
			{
				prefix[i] = ++len;
				i++;
			}
			else
			{
				if(len > 0)
				{
					len = prefix[len - 1];
				}
				else
				{
					prefix[i++] = len;
				}
			}
		}
		//将公共前后缀表往后移动一个
		move_prefix_table(prefix);
	}
	
	public void move_prefix_table(int[] prefix)
	{
		for(int i=prefix.length-1; i>0; i--)
		{
			prefix[i] = prefix[i-1];
		}
		prefix[0] = -1;
	}
	
	public boolean KMP(String content, String pattern)
	{
		int[] prefix = new int[pattern.length()];
		prefix_table(pattern, prefix);
		
		int i = 0, j = 0;
		int m = content.length(), n = pattern.length();
		
		while(i < m)
		{
			if(j == n-1 && content.charAt(i) == pattern.charAt(j))
			{
				System.out.println("Found pattern at: "+(i-j)+"\n");
				j = prefix[j];
			}
			
			if(content.charAt(i) == pattern.charAt(j))
			{
				i++;
				j++;
			}
			else
			{
				j = prefix[j];
				if(j == -1)
				{
					j++;
					i++;
				}
			}
		}
		
		return false;
	}
}
