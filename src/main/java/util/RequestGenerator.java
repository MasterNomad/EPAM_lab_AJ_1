package util;

import dto.BookingRequest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RequestGenerator {

    private static final List<String> HOTEL_NAMES = Arrays.asList("Abu Dhabi", "Rancho Valencia Resort",
            "The Westin Excelsior", "Burj Al Arab Hotel", "The Plaza", "Atlantis Paradise Island");

    public static BookingRequest generateRequest(int id) {
        Random random = new Random();
        BookingRequest bookingRequest = new BookingRequest();

        bookingRequest.setId(id);
        bookingRequest.setHotel(HOTEL_NAMES.get(random.nextInt(HOTEL_NAMES.size() - 1)));
        bookingRequest.setEntryDate(LocalDate.now().plusDays(random.nextInt(20)));
        bookingRequest.setPersonsNumber(random.nextInt(5) + 1);
        return bookingRequest;
    }

}
