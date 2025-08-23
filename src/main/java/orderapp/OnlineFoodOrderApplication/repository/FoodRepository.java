package orderapp.OnlineFoodOrderApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orderapp.OnlineFoodOrderApplication.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

	

}
