/*
 * Copyright (c) 2009-$today.year Ericsson Mobile Financial Services AB, Sweden. All rights reserved.
 *
 * The Copyright to the computer program(s) herein is the property of Ericsson Mobile Financial
 * Services AB, Sweden. The program(s) may be used and/or copied with the written permission from
 * Ericsson Mobile Financial Services AB or in accordance with the terms and conditions stipulated
 * in the agreement/contract under which the program(s) have been supplied.
 *
 */
package com.transport.transport.api.user.v1;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.transport.transport.model.user.User;
import com.transport.transport.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

	@PostMapping
	public void add(@Valid @NotNull @RequestBody User user) {
		userService.add(user);
	}
	@GetMapping
	public List<User> getAll() {
		return userService.getAll();
	}

  @GetMapping(path = "{id}")
  public User getById(@PathVariable("id") UUID id) {
    return userService.getById(id).orElse(null);
  }

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable("id") UUID id) {
		userService.delete(id);
	}

	@PutMapping(path = "{id}")
	public void update(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody User user) {
		userService.update(id, user);
	}
}
