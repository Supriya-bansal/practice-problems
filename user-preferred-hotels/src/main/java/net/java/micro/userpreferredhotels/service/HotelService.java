package net.java.micro.userpreferredhotels.service;

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

import net.java.micro.userpreferredhotels.constants.HotelConstants;
import net.java.micro.userpreferredhotels.models.Hotel;

@Service
public class HotelService {

	public List<Hotel> processInputFile(String fileName, Long userId) {
		ClassPathResource resource = new ClassPathResource(fileName);
		List<Hotel> inputList = new ArrayList<Hotel>();
		try (InputStream inputFS = resource.getInputStream()) {

			BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

			inputList = br.lines().map(mapToItem).filter(hotel -> hotel.getUserId().equals(userId))
					.collect(Collectors.toList());
			br.close();
		} catch (IOException ioex) {
			System.out.println(HotelConstants.EXCEPTION_FILE_NOT_FOUND_MESSAGE);
		}
		return inputList;
	}

	private Function<String, Hotel> mapToItem = (line) -> {
		String[] p = line.split(HotelConstants.COMMA);
		Hotel hotel = new Hotel();
		hotel.setTimestamp(Integer.valueOf(p[0]));
		hotel.setUserId(Long.valueOf(p[1]));
		hotel.setHotelId(Integer.valueOf(p[2]));
		if (p.length > 3) {
			hotel.setHotelRegion(p[3]);
		}

		return hotel;
	};

}
