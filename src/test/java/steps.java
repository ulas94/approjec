import org.openqa.selenium.WebDriver;


public class steps {
    public WebDriver driver;

        public steps() {
        }

        @steps ("3 samiye bekle")
        public void waitForSecond() throws InterruptedException {
            Thread.sleep(5000L);
        }

        @steps("adresine git")
        public void getUrl() {
            this.driver.get("https://www.ozdilek.com.tr/");

        }steps("uygulamayı kontrol et")
        public void CheckApp throws InterruptedException {
         logger.info("uygulamayı kontrol et");
       

    }

    }

