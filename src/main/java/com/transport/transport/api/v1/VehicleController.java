package com.transport.transport.api.v1;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.transport.transport.model.User;
import com.transport.transport.model.Vehicle;
import com.transport.transport.service.VehicleService;

public class VehicleController {
	private final VehicleService vehicleService;
	@Autowired
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@PostMapping
	public void add(@Valid @NotNull @RequestBody Vehicle vehicle) {
		vehicleService.add(vehicle);
	}
	@GetMapping
	public List<Vehicle> getAll() {
		return vehicleService.getAll();
	}

	@GetMapping(path = "{id}")
	public Vehicle getById(@PathVariable("id") UUID id) {
		return vehicleService.getById(id).orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public void delete(@PathVariable("id") UUID id) {
		vehicleService.delete(id);
	}

	@PutMapping(path = "{id}")
	public void update(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Vehicle user) {
		vehicleService.update(id, user);
	}
}
