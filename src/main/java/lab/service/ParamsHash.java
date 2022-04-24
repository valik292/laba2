package lab.service;

import lab.models.Calculation;
import lab.models.Parameters;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParamsHash {
    private final HashMap<Parameters, Calculation> hashMap = new LinkedHashMap<>();
    public boolean findByKey(Parameters key) {
        return hashMap.containsKey(key);
    }

    public void addToMap(Parameters key, Calculation result) { hashMap.put(key, result); }

    public Calculation getParameters(Parameters key) {
        return hashMap.get(key);
    }

    public Map<Parameters, Calculation> getParametersHashMap() {
        return hashMap;
    }
}
