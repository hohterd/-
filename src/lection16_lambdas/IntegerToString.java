package lection16_lambdas;

import java.util.List;

@FunctionalInterface
public interface IntegerToString {
    StringBuilder concat(List<Integer> list);
}
