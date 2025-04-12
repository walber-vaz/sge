package br.com.sge.userservice.mapper;

import br.com.sge.userservice.domain.User;
import br.com.sge.userservice.dto.request.UserCreateRequest;
import br.com.sge.userservice.dto.request.UserUpdateRequest;
import br.com.sge.userservice.dto.response.UserGetResponse;
import br.com.sge.userservice.dto.response.UserResponsePost;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {

  User toUser(UserCreateRequest userCreateRequest);

  UserResponsePost toUserResponsePost(User user);

  User toUser(UserUpdateRequest userUpdateRequest);

  List<UserGetResponse> toUserGetResponseList(List<User> users);
}
