package br.com.sge.userservice.mapper;

import br.com.sge.userservice.domain.User;
import br.com.sge.userservice.dto.response.UserGetResponse;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper {
  List<UserGetResponse> toUserGetResponseList(List<User> users);
}
