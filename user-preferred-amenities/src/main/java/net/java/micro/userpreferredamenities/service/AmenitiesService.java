package net.java.micro.userpreferredamenities.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import net.java.micro.userpreferredamenities.constants.AmenityConstants;
import net.java.micro.userpreferredamenities.models.Amenity;

@Service
public class AmenitiesService {

	public List<Amenity> processInputFile(String fileName, Long userId) {
		ClassPathResource resource = new ClassPathResource(fileName);
		List<Amenity> inputList = new ArrayList<Amenity>();
		try (InputStream inputFS = resource.getInputStream()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

			inputList = br.lines().map(mapToItem).filter(amenity -> amenity.getUserId().equals(userId))
					.collect(Collectors.toList());//
			br.close();
		} catch (IOException ioex) {
			System.out.println(AmenityConstants.EXCEPTION_FILE_NOT_FOUND_MESSAGE);
		}
		return inputList;
	}

	private Function<String, Amenity> mapToItem = (line) -> {
		String[] p = line.split(AmenityConstants.COMMA);
		Amenity amenity = new Amenity();
		amenity.setTimestamp(Integer.valueOf(p[0]));
		amenity.setUserId(Long.valueOf(p[1]));
		amenity.setAmenityId(Integer.valueOf(p[2]));
		return amenity;
	};

}
