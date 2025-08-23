package orderapp.OnlineFoodOrderApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orderapp.OnlineFoodOrderApplication.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	

}
