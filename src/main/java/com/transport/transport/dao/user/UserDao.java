package com.transport.transport.dao.user;

import com.transport.transport.model.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
  int add(User user);

	List<User> getAll();

  Optional<User> getById(UUID id);

  int update(UUID id, User user);

  int delete(UUID id);
}
