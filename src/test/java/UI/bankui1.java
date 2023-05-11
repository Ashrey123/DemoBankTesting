package UI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base1.bankbase1;

public class bankui1 extends bankbase1
{
@FindBy(xpath="//strong[text()='XYZ Bank']")
WebElement banklogo;

@FindBy(xpath="//button[normalize-space()='Customer Login']")
WebElement cuslogin;

@FindBy(xpath="//select[@id='userSelect']")
WebElement user;

@FindBy(xpath="//button[@type='submit']")
WebElement submit;

@FindBy(xpath="//button[normalize-space()='Transactions']")
WebElement transact;

@FindBy(xpath="//button[normalize-space()='Back']")
WebElement transback;

@FindBy(xpath="//button[normalize-space()='Deposit']")
WebElement deposit;

@FindBy(xpath="//input[@placeholder='amount']")
WebElement amount;

@FindBy(xpath="//button[@type='submit']")
WebElement conf;

@FindBy(xpath="//button[@ng-click='withdrawl()']")
WebElement withd;

@FindBy(xpath="//input[@placeholder='amount']")
WebElement withdamount;

@FindBy(xpath="//button[@type='submit']")
WebElement withconf;

@FindBy(xpath="//button[@class='btn home']")
WebElement home;

@FindBy(xpath="//button[normalize-space()='Bank Manager Login']")
WebElement manage;

@FindBy(xpath="//button[normalize-space()='Customers']")
WebElement custlist;

@FindBy(xpath="//button[normalize-space()='Open Account']")
WebElement open;

@FindBy(xpath="//button[@type='submit']")
WebElement confaccount;


public bankui1()
{
	PageFactory.initElements(driver, this);
}
public WebElement confirmAccountbt_ch()
{
	return confaccount;
}
public WebElement openbank_ch()
{
	return open;
}
public WebElement cust_list_ch()
{
	return custlist;
}
public WebElement bankmanage_ch()
{
	return manage;
}
public WebElement home_ch()
{
	return home;
}
public WebElement trans_back()
{
	return transback;
}
public WebElement withdrwar_conf()
{
	return withconf;
}
public WebElement withdrwar_amount()
{
	return withdamount;
}
public WebElement withdrwar()
{
	return withd;
}
public WebElement confirmamount()
{
	return conf;
}
public WebElement depositamount()
{
	return amount;
}
public WebElement transCheck()
{
	return transact;
}
public WebElement logoCheck()
{
	return banklogo;
}
public WebElement custmberbt()
{
	return cuslogin;
}
public WebElement userselect()
{
	return user;
}
public WebElement submit_ch()
{
	return submit;
}
public WebElement deposit_ch()
{
	return deposit;
}
	
	
	
	
}
