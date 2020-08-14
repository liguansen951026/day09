package com.xiaoshu.listener;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoshu.entity.Major;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class ItemcatListener implements MessageListener {
	
	@Autowired 
	private JedisPool jedisPool;

	@Override
	public void onMessage(Message massage) {
		// TODO Auto-generated method stub
		
		TextMessage om = (TextMessage)massage;
		
		
		String maj;
		try {
			maj = om.getText();

			/*Major major = JSON.parseObject(maj,Major.class);*/
			
			JSONObject parseObject = JSON.parseObject(maj);
			String mdname = parseObject.getString("mdname");
			Integer mdid = parseObject.getInteger("mdid");
			Jedis jedis = jedisPool.getResource();
			jedis.set(mdname, mdid.toString());

		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
