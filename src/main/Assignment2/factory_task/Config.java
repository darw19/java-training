package factory_task;

public interface Config {
    <T> Class<T> getImpl(Class<T> ifc);
}
