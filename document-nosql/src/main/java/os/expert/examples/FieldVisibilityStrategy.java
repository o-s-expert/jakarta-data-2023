package os.expert.examples;

import jakarta.json.bind.annotation.JsonbVisibility;
import jakarta.json.bind.config.PropertyVisibilityStrategy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@JsonbVisibility(FieldVisibilityStrategy.class)
public class FieldVisibilityStrategy implements PropertyVisibilityStrategy {
    @Override
    public boolean isVisible(Field field) {
        return true;
    }

    @Override
    public boolean isVisible(Method method) {
        return true;
    }
}
