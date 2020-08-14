package com.xiaoshu.test;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.xiaoshu.entity.Major;

public class TestJson {
	@Test
	public void testOne(){
		String JsonString = "{\"id\":21,\"name\":\"X\"}";
		
	
		/*Stu stu = JSON.parseObject(JsonString,Stu.class);
		System.out.println(stu);*/
		
		
		Stu stu2 = new Stu("张三",1);
		String stu2Json = JSON.toJSONString(stu2);
		System.out.println(stu2Json);
		
		Stu stu2_bac = JSON.parseObject(stu2Json,Stu.class);
		System.out.println(stu2_bac);
		
		

		
		
	}	
}
