package lection16_lambdas;

import java.util.Map;

@FunctionalInterface
public interface StringMapValidator {
    int sumKey(Map<String, Integer> map);
}
