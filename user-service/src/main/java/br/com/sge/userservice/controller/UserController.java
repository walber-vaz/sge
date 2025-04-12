package br.com.sge.userservice.controller;

import br.com.sge.userservice.dto.request.UserCreateRequest;
import br.com.sge.userservice.dto.response.UserGetResponse;
import br.com.sge.userservice.dto.response.UserResponsePost;
import br.com.sge.userservice.mapper.UserMapper;
import br.com.sge.userservice.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping
  public ResponseEntity<UserResponsePost> create(@RequestBody @Valid UserCreateRequest request) {
    log.info("Request to create user: {}", request);

    var user = mapper.toUser(request);

    var userSaved = service.store(user);

    var response = mapper.toUserResponsePost(userSaved);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
