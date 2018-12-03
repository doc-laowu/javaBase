package com.neusoft.javaClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class practice_03 {
	public static void main(String[] args) {
		new practice_03().DivideTeam();
	}
	
	public void displayScore()
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		
		Random rand = new Random();
		
		for(int i=20180301; i<=20180330; i++)
		{
			map.put(i+"", rand.nextInt(60)+40);
		}
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet);
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
		{

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
			
		});
		
		Iterator<Map.Entry<String, Integer>> iter = list.iterator();    //获取List集合的迭代器,String为迭代元素的类型
		while(iter.hasNext()){
			Map.Entry<String, Integer> item = iter.next();
			String key = item.getKey();
			Integer value = item.getValue();
			System.out.println(key+":"+value);

		}

	}
	
	public void HashsetTest()
	{
		Set<Integer> sets1 = new HashSet<Integer>();
		Set<Integer> sets2 = new HashSet<Integer>();
		
		Random rand = new Random();
		
		for(int i=0; i<20; i++)
		{
			sets1.add(rand.nextInt(100));
			sets2.add(rand.nextInt(100));
		}
			
		//求并集
		Set<Integer> sets3 = new HashSet<Integer>();
		sets3.addAll(sets1);
		sets3.addAll(sets2);
		for(Integer o : sets3)
			System.out.print(o+" ");
		
		//求差集
		sets3.clear();
		sets3.addAll(sets1);
		sets3.removeAll(sets2);
		for(Integer o : sets3)
			System.out.print(o+" ");
		
		//求交集
		sets3.clear();
		sets3.addAll(sets1);
		sets3.retainAll(sets2);
		for(Integer o : sets3)
			System.out.print(o+" ");
	}
	
	public void StuScoreMan()
	{
		//存放学生信息类
		//List<Student> students = null;
		Map<String, Student> students =new HashMap<String, Student>();
		
		Student stu1 = new Student("123456", "张三", 10);
		Student stu2 = new Student("123457", "张四", 11);
		
		//students = Arrays.asList(stu1, stu2);
		students.put("123456", stu1);
		students.put("123457", stu2);
		
		
		
		//存放课程类
		//List<Course> courses = null;
		Map<String, Course> courses = new HashMap<String, Course>();
		
		Course cou1 = new Course("语文","001");
		Course cou2 = new Course("数学", "002");
		
		//courses = Arrays.asList(cou1, cou2);
		courses.put("001", cou1);
		courses.put("002", cou2);
		
		//存放学生成绩类
		List<Score> scores = null;
		
		Score sco1 = new Score("123456", "001", 70, "平时成绩");
		Score sco2 = new Score("123456", "002", 75, "平时成绩");
		
		Score sco3 = new Score("123457", "001", 60, "平时成绩");
		Score sco4 = new Score("123457", "002", 65, "平时成绩");
		
		Score sco7 = new Score("123456", "001", 70, "期中考试成绩");
		Score sco8 = new Score("123456", "002", 75, "期中考试成绩");
	
		Score sco9 = new Score("123457", "001", 60, "期中考试成绩");
		Score sco10 = new Score("123457", "002", 65, "期中考试成绩");
		
		Score sco11 = new Score("123456", "001", 60, "实习成绩");
		Score sco12 = new Score("123456", "002", 65, "实习成绩");
		
		Score sco13 = new Score("123457", "001", 60, "实习成绩");
		Score sco14 = new Score("123457", "002", 65, "实习成绩");
		
		Score sco15 = new Score("123456", "001", 60, "期末考试成绩");
		Score sco16 = new Score("123456", "002", 65, "期末考试成绩");
	
		Score sco17 = new Score("123457", "001", 60, "期末考试成绩");
		Score sco18 = new Score("123457", "002", 65, "期末考试成绩");
		
		Score sco19 = new Score("123456", "001", 60, "总评成绩");
		Score sco20 = new Score("123456", "002", 65, "总评成绩");
		
		Score sco21 = new Score("123457", "001", 60, "总评成绩");
		Score sco22 = new Score("123457", "002", 65, "总评成绩");
		
		scores = Arrays.asList(sco1, sco2, sco3, sco4, sco7, sco8, sco9, sco10,
				sco11, sco12, sco13, sco14, sco15, sco16, sco17, sco18,sco19,
				sco20, sco21, sco22);
		
		//列出张山的所有成绩
		System.out.println("张山的课程成绩为:");
		
		
		//列出语文课程的所有学生的成绩
		System.out.println("语文的成绩为:");
		for(Score sc : scores)
		{
			if( "语文".compareTo(
					courses.get(sc.getCourseNo()).getCourseName()) == 0)
			{
				System.out.println(students.get(sc.getStuNo()).getName()+":"
						+sc.getType()+":"+sc.getScoNum());
			}
		}
		
		//列出所有学生总评成绩的总评分
		System.out.println("总评成绩为:");
		for(Score sc : scores)
		{
			if("总评成绩".compareTo(sc.getType()) == 0)
			{
				System.out.println(students.get(sc.getStuNo()).getName()+":"
						+sc.getScoNum()+":"+sc.getType());
			}
		}
		
		//60 分以下的学生人数
		System.out.println("60 分以下的学生人数:");
		int count1 = 0;
		int count2 = 0;
		for(Score sc : scores)
		{
			if("总评成绩".compareTo(sc.getType()) == 0 && 
					"语文".compareTo(courses.get(sc.getCourseNo()).getCourseName()) == 0
					&& sc.getScoNum() < 60)
			{
				count1++;
			}
			
			if("总评成绩".compareTo(sc.getType()) == 0 && 
					"语文".compareTo(courses.get(sc.getCourseNo()).getCourseName()) == 0
					&& sc.getScoNum() >= 60 && sc.getScoNum() <= 70)
			{
				count2++;
			}
			
		}
		System.out.println(count1);
		System.out.println(count2);
		

	}
	
	
	public void DivideTeam()
	{
		List<String> teams = null;
		teams = Arrays.asList("科特迪瓦","阿根廷","澳大利亚","塞尔维亚","荷兰","尼日利亚","日本"
				,"美国","中国","新西 兰","巴西",
				"比利时","韩国","喀麦隆","洪都拉斯","意大利");
		
		List<String> teams2 = new ArrayList<String>();
		
		
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		randomCommon1(16, 16, set);
		
		for(int o : set)
		{
			teams2.add(teams.get(o));
		}
		
		for(int i=0 ;i<teams2.size(); i++)
		{
			if((i+1)%4 != 0)
			{
				System.out.print(teams2.get(i)+" ");
			}
			else
			{
				System.out.println("");
			}
		}
		
	}
	
	public void randomCommon1(int max, int n, LinkedHashSet<Integer> set)
	{
		while(true)
		{
			if(set.size() < n)
			{
				int ran = (int)(max*Math.random());
				set.add(ran);
			}
			else
				break;
			
		}
	}
	
	public void randomCommon(int max, int n, int[] result)
	{  
		for(int i = 0 ; i < n ; i++)
		{
			while(true)
			{
				int ran = (int)(max*Math.random());
				for(int j = 0 ; j < i ; j++)
				{
					if(result[j] == ran) 
					{
						ran = -1;
						break;
					} 
				}
				if(ran != -1) 
				{
					result[i] = ran;
					break;
				}
			}
		}
	}
	 
	//计算所有学生的平均年龄
