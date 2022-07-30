package Spring2.exercise.controller;

import Spring2.exercise.member.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {
    private Long id;
    private Member member;
    //여기서 id도 입력받아야 하는데 어떡하지??
    private String pName;
    private int pNumber;
}
