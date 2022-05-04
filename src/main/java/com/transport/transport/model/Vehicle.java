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
public class Vehicle {
  private UUID id;
	private VehicleType type;
  private String registrationNumber;
  private String description;

	public static Vehicle createNewFrom(Vehicle vehicle) {
		UUID id = UUID.randomUUID();
		return Vehicle.builder()
				.id(id)
				.type(vehicle.getType())
				.registrationNumber(vehicle.getRegistrationNumber())
				.description(vehicle.getDescription())
				.build();
	}
}
