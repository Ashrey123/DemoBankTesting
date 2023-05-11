package TEST;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Action.bankaction;
import Base1.bankbase1;
import UI.bankui1;
public class banktest1 extends bankbase1
{
	bankui1 Callui;
	  bankaction callaction;
	  public ExtentTest test;
		public ExtentReports extent;
		  @BeforeClass
		  public void launch() throws IOException, InterruptedException
		  {
			  bankintilization();
			  callaction = new bankaction();
			  Callui= new bankui1();
		  }
		  @AfterClass
		  public void Bnd() throws InterruptedException
		  {
			  Thread.sleep(3000);
			  bankterminate();
		  }
		  @BeforeTest
			public void x() {
				extent=new ExtentReports("C:\\Users\\abhoil\\.jenkins\\workspace\\XYZ Bank\\Bank.html",true);	
			}
        @AfterTest
			public void y() {
				extent.endTest(test);
				extent.flush();
			}
			@Test(priority=1)
			public void logo_displaycheck()
			{
				test=extent.startTest("Verify that Bank logo is displayed or not");
				 test.log(LogStatus.INFO, "User is able to Navigated to BankHomepage");
				test.log(LogStatus.INFO,"Visibility of logo is checking");
				boolean actual= Callui.logoCheck().isDisplayed(); 
				if(actual==true)
				{
				test.log(LogStatus.PASS, "Bank logo is displayed");
			}
			else 
			{
				test.log(LogStatus.FAIL, "Bank Logo is not displayed");
			}
				 Assert.assertEquals(actual, true);
			}
			@Test(priority=2)
			public void Customerlogin() throws InterruptedException
			{
				test=extent.startTest("Verify the functionality of Customer login button");
				 test.log(LogStatus.INFO, "User is able to Navigated to BankHomepage");
				test.log(LogStatus.INFO,"user is navigated login page");
				callaction.custmberbutton();
				Thread.sleep(3000);
				String actual = driver.getCurrentUrl();
				String expected= "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
				if(actual.equals(expected))
				{
				test.log(LogStatus.PASS, "Customer login button is working");
			}
			else 
			{
				test.log(LogStatus.FAIL, "Customer login button is not working");
			}
				
			Assert.assertEquals(actual, expected);
			}
			@Test(priority=3,dependsOnMethods="Customerlogin")
			public void user_login_check() throws InterruptedException
			{
				test=extent.startTest("Verify user is able to login or not");
				 test.log(LogStatus.INFO, "User is able to Navigated to BankHomepage");
				test.log(LogStatus.INFO,"user is navigated login page");
				test.log(LogStatus.INFO,"user is selecting username page");
				callaction.user_login();
				Thread.sleep(2000);
				String actual = driver.getCurrentUrl();
				String expected= "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account";
				if(actual.equals(expected))
				{
				test.log(LogStatus.PASS, "Customer is able to login in succesfuly");
			}
			else 
			{
				test.log(LogStatus.FAIL, "Customer is not able to login in succesfuly");
			}
				Assert.assertEquals(actual, expected);
			}
			@Test(priority=6,dependsOnMethods="user_login_check")
			public void transaction_check() throws InterruptedException
			{
				test=extent.startTest("Verify user is able to navigate to transaction check page");
			   test.log(LogStatus.INFO, "User is able to Navigated to BankHomepage");
			   test.log(LogStatus.INFO,"user is navigated login page");
			 callaction.transaction();
				Thread.sleep(2000);
				String actual = driver.getCurrentUrl();
				String expected= "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account";
				if(actual.equals(expected))
				{
				test.log(LogStatus.PASS, "Customer is able to navigated to transaction page");
			}
			else 
			{
				test.log(LogStatus.FAIL, "Customer is not able to navigated to transaction page");
			}
				Assert.assertEquals(actual, expected);
			}
			@Test(priority=4,dependsOnMethods="user_login_check")
			public void deposit_ch() throws InterruptedException
			{
				test=extent.startTest("Verify user is able to deposit the amount or not");
				   test.log(LogStatus.INFO, "User is able to Navigated to BankHomepage");
				   test.log(LogStatus.INFO,"user is depositing the amount");
				  callaction.deposi_ch();
				  Thread.sleep(2000);
				  WebElement w2= driver.findElement(By.xpath("//span[@class='error ng-binding']"));
				  
				boolean actual = w2.isDisplayed();
				
				if(actual==true)
				{
				test.log(LogStatus.PASS, "Customer is able to deposit the amount successfully");
			}
			else 
			{
				test.log(LogStatus.FAIL, "Customer is not able to deposit the amount successfully");
			}
				Assert.assertEquals(actual, true);
			}
			@Test(priority=5,dependsOnMethods="deposit_ch")
			public void withdrwal_ch() throws InterruptedException
			{
				test=extent.startTest("Verify user is able to withdrawal the amount or not");
				   test.log(LogStatus.INFO, "User is able to Navigated to Bank Homepage");
				   test.log(LogStatus.INFO,"user is withdrwaing the amount");
				  callaction.withdraw_ch();
				  Thread.sleep(2000);
				  WebElement w2= driver.findElement(By.xpath("//span[text()='Transaction successful']"));
				  
				boolean actual = w2.isDisplayed();
				
				if(actual==true)
				{
				test.log(LogStatus.PASS, "Customer is able to withdrwal the amount successfully");
			}
			else 
			{
				test.log(LogStatus.FAIL, "Customer is not able to withdrwal the amount successfully");
			}
				Assert.assertEquals(actual, true);
			}
			@Test(priority=7,dependsOnMethods="transaction_check")
			public void home_check_button() throws InterruptedException
			{
				
				test=extent.startTest("Verify user is able to navigate back homepage");
				   test.log(LogStatus.INFO, "clicking on home button");
				   test.log(LogStatus.INFO,"Homepage elements are displayed");
				   callaction.home();
					Thread.sleep(2000);
					String actual = driver.getCurrentUrl();
					String expected= "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
					if(actual.equals(expected))
					{
					test.log(LogStatus.PASS, "Customer is able to navigate back to Home page");
				}
				else 
				{
					test.log(LogStatus.FAIL, "Customer is not able to navigate back to home page");
				}
					Assert.assertEquals(actual, expected);
				}
			@Test(priority=8)
			public void bankmanagercheck() throws InterruptedException
			{
				
				test=extent.startTest("Verify user is able to navigate to bank manager page");
				   test.log(LogStatus.INFO, "clicking on manager button");
				   test.log(LogStatus.INFO,"Bank manager elements are displayed");
				   callaction.mangerbutton();
					Thread.sleep(2000);
					String actual = driver.getCurrentUrl();
					String expected= "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
					if(actual.equals(expected))
					{
					test.log(LogStatus.PASS, "user is able to navigate to Bank manager page");
				}
				else 
				{
					test.log(LogStatus.FAIL, "user is not able to navigate to bank manager page");
				}
					Assert.assertEquals(actual, expected);
			}
			