//	public void getAvgAge()
//	{
//		List<Student> list = new ArrayList<Student>();
//		
//		list.add(new Student("Tom", 18, 100, "class05"));  
//
//		list.add(new Student("Jerry", 22, 70, "class04")); 
//
//		list.add(new Student("Owen", 25, 90, "class05")); 
//
//		list.add(new Student("Jim", 30,80 , "class05")); 
//
//		list.add(new Student("Steve", 28, 66, "class06"));
//
//		list.add(new Student("Kevin", 24, 100, "class04"));
//		
//		//计算所有学生的平均年龄
//		int sum = 0;
//		for(Student o : list )
//		{
//			sum += o.getAge();
//		}
//		
//		System.out.println("平局年龄为:"+(double)sum/list.size());
//		
//		
//		//计算各个班级的平均分 
//		Map<String, Integer> map1 = new HashMap<String, Integer>();
//		Map<String, Integer> map2 = new HashMap<String, Integer>();
//		
//		for(Student o : list )
//		{
//			if(map1.containsKey(o.getClassNum()))
//			{
//				map2.put(o.getClassNum(), map2.get(o.getClassNum())+o.getScore());
//				map2.put(o.getClassNum(), map2.get(o.getClassNum())+1);
//			}
//			else
//			{
//				map2.put(o.getClassNum(), 1);
//			}
//		}
//		
//		Set<String> set1 = map1.keySet();
//		for(String key : set1)
//		{
//			System.out.println(key+":"+map1.get(key)/map2.get(key));
//		}
//	}
	
	public void WorldCup()
	{
		Map<String, List<String>> maps = new HashMap<String, List<String>>();
		
		maps.put("乌拉圭", Arrays.asList("1930", "1950"));
		maps.put("意大利", Arrays.asList("1934", "1938", "1982", "2006"));
		maps.put("西德", Arrays.asList("1954", "1974", "1990"));
		maps.put("巴西", Arrays.asList("1958", "1962", "1970", "1994", "2002"));
		maps.put("英格兰", Arrays.asList("1966"));
		maps.put("阿根廷", Arrays.asList("1978", "1986"));
		maps.put("法国", Arrays.asList("1998"));
		maps.put("西班牙", Arrays.asList("2010"));
		maps.put("德国", Arrays.asList("2014"));
		
		
		String str = "巴西";
		Set<Entry<String, List<String>>>  sets = maps.entrySet();
		boolean flag = false;
		for(Entry<String, List<String>> o : sets)
		{
			if(str.compareTo(o.getKey()) == 0)
			{
				for(String o1 : o.getValue())
				{
					System.out.println(o1);
				}
			}
		}
		
		if(!flag)
			System.out.println("没有获得过世界杯");
		
	}
	
}


