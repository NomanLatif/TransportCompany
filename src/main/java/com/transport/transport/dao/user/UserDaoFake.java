package com.transport.transport.dao.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.transport.transport.model.User;

@Repository("fake")
public class UserDaoFake implements UserDao {

  List<User> users = new ArrayList<>();

  @Override
  public int add(User user) {
    User newUser = User.createNewFrom(user);
    users.add(newUser);
    return 1;
  }

  @Override
  public List<User> getAll() {
		return new ArrayList<>(users);
	}

	@Override
	public Optional<User> getById(UUID id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst();
	}

	@Override
	public int update(UUID id, User newUser) {
		return getById(id).map(user -> {
			int indexOfPersonToUpdate = users.indexOf(user);
			if(indexOfPersonToUpdate >= 0) {
				user.setName(newUser.getName());
				user.setEmail(newUser.getEmail());
				return 1;
			}
			return 0;
		}).orElse(0);
	}

	@Override
	public int delete(UUID id) {

		Optional<User> userOptional = getById(id);
		if(userOptional.isEmpty()) {
			return 0;
		}
		users.remove(userOptional.get());
		return 1;
	}
}
