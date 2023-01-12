package jpa.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.util.concurrent.locks.Lock;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") // 필드와 매핑할 컬럼
    private String username;

    @ManyToOne // 하나의 팀에 여러개의 멤버가 소속됨. (다인 쪽이 연관관계의 주인이 됨. 다대향, DB입장에서 외래키가 있는곳이 무조건 '다' 임.)
    @JoinColumn(name = "TEAM_ID") // FK를 관리함.
    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
