/*
 * Copyright (c) 2009-$today.year Ericsson Mobile Financial Services AB, Sweden. All rights reserved.
 *
 * The Copyright to the computer program(s) herein is the property of Ericsson Mobile Financial
 * Services AB, Sweden. The program(s) may be used and/or copied with the written permission from
 * Ericsson Mobile Financial Services AB or in accordance with the terms and conditions stipulated
 * in the agreement/contract under which the program(s) have been supplied.
 *
 */
package com.transport.transport.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.transport.transport.dao.user.UserDao;
import com.transport.transport.dao.vehicle.VehicleDao;
import com.transport.transport.model.User;
import com.transport.transport.model.Vehicle;

@Service
public class VehicleService {
  private final VehicleDao vehicleDao;

  @Autowired
  public VehicleService(@Qualifier("fakevehicle") VehicleDao vehicleDao) {
    this.vehicleDao = vehicleDao;
  }

  public Optional<Vehicle> getById(UUID id) {
    return vehicleDao.getById(id);
  }

	public int add(Vehicle vehicle) {
		return vehicleDao.add(vehicle);
	}

	public List<Vehicle> getAll() {
		return vehicleDao.getAll();
	}

	public int delete(UUID id) {
		return vehicleDao.delete(id);
	}

	public void update(UUID id, Vehicle vehicle) {
		vehicleDao.update(id,vehicle);
	}
}