class Student
{
	private String stuNo;
	private String Name;
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	public Student(String StuNo, String Name, int age)
	{
		this.setStuNo(StuNo);
		this.setAge(age);
		this.setName(Name);
	}
	
}

class Course
{
	private String CourseName;
	private String CourseNo;

	public String getCourseNo() {
		return CourseNo;
	}

	public void setCourseNo(String courseNo) {
		CourseNo = courseNo;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	public Course(String CourseName, String CourseNo)
	{
		this.setCourseName(CourseName);
		this.setCourseNo(CourseNo);
	}
}

class Score
{	
	private String stuNo;
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	private String CourseNo;
	private int scoNum;
	private String type;
	public String getCourseNo() {
		return CourseNo;
	}
	public void setCourseNo(String courseNo) {
		CourseNo = courseNo;
	}
	public int getScoNum() {
		return scoNum;
	}
	public void setScoNum(int scoNum) {
		this.scoNum = scoNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Score(String stuNo, String CourseNo, int scoNum, String type)
	{
		this.setStuNo(stuNo);
		this.setCourseNo(CourseNo);
		this.setScoNum(scoNum);
		this.setType(type);
	}
}

//class Student
//{
//	private String name;  
//
//    public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public int getScore() {
//		return score;
//	}
//
//	public void setScore(int score) {
//		this.score = score;
//	}
//
//	public String getClassNum() {
//		return classNum;
//	}
//
//	public void setClassNum(String classNum) {
//		this.classNum = classNum;
//	}
//
//	private int age;  
//
//    private int score;  
//
//    private String classNum;
//    
//    public Student(String name, int age, int score, String classNum)
//    {
//    	this.setName(name);
//    	this.setAge(age);
//    	this.setScore(score);
//    	this.setClassNum(classNum);
//    }
//}














