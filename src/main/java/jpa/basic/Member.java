package jpa.basic;

import javax.persistence.*;

@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") // 필드와 매핑할 컬럼
    private String username;

    // 기간 Period
    @Embedded // 값 타입을 사용하는 곳에 표시
    private Period period;

    // 주소 Address
    @Embedded // 값 타입을 사용하는 곳에 표
    private Address homeAddress;

//    @Embedded // 하나의 Entity에서 중복값이 있을 경우 @AttributeOverrides, @AttributeOverride
//    @AttributeOverrides({
//        @AttributeOverride(name = "city", column = @Column(name = "WORK_CITY")),
//        @AttributeOverride(name = "street", column = @Column(name = "WORK_STREET")),
//        @AttributeOverride(name = "zipcode", column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
