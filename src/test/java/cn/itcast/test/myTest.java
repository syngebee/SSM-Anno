package cn.itcast.test;

import cn.itcast.config.SpringConfig;
import cn.itcast.service.BuyGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfig.class)
public class myTest {

	@Autowired
	private BuyGoodsService buyGoodsService;

	@Test
	public void test01(){
		buyGoodsService.buy("1","10");
	}
}