			@Test(priority=10,dependsOnMethods="bankmanagercheck")
			public void BankCustomerList_Check() throws InterruptedException
			{
				
				test=extent.startTest("Verify user is able to Check Bank Customer list");
				   test.log(LogStatus.INFO, "clicking on Customer button");
				   test.log(LogStatus.INFO,"Customer list is displaying");
				   callaction.Customerlist();
					Thread.sleep(2000);
					String actual = driver.getCurrentUrl();
					String expected= "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";
					if(actual.equals(expected))
					{
					test.log(LogStatus.PASS, "User is able to see custmober list");
				}
				else 
				{
					test.log(LogStatus.FAIL, "User is Not able to see Customer list");
				}
					Assert.assertEquals(actual, expected);
			}
			@Test(priority=9,dependsOnMethods="bankmanagercheck")
			public void OpenBankAccount() throws InterruptedException
			{
				
				test=extent.startTest("Verify user is able to Open Bank Account or not");
				   test.log(LogStatus.INFO, "clicking on open bank account button");
				   test.log(LogStatus.INFO,"Filling the account details");
				   callaction.open_bank_account();
					Thread.sleep(2000);
					String actual = driver.getCurrentUrl();
					String expected= "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/openAccount";
					if(actual.equals(expected))
					{
					test.log(LogStatus.PASS, "User is able to Open a Bank Account");
				}
				else 
				{
					test.log(LogStatus.FAIL, "User is not able to Open a Bank Account");
				}
					Assert.assertEquals(actual, expected);
			}
				
				
			}


