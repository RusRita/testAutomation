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

        webDriver.get("https://staging.lessonplanet.com");
        webDriver.get("https://staging.lessonplanet.com/auth/users/sign_in");
        webDriver.findElement(By.cssSelector("#user_login")).sendKeys("blabla@test.com");
        webDriver.findElement(By.cssSelector("#user_password")).sendKeys("blablablaaaaaaaaaa");
        webDriver.findElement(By.cssSelector("[class='btn btn-action']")).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='alert alert-dismissable alert-danger']")).getText(), "Invalid login or password.");
        System.out.println("Test passed -Invalid Account");
    }sadfasdfasdfdas
f
    @Test
    public void ValidAccount(){
        webDriver.get("https://staging.lessonplanet.com");
        webDriver.get("https://staging.lessonplanet.com/auth/users/sign_in");
        webDriver.findElement(By.cssSelector("#user_login")).sendKeys("ritatest@lp.com");
        webDriver.findElement(By.cssSelector("#user_password")).sendKeys("test1234");
        webDriver.findElement(By.cssSelector("[class='btn btn-action']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/");
        System.out.println("Test passed -Valid Account");
    }

    @Test
    public void Step1Modal(){

        webDriver.get("https://staging.lessonplanet.com");
        webDriver.findElement(By.cssSelector("[class='lp-try-it-free']")).click();
        WebDriverWait wait=new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='modal-header'] [class='title']")));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='modal-header'] [class='title']")).getText(), "Discover 350k+ Teacher Reviewed Resources");
        webDriver.findElement(By.cssSelector("#user_email")).sendKeys("rita104@lp.com");
        webDriver.findElement(By.cssSelector("#user_password")).sendKeys("test1234");
        webDriver.findElement(By.cssSelector("#submit-signup")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='modal-header text-center']")));
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='modal-header text-center']")).getText(), "Select Your Membership");
        webDriver.findElement(By.cssSelector("[class='button close']")).click();
    }

    @Test
    public void Step1Static(){

        webDriver.get("https://staging.lessonplanet.com/subscription/new");
        Assert.assertEquals(webDriver.findElement(By.cssSelector("[class='panel-title']")).getText(), "Ready to start your Free 10 Days?");
        webDriver.findElement(By.cssSelector("[class='form-group email required user_email'] #user_email")).sendKeys("rita1076@lp.com");
        webDriver.findElement(By.cssSelector("[class='form-group password optional user_password'] #user_password")).sendKeys("test12345");
        webDriver.findElement(By.cssSelector("#qa")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/subscription/new");
    }

    @Test
    public void Header(){

        //Resources drop-down
        webDriver.get("https://staging.lessonplanet.com/");
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();

        //Discover Resources option
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/search']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/search");

        //Browse Resource Directory
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/lesson-plans']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/lesson-plans");

        //Lesson Planning Articles
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/articles']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/articles");

        //Curriculum Calendar
        webDriver.findElement(By.cssSelector("[class='lp-resources']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-resources'] [class='lp-resources-dd'] [href*='/calendar']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/calendar");

        //Solutions drop-down
        webDriver.get("https://staging.lessonplanet.com/");
        webDriver.findElement(By.cssSelector("[class='lp-solutions']")).click();
        //Educator Edition option
        webDriver.findElement(By.cssSelector("[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/educator-edition']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/educator-edition");

        //Learning Explorer option
        webDriver.get("https://staging.lessonplanet.com/");
        webDriver.findElement(By.cssSelector("[class='lp-solutions']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/learning-explorer']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/learning-explorer");

        //PD Learning option
        webDriver.get("https://staging.lessonplanet.com/");
        webDriver.findElement(By.cssSelector("[class='lp-solutions']")).click();
        webDriver.findElement(By.cssSelector("[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/pdln']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/pdln");

/*
        //----------------------------About drop-down--------------------------
        webDriver.get("https://staging.lessonplanet.com/");
        webDriver.findElement(By.cssSelector("[class='lp-about']")).click();

        //Our Story option
       webDriver.findElement(By.cssSelector("[class='lp-about'] [class='lp-about-dd'] [href='/us/about_us']")).click();
       Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/us/about_us");

        //User Guide & FAQ option
        webDriver.findElement(By.cssSelector("[class='lp-about'] [class='lp-about-dd'][href='/us/faq']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/us/faq");

        //Testimonials option
        webDriver.findElement(By.cssSelector("[class='lp-about'][class='lp-about-dd'] [href='/us/testimonials']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/us/testimonials");

        //Contact Us option
        webDriver.findElement(By.cssSelector("[class='lp-about'] [class='lp-about-dd'] [href='/us/contact']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/us/contact");
*/

        //Pricing button
        webDriver.get("https://staging.lessonplanet.com");
        webDriver.findElement(By.cssSelector("[class='lp-nav-menu'] [class='lp-pricing'] [href='/pricing']")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://staging.lessonplanet.com/pricing");

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
