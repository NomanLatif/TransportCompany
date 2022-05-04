package com.transport.transport.api.v1;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.transport.transport.model.User;
import com.transport.transport.service.UserService;
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
