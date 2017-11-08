package factory_task;

import org.fluttercode.datafactory.impl.DataFactory;
import java.lang.reflect.Field;
import lombok.SneakyThrows;


public class RandomIntConfigurator  {

    @SneakyThrows
    public <T> T configure(Class<T> type, T o) {

        Field[] fields = type.getDeclaredFields();
        DataFactory dataFactory = new DataFactory();


        for (java.lang.reflect.Field field : fields) {

                InjectRandomInt annot = field.getAnnotation(InjectRandomInt.class);
                int min = annot.min();
                int max = annot.max();
                int rand = dataFactory.getNumberBetween(min, max);

                field.setAccessible(true);
                field.set(o, rand);
        }

        return o;
    }
}
