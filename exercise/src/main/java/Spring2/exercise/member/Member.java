package Spring2.exercise.member;

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

    private String city;

    private int distance;


 }
