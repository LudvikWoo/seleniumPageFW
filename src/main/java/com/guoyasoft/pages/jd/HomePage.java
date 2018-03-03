package com.guoyasoft.pages.jd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guoyasoft.commons.basePages.BasePage;


public class HomePage extends BasePage{
    //搜索输入框  
    @FindBy (id="key")  
    WebElement search_inputBox; 
    
    //搜索提交按钮  
    @FindBy (xpath="//*[@id='search']/div/div[2]/button")  
    WebElement search_submitBtn;  
    
    
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
    /*  
     * 搜索框输入关键字，点击搜索  
     */  
    public SearchResultListPage searchWithKeyword(String keyword){  
        text(search_inputBox, keyword);  
        click(search_submitBtn);  
        return PageFactory.initElements(driver, SearchResultListPage.class);  
    }  

}
