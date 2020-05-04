package be.adrienhelin.project.domain.orders;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

    List<Order> findAll();

    List<Order> findAllById(Integer id);

}
