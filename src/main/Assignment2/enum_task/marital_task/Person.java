package enum_task.marital_task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class Person {

    private MaritalStatus status;
    private int age;

    private String name;
    private String surname;

    public Person(int status, int age, String name, String surname) {
        this.status = MaritalStatus.findByCode(status);
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
    @Override
    public String toString(){
        return getName() + " " + getSurname() + " age: " + getAge() + ", " + getStatus();
    }
}