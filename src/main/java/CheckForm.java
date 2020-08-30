import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;


public  class CheckForm {
    public WebDriver driver;

    public CheckForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'gwt-TextBox')]")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[contains(@class, 'gwt-DateBox')]")
    private WebElement birthDayField;

    @FindBy(xpath = "//*[contains(@class, 'gwt-TextArea')]")
    private WebElement addressField;

    @FindBy(xpath = "//*[contains(@class, 'gwt-Button')]")
    private WebElement buttonField;

    public void lastName(int i,String lastName){
        List<WebElement> elementsTextBox = driver.findElements(By.xpath("//*[@class='gwt-TextBox']"));
        elementsTextBox.get(i).clear();
        elementsTextBox.get(i).sendKeys(lastName);
    }

    public void getList(String category){
        Select listBox = new Select(driver.findElement(By.xpath("//*[@class='gwt-ListBox']")));
        listBox.selectByValue(category);
    }
    public void clearFields(){
        firstNameField.clear();
        birthDayField.clear();
        addressField.clear();
    }

    public void inputFirstNameField(String firstName) throws InterruptedException {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    public void inputBirthDayField(String birthDay) {
        birthDayField.clear();
        birthDayField.sendKeys(birthDay);
        birthDayField.sendKeys(Keys.ENTER);
    }
    public void inputAddressField(String AddressName) {
        addressField.clear();
        addressField.sendKeys(AddressName);
    }
    public void clickButton(int i) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> elementsTextBox = driver.findElements(By.xpath("//*[@class='gwt-Button']"));
        elementsTextBox.get(i).click();
        Thread.sleep(1000);
    }

    public int checkCounts(){
        List<WebElement> elementsListEven = driver.findElements(By.xpath("//*[@class='GNHGC04CEB']"));
        List<WebElement> elementsListUnEven = driver.findElements(By.xpath("//*[@class='GNHGC04CCB']"));
        int sum = elementsListEven.size() + elementsListUnEven.size();
        return sum;
    }

    public void scrollDown() {
        driver.findElement(By.xpath("//*[@class='GNHGC04CJJ']")).click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

        }

    public void scrollUp() {
        driver.findElement(By.xpath("//*[@class='GNHGC04CJJ']")).click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).perform();
    }

    public String getFirstName(){
        return  firstNameField.getAttribute("value");
        }

    public String getLastName(){
        List<WebElement> elementsTextBox = driver.findElements(By.xpath("//*[@class='gwt-TextBox']"));
         return elementsTextBox.get(1).getAttribute("value");
    }

    public String getCategory(){
       return  driver.findElement(By.xpath("//*[@class='gwt-ListBox']")).getAttribute("value");

    }
    public String getBirthday(){
       return birthDayField.getAttribute("value");
    }

    public String getAddress(){
       return  addressField.getAttribute("value");
    }
    }



