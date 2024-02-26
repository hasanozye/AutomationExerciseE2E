package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class SignupPage extends BaseTest {

    public SignupPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(.,'Enter')]")
    private WebElement enterAccountInfoText;
    @FindBy(xpath = "//div[@class='radio' and @id='uniform-id_gender1'] ")
    private WebElement radioMaleValue;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'name')]")
    private WebElement formNameField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'Email')]")
    private WebElement formEmailField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'password')]")
    private WebElement formPasswordField;
    @FindBy(xpath = "//select[@id='days']")
    private WebElement formSelectDay;
    @FindBy(xpath = "//select[@id='months']")
    private WebElement formSelectMonth;
    @FindBy(xpath = "//select[@id='years']")
    private WebElement formSelectYear;
    @FindBy(xpath = "//input[@type='checkbox' and @id='newsletter']")
    private WebElement newsLetterCheckbox;
    @FindBy(xpath = "//input[@type='checkbox' and @id='optin']")
    private WebElement specialOfferCheckbox;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'first_name')]")
    private WebElement formFirstNameField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'last_name')]")
    private WebElement formLastNameField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'company')]")
    private WebElement formCompanyField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'address1')]")
    private WebElement addressField1;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'address2')]")
    private WebElement addressField2;
    @FindBy(xpath = "//select[@id='country']")
    private WebElement formSelectCountry;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'state')]")
    private WebElement stateField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'city')]")
    private WebElement cityField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'zipcode')]")
    private WebElement zipCodeField;
    @FindBy(xpath = "//div[@class='login-form']//input[contains(@class,'form') and contains(@id,'mobile')]")
    private WebElement mobileNumberField;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    public boolean verifyTextIsLoaded() {
        waitForVisibility(enterAccountInfoText);
        return enterAccountInfoText.isDisplayed();
    }

    public void fillTitlePasswordDoB() {
        click(radioMaleValue);
        sendKeys(formNameField, faker.name().firstName());
        sendKeys(formPasswordField, faker.cat().name());
        selectByVisibleText(formSelectDay, "23");
        selectByVisibleText(formSelectMonth, "July");
        selectByVisibleText(formSelectYear, "2000");
    }

    public void selectNewsLetter() {
        scrollIntoElement(newsLetterCheckbox);
        click(newsLetterCheckbox);
    }

    public void selectSpecialOffers() {
        click(specialOfferCheckbox);
    }

    public void fillTheRestOfTheForm() {
        sendKeys(formFirstNameField, faker.name().firstName());
        sendKeys(formLastNameField, faker.name().lastName());
        sendKeys(formCompanyField, faker.company().name());
        sendKeys(addressField1, faker.address().fullAddress());
        sendKeys(addressField2, faker.address().secondaryAddress());
        selectByVisibleText(formSelectCountry, "United States");
        scrollIntoElement(stateField);
        sendKeys(stateField, faker.address().state());
        sendKeys(cityField, faker.address().city());
        sendKeys(zipCodeField, faker.address().zipCode());
        sendKeys(mobileNumberField, faker.phoneNumber().cellPhone());
    }

    public void clickCreateAccountButton() {
        click(createAccountButton);
    }


}
