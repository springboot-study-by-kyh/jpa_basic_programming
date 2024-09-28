package hello.jpa;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Getter
@Setter
@Entity
public class Member {

    @Id // PK
    private Long id;
    private String name;

}
