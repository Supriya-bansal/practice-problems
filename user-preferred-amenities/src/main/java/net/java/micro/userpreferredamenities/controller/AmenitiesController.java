package net.java.micro.userpreferredamenities.controller;																											

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.micro.userpreferredamenities.constants.AmenityConstants;
import net.java.micro.userpreferredamenities.models.Amenity;
import net.java.micro.userpreferredamenities.service.AmenitiesService;

@RestController
@RequestMapping("/amenities")
public class AmenitiesController {
	
	@Autowired
	AmenitiesService service;
	
	@RequestMapping("/{userId}")
	public List<Amenity> getAmenitiesForUser(@PathVariable("userId") Long userId){
		
		return service.processInputFile(AmenityConstants.AMENITY_SELECTIONS_FILE_NAME, userId);
	}
	
	
 }
