package CommonTests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Admin_Portal.AdminPortalTest1;
import Admin_Portal.AdminPortalTest1stPage;
import Admin_Portal.AdminPortalTest2ndPage;
import Admin_Portal.Login_Page;
import CustomerPortal.SupportPortalPage;
import webdriverbase.BaseTest;

public class CommonTests1 extends BaseTest{
	
public Login_Page hploginpage;
public SupportPortalPage hpSupportPortalPage;
public AdminPortalTest1stPage hpAdminPortalTest1;
public AdminPortalTest2ndPage hpAdminPortalTest2;
	
public String AdminPortalURL = "https://interview.supporthive.com/staff";
public static String SupportTicketURL = "https://interview.supporthive.com/new/";
public static String browser = "Chrome";
public static String username = "interview_agent";
public static String password = "Interview@123";
public static String statusName = "Issue created";
public static String priorityName = "Assistance required";
public static String Subject = "Test Ticket raised by XYZ";
public static String Message = "Hi, i am having certain issues in the Happy fox portal. Can you please help me.";
public static String FullName = "Reese Harrold";
public static String Email = "testno100@gmail.com";

public void loginasAdmin() {
    
    String Methodname = new Object(){}.getClass().getEnclosingMethod().getName(); 
	System.out.println("Start of LoginAsAdmin "+"MethodName : "+Methodname); 

	try
	{	
		hploginpage = new Login_Page(getDriver());
		hploginpage.navigateToHappyFoxHomePageURL(AdminPortalURL);
		hploginpage.enterUsername(username);
		System.out.println("username entered");
		hploginpage.enterPassword(password);
		System.out.println("password entered");
		hploginpage.clickLoginbutton();
		System.out.println("login clicked");
		hpAdminPortalTest1=hploginpage.validatePendingTicketsTitle();
		
		
	}
 
	catch(Throwable t)
	{
		t.printStackTrace();
		Assert.fail("Error in " + Methodname + " : " + t.getMessage());
	}
	
	
}
  
  public void CreatingSupportTicket() {
	  
	  String Methodname = new Object(){}.getClass().getEnclosingMethod().getName(); 
	  System.out.println("Start of Client support ticket "+"MethodName : "+Methodname); 
	  
	  try 
	  {
		    
		  hpSupportPortalPage = new SupportPortalPage(getDriver());
		  hpSupportPortalPage.navigateToHappyFoxSupportPortalURL(SupportTicketURL);
		  hpSupportPortalPage.enterSubject(Subject);
		  hpSupportPortalPage.enterMessage(Message);
		  hpSupportPortalPage.clickAddCC();
		  hpSupportPortalPage.clickAddBCC(); 
		  hpSupportPortalPage.enterFullName(FullName);
		  hpSupportPortalPage.enterEmail(Email);
		  hpAdminPortalTest2=hpSupportPortalPage.clickCreateTicket();
		  System.out.println("Ticket created");
		  hpAdminPortalTest2.gotoAgentPortal();
	  
	  }
	  
	  catch (Throwable t) {
		  
		    t.printStackTrace();
			Assert.fail("Error in " + Methodname + " : " + t.getMessage());
	  }
  }
  
