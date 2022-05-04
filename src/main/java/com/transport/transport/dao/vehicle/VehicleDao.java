package com.transport.transport.dao.vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.transport.transport.model.User;
import com.transport.transport.model.Vehicle;

public interface VehicleDao {
  int add(Vehicle user);

	List<Vehicle> getAll();

  Optional<Vehicle> getById(UUID id);

  int update(UUID id, Vehicle user);

  int delete(UUID id);
}
