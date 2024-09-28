package hello.jpa;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Member {

    @Id // PK
    private Long id;
    private String name;

}
