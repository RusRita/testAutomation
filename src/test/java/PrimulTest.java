import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrimulTest {

    public static final String URL_homepage="https://staging.lessonplanet.com";
    public static final String URL_homepage2="https://staging.lessonplanet.com/";
    public static final String URL_SignIn= "https://staging.lessonplanet.com/auth/users/sign_in";
    public static final String URL_New_Subscription= "https://staging.lessonplanet.com/subscription/new";
    public static final String Invalid_login= "Invalid login or password.";
    public static final String Invalid_email="blabla@test.com";
    public static final String Invalid_password="blablablaaaaaaaaaa--79*";
    public static final String Valid_email="ritatest@test.com";
    public static final String Valid_password="hello123844";
    public static final String Step1_modal_text="Discover 350k+ Teacher Reviewed Resources";
    public static final String Step1_modal_email="rita104@lp.com";
    public static final String Step1_modal_password="test1234";
    public static final String Step2_modal_text="Select Your Membership";
    public static final String Step1_static_text="Ready to start your Free 10 Days?";
    public static final String Step1_static_email="rita122@yahoo.com";
    public static final String Step1_static_password="test1234";
    public static final String URL_Search="https://staging.lessonplanet.com/search";
    public static final String URL_Directory="https://staging.lessonplanet.com/lesson-plans";
    public static final String URL_Articles="https://staging.lessonplanet.com/articles";
    public static final String URL_Calendar="https://staging.lessonplanet.com/calendar";
    public static final String URL_Educator_Edition="https://staging.lessonplanet.com/educator-edition";
    public static final String URL_Learning_Explorer="https://staging.lessonplanet.com/learning-explorer";
    public static final String URL_PDLN="https://staging.lessonplanet.com/pdln";
    public static final String URL_Pricing="https://staging.lessonplanet.com/pricing";
    
    
    private WebDriver webDriver;
  
    
    @BeforeTest
    public void initTest(){
        System.setProperty("webdriver.gecko.driver","C:\\Projects\\drivers\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

    }


    

    @Test
    public void InvalidAccount(){

        webDriver.get(PrimulTest.URL_homepage);
        webDriver.get(PrimulTest.URL_SignIn);
        webDriver.findElement(By.cssSelector("#user_login")).sendKeys(PrimulTest.Invalid_email);
        webDriver.findElement(By.cssSelector("#user_password")).sendKeys(PrimulTest.Invalid_password);
        webDriver.findElement(By.cssSelector("[class='btn btn-action']")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='alert alert-dismissable alert-danger']")).getText(), PrimulTest.Invalid_login);
        System.out.println("Test passed -Invalid Account");
    }
    @Test
    public void ValidAccount(){
        webDriver.get(PrimulTest.URL_homepage);
        webDriver.get(PrimulTest.URL_SignIn);
        webDriver.findElement(By.cssSelector("#user_login")).sendKeys(PrimulTest.Valid_email);
        webDriver.findElement(By.cssSelector("#user_password")).sendKeys(PrimulTest.Valid_password);
        webDriver.findElement(By.cssSelector("[class='btn btn-action']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_homepage2);
        System.out.println("Test passed -Valid Account");
    }

    @Test
    public void Step1Modal(){

        webDriver.get(PrimulTest.URL_homepage);
        webDriver.findElement(By.cssSelector("[class='lp-try-it-free']")).click();
        WebDriverWait wait=new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='modal-header'] [class='title']")));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='modal-header'] [class='title']")).getText(), PrimulTest.Step1_modal_text);
        webDriver.findElement(By.cssSelector("#user_email")).sendKeys(PrimulTest.Step1_modal_email);
        webDriver.findElement(By.cssSelector("#user_password")).sendKeys(PrimulTest.Step1_modal_password);
        webDriver.findElement(By.cssSelector("#submit-signup")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='modal-header text-center']")));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='modal-header text-center']")).getText(), PrimulTest.Step2_modal_text);
        webDriver.findElement(By.cssSelector("[class='button close']")).click();
    }

    @Test
    public void Step1Static(){

        webDriver.get(PrimulTest.URL_New_Subscription);
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='panel-title']")).getText(),PrimulTest.Step1_static_text );
        webDriver.findElement(By.cssSelector("[class='form-group email required user_email'] #user_email")).sendKeys(PrimulTest.Step1_static_email);
        webDriver.findElement(By.cssSelector("[class='form-group password optional user_password'] #user_password")).sendKeys(PrimulTest.Step1_static_password);
        webDriver.findElement(By.cssSelector("#qa")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_New_Subscription);
    }

    @Test
    public void Header(){

        //Resources drop-down
        webDriver.get(PrimulTest.URL_homepage);
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();

        //Discover Resources option
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/search']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_Search);

        //Browse Resource Directory
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/lesson-plans']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_Directory);

        //Lesson Planning Articles
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/articles']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_Articles);

        //Curriculum Calendar
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/calendar']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_Calendar);

        //Solutions drop-down
        webDriver.get(PrimulTest.URL_homepage);
        webDriver.findElement(By.cssSelector("[class='lp-solutions']")).click();
        //Educator Edition option
        webDriver.findElement(By.cssSelector("[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/educator-edition']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_Educator_Edition);

        //Learning Explorer option
        webDriver.get(PrimulTest.URL_homepage);
        webDriver.findElement(By.cssSelector("[class='lp-solutions']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/learning-explorer']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_Learning_Explorer);

        //PD Learning option
        webDriver.get(PrimulTest.URL_homepage);
        webDriver.findElement(By.cssSelector("[class='lp-solutions']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/pdln']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(),PrimulTest.URL_PDLN );

        //Pricing button
        webDriver.get(PrimulTest.URL_homepage);
        webDriver.findElement(By.cssSelector("[class='lp-nav-menu'] [class='lp-pricing'] [href='/pricing']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_Pricing );

    }

    @AfterTest
    public void closeAll(){
        try{
            webDriver.close();
        }catch (Exception ex){
            ex.toString();
        }
    }
}
