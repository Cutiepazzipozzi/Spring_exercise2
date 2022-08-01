package Spring2.exercise.controller;

import Spring2.exercise.product.Product;
import Spring2.exercise.product.ProductRepository;
import Spring2.exercise.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products/join")
    public String join(Model model) {
        model.addAttribute("form", new ProductForm());
        //아 이게 다 수정될 수 있어서 원래 정보들을 넣어줘야하는 건가보다
        return "products/joinProduct";
    }

    @PostMapping("/products/join")
    public String enroll(ProductForm form) {
        Product product = new Product();

        product.setProductName(form.getProductName());
        product.setProductPrice(form.getProductPrice());
        product.setStockQuantity(form.getStockQuantity());
        product.setKind(form.getKind());

        productService.save(product);

        return "redirect:/";
    }

    @GetMapping("/products/list")
    public String list(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products/productList";
    }

    //이게 쌉 어려워보임,,, 보엥
    @GetMapping("/products/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        //PathVariable은 인자로 넣는 변수를 주소에 넣을 때 사용된다
        //수정할 칸에 원래의 값을 쓰기 위해 model을 사용하는게 좋을듯
        Product product = productService.findOne(id);

        ProductForm form = new ProductForm();

        form.setId(product.getId());
        form.setProductName(product.getProductName());
        form.setStockQuantity(product.getStockQuantity());
        form.setProductPrice(product.getProductPrice());
        form.setKind(product.getKind());

        model.addAttribute("form", form);

        return "products/editProduct";
    }

    //여기가 좀 궁금하다 id는 이제 여기 인자로 받지 않는데
    //폼에서 받아와서 id가 보관되는 건지 싶다
    @PostMapping("/products/{id}/edit")
    public String edit2(ProductForm form) {
        //ModelAttribute가 붙으면 객체를 자동으로 생성해준다
        //는 bean 클래스라야 한다

        productService.update(form.getId(), form.getProductName(), form.getProductPrice(),
                form.getStockQuantity(), form.getKind());

        //@PathVariable("id") Long productId,

        return "redirect:/";
    }
}

