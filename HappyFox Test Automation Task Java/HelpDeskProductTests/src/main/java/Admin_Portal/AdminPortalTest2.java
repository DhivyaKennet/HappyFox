package Admin_Portal;

import org.testng.Assert;
import org.testng.annotations.Test;

import CommonTests.CommonTests1;
import CustomerPortal.SupportPortalPage;

public class AdminPortalTest2 extends CommonTests1 {
  
  @Test
  public void Scenario2() {
	  
	  String Methodname = new Object(){}.getClass().getEnclosingMethod().getName(); 
		
		try {
			
			String Classname = getClass().getSimpleName();
            System.out.println("start of method : " + Classname);
            loginasAdmin();
            TestCase1();
            TestCase2();
            TestCase3();
              
		}
		
		catch(Throwable t) {
			 t.printStackTrace();
			 Assert.fail("Error in "+ Methodname +" : "+ t.getMessage());
		}
  }
}
