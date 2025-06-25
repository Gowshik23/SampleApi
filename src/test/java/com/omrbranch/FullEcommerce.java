package com.omrbranch;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.cancelorder.CancelOrder_Input_Pojo;
import com.omrbranch.pojo.getallorder.GetALlOrder;
import com.omrbranch.pojo.getallorder.GetAllOrder_Output_Pojo;
import com.omrbranch.pojo.login.PostmanBasicAuthLogin_Output_Pojo;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import org.openqa.selenium.interactions.Actions;

public class FullEcommerce extends BaseClass{
	String orderNo;
	String logtoken;
	String OrderId;
	@Test(priority = 1)
	public void createOrderNo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.omrbranch.com/");

		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement textEmail = driver.findElement(By.xpath("//input[@id='email']"));
		if (textEmail.isEnabled()) {
			textEmail.sendKeys("gowshik927@gmail.com");
		} else {
			System.out.println("Email box not editable");
		}

		WebElement textPassword = driver.findElement(By.xpath("//input[@id='pass']"));
		if (textPassword.isEnabled()) {
			textPassword.sendKeys("Greens@22");
		} else {
			System.out.println("Password box not editable");
		}

		WebElement btnSign = driver.findElement(By.xpath("//button[text()='Login']"));
		if (btnSign.isEnabled()) {
			btnSign.click();
		} else {
			System.out.println("Sign button is not clickable");
		}

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement clickGro1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='fliter_box_inner text-center' and @data-href='https://www.omrbranch.com/grocery']")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickGro1);

		WebElement hoverCate = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='CATEGORIES ']")));

		actions.moveToElement(hoverCate).perform();

		WebElement hoverGro = driver.findElement(By.xpath("//a[text()='Grocery']"));
		actions.moveToElement(hoverGro).perform();

		WebElement clickFrNu = driver.findElement(By.xpath("//a[text()='Fruit & Nuts']"));
		clickFrNu.click();

		WebElement btnAddFruit = driver.findElement(By.xpath("//a[contains(@class,'addBtn-37') and text()='Add']"));
		btnAddFruit.click();

		WebElement btnAddVarient = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='cart-53']")));
		btnAddVarient.click();

		WebElement goToCart = driver.findElement(
				By.xpath("//a[@href='https://www.omrbranch.com/my-cart' and contains(text(), 'Go To Cart')]"));

		// Use JavaScript Executor to click it
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();", goToCart);

		WebElement clickPayment = driver.findElement(By.xpath("//select[@id='payment_type']"));
		clickPayment.click();

		Select ddnPayment = new Select(clickPayment);
		ddnPayment.selectByVisibleText(" Debit Card ");

		Select selectCard = new Select(clickPayment);
		selectCard.selectByIndex(1);

		WebElement vistSelected = driver.findElement(By.xpath("//label[text()=' Visa ']"));
		vistSelected.click();

		WebElement textNumber = driver.findElement(By.xpath("//input[@class='form-control mt-2']"));
		textNumber.sendKeys("5555555555552222");

		WebElement clickMonth = driver.findElement(By.xpath("//select[@id='month']"));
		clickMonth.click();

		Select selectMonth = new Select(clickMonth);
		selectMonth.selectByIndex(6);

		WebElement clickYear = driver.findElement(By.xpath("//select[@id='year']"));
		clickYear.click();

		Select selectYear = new Select(clickYear);
		selectYear.selectByVisibleText("2026");

		WebElement clickCvv = driver.findElement(By.xpath("//input[@name='cvv']"));
		clickCvv.sendKeys("345");

		WebElement clickPlaceOrder = driver.findElement(By.xpath("//button[@id='placeOrder']"));
		clickPlaceOrder.click();

		WebElement emailText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
		emailText.sendKeys("gowshik927@gmail.com");
		WebElement passtext = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pass']")));
		passtext.sendKeys("Greens@22");

		WebElement clickSign = driver.findElement(By.xpath("//button[text()='Login']"));
		clickSign.click();

		WebElement clickWelcome = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='Welcome gowshik']")));

		clickWelcome.click();

		WebElement clickGrogery = driver.findElement(By.xpath("//a[text()='Grocery Settings']"));
		clickGrogery.click();

		WebElement orderClick = driver.findElement(By.xpath("//a[@id='v-pills-orders-tab']"));
		orderClick.click();

		try {
			WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Step 1: Wait until all 'More Details' elements are present
			List<WebElement> moreDetailsLinks = wait4.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.xpath("//div[@class='editBtn my-3']/a[contains(text(),'More Details')]")));

			if (!moreDetailsLinks.isEmpty()) {
				WebElement firstLink = moreDetailsLinks.get(0);

				// Step 2: Scroll into view (optional, helps visibility)
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstLink);

				// Step 3: Wait until clickable
				wait.until(ExpectedConditions.elementToBeClickable(firstLink));

				// Step 4: Click using Selenium (NO JS click)
				firstLink.click();

				System.out.println("First 'More Details' clicked successfully using Selenium.");
			} else {
				System.out.println("'More Details' not found.");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		List<WebElement> orderDivs = driver
				.findElements(By.cssSelector("div.d-flex.justify-content-between.py-sm-4.py-2"));
		for (WebElement Order : orderDivs) {

			orderNo = Order.findElement(By.xpath(".//p[contains(text(), 'Order No:')]//span")).getText();
			String schedule = Order.findElement(By.xpath(".//p[contains(text(), 'Schedule:')]//span")).getText();
			String date = Order.findElement(By.xpath(".//p[contains(text(), 'Date:')]//span")).getText();

			System.out.println("Order No: " + orderNo);
			System.out.println("Schedule: " + schedule);
			System.out.println("Date: " + date);

		}
	}
	@Test(priority = 2)
	public void login() 
	{

		addHeader("accept", "application/json");
		addBasicAuth("gowshik927@gmail.com", "Greens@22");
		Response response = addRequest("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		 int code = getStatusCode(response);
		 System.out.println(code);
		 Assert.assertEquals(code, 200,"Verified code");
		 PostmanBasicAuthLogin_Output_Pojo pojo = response.as(PostmanBasicAuthLogin_Output_Pojo.class);
		  logtoken = pojo.getData().getLogtoken();
	}
	@Test(priority = 4)
	public void cancelOrder() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   Header h3=new Header("Content-Type", "application/json");
		   header.add(h1);
		   header.add(h2);
		   header.add(h3);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   CancelOrder_Input_Pojo input_Pojo=new CancelOrder_Input_Pojo(OrderId);
		   addPayload(input_Pojo);
		   Response response = addRequest("POST","https://omrbranch.com/api/cancelOrder");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
	}
	@Test(priority = 3)
	public void getAllOrder() 
	{
		List<Header> header=new ArrayList<>(); 
		   Header h1=new Header("accept","application/json");
		   Header h2= new Header("Authorization","Bearer "+logtoken);
		   header.add(h1);
		   header.add(h2);
		   Headers headers=new Headers(header);
		   addHeaders(headers);
		   Response response = addRequest("GET", "https://omrbranch.com/api/getAllOrders");
		   int code = getStatusCode(response);
			 System.out.println(code);
			 Assert.assertEquals(code, 200,"Verified code");
			 GetAllOrder_Output_Pojo output_Pojo=response.as(GetAllOrder_Output_Pojo.class);
			 ArrayList<GetALlOrder> data = output_Pojo.getData();
			 for (GetALlOrder getALlOrder : data) 
			 {
				String order_no = getALlOrder.getOrder_no();
				if(order_no.equals(orderNo))
				{
					int id = getALlOrder.getId();
					System.out.println(id);
					OrderId=String.valueOf(id);
				}
			}
			 
	}
}
