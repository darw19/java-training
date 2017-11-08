package enum_task.marital_task;

import lombok.SneakyThrows;
import org.fluttercode.datafactory.impl.DataFactory;

/**
 * Created by bolshanetskyi on 04.11.17.
 */
public class Main {

    public static void main(String[] args) {
        PersonFactory factory = new PersonFactory();
        PersonReader personReader = new PersonReader();

        personReader.readPerson(factory.getPerson());
        personReader.readPerson(factory.getPerson());
        personReader.readPerson(factory.getPerson());
        personReader.readPerson(factory.getPerson());
        personReader.readPerson(factory.getPerson());

    }
}