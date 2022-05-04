package com.transport.transport.config;

import static com.transport.transport.config.Permission.USER_CREATE;
import static com.transport.transport.config.Permission.USER_DELETE;
import static com.transport.transport.config.Permission.USER_READ;
import static com.transport.transport.config.Permission.USER_UPDATE;
import static com.transport.transport.config.Permission.VEHICLE_CREATE;
import static com.transport.transport.config.Permission.VEHICLE_DELETE;
import static com.transport.transport.config.Permission.VEHICLE_READ;
import static com.transport.transport.config.Permission.VEHICLE_UPDATE;

import java.util.HashSet;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.common.collect.Sets;

public enum Role {
  ADMIN(Sets.newHashSet(USER_CREATE, USER_DELETE, USER_READ, USER_UPDATE, VEHICLE_CREATE, VEHICLE_DELETE, VEHICLE_READ, VEHICLE_UPDATE)),
	NORMAL(Sets.newHashSet(VEHICLE_READ, USER_READ));

	private final HashSet<Permission> myPermissions;

	<E extends @Nullable Object> Role(HashSet<Permission> permissions) {
		myPermissions= permissions;
	}

	HashSet<Permission> getPermissions() {
		return myPermissions;
	}
}
