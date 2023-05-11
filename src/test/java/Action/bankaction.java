package Action;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Base1.bankbase1;
import UI.bankui1;

public class bankaction extends bankbase1
{
  bankui1 callui= new bankui1();

  public void custmberbutton()
{
	callui.custmberbt().click();
}
public void user_login()
{
	Select z= new Select(callui.userselect());
	z.selectByVisibleText("Harry Potter");
	callui.submit_ch().click();
}
public void transaction() throws InterruptedException
{
	callui.transCheck().click();
	Thread.sleep(2000);
	callui.trans_back().click();
}
public void deposi_ch()
{
	
	callui.deposit_ch().click();
	callui.depositamount().sendKeys(prop.getProperty("amount"));
	callui.confirmamount().click();
}
public void withdraw_ch() throws InterruptedException
{
	callui.withdrwar().click();
	Thread.sleep(2000);
	callui.withdrwar_amount().sendKeys(prop.getProperty("withamount"));
	callui.withdrwar_conf().click();
}
public void home() 
{
	callui.home_ch().click();
}
public void mangerbutton()
{
	callui.bankmanage_ch().click();
}
public void Customerlist()
{
	callui.cust_list_ch().click();
}
public void open_bank_account() throws InterruptedException
{
	callui.openbank_ch().click();
	Select custm= new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
	custm.selectByVisibleText("Hermoine Granger");
	Select currency= new Select(driver.findElement(By.xpath("//select[@id='currency']")));
	currency.selectByVisibleText("Rupee");
	callui.confirmAccountbt_ch().click();
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
}


}
