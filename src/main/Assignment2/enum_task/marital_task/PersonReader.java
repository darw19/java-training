package enum_task.marital_task;

import java.util.ArrayList;
import com.google.common.collect.Iterables;

public class PersonReader {

    private ArrayList<Person> persons;

    public PersonReader() {
        this.persons = new ArrayList<>();
    }

    public void readPerson(Person person_to_read) {
            if (!persons.isEmpty() && person_to_read.equals(Iterables.getLast(persons, null))) {
            System.out.println(person_to_read.getSurname() + " You again??");
        } else {
            System.out.println(person_to_read.toString());
        }
        persons.add(person_to_read);
    }
}