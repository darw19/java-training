package factory_task;

import lombok.SneakyThrows;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private RandomIntConfigurator configurator;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        configurator = new RandomIntConfigurator();
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type){
        if (type.isInterface()) {
            type = config.getImpl(type);
        }
        T o = type.newInstance();
        configurator.configure(type, o);

        return o;
    }
}

