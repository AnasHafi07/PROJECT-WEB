import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Orange/Login/common_Login'), [('Orange_Username') : GlobalVariable.Orange_Username, ('Orange_Password') : GlobalVariable.Orange_Password], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index')

WebUI.click(findTestObject('Object Repository/Orange/Page_OrangeHRM/a_Admin'))

WebUI.click(findTestObject('Object Repository/Orange/Page_OrangeHRM/i_Organization_oxd-icon bi-chevron-down'))

WebUI.click(findTestObject('Object Repository/Orange/Page_OrangeHRM/a_Structure'))

WebUI.click(findTestObject('Object Repository/Orange/Page_OrangeHRM/span_Edit_oxd-switch-input oxd-switch-input_e15d3c'))

WebUI.click(findTestObject('Object Repository/Orange/Page_OrangeHRM/button_Add'))

WebUI.setText(findTestObject('Object Repository/Orange/Page_OrangeHRM/input_Unit Id_oxd-input oxd-input--focus'), 'Test Id')

WebUI.click(findTestObject('Object Repository/Orange/Page_OrangeHRM/button_Save'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Orange/Page_OrangeHRM/span_Required'))

