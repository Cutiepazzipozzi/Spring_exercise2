package Spring2.exercise.controller;

import Spring2.exercise.member.Member;
import Spring2.exercise.product.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderForm {
    private Member member;
    private Product product;
    private int pNumber;
}
