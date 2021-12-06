package loanCalculatorStepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import loanCalculatorPages.HowMuchCanIBorrow;

public class LoanCalculatorSteps {
	
	public HowMuchCanIBorrow testPage = null;
	
	@Before() public void TestSetup() {
		baseClass.initialize();
		testPage = new HowMuchCanIBorrow (baseClass.driver);
	}
	
	@After() public void TestTearDown() {
		baseClass.close();
	}
	
	@Given("User is in the ANZ How much can I borrow page")
	public void user_is_in_the_anz_how_much_can_i_borrow_page() {
	    // Write code here that turns the phrase above into concrete actions
	   baseClass.getPage(ConstantVariable.anzBorrowURL);
	}
	
	@When("User selects {string} and {string}")
	public void user_selects_and(String string, String string2) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    testPage.clickApplicationTypeSingle();
	    testPage.selectDependents(string2);
	}
	
	@And("User selects {string} with earning details, Income Before Tax {string} Other Income {string}")
	public void user_selects_with_earning_details_income_before_tax_other_income(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		testPage.selectPropertyType(string);
		testPage.enterPrimaryIncome(string2);
		testPage.enterSecondaryIncome(string3);
	}
	@Given("User enters Expenses details with Living Expense {string}, Current Home Loan Repayment {string}, Other Loan Repayment {string}")
	public void user_enters_expenses_details_with_living_expense_current_home_loan_repayment_other_loan_repayment(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		testPage.enterLivingExpense(string);
		testPage.enterCurrentHomeLoanRepayment(string2);
		testPage.enterOtherLoanRepayment(string3);
	}
	@And("User enters Expenses details with Other Commitments {string}, Total Credit Card Limits {string}")
	public void user_enters_expenses_details_with_other_commitments_total_credit_card_limits(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		testPage.enterOtherCommitments(string);
		testPage.enterCreditCardLimits(string2);
	}
	@And("User clicks on Work out how much I could borrow button to calculate the Borrowing Estimate")
	public void user_clicks_on_work_out_how_much_i_could_borrow_button_to_calculate_the_borrowing_estimate() {
	    // Write code here that turns the phrase above into concrete actions
		testPage.calculateEstimate();
	}
	@Then("The Calculated Borrowing Estimate should be {string}")
	public void the_calculated_borrowing_estimate_should_be(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(string, testPage.getCalculatedEstimate());
	}
	@And("User clicks on Start Over Button")
	public void user_clicks_on_start_over_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		testPage.startOver();
	}
	@When("User Verifies the entered field values")
	public void user_verifies_the_entered_field_values() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@Then("The entered field values should be cleared and it should default to zero")
	public void the_entered_field_values_should_be_cleared_and_it_should_default_to_zero() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("0", testPage.getPrimaryIncomeValue());
		Assert.assertEquals("0", testPage.getSecondaryIncomeValue());
		Assert.assertEquals("0", testPage.getCreditCardLimitValue());
		Assert.assertEquals("0", testPage.getLivingExpenseValue());
		Assert.assertEquals("0", testPage.getOtherLoanValue());
		Assert.assertEquals("0", testPage.getOtherCommitmentsValue());
	}
	@When("User enters Living expense as One Dollar")
	public void user_enters_living_expense_as_one_dollar() {
	    // Write code here that turns the phrase above into concrete actions
		testPage.enterLivingExpense("1");
	}
	@Then("Error message for not able to calculate the estimate with given information should be displayed")
	public void error_message_for_not_able_to_calculate_the_estimate_with_given_information_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.", testPage.getEstimationErrorText());
	}
}
