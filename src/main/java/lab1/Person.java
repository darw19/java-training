package lab1;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable{

    @Setter
    private String name;

    @Getter
    private transient int age;
    private String family;


}
