package loanCalculatorPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HowMuchCanIBorrow {
	 
	WebDriver driver;
	// WebElements in How Much Can I Borrow page
	By applicationTypeSingleBtn = By.xpath("//label[@for='borrow_type_home']");
	By applicationTypeJointBtn = By.id("application_type_joint");
	By dependentsDropDown = By.xpath("//select[@title='Number of dependants']");
	By propertyHomeToLiveInBtn = By.id("borrow_type_home");
	By propertyResidentialInvestmentBtn = By.id("borrow_type_investment");
	By incomeBeforeTaxTxtFld = By.xpath("//input[@aria-describedby='q2q1i1 q2q1i2']");
	By yourAnotherIncomeTxtFld = By.xpath("//input[@aria-describedby='q2q2i1 q2q2i2']");
	By livingExpenseTxtFld = By.xpath("//input[@id='expenses']");
	By currentHomeLoanRepaymentTxtFld = By.xpath("//input[@id='homeloans']");
	By otherLoanRepaymentTxtFld = By.id("otherloans");
	By otherCommitmentsTxtFld = By.xpath("//input[@aria-describedby='q3q4i1 q3q4i2']");
	By totalCreditCardLimit = By.id("credit");
	By calculateBarrowAmountBtn = By.id("btnBorrowCalculater");
	By estimatedBarrowAmountTxt = By.id("borrowResultTextAmount");
	By startOverBtn = By.xpath("//button[contains(text(), 'Start over')]");
	By barrowErrorTxt = By.xpath("//span[@class='borrow__error__text']");
	
	public HowMuchCanIBorrow(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectDependents(String count) {
		Select dependents = new Select (driver.findElement(dependentsDropDown));
		if (count.equalsIgnoreCase("zero")) {
			dependents.selectByVisibleText("0");
		}
	}
	
	public void clickApplicationTypeSingle() throws InterruptedException {
		driver.findElement(applicationTypeSingleBtn).click();
	}
	
	public void selectPropertyType (String type) {
		if (type.equalsIgnoreCase("HomeToLiveIn")) {
			driver.findElement(propertyHomeToLiveInBtn).click();
		}
		if (type.equals("ResidentialInvestment")) {
			driver.findElement(propertyResidentialInvestmentBtn).click();
		}
	}
	
	public void enterPrimaryIncome(String amount) {
		driver.findElement(incomeBeforeTaxTxtFld).sendKeys(amount);
	}
	public String getPrimaryIncomeValue() {
		return driver.findElement(incomeBeforeTaxTxtFld).getAttribute("value");
	}
	public void enterSecondaryIncome(String amount) {
		driver.findElement(yourAnotherIncomeTxtFld).sendKeys(amount);
	}
	public String getSecondaryIncomeValue() {
		return driver.findElement(yourAnotherIncomeTxtFld).getAttribute("value");
	}
	public void enterLivingExpense(String amount) {
		driver.findElement(livingExpenseTxtFld).sendKeys(amount);
	}
	public String getLivingExpenseValue() {
		return driver.findElement(livingExpenseTxtFld).getAttribute("value");
	}
	public void enterCurrentHomeLoanRepayment(String amount) {
		driver.findElement(currentHomeLoanRepaymentTxtFld).sendKeys(amount);
	}
	public String getCurrentHomeLoanValue() {
		return driver.findElement(currentHomeLoanRepaymentTxtFld).getAttribute("value");
	}
	public void enterOtherLoanRepayment(String amount) {
		driver.findElement(otherLoanRepaymentTxtFld).sendKeys(amount);
	}
	public String getOtherLoanValue() {
		return driver.findElement(otherLoanRepaymentTxtFld).getAttribute("value");
	}
	public void enterOtherCommitments(String amount) {
		driver.findElement(otherCommitmentsTxtFld).sendKeys(amount);
	}
	public String getOtherCommitmentsValue() {
		return driver.findElement(otherCommitmentsTxtFld).getAttribute("value");
	}
	public void enterCreditCardLimits(String amount) {
		driver.findElement(totalCreditCardLimit).sendKeys(amount);
	}
	public String getCreditCardLimitValue() {
		return driver.findElement(totalCreditCardLimit).getAttribute("value");
	}
	public String getEstimationErrorText() {
		return driver.findElement(barrowErrorTxt).getText();
	}
	
	public void calculateEstimate() {
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(calculateBarrowAmountBtn)));
		driver.findElement(calculateBarrowAmountBtn).click();
	}
	
	public void startOver() throws InterruptedException {
		Thread.sleep(2000);
		JSclick(driver.findElement(startOverBtn));
	}
	public String getCalculatedEstimate() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait (driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(estimatedBarrowAmountTxt)));
		Thread.sleep(10000);
		return driver.findElement(estimatedBarrowAmountTxt).getText();
	}
	public void JSclick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver; executor. executeScript("arguments[0]. click();", element);
	}
}
