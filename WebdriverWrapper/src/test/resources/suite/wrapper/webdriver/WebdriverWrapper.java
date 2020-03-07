package automation.suite.util;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.suite.constants.WebdriverConstants;

/**
 * Wrapper library around webdriver interface
 * @author arth.kumar
 *
 */
public class WebdriverWrapper {
	
	/**
	 * Load the web url in the browser
	 * @param driver webdriver instance
	 * @param pageURL url of the webpage
	 */
	public void NavigatetoPage(WebDriver driver,String pageURL) {
		driver.navigate().to(pageURL);		
	}
		
	/**
	 * Clicking on Webelement
	 * @param driver Instance of the Webdriver
	 * @param element WebElement variable
	 */
	public void clickingElement(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}


	/**
	 * Verify if the element is visible in the Webpage or not
	 * @param driver Instance of the Webdriver
	 * @param element WebElement variable
	 */
	public void isElementVisible(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	/**
	 * Verify if all the elements are visible in the the list
	 * @param driver Instance of the Webdriver
	 * @param elements List of webElements
	 */
	public void areElementsVisible(WebDriver driver, ArrayList<WebElement> elements) {
		
		WebDriverWait wait = new WebDriverWait(driver, WebdriverConstants.MAX_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));		
	}
	
	/**
	 * Enter value in the text box
	 * @param driver Instance of the Webdriver
	 * @param textBoxLabel TextBox WebElement
	 * @param inputText text that needs to be inserted
	 */
	public void setText(WebDriver driver, WebElement textBoxLabel, String inputText){
		isElementVisible(driver, textBoxLabel);
		textBoxLabel.click();
		textBoxLabel.clear();
		textBoxLabel.sendKeys(inputText);
	}

	/**
	 * Gets the textual value of WebElement
	 * @param driver Instance of the Webdriver
	 * @param element WebElement variable
	 * @return the textual value of WebElement
	 */
	public String getText(WebDriver driver, WebElement element){
		isElementVisible(driver, element);
		return element.getText();
	}

	/**
	 * Get value of the attribute 
	 * @param driver Instance of the Webdriver
	 * @param element WebElement variable
	 * @param attribute Attribute Value
	 * @return the value of the attribute 
	 */
	public String getAttributeValue(WebDriver driver, WebElement element, String attribute){
		isElementVisible(driver, element);
		return element.getAttribute(attribute);
	}
	
	/**
	 * Hover over a the specified webelement
	 * @param driver Instance of the Webdriver
	 * @param element WebElement variable
	 */
	public void hoverOverElement(WebDriver driver, WebElement element){
		isElementVisible(driver, element);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}

	/**
	 * Returns false if element is disabled.
	 * Returns true if element is enabled.
	 * @param driver Instance of the Webdriver
	 * @param element WebElement variable
	 */
	public boolean isWebElementEnabled(WebDriver driver, WebElement element) {
		isElementVisible(driver, element);
		return element.isEnabled();
	}
	
	/**
	 * Clear the text area of the Textbox.
	 * @param driver Instance of the Webdriver
	 * @param textboxLabel TextBox WebElement
	 */
	public void clearTextArea(WebDriver driver, WebElement textboxLabel) {
		isElementVisible(driver, textboxLabel);
		textboxLabel.clear();	
	}

	/**
	 * Returns the number of elements inside the list 
	 * @param driver Instance of the Webdriver
	 * @param elementList WebElement List
	 */
	public Integer verifyListSizeOfElements(WebDriver driver, ArrayList<WebElement> elementList) {
		return elementList.size();
	}

}
