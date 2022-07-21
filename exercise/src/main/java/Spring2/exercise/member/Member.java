package Spring2.exercise.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    private String name;
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private int distance;

    public Member(String name, String city, int distance) {
        this.name = name;
        this.city = city;
        this.distance = distance;
    }
 }
