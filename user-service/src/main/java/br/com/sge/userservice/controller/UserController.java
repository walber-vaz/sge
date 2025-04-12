package br.com.sge.userservice.controller;

import br.com.sge.userservice.dto.response.UserGetResponse;
import br.com.sge.userservice.mapper.UserMapper;
import br.com.sge.userservice.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
  private final UserService service;
  private final UserMapper mapper;

  @GetMapping
  public ResponseEntity<List<UserGetResponse>> index() {
    log.info("Request to get all users");

    var users = service.index();

    var response = mapper.toUserGetResponseList(users);

    return ResponseEntity.ok(response);
  }
}
