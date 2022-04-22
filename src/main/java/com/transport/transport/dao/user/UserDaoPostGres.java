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
import org.springframework.stereotype.Repository;

@Repository("postgres")
public class UserDaoPostGres implements UserDao {

  @Override
  public int add(User user) {
    return 0;
  }

  @Override
  public List<User> getAll() {
    return null;
  }

  @Override
  public Optional<User> getById(Long id) {
    return Optional.empty();
  }

  @Override
  public int update(Long id, User user) {
    return 0;
  }

  @Override
  public int delete(Long id) {
    return 0;
  }
}
