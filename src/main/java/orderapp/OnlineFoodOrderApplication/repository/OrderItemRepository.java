package orderapp.OnlineFoodOrderApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orderapp.OnlineFoodOrderApplication.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
