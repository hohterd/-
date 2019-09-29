package lection16_lambdas;

import java.util.List;

@FunctionalInterface
public interface StringValidator {
    int checkString(List<String> list);
}
