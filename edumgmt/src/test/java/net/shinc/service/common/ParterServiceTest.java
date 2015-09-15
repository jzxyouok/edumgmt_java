package net.shinc.service.common;

import java.util.List;

import net.shinc.InfoMgmtApplication;
import net.shinc.orm.mybatis.bean.edu.Parter;
import net.shinc.service.edu.business.ParterService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InfoMgmtApplication.class)
@WebAppConfiguration
public class ParterServiceTest {

	@Autowired
	private ParterService parterService;
	
	@Test
	public void add(){
		Parter parter = new Parter();
		parter.setName("111");
		Integer asdfa= parterService.addParter(parter);
		System.out.println(asdfa);
		
	} 
	
	@Test
	public void getList(){
		Parter parter = new Parter();
		parter.setName("111");
		List list = parterService.getParterList(null);
		Gson g = new Gson();
		System.out.println(g.toJson(list));
		
	}
	
	@Test
	public void getById(){
		Gson g = new Gson();
		System.out.println(g.toJson(parterService.getParterById(1)));
		
	}
	
	@Test
	public void update(){
		Parter parter = new Parter();
		parter.setName("222");
		parter.setId(4);
		Gson g = new Gson();
		System.out.println(g.toJson(parterService.updateParter(parter)));
		
	}
	
	@Test
	public void delete(){
		Gson g = new Gson();
		System.out.println(g.toJson(parterService.deleteParterById(4)));
		
	}
	
	
	
}
