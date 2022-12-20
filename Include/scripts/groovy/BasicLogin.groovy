import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class BasicLogin {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */

	@Given("I navigate to Cura System homepage")
	def I_navigate_to_Cura_system_homepage() {

		WebUI.openBrowser('')

		WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
	}


	@When("I click Make Appointment button")
	def I_click_Make_Appointment_button() {

		WebUI.click(findTestObject('Object Repository/CURA/Page_CURA Healthcare Service/a_Make Appointment'))
	}

	@And("I enter username (.*) and password (.*)")
	def I_enter_username_and_password(String username, String password) {

		WebUI.setText(findTestObject('Object Repository/CURA/Page_CURA Healthcare Service (1)/input_Username_username'), username)

		WebUI.setText(findTestObject('Object Repository/CURA/Page_CURA Healthcare Service (1)/input_Password_password'), password)
	}

	@And("I click Log in button")
	def I_click_Log_in_button() {

		WebUI.click(findTestObject('Object Repository/CURA/Page_CURA Healthcare Service (1)/button_Login'))
	}

	@Then("I should be able to login successfully")
	def I_should_be_able_to_login_successfully() {

		WebUI.callTestCase(findTestCase('CURA/Common/Basic Login'), [('username') : GlobalVariable.username, ('password') : GlobalVariable.password],
		FailureHandling.STOP_ON_FAILURE)

		WebUI.verifyElementVisible(findTestObject('Object Repository/CURA/Page_CURA Healthcare Service (1)/h2_Make Appointment'))
	}

	@And("I enter an invalid username (.*) and password (.*)")
	def I_enter_an_invalid_username_and_password(String username, String password) {

		WebUI.setText(findTestObject('Object Repository/CURA/Page_CURA Healthcare Service (1)/input_Username_username'), username)

		WebUI.setText(findTestObject('Object Repository/CURA/Page_CURA Healthcare Service (1)/input_Password_password'), password)
	}

	@Then("I should NOT be able to login successfully")
	def I_should_NOT_be_able_to_login_successfully() {
		WebUI.verifyElementVisible(findTestObject('CURA/TC002/Page_CURA Healthcare Service/p_Login failed'))
	}
}