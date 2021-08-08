package com.yeon.ho.config;

import java.sql.Connection;

import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DatabaseTest {
	
	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private DataSource ds;

	
	@Test // DB 테스트
	public void testDs() {
		log.info(ds);
		try(Connection con = ds.getConnection()) {
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCtx() {
		log.info(ctx);
	}
	
}