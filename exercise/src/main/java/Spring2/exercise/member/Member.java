package Spring2.exercise.member;

import Spring2.exercise.order.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="members")
public class Member {

    private String name;

    @Id
    @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @Embedded
    private Address address;

    public Member(String name, Long id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }
 }
