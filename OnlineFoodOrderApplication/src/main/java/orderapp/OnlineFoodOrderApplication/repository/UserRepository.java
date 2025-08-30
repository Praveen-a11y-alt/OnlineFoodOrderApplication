package orderapp.OnlineFoodOrderApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import orderapp.OnlineFoodOrderApplication.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
