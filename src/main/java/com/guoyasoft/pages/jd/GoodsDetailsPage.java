package com.guoyasoft.pages.jd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.guoyasoft.commons.basePages.BasePage;
	
	
public class GoodsDetailsPage extends BasePage {
	
	public GoodsDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*/span[@class='p-price']/span[2]")
	public WebElement goods_price;
	
    @FindBy(xpath="//*[@id='InitCartUrl']")  
    public WebElement addToCart_Btn; 
    
    /*  
     * 获取商品详情页的价格  
     */  
    public String getPriceOnDetailsPage(){  
    
        return goods_price.getText();  
    } 
    
    /* 
     * 点击添加购物车 
     */  
    public void addGoodToCart(){  
          
        click(addToCart_Btn);  
    }  

}
