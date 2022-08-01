package Spring2.exercise.product;

import Spring2.exercise.member.Member;
import Spring2.exercise.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

    public void save(Product product) {
        if(product.getId() == null) {
            em.persist(product);
        }
        else {
            em.merge(product);
            //잇츠 라잌 수정 시 업데이트 하는 듯한
        }
    }

    public List<Product> findAll() {
        return em.createQuery("select p from Product as p", Product.class)
                .getResultList();
    }

    public Product findOne(Long id) {
        return em.find(Product.class, id);
    }

    public Product findByName(String name) {
        return em.createQuery(
                "SELECT p from Product p WHERE p.name = :name", Product.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
