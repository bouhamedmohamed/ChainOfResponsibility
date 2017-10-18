import java.util.HashMap;
import java.util.Map;

public interface DispenseChain {

    Map<String, Integer> dispencePices = new HashMap<>();

    default void addToDispenser(String key, Integer value) {
        dispencePices.put(key, value);
    }

    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}