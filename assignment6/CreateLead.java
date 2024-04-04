package assignment6;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {
	@DataProvider(name="fetchdata")
	public String[][] SendData() {
		String [] []data = new String[3][4];
	
	
	data[0][0]="TestLeaf";
	data[0][1] = "Anurekha";
	data[0][2]="B";
	data[0][3]="91";
	
	data[1][0]="TestLeaf";
	data[1][1]="Subraja";
	data[1][2]="S";
	data[1][3]="92";
	
	
	data[2][0]="TestLeaf";
	data[2][1]="Deepika";
	data[2][2]="s";
	data[2][3]="93";
	
	
	return data;
	}
	
	@Test(dataProvider="fetchdata")	
	
public void runCreateLead(String cname,String fname,String lname,String phno) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cname)) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
		driver.close();
}
	


	}

