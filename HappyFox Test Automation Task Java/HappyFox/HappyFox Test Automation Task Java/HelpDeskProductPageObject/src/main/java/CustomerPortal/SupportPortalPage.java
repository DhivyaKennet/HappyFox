package CustomerPortal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Admin_Portal.AdminPortalTest2ndPage;
import Admin_Portal.Login_Page;
import webdriverbase.AppPage;


public class SupportPortalPage extends AppPage{
	
	public SupportPortalPage(WebDriver driver)
	{
		super(driver);
				
	}
	
	
	public void navigateToHappyFoxSupportPortalURL(String url) {
		this.driver.get(url);
	}
		
	@FindBy(id = "id_subject")  
	private WebElement Subject;
	
	public void enterSubject(String text)
 	{
		Subject.sendKeys(text);
 	}
	
	@FindBy(xpath = "//div[@class='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")  
	private WebElement Message;
	
	public void enterMessage(String text)
 	{
	    Message.sendKeys(text);
 	}
	
	@FindBy(id = "add-cc")  
	private WebElement AddCC;
	
	public void clickAddCC()
 	{
	    AddCC.click();
 	}
	
	@FindBy(id = "add-bcc")  
	private WebElement AddBCC;
	
	public void clickAddBCC()
 	{
	    AddBCC.click();
 	}
	
	@FindBy(xpath = "//input[@id='id_cc']")  
	private WebElement CC;
	
	public void enterCC(String text)
 	{
	    CC.sendKeys(text);
 	}
	
	@FindBy(xpath = "//input[@id='id_bcc']")  
	private WebElement BCC;
	
	public void enterBCC(String text)
 	{
	    BCC.sendKeys(text);
 	}
	
	
	
	@FindBy(xpath = "//a[@class='hf-attach-file_link']")  
	private WebElement BrowseFile;
	
	public void addingScreenshot(String abc)
 	{
	    BrowseFile.sendKeys(getTestDataFullDirPath(abc));
	    
 	}
	
	
	@FindBy(id = "id_name")  
	private WebElement FullName;
	
	public void enterFullName(String text) throws InterruptedException
 	{
		sleep();
	    FullName.sendKeys(text);
 	}
	
	@FindBy(id = "id_email")  
	private WebElement Email;
	
	public void enterEmail(String text) throws InterruptedException
 	{
		sleep();
	    Email.sendKeys(text);
 	}
	
	@FindBy(id = "id_phone")  
	private WebElement Phone;
	
	public void enterPhone(String text)
 	{
	    Phone.sendKeys(text);
 	}
	
	
	@FindBy(xpath = "//button[@id='submit']")  
	private WebElement CreateTicket;
		
	public AdminPortalTest2ndPage clickCreateTicket()
	 {
		   CreateTicket.click();
		   return new AdminPortalTest2ndPage(driver);
	 }
	
     public void sleep() throws InterruptedException {
    	 Thread.sleep(1000);
     }
     
     
     
	
	
}
