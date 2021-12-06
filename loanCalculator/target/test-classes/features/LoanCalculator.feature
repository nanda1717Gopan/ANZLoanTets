#Author: krish13287@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
## (Comments)
#Sample Feature Definition Template
@FirstThreeTests
Feature: Feature file to test the calculate borrowing estimate, starting over, checking borrowing estimate error message

  @FirstThreeTests
  Scenario Outline: Verifying user is able to calculate the Borrowing Estimate for a given set of data
    Given User is in the ANZ How much can I borrow page
    When User selects "<ApplicationType>" and "<Dependents>"
    And User selects "<PropertyType>" with earning details, Income Before Tax "<Income>" Other Income "<OtherIncome>"
    And User enters Expenses details with Living Expense "<LivingExpense>", Current Home Loan Repayment "<CurrentHomeLoan>", Other Loan Repayment "<OtherLoanRepayment>"
    And User enters Expenses details with Other Commitments "<Commitments>", Total Credit Card Limits "<CreditCardLimit>"
    And User clicks on Work out how much I could borrow button to calculate the Borrowing Estimate
    Then The Calculated Borrowing Estimate should be "<BorrowingEstimate>"

    Examples: 
      | ApplicationType | Dependents | PropertyType | Income | OtherIncome | LivingExpense | CurrentHomeLoan | OtherLoanRepayment | Commitments | CreditCardLimit | BorrowingEstimate |
      | Single          | Zero       | HomeToLiveIn |  80000 |       10000 |           500 |               0 |                100 |           0 |           10000 | $479,000          |

  @FirstThreeTests
  Scenario Outline: Verifying Start Over button clears the Loan estimation form data
    Given User is in the ANZ How much can I borrow page
    When User selects "<ApplicationType>" and "<Dependents>"
    And User selects "<PropertyType>" with earning details, Income Before Tax "<Income>" Other Income "<OtherIncome>"
    And User enters Expenses details with Living Expense "<LivingExpense>", Current Home Loan Repayment "<CurrentHomeLoan>", Other Loan Repayment "<OtherLoanRepayment>"
    And User enters Expenses details with Other Commitments "<Commitments>", Total Credit Card Limits "<CreditCardLimit>"
    And User clicks on Work out how much I could borrow button to calculate the Borrowing Estimate
    And User clicks on Start Over Button
    When User Verifies the entered field values
    Then The entered field values should be cleared and it should default to zero

    Examples: 
      | ApplicationType | Dependents | PropertyType | Income | OtherIncome | LivingExpense | CurrentHomeLoan | OtherLoanRepayment | Commitments | CreditCardLimit | BorrowingEstimate |
      | Single          | Zero       | HomeToLiveIn |  80000 |       10000 |           500 |               0 |                100 |           0 |           10000 | $479,000          |

  @FirstThreeTests
  Scenario: Trying to estimate the Borrowing without entering all necessary details and checking the corresponding error message
    Given User is in the ANZ How much can I borrow page
    When User enters Living expense as One Dollar
    And User clicks on Work out how much I could borrow button to calculate the Borrowing Estimate
    Then Error message for not able to calculate the estimate with given information should be displayed