  public void TestCase1() {
		
		try {
			
			String Classname = getClass().getSimpleName();
          System.out.println("start of method : " + Classname);
          hpAdminPortalTest1=hploginpage.validatePendingTicketsTitle();
          hpAdminPortalTest1.clickStatus();
          hpAdminPortalTest1.clickNewStatus();
          System.out.println("New Status process started");
          hpAdminPortalTest1.enterStatusName(statusName);
          System.out.println("status name entered");
          //hpAdminPortalTest1.enterStatusColour("#21d0d5"); //#21d0d5 skyblue, #21d567 green
          System.out.println("colour set");
          hpAdminPortalTest1.enterBehavior("Pending");
          hpAdminPortalTest1.enterStatusDescription("Status when a new issue ticket is created in HappyFox");
          System.out.println("description added");
          hpAdminPortalTest1.clickAddStatus();
          System.out.println("Status added");
          hpAdminPortalTest1.setDefaultStatus(statusName); 
          hpAdminPortalTest1.clickPrioritySection();
          hpAdminPortalTest1.clickNewPriority();
          System.out.println("New priority process started");
          hpAdminPortalTest1.enterPriorityName(priorityName);
          hpAdminPortalTest1.enterPriorityDescription("Priority of the newly created tickets");
          hpAdminPortalTest1.enterPriorityHelpText("priority helptext");
          hpAdminPortalTest1.clickAddPriority();
          hpAdminPortalTest1.setDefaultPriroity(priorityName);
          System.out.println("Priority added");    
				
		} 
		
		catch (Throwable e) {
			e.printStackTrace();
		}
		
	
} 
  
  public void TestCase2() {
		
		try {
			
			String Classname = getClass().getSimpleName();
          System.out.println("start of method : " + Classname);
          CreatingSupportTicket();
          hploginpage.validatePendingTicketsTitle1();
          hpAdminPortalTest2.clickPendingTickets();
          System.out.println("Pending tickets clicked");
          hpAdminPortalTest2.openCustomerTicket(Subject);
          
          //Assertion of the Priority and Status of the ticket created 
          Assert.assertEquals(hpAdminPortalTest2.getContactName(),"Aravind"); 
          Assert.assertEquals(hpAdminPortalTest2.getEmailtxt(),Email);
          
          hpAdminPortalTest2.clickReplyButton();
          Assert.assertEquals(hpAdminPortalTest2.getStatustxt(),statusName);
          Assert.assertEquals(hpAdminPortalTest2.getPrioritytxt(),priorityName.toUpperCase());
          
          hpAdminPortalTest2.clickCannedAction();
          hpAdminPortalTest2.clickSearchCannedAction("Reply to Customer Query");
          hpAdminPortalTest2.clickApplyCannedAction();
          
          //Assertion of the Priority and Status of the ticket after edition
          Assert.assertEquals(hpAdminPortalTest2.getStatustxt(),"Closed");
          Assert.assertEquals(hpAdminPortalTest2.getPrioritytxt(),"Medium");
          hpAdminPortalTest2.sendReply(); 
          hpAdminPortalTest1=hpAdminPortalTest2.closeTheTicket();
          hpAdminPortalTest1.clickPriorities();
          System.out.println("Test Case 2 over");
          
		}
		
		catch(Throwable t) {
			 t.printStackTrace();
		}
}
  
  public void TestCase3() {
		
		try {
			
			String Classname = getClass().getSimpleName();
			hpAdminPortalTest1.setDefaultPriroity("Low");
			System.out.println("Default priority set as Low");
			hpAdminPortalTest1.ClickAddedPriority(priorityName);
			System.out.println("Priority clicked");
			hpAdminPortalTest1.clickPriorityDeleteLink();
			hpAdminPortalTest1.clickDeleteConfirm();
			System.out.println("Priority deleted");  
			hpAdminPortalTest1.clickStatusesSection();
			hpAdminPortalTest1.setDefaultStatus("New");
			System.out.println("Default status set as New");
			hpAdminPortalTest1.ClickAddedStatus(statusName);
			System.out.println("Statuses clicked");
			hpAdminPortalTest1.clickStatusDeleteLink();
			//hpAdminPortalTest1.setNewDefaultStatus();
			hpAdminPortalTest1.clickDeleteConfirm();
			System.out.println("Statuses deleted");  
			hpAdminPortalTest1.clickProfile();
            hpAdminPortalTest1.clickLogout();
            System.out.println("Logged out successfully"); 
			
				
		} 
		
		catch (Throwable e) {
			e.printStackTrace();
		}
		
	
} 
}
