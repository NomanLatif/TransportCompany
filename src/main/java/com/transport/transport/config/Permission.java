/*
 * Copyright (c) 2009-$today.year Ericsson Mobile Financial Services AB, Sweden. All rights reserved.
 *
 * The Copyright to the computer program(s) herein is the property of Ericsson Mobile Financial
 * Services AB, Sweden. The program(s) may be used and/or copied with the written permission from
 * Ericsson Mobile Financial Services AB or in accordance with the terms and conditions stipulated
 * in the agreement/contract under which the program(s) have been supplied.
 *
 */package com.transport.transport.config;
public enum Permission {
	USER_CREATE("user:create"),
	USER_UPDATE("user:update"),
	USER_DELETE("user:delete"),
	USER_READ("user:read"),
	VEHICLE_CREATE("vehicle:create"),
	VEHICLE_UPDATE("vehicle:update"),
	VEHICLE_DELETE("vehicle:delete"),
	VEHICLE_READ("vehicle:read"),
	;

	private final String myPermission;

	Permission(String permission) {
		this.myPermission = permission;

	}
}
