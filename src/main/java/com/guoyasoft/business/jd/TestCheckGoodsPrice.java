package com.guoyasoft.business.jd;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guoyasoft.commons.browserEngins.BrowserEngine;
import com.guoyasoft.commons.snapshot.Snapshot;
import com.guoyasoft.pages.jd.GoodsDetailsPage;
import com.guoyasoft.pages.jd.HomePage;
import com.guoyasoft.pages.jd.SearchResultListPage;


public class TestCheckGoodsPrice {
	WebDriver driver;  
	BrowserEngine browserEngine;
    
    @BeforeClass  
    public void setUp() throws Exception{  
          
        browserEngine = new BrowserEngine();  
        driver = browserEngine.startChrome();  
    }  
    
    @Test  
    public void checkPrice() throws InterruptedException{  
    	/*
    	 * 第1步：打开京东
    	 */
    	driver.get("http://www.jd.com");
    	
    	/*
    	 * 第2步：输入iphone7，查询，截图
    	 */
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);  
        SearchResultListPage srlp=homepage.searchWithKeyword("iPhone7");  

        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("HHmmss");
        String dateStr=sf.format(date);
		Snapshot.snapshot((TakesScreenshot) driver, "open_jd"+dateStr+".png");

        /*
         * 第3步：获取第1个商品的价格，并点击商品图片连接，截图
         */
        Thread.sleep(1000);  
        String price1 = srlp.getGoodsPriceOnListPage(); // 获取列表页商品的价格  
        System.out.println(price1);  
        GoodsDetailsPage gdp=srlp.clickItemImg();  
		Snapshot.snapshot((TakesScreenshot) driver, "open_jd_detail"+dateStr+".png");

        /*
         * 第4步：获取商品详情界面的价格 
         */
        Thread.sleep(1000);  
        String price2 = gdp.getPriceOnDetailsPage(); //获取商品详情页价格  
        System.out.println(price2);  
          
        /*
         * 第5步：对比商品查询界面的价格和详情界面的价格
         */
        Assert.assertEquals(price2, price1);  
        
        /*
         * 第6步：添加到购物车，并截屏
         */
        gdp.addGoodToCart(); // 添加到购物车  

        Thread.sleep(3000);
		Snapshot.snapshot((TakesScreenshot) driver, "open_jd_cart"+dateStr+".png");

    }  

        //如果需要看清楚结果，把@AfterClass注销就好  
    @AfterClass  
    public void tearDown(){  
		browserEngine.closeChrome(driver);
    }  
  
}
