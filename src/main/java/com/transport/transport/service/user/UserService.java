/*
 * Copyright (c) 2009-$today.year Ericsson Mobile Financial Services AB, Sweden. All rights reserved.
 *
 * The Copyright to the computer program(s) herein is the property of Ericsson Mobile Financial
 * Services AB, Sweden. The program(s) may be used and/or copied with the written permission from
 * Ericsson Mobile Financial Services AB or in accordance with the terms and conditions stipulated
 * in the agreement/contract under which the program(s) have been supplied.
 *
 */
package com.transport.transport.service.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.transport.transport.dao.user.UserDao;
import com.transport.transport.model.user.User;

@Service
public class UserService {
  private final UserDao userDao;

  @Autowired
  public UserService(@Qualifier("fake") UserDao userDao) {
    this.userDao = userDao;
  }

  public Optional<User> getById(UUID id) {
    return userDao.getById(id);
  }

	public int add(User user) {
		return userDao.add(user);
	}

	public List<User> getAll() {
		return userDao.getAll();
	}

	public int delete(UUID id) {
		return userDao.delete(id);
	}

	public void update(UUID id, User user) {
		userDao.update(id,user);
	}
}
