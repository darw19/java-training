package enum_task.marital_task;

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