package orderapp.OnlineFoodOrderApplication.service.implimentation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import orderapp.OnlineFoodOrderApplication.entity.Food;
import orderapp.OnlineFoodOrderApplication.entity.Restaurant;
import orderapp.OnlineFoodOrderApplication.repository.FoodRepository;
import orderapp.OnlineFoodOrderApplication.repository.RestaurantRepository;
import orderapp.OnlineFoodOrderApplication.service.FoodService;

@Service
public class FoodServiceImplementation implements FoodService{
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Food createFood(Food food) {	
		return foodRepository.save(food);
	}

	@Override
	public Food getFoodById(Integer id) {
		Optional<Food> response = foodRepository.findById(id);
		if(response.isPresent()) {
			return response.get();
		}
		throw new NoSuchElementException("Food with ID: "+id+" does not exist");
	}

	@Override
	public Page<Food> getAllFood(Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return foodRepository.findAll(pageable);
	}

	@Override
	public Food updateFood(Food food, Integer id) {
		Food existing = getFoodById(id);
		existing.setDescription(food.getDescription());
		existing.setName(food.getName());
		existing.setPrice(food.getPrice());
		return foodRepository.save(existing);
	}

	@Override
	public void deleteFood(Integer id) {
		Food food = getFoodById(id);
		List<Restaurant> restaurants = food.getRestaurants();
		if(restaurants.size()==0) {
			foodRepository.delete(food);
			return;
		}
		for(Restaurant restaurant : restaurants) {
			restaurant.getFood().remove(food);
		}
		restaurantRepository.saveAll(restaurants);
		foodRepository.delete(food);
	}

}