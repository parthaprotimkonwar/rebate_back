package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{

}
