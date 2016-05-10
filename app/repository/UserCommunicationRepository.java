package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.UserCommunication;

@Repository
public interface UserCommunicationRepository extends JpaRepository<UserCommunication, Long>{

}
