//package Spring2.exercise.controller;
//
//import Spring2.exercise.product.Product;
//import Spring2.exercise.product.ProductRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Controller
//public class ProductController {
//
//    AppConfig appConfig = new AppConfig();
//    ProductRepository productRepository = appConfig.productRepository();
//
//    @GetMapping("/products/join")
//    public String join() {
//        return "products/joinProduct";
//    }
//
//    @PostMapping("/products/join")
//    public String enroll(ProductForm form) {
//        Product product = new Product(form.getProductName(), form.getProductPrice(), form.getProductNumber(), form.getKind());
//        product.setProductName(form.getProductName());
//        product.setProductNumber(form.getProductNumber());
//        product.setProductPrice(form.getProductPrice());
//        product.setKind(form.getKind());
//
//        productRepository.save(product);
//
//        return "redirect:/";
//    }
//
//    @GetMapping("/products/list")
//    public String list(Model model) {
//        List<Product> products = productRepository.findAll();
//        model.addAttribute("products", products);
//        return "products/productList";
//    }
//
//    @PostMapping("/products/edit")
//    public String edit(ProductForm form) {
//        //product.change를 쓰는게 좋을 거 같은뎅
//        //수정할 칸에 원래의 값을 쓰기 위해 model을 사용하는게 좋을듯
//        Product product = new Product(form.getProductName(), form.getProductPrice(), form.getProductNumber(), form.getKind());
//        product.setProductName(form.getProductName());
//        product.setProductNumber(form.getProductNumber());
//        product.setProductPrice(form.getProductPrice());
//        product.setKind(form.getKind());
//
//        productRepository.save(product);
//
//        return "redirect:/products/list";
//    }
//
//}
//
