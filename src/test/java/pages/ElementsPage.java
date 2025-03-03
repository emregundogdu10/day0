package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ElementsPage {

    public ElementsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='firstName']")
    public static WebElement firstNameInput;

    @FindBy(xpath = "//*[@id='lastName']")
    public static WebElement lastNameInput;

    @FindBy(xpath = "//nz-select-search/input")
    public static WebElement countryDropdown;

    @FindBy(xpath = "//*[@id='phoneNumber']")
    public static WebElement phoneNumberInput;

    @FindBy(id = "companyName")
    public static WebElement companyNameInput;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/sign-up1/div/div[1]/perfect-scrollbar/div/div[1]/div/form/nz-form-item[3]/nz-form-control/div/div/nz-input-group/input")
    public static WebElement kullanicimail;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/sign-up1/div/div[1]/perfect-scrollbar/div/div[1]/div/form/div[3]/nz-form-item/nz-form-control/div/div/nz-select/nz-select-top-control")
    public static WebElement titleField;

    @FindBy(xpath = "//*[@id='cdk-overlay-1']/nz-option-container/div/cdk-virtual-scroll-viewport/div[1]/nz-option-item[2]")
    public static WebElement ceoOption;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/sign-up1/div/div[1]/perfect-scrollbar/div/div[1]/div/form/div[4]/nz-form-item/nz-form-control/div/div/nz-input-group/input")
    public static WebElement emailInput;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/sign-up1/div/div[1]/perfect-scrollbar/div/div[1]/div/form/div[5]/nz-form-item/nz-form-control/div/div/nz-input-group/input")
    public static WebElement passwordInput;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/sign-up1/div/div[1]/perfect-scrollbar/div/div[1]/div/form/nz-form-item[4]/nz-form-control/div/div/label/span")
    public static WebElement termsCheckbox;

    @FindBy(xpath = "//*[@id='cdk-overlay-2']/nz-modal-container/div/div/div[3]/div/button/span")
    public static WebElement ConfirmButton;

    @FindBy(xpath = "//*[@id='ihOWn1']/div/label/input")
    public static WebElement testigec;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/sign-up1/div/div[1]/perfect-scrollbar/div/div[1]/div/button/span")
    public static WebElement sonbuton;

    @FindBy(xpath = "//*[@id='cdk-overlay-3']/nz-modal-container/div/div/div/div/forceget-confirmation-content/div/nz-spin/div/form/div/input[1]")
    public static WebElement ilkbosluk;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    public static WebElement loginmail;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/login1/div/div[1]/div/form/nz-form-item[2]/nz-form-control/div/div/nz-input-group/input")
    public static WebElement loginpassword;

    @FindBy(xpath = "/html/body/app-root/app-full-layout/login1/div/div[1]/div/form/nz-form-item[3]/nz-form-control/div/div/div/button")
    public static WebElement loginbuton;

















}
