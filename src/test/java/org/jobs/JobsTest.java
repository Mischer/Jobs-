package org.jobs;

import org.jobs.ws.bean.UsersManagerBeanTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Ignore
@RunWith(Suite.class)
@Suite.SuiteClasses( { UsersManagerBeanTest.class })
public class JobsTest {

	private static ApplicationContext context = null;

	@BeforeClass
	public static void setUpClass() throws Exception {
		getContext();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public synchronized static ApplicationContext getContext() {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return context;
	}

}