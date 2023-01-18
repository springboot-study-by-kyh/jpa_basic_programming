package jpa.basic;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") // 일대다 매핑해서 어떤것과 연결 되어있는지 보여주는것.일 (팀 -> 멤버는 일대다, team에 의해서 관리가 되는중.)
    private List<Member> members = new ArrayList<>(); // arrayList 초기화, 값 추가시 null 안뜨도록 해줌. 가짜 매핑역할.

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
