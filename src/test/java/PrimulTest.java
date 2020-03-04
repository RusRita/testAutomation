import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PrimulTest {

    public static final String URL_HOMEPAGE = "https://staging.lessonplanet.com";
    public static final String URL_HOMEPAGE2 = "https://staging.lessonplanet.com/";
    public static final String URL_SIGNIN = "https://staging.lessonplanet.com/auth/users/sign_in";
    public static final String URL_NEW_SUBSCRIPTION = "https://staging.lessonplanet.com/subscription/new";
    public static final String INVALID_LOGIN_TEXT = "Invalid login or password.";
    public static final String INVALID_EMAIL = "blabla@test.com";
    public static final String INVALID_PASSWORD = "blablablaaaaaaaaaa--79*";
    public static final String VALID_EMAIL = "ritatest@test.com";
    public static final String VALID_PASSWORD = "hello123844";
    public static final String SIGN_IN_MODAL_TEXT = "Sign in to Lesson Planet";
    public static final String STEP1_MODAL_TEXT = "Discover 350k+ Teacher Reviewed Resources";
    public static final String STEP1_MODAL_EMAIL = "rita104@lp.com";
    public static final String STEP1_MODAL_PASSWORD = "test1234";
    public static final String STEP2_MODAL_TEXT = "Select Your Membership";
    public static final String STEP1_STATIC_TEXT = "Ready to start your Free 10 Days?";
    public static final String STEP1_STATIC_EMAIL = "rita122@yahoo.com";
    public static final String STEP1_STATIC_PASSWORD = "test1234";
    public static final String URL_SEARCH = "https://staging.lessonplanet.com/search";
    public static final String URL_DIRECTORY = "https://staging.lessonplanet.com/lesson-plans";
    public static final String URL_ARTICLES = "https://staging.lessonplanet.com/articles";
    public static final String URL_CALENDAR = "https://staging.lessonplanet.com/calendar";
    public static final String URL_EDUCATOR_EDITION = "https://staging.lessonplanet.com/educator-edition";
    public static final String URL_LEARNING_EXPLORER = "https://www.learningexplorer.com/";
    public static final String URL_PDLN = "https://staging.lessonplanet.com/pdln";
    public static final String URL_PRICING = "https://staging.lessonplanet.com/pricing";
    public static final String URL_ABOUT_US = "https://staging.lessonplanet.com/us/about_us";
    public static final String URL_FAQ = "https://staging.lessonplanet.com/us/faq";
    public static final String URL_TESTIMONIALS = "https://staging.lessonplanet.com/us/testimonials";
    public static final String URL_CONTACT_US = "https://staging.lessonplanet.com/us/contact";
    public static final String KEYWORDS_SEARCH_BOX = "Water cycle";
    public static final String URL_KEYWORDS = "keywords=Water+cycle";
    public static final String SEARCH_BOX_PLACEHOLDER_TEXT = "Search educational resources";
    public static final String SEARCH_HEADING_WE_FOUND_TEXT ="We found";
    public static final String SEARCH_HEADING_REVIEWED_RESOURCES_TEXT ="reviewed resources for";
    public static final String SEARCH_HEADING_SHOWING_ALL_RESOURCES_TEXT ="Showing all reviewed resources";

    public static final String USERNAME_INPUT = "#user_login";
    public static final String PASSWORD_INPUT = "#user_password";
    public static final String SIGN_IN_BUTTON = "[class*='btn-action']";
    public static final String INVALID_LOGIN_NOTIFICATION = "#content-header";
    public static final String TRY_IT_FREE_BUTTON = "[class='lp-try-it-free']";
    public static final String STEP1_MODAL_TITLE = "[class='modal-header'] [class='title']";
    public static final String EMAIL_INPUT = "#user_email";
    public static final String GET_STARTED_TODAY_BUTTON = "#submit-signup";
    public static final String STEP2_MODAL_TITLE = "[class='modal-header text-center']";
    public static final String CLOSE_BUTTON = "[class*='close']";  //"[class='button close']"
    public static final String STEP1_STATIC_TITLE = "[class='panel-title']";
    public static final String STEP1_STATIC_EMAIL_INPUT = "[class*='email required user_email'] #user_email"; //"[class='form-group email required user_email'] #user_email";
    public static final String STEP1_STATIC_PASSWORD_INPUT = "[class*='password optional user_password'] #user_password"; //"[class='form-group password optional user_password'] #user_password";
    public static final String GET_FREE_TRIAL_BUTTON = "#qa";
    public static final String DISCOVER_DROP_DOWN = "[class='lp-resources']";
    public static final String DISCOVER_RESOURCES_TITLE_LINK = "[class='lp-resources'] [href*='/search'] [class='lp-menu-link-title']";
    public static final String BROWSE_RESOURCE_DIRECTORY_TITLE_LINK = "[class='lp-resources'] [class='lp-resources-dd'] [href*='/lesson-plans']";
    public static final String LEARNING_PLANNING_ARTICLES_TITLE_LINK = "[class='lp-resources'] [class='lp-resources-dd'] [href*='/articles']";
    public static final String CURRICULUM_CALENDAR_TITLE_LINK = "[class='lp-resources'] [class='lp-resources-dd'] [href*='/calendar']";
    public static final String SOLUTIONS_DROP_DOWN = "[class='lp-solutions']";
    public static final String EDUCATOR_EDITION_TITLE_LINK = "[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/educator-edition']";
    public static final String LEARNING_EXPLORER_TITLE_LINK = "[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/learning-explorer']";
    public static final String PDLN_TITLE_LINK = "[class='lp-solutions'] [class='lp-solutions-dd'] [href*='/pdln']";
    public static final String PRICING_BUTTON = "[class='lp-pricing']";
    public static final String SIGN_IN_HEADER_BUTTON = "[class='lp-sign-in']";
    public static final String SIGN_IN_MODAL_TITLE = "[class='modal-header login-box-header'] [class='modal-title']"; //"[class='modal-header login-box-header'] [class='modal-title']";
    public static final String ABOUT_DROP_DOWN = "[class='lp-about']";
    public static final String OUR_STORY_TITLE_LINK = "[class='lp-about'] [href*='/about_us'] [class='lp-menu-link-title']";
    public static final String USER_GUIDE_AND_FAQ_TITLE_LINK = "[class='lp-about'] [href*='/faq'] [class='lp-menu-link-title']";
    public static final String TESTIMONIALS_TITLE_LINK = "[class='lp-about'] [href*='/testimonials'] [class='lp-menu-link-title'] ";
    public static final String CONTACT_US_TITLE_LINK = "[class='lp-about'] [href*='/contact'] [class='lp-menu-link-title']";
    public static final String LOGO = "#logo";
    public static final String SEARCHBOX_INPUT = "#keywords";
    public static final String MAGNIFIER_BUTTON = "[class*='fa-search']";
    public static final String SEARCH_HEADING_TITLE = "#search-heading-row";
    public static final String SEARCH_BOX_X_BUTTON = "[class*='clear-search']";



    private WebDriver webDriver;

    @BeforeTest
    public void initTest() {
        System.setProperty("webdriver.gecko.driver", "C:\\Projects\\drivers\\geckodriver.exe");
        webDriver = new FirefoxDriver();
       webDriver.manage().window().maximize();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
    }

    @Test
    public void invalidAccount() {
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.get(PrimulTest.URL_SIGNIN);
        webDriver.findElement(By.cssSelector(PrimulTest.USERNAME_INPUT)).sendKeys(PrimulTest.INVALID_EMAIL);
        webDriver.findElement(By.cssSelector(PrimulTest.PASSWORD_INPUT)).sendKeys(PrimulTest.INVALID_PASSWORD);
        webDriver.findElement(By.cssSelector(PrimulTest.SIGN_IN_BUTTON)).click();
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.INVALID_LOGIN_NOTIFICATION)).getText(), PrimulTest.INVALID_LOGIN_TEXT);
    }

    @Test
    public void validAccount() {
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.get(PrimulTest.URL_SIGNIN);
        webDriver.findElement(By.cssSelector(PrimulTest.USERNAME_INPUT)).sendKeys(PrimulTest.VALID_EMAIL);
        webDriver.findElement(By.cssSelector(PrimulTest.PASSWORD_INPUT)).sendKeys(PrimulTest.VALID_PASSWORD);
        webDriver.findElement(By.cssSelector(PrimulTest.SIGN_IN_BUTTON)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_HOMEPAGE2);
    }

    @Test
    public void step1Modal() {
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.TRY_IT_FREE_BUTTON)).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.STEP1_MODAL_TITLE)));
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.STEP1_MODAL_TITLE)).getText(), PrimulTest.STEP1_MODAL_TEXT);
        webDriver.findElement(By.cssSelector(PrimulTest.EMAIL_INPUT)).sendKeys(PrimulTest.STEP1_MODAL_EMAIL);
        webDriver.findElement(By.cssSelector(PrimulTest.PASSWORD_INPUT)).sendKeys(PrimulTest.STEP1_MODAL_PASSWORD);
        webDriver.findElement(By.cssSelector(PrimulTest.GET_STARTED_TODAY_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.STEP2_MODAL_TITLE)));
        Assert.assertEquals(webDriver.findElement(By.cssSelector(STEP2_MODAL_TITLE)).getText(), PrimulTest.STEP2_MODAL_TEXT);
        webDriver.findElement(By.cssSelector(PrimulTest.CLOSE_BUTTON)).click();
    }

    @Test
    public void step1Static() {

        webDriver.get(PrimulTest.URL_NEW_SUBSCRIPTION);
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.STEP1_STATIC_TITLE)).getText(), PrimulTest.STEP1_STATIC_TEXT);
        webDriver.findElement(By.cssSelector(PrimulTest.STEP1_STATIC_EMAIL_INPUT)).sendKeys(PrimulTest.STEP1_STATIC_EMAIL);
        webDriver.findElement(By.cssSelector(PrimulTest.STEP1_STATIC_PASSWORD_INPUT)).sendKeys(PrimulTest.STEP1_STATIC_PASSWORD);
        webDriver.findElement(By.cssSelector(PrimulTest.GET_FREE_TRIAL_BUTTON)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_NEW_SUBSCRIPTION);
    }

    @Test
    public void headerDropDowns() {
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        //Discover Resources option
        webDriver.findElement(By.cssSelector(PrimulTest.DISCOVER_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.DISCOVER_RESOURCES_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.DISCOVER_RESOURCES_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_SEARCH);
        //Browse Resource Directory
        webDriver.findElement(By.cssSelector(PrimulTest.DISCOVER_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.BROWSE_RESOURCE_DIRECTORY_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.BROWSE_RESOURCE_DIRECTORY_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_DIRECTORY);
        //Lesson Planning Articles
        webDriver.findElement(By.cssSelector(PrimulTest.DISCOVER_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.LEARNING_PLANNING_ARTICLES_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.LEARNING_PLANNING_ARTICLES_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_ARTICLES);
        //Curriculum Calendar
        webDriver.findElement(By.cssSelector(PrimulTest.DISCOVER_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.CURRICULUM_CALENDAR_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.CURRICULUM_CALENDAR_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_CALENDAR);
        //Educator Edition option
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.SOLUTIONS_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.EDUCATOR_EDITION_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.EDUCATOR_EDITION_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_EDUCATOR_EDITION);
        //Learning Explorer option
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.SOLUTIONS_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.LEARNING_EXPLORER_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.LEARNING_EXPLORER_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_LEARNING_EXPLORER);
        //PD Learning option
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.SOLUTIONS_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.PDLN_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.PDLN_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_PDLN);
        //Our Story option
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.ABOUT_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.OUR_STORY_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.OUR_STORY_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_ABOUT_US);
        //User Guide & FAQ option
        webDriver.findElement(By.cssSelector(PrimulTest.ABOUT_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.USER_GUIDE_AND_FAQ_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.USER_GUIDE_AND_FAQ_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_FAQ);
        //Testimonials option
        webDriver.findElement(By.cssSelector(PrimulTest.ABOUT_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.TESTIMONIALS_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.TESTIMONIALS_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_TESTIMONIALS);
        //Contact Us option
        webDriver.findElement(By.cssSelector(PrimulTest.ABOUT_DROP_DOWN)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PrimulTest.CONTACT_US_TITLE_LINK)));
        webDriver.findElement(By.cssSelector(PrimulTest.CONTACT_US_TITLE_LINK)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_CONTACT_US);
    }

    @Test
    public void headerButtons() {
        //Sign In button
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.SIGN_IN_HEADER_BUTTON)).click();
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PrimulTest.SIGN_IN_MODAL_TITLE)));
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.SIGN_IN_MODAL_TITLE)).getText(), PrimulTest.SIGN_IN_MODAL_TEXT);
        //Try it free button
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PrimulTest.TRY_IT_FREE_BUTTON)));
        webDriver.findElement(By.cssSelector(PrimulTest.TRY_IT_FREE_BUTTON)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PrimulTest.STEP1_MODAL_TITLE)));
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.STEP1_MODAL_TITLE)).getText(), PrimulTest.STEP1_MODAL_TEXT);
        //Pricing button
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.PRICING_BUTTON)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_PRICING);
    }

    @Test
    public void lpLogo() {
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        webDriver.findElement(By.cssSelector(PrimulTest.LOGO)).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_HOMEPAGE2);
    }

    @Test
    public void searchBox() {
        webDriver.get(PrimulTest.URL_HOMEPAGE);
        //verify if search box is displayed
        Assert.assertTrue(webDriver.findElement(By.cssSelector(PrimulTest.SEARCHBOX_INPUT)).isDisplayed());
        //verify if placeholder is displayed in the search box
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.SEARCHBOX_INPUT)).getAttribute("placeholder"), PrimulTest.SEARCH_BOX_PLACEHOLDER_TEXT);
        //verify if magnifier is displayed
        Assert.assertTrue(webDriver.findElement(By.cssSelector(PrimulTest.MAGNIFIER_BUTTON)).isDisplayed());
        //type a keyword in the search field and click search
        webDriver.findElement(By.cssSelector(PrimulTest.SEARCHBOX_INPUT)).sendKeys(PrimulTest.KEYWORDS_SEARCH_BOX);
        webDriver.findElement(By.cssSelector(PrimulTest.MAGNIFIER_BUTTON)).click();
        //verify if the keyword remains in the search bar after pressing Enter
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.SEARCHBOX_INPUT)).getAttribute("value"), PrimulTest.KEYWORDS_SEARCH_BOX);
        //verify if the Text "we found x resources" contains the keyword
        Assert.assertTrue(webDriver.findElement(By.cssSelector(PrimulTest.SEARCH_HEADING_TITLE)).getText().contains(PrimulTest.SEARCH_HEADING_WE_FOUND_TEXT) && webDriver.findElement(By.cssSelector(PrimulTest.SEARCH_HEADING_TITLE)).getText().contains(PrimulTest.SEARCH_HEADING_REVIEWED_RESOURCES_TEXT) && webDriver.findElement(By.cssSelector(PrimulTest.SEARCH_HEADING_TITLE)).getText().contains(PrimulTest.KEYWORDS_SEARCH_BOX));
        //check if the URL contains the keyword
        Assert.assertTrue(webDriver.getCurrentUrl().contains(PrimulTest.URL_KEYWORDS));
        //check if x button in displayed in the searchbox
        Assert.assertTrue(webDriver.findElement(By.cssSelector(PrimulTest.SEARCH_BOX_X_BUTTON)).isDisplayed());
        //Assert.assertTrue(webDriver.findElement(By.cssSelector("[class='lp-header-clear-search']")).isDisplayed())
        //Click the X button from the searchbox
        webDriver.findElement(By.cssSelector(PrimulTest.SEARCH_BOX_X_BUTTON)).click();
        //verify if the keyword was removed after clicking the 'x' button from: URL, search box and text heading
        Assert.assertEquals(webDriver.getCurrentUrl(), PrimulTest.URL_SEARCH);
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.SEARCHBOX_INPUT)).getAttribute("placeholder"), PrimulTest.SEARCH_BOX_PLACEHOLDER_TEXT);
        WebDriverWait wait = new WebDriverWait(webDriver, 15);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(PrimulTest.SEARCH_HEADING_TITLE), PrimulTest.SEARCH_HEADING_SHOWING_ALL_RESOURCES_TEXT));
        Assert.assertEquals(webDriver.findElement(By.cssSelector(PrimulTest.SEARCH_HEADING_TITLE)).getText(), PrimulTest.SEARCH_HEADING_SHOWING_ALL_RESOURCES_TEXT);
    }


    @AfterTest
    public void closeAll() {
        try {
            webDriver.close();
        } catch (Exception ex) {
            ex.toString();
        }
    }
}


