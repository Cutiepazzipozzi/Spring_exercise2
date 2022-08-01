package Spring2.exercise.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(Long id) {
        return productRepository.findOne(id);
    }

    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Transactional
    public void update(Long id, String name, int price, int quantity, OrderProduct kind) {
        Product product = productRepository.findOne(id);
        product.setProductName(name);
        product.setProductPrice(price);
        product.setStockQuantity(quantity);
        product.setKind(kind);
    }

}
