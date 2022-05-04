/*
 * Copyright (c) 2009-$today.year Ericsson Mobile Financial Services AB, Sweden. All rights reserved.
 *
 * The Copyright to the computer program(s) herein is the property of Ericsson Mobile Financial
 * Services AB, Sweden. The program(s) may be used and/or copied with the written permission from
 * Ericsson Mobile Financial Services AB or in accordance with the terms and conditions stipulated
 * in the agreement/contract under which the program(s) have been supplied.
 *
 */
package com.transport.transport.model.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.transport.transport.model.User;

public class UserTests {

  public static final String NOMAN = "Noman";
  public static final String NOMAN_EMIAL = "noman@noman.com";

  @Test
  public void testCanCreateUser() {
    User user = User.builder().id(1L).name(NOMAN).email(NOMAN_EMIAL).build();

    assertThat(user.getId()).isEqualTo(1L);
    assertThat(user.getName()).isEqualTo(NOMAN);
    assertThat(user.getEmail()).isEqualTo(NOMAN_EMIAL);
  }

}
