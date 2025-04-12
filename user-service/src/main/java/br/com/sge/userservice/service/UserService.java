package br.com.sge.userservice.service;

import br.com.sge.userservice.domain.User;
import br.com.sge.userservice.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public List<User> index() {
    return repository.findAll();
  }
}
