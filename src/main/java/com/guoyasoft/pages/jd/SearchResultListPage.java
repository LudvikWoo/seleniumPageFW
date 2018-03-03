package com.guoyasoft.pages.jd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guoyasoft.commons.basePages.BasePage;

public class SearchResultListPage extends BasePage{

	public SearchResultListPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * 定位元素
	 */
    //第一页第一个商品  
    @FindBy (xpath="//*[@id='J_goodsList']/ul/li[1]/div/div[1]/a/img")  
    WebElement searchResult_firstItem_img;  
    
    //第一页第2个商品,为了和第一个对比  
    @FindBy (xpath="//*[@id='J_goodsList']/ul/li[2]/div/div[1]/a/img")  
    WebElement searchResult_secondItem_img;  
    
    //第一个商品的价格  
    @FindBy (xpath="//*[@id='J_goodsList']/ul/li[1]/div/div[3]/strong/i")
    WebElement searchResult_firstItem_price;  

    /*  
     * 点击商品图片，进入商品详情页  
     */  
    public GoodsDetailsPage clickItemImg() throws InterruptedException{  
          
        click(searchResult_firstItem_img);  
        Thread.sleep(1000);  
        switchToNextWindow();
        return PageFactory.initElements(driver,GoodsDetailsPage.class);  
    }  
    
    /* 
     * 获取商品价格，好和详情页价格对比 
     */  
    public String getGoodsPriceOnListPage(){  
          
        return searchResult_firstItem_price.getText();  
          
    }  
}
