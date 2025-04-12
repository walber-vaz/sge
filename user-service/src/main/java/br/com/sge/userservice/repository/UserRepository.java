package br.com.sge.userservice.repository;

import br.com.sge.userservice.domain.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByEmailOrPhone(String email, String phone);
  Optional<User> findByEmailOrPhoneAndId(String email, String phone, UUID id);
}
