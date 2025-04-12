package br.com.sge.userservice.service;

import br.com.sge.exception.ConflictException;
import br.com.sge.exception.NotFoundException;
import br.com.sge.userservice.domain.User;
import br.com.sge.userservice.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

  private final UserRepository repository;

  public List<User> index() {
    return repository.findAll();
  }

  @Transactional
  public User store(User user) {
    assertEmailOrPhoneExists(user.getEmail(), user.getPhone());
    return repository.save(user);
  }

  @Transactional
  public void update(User user) {
    assertUserExists(user.getId());
    assertUserEmailOrPhoneAndId(user.getId(), user.getEmail(), user.getPhone());
    repository.save(user);
  }

  public void assertUserExists(UUID id) {
    repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
  }

  public void assertUserEmailOrPhoneAndId(UUID id, String email, String phone) {
    repository.findByEmailOrPhoneAndId(email, phone, id)
        .orElseThrow(() -> new NotFoundException("User not found"));
  }

  public void assertEmailOrPhoneExists(String email, String phone) {
    repository.findByEmailOrPhone(email, phone).ifPresent(user -> {
      if (user.getPhone().equals(phone)) {
        log.error("Phone already registered: {}", phone);
        throw new ConflictException("Phone already registered");
      }
      if (user.getEmail().equals(email)) {
        log.error("Email already registered: {}", email);
        throw new ConflictException("Email already registered");
      }
    });
  }
}
