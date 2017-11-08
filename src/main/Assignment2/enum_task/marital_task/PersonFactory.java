package enum_task.marital_task;

import org.fluttercode.datafactory.impl.DataFactory;

public class PersonFactory {

    public Person getPerson() {
        DataFactory dataFactory = new DataFactory();
        int code = dataFactory.getNumberBetween(1, 4);
        int age = dataFactory.getNumberBetween(0, 120);
        String name = dataFactory.getFirstName();
        String surname = dataFactory.getLastName();
        return new Person(code, age, name, surname);
    }

    public void savePerson(Person person) {
        System.out.println("save called");
    }
}