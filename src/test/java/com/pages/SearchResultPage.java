package com.pages;

import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.automation.BasePage;

public class SearchResultPage extends BasePage {

	@FindBy(how = How.ID, using = "firstHeading")
	public WebElement firstHeading;

	@FindBy(how = How.XPATH, using = "//*[@id='p-lang']/div/ul/li/a")
	public List<WebElement> languageList;

	public String getHeadingText() {
		return firstHeading.getText();
	}

	public String getLangAttribute() {
		return firstHeading.getAttribute("lang");
	}

	public void selectLanguage() {
		languageList.get(0).click();
	}

	public boolean checkLangAttribute(String value) {
		Optional<WebElement> element = languageList.stream().filter(elem -> elem.getAttribute("lang").equals(value))
				.findFirst();
		return element.isPresent();
	}
}