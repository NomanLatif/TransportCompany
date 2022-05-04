package com.transport.transport.dao.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.transport.transport.model.Vehicle;

@Repository("fakevehicle")
public class VehicleDaoFake implements VehicleDao {

  List<Vehicle> vehicles = new ArrayList<>();

  @Override
  public int add(Vehicle vehicle) {
    Vehicle newVehicle = Vehicle.createNewFrom(vehicle);
    vehicles.add(newVehicle);
    return 1;
  }

  @Override
  public List<Vehicle> getAll() {
		return new ArrayList<>(vehicles);
	}

	@Override
	public Optional<Vehicle> getById(UUID id) {
		return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
	}

	@Override
	public int update(UUID id, Vehicle newVehicle) {
    return getById(id)
        .map(
            vehicle -> {
              int indexOfPersonToUpdate = vehicles.indexOf(vehicle);
              if (indexOfPersonToUpdate >= 0) {
                vehicle.setDescription(newVehicle.getDescription());
                vehicle.setType(newVehicle.getType());
                vehicle.setRegistrationNumber(newVehicle.getRegistrationNumber());
                return 1;
              }
              return 0;
            })
        .orElse(0);
	}

	@Override
	public int delete(UUID id) {
		Optional<Vehicle> vehicleOptional = getById(id);
		if(vehicleOptional.isEmpty()) {
			return 0;
		}
		vehicles.remove(vehicleOptional.get());
		return 1;
	}
}
