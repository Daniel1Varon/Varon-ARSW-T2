package WeatherTestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Daniel Varón
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherServices weatherServices;

    /**
     *
     * @param city nombre de la ciudad a consultar
     * @return data de la ciudad.
     */
    @RequestMapping(value = "/{city}", method= RequestMethod.GET)
    public ResponseEntity<?> getWeatherByCity(@PathVariable String city){
        try{
            String data=weatherServices.getWeatherByCity(city);
            return new ResponseEntity<>(data,HttpStatus.OK);
        } catch (Exception e) {
            Logger.getLogger(WeatherAPI.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
