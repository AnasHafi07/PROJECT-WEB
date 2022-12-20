import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When


class Orange_Basic_Login {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I navigate to Orange HRM System homepage")
	def I_navigate_to_Orange_HRM_System_homepage() {
		
		WebUI.openBrowser('')

		WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')
	}

	@Then("I click Log in button!")
	def I_click_Log_in_button() {

		WebUI.click(findTestObject('Object Repository/Orange/Page_OrangeHRM/button_Login'))
	}


}