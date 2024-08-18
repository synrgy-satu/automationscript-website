package Selenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"}, // Path ke folder features Anda
        glue = {"Selenium.stepdef"}, // Package yang berisi step definitions
        plugin = {
                "pretty", // Menampilkan output yang lebih mudah dibaca di console
                "html:target/cucumber-reports/cucumber.html", // Laporan dalam format HTML
                "json:target/cucumber-reports/cucumber.json", // Laporan dalam format JSON
                "junit:target/cucumber-reports/cucumber.xml"  // Laporan dalam format XML (bisa digunakan di Jenkins atau CI lainnya)
        },
        monochrome = true // Menampilkan output tanpa karakter warna yang bisa mempersulit pembacaan log
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}