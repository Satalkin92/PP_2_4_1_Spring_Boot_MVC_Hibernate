package spring_mvc_hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_mvc_hibernate.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
