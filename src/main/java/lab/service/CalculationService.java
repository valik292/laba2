package lab.service;

import lab.Exeption.ParamsDoesNotExistException;
import lab.models.Calculation;
import lab.models.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CalculationService {
    private static final Logger logger = LogManager.getLogger(CalculationService.class);

    @Autowired
    private ParamsHash hashMap;

    public double calculateSpeedAfterCollision(Parameters parameters) {

        double[] weights = parameters.getWeights();
        double[] speeds = parameters.getSpeeds();

        Parameters requestParams = new Parameters(weights, speeds);

       /* if (hashMap.findByKey(requestParams)){
            logger.info("get hashMap");

            return hashMap.getParameters(parameters);

        }*/

        if (weights[0] <= 0 || weights[1] <= 0 || speeds[0] <= 0 || speeds[1] <= 0) {
            //System.out.println("Incorrect Input");
            logger.error("Calculating error. Wrong parameters.");
            throw new ParamsDoesNotExistException("Result does not exist");
        }
        double speed = (weights[0] * speeds[0] + weights[1] * speeds[1]) / (weights[0] + weights[1]);
        logger.info("Successful calculations of perimeter and square.");

         hashMap.addToMap(requestParams, new Calculation(speed));
        logger.info("add hashMap");

       // return new Calculation(speed);
        return (weights[0] * speeds[0] + weights[1] * speeds[1]) / (weights[0] + weights[1]);
    }
    public Map<Parameters, Calculation> getCache() {
        return hashMap.getParametersHashMap();
    }
}
