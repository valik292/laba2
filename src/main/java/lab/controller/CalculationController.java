package lab.controller;

import lab.Exeption.ParamsDoesNotExistException;
import lab.models.Calculation;
import lab.models.Parameters;
import lab.service.CalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CalculationController {
    private static final Logger logger = LogManager.getLogger(CalculationController.class);
    @Autowired
    CalculationService calculationService;

    public CalculationController(CalculationService service){
        this.calculationService = service;
    }
  @GetMapping("/")
    public ResponseEntity getUsers()
    {
        try {
            return ResponseEntity.ok("Сервер Работает");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произашла ошибка!");
        }

    }
    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public ResponseEntity<Calculation> calculateSpeed(@RequestParam(value = "weight1", defaultValue = "0") double w1,
                                                      @RequestParam(value = "speed1", defaultValue = "0") double s1,
                                                      @RequestParam(value = "weight2", defaultValue = "1") double w2,
                                                      @RequestParam(value = "speed2", defaultValue = "1") double s2) {

        System.out.println("1 Weight:" + w1);
        System.out.println("1 Speed:" + s1);
        System.out.println("2 Weight:" + w2);
        System.out.println("2 Speed:" + s2);
        double speed = calculationService.calculateSpeedAfterCollision(new Parameters(new double[]{w1, w2}, new double[]{s1, s2}));
        return new ResponseEntity<>(new Calculation(speed), HttpStatus.OK);
    }
    /*
    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public ResponseEntity<Calculation> Calculation calculateSpeed(@RequestParam(value = "weight1", defaultValue = "0") double w1,
                                                                      @RequestParam(value = "speed1", defaultValue = "0") double s1,
                                                                      @RequestParam(value = "weight2", defaultValue = "1") double w2,
                                                                      @RequestParam(value = "speed2", defaultValue = "1") double s2)
            throws ParamsDoesNotExistException {

        System.out.println("Input 1 Weight:" + w1);
        System.out.println("Input 1 Speed:" + s1);
        System.out.println("Input 2 Weight:" + w2);
        System.out.println("Input 2 Speed:" + s2);
        logger.info("Action with getTriangle mapping.");
        // return calculationService.calculateSpeedAfterCollision(new Parameters(new double[]{w1, w2}, new double[]{s1, s2}));
        return calculationService.calculateSpeedAfterCollision(new Parameters(new double[]{w1, w2}, new double[]{s1, s2}));

        //double speed = calculationService.calculateSpeedAfterCollision(new Parameters(new double[]{w1, w2}, new double[]{s1, s2}));
        //  return new ResponseEntity<>(new Calculation(speed), HttpStatus.OK);
    }*/
    @GetMapping("/cache")
    public Map<Parameters, Calculation> getCache() {
        logger.info("Successfully got triangles from Map");
        return calculationService.getCache();
    }


}