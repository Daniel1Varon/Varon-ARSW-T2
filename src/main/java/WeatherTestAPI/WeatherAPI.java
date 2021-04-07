package WeatherTestAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Daniel Varón
 */
@SpringBootApplication
@ComponentScan(basePackages = {"WeatherTestAPI"})
public class WeatherAPI {
    public static void main(String[] args) {
        SpringApplication.run(WeatherAPI.class, args);
    }
}
