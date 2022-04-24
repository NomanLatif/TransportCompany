/*
 * Copyright (c) 2009-$today.year Ericsson Mobile Financial Services AB, Sweden. All rights reserved.
 *
 * The Copyright to the computer program(s) herein is the property of Ericsson Mobile Financial
 * Services AB, Sweden. The program(s) may be used and/or copied with the written permission from
 * Ericsson Mobile Financial Services AB or in accordance with the terms and conditions stipulated
 * in the agreement/contract under which the program(s) have been supplied.
 *
 */
package com.transport.transport.dao.user;

import com.transport.transport.model.user.User;
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
