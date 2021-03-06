/*
 * Copyright (c) 2009-$today.year Ericsson Mobile Financial Services AB, Sweden. All rights reserved.
 *
 * The Copyright to the computer program(s) herein is the property of Ericsson Mobile Financial
 * Services AB, Sweden. The program(s) may be used and/or copied with the written permission from
 * Ericsson Mobile Financial Services AB or in accordance with the terms and conditions stipulated
 * in the agreement/contract under which the program(s) have been supplied.
 *
 */
package com.transport.transport.model;

import java.util.UUID;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class User {
  private UUID id;
  private String name;
  private String email;

	public static User createNewFrom(User user) {
		UUID id = UUID.randomUUID();
		return User.builder().id(id).email(user.getEmail()).name(user.getName()).build();
	}
}
