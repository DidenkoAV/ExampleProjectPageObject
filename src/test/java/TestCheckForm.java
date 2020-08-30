import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TestCheckForm {
    Integer quantity = 0;

    @Test(priority = 1)
    @Description("Получить количество аккаунтов")
    public void getQuantityAccounts()  {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.scrollDown();
        quantity = checkForm.checkCounts();
        checkForm.scrollUp();
        Allure.addAttachment("quantity: ", quantity.toString() );
    }

    @Test(priority = 2)
    @Description("Очистить поля")
    public void clearSomeFields()  {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.clearFields();
    }

    @Test(priority = 3)
    @Description("Создаем аккаунт типа: Family")
    public void createFamilyAccount() throws Exception {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.inputFirstNameField("Family");
        checkForm.lastName(1,"Account");
        checkForm.getList("Family");
        checkForm.inputBirthDayField("August 27, 1990");
        checkForm.inputAddressField("Russia, Saint-Petersburg");
        checkForm.clickButton(1);
        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        Path content = Paths.get("image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("Screen", is);
        }
    }

    @Test(priority = 4)
    @Description("Создаем аккаунт типа: Friends")
    public void createFriendsAccount() throws Exception {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.inputFirstNameField("Friends");
        checkForm.lastName(1,"Account");
        checkForm.getList("Friends");
        checkForm.inputBirthDayField("August 27, 1991");
        checkForm.inputAddressField("Russia, Saint-Petersburg");
        checkForm.clickButton(1);
        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        Path content = Paths.get("image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("Screen", is);
        }
    }

    @Test(priority = 5)
    @Description("Создаем аккаунт типа: Coworkers")
    public void createCoworkersAccount() throws Exception {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.inputFirstNameField("Coworkers");
        checkForm.lastName(1,"Account");
        checkForm.getList("Coworkers");
        checkForm.inputBirthDayField("August 27, 1992");
        checkForm.inputAddressField("Russia, Saint-Petersburg");
        checkForm.clickButton(1);
        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        Path content = Paths.get("image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("Screen", is);
        }
    }

    @Test(priority = 6)
    @Description("Создаем аккаунт типа: Businesses")
    public void createBusinessesAccount() throws Exception {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.inputFirstNameField("Businesses");
        checkForm.lastName(1,"Account");
        checkForm.getList("Businesses");
        checkForm.inputBirthDayField("August 27, 1993");
        checkForm.inputAddressField("Russia, Saint-Petersburg");
        checkForm.clickButton(1);
        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        Path content = Paths.get("image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("Screen", is);
        }
    }
    @Test(priority = 7)
    @Description("Создаем аккаунт типа: Contract")
    public void createContractAccount() throws Exception {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.inputFirstNameField("Contract");
        checkForm.lastName(1,"Account");
        checkForm.getList("Contacts");
        checkForm.inputBirthDayField("August 27, 1994");
        checkForm.inputAddressField("Russia, Saint-Petersburg");
        checkForm.clickButton(1);
        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        Path content = Paths.get("image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("Screen", is);
        }
    }

    @Test(priority = 8)
    @Description("Проверяем корректность работы подсчета аккаунтов")
    public void checkQuantityAccounts()  {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        checkForm.scrollDown();
        int finishedQuantity = checkForm.checkCounts();
        Assert.assertEquals(finishedQuantity,quantity+5);
    }

    @Test(priority = 9)
    @Description("Сверяем корректность сохранения введенной информации по всем аккаунтам")
    public void checkInformation() throws Exception {
        CheckForm checkForm = new CheckForm(DriverBase.setup());
        Actions actions = new Actions(DriverBase.setup());

        // check contacts account
        Assert.assertEquals("Contract", checkForm.getFirstName());
        Assert.assertEquals("Account", checkForm.getLastName());
        Assert.assertEquals("Contacts", checkForm.getCategory());
        Assert.assertEquals("August 27, 1994",checkForm.getBirthday());
        Assert.assertEquals("Russia, Saint-Petersburg",checkForm.getAddress());

        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        Path content = Paths.get("image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("ScreenContract", is);
        }

        actions.sendKeys(Keys.UP).perform();

        //check businesses account
        Assert.assertEquals("Businesses", checkForm.getFirstName());
        Assert.assertEquals("Account", checkForm.getLastName());
        Assert.assertEquals("Businesses", checkForm.getCategory());
        Assert.assertEquals("August 27, 1993",checkForm.getBirthday());
        Assert.assertEquals("Russia, Saint-Petersburg",checkForm.getAddress());

        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("ScreenBusinesses", is);
        }

        actions.sendKeys(Keys.UP).perform();

        //check coworkers account
        Assert.assertEquals("Coworkers", checkForm.getFirstName());
        Assert.assertEquals("Account", checkForm.getLastName());
        Assert.assertEquals("Coworkers", checkForm.getCategory());
        Assert.assertEquals("August 27, 1992",checkForm.getBirthday());
        Assert.assertEquals("Russia, Saint-Petersburg",checkForm.getAddress());

        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("ScreenCoworkers", is);
        }

        actions.sendKeys(Keys.UP).perform();

        //check friends account
        Assert.assertEquals("Friends", checkForm.getFirstName());
        Assert.assertEquals("Account", checkForm.getLastName());
        Assert.assertEquals("Friends", checkForm.getCategory());
        Assert.assertEquals("August 27, 1991",checkForm.getBirthday());
        Assert.assertEquals("Russia, Saint-Petersburg",checkForm.getAddress());

        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("ScreenFriends", is);
        }

        actions.sendKeys(Keys.UP).perform();

        //check family account
        Assert.assertEquals("Family", checkForm.getFirstName());
        Assert.assertEquals("Account", checkForm.getLastName());
        Assert.assertEquals("Family", checkForm.getCategory());
        Assert.assertEquals("August 27, 1990",checkForm.getBirthday());
        Assert.assertEquals("Russia, Saint-Petersburg",checkForm.getAddress());

        DriverBase.makeScreen(DriverBase.setup(),"image/png/Screen.png");
        try (InputStream is = Files.newInputStream(content)) {
            Allure.addAttachment("ScreenFamily", is);
        }

    }
    @AfterClass
    static void quit(){
        DriverBase.setup().quit();
        DriverBase.setup().close();

    }


}
