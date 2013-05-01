package net.slipp.user;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import net.slipp.qna.IndexPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		assertThat(driver.getTitle(), is("로그인 :: SLiPP"));
	}

	public FacebookPage loginFacebook() {
		driver.findElement(By.cssSelector("input[value='페이스북 계정으로 로그인']")).click();
		if (driver.getTitle().equals("SLiPP")) {
			
		}
		
		return new FacebookPage(driver);
	}

	public IndexPage loginSlipp(final String userName) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.cssSelector(".btn-success")).click();
		return new IndexPage(driver);
	}

    public IndexPage join(String userId, String nickName, String email) {
        driver.findElement(By.id("userId")).clear();
        driver.findElement(By.id("userId")).sendKeys(userId); 
        driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys(nickName);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.cssSelector(".btn-submit")).click();
        return new IndexPage(driver);
        
    }
}
