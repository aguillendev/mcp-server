package com.playmatch.mcpserver.service;

import com.playmatch.mcpserver.model.AvailabilityResponse;
import com.playmatch.mcpserver.model.BookingConfirmation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    public List<AvailabilityResponse> getAvailability(String date, String fieldType) {
        // Return mock data for availability
        List<AvailabilityResponse> availability = new ArrayList<>();

        // Simulating some available slots
        availability.add(new AvailabilityResponse("field-1", fieldType, "10:00", true));
        availability.add(new AvailabilityResponse("field-2", fieldType, "14:00", true));
        availability.add(new AvailabilityResponse("field-1", fieldType, "18:00", true));
        availability.add(new AvailabilityResponse("field-3", fieldType, "20:00", true));

        return availability;
    }

    public BookingConfirmation bookField(String fieldId, String time, String contact) {
        // Simulating booking logic and returning a confirmation
        String bookingId = UUID.randomUUID().toString();

        // Log booking (simulate saving to DB)
        System.out.println("Booking created: ID=" + bookingId + ", Field=" + fieldId + ", Time=" + time + ", Contact=" + contact);

        return new BookingConfirmation(bookingId, fieldId, time, contact, "CONFIRMED");
    }
}
