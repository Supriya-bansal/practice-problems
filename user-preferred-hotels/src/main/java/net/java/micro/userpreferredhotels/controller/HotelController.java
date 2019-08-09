package net.java.micro.userpreferredhotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.java.micro.userpreferredhotels.constants.HotelConstants;
import net.java.micro.userpreferredhotels.models.Hotel;
import net.java.micro.userpreferredhotels.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	HotelService service;

	@RequestMapping("/{userId}")
	public List<Hotel> getHotelsCheckedByUser(@PathVariable("userId") Long userId){
		return service.processInputFile(HotelConstants.HOTEL_CLICKS_FILE_NAME,userId);
	}
		
 }
