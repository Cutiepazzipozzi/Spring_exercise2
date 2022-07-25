package Spring2.exercise.controller;

import Spring2.exercise.order.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class MemberForm {
    private String name;
    private Long id;
    private Address address;
}

