package com.playmatch.mcpserver.tools;

import com.playmatch.mcpserver.model.AvailabilityResponse;
import com.playmatch.mcpserver.model.BookingConfirmation;
import com.playmatch.mcpserver.service.BookingService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookingTools {

    private final BookingService bookingService;

    public BookingTools(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Consulta la disponibilidad de canchas de fútbol.
     * Recibe fecha y tipo de cancha, devuelve una lista de horarios libres.
     *
     * @param fecha La fecha para la que se quiere buscar disponibilidad, por ejemplo "2024-11-20".
     * @param tipoCancha El tipo de cancha buscada, por ejemplo "futbol-5", "futbol-7", "futbol-11".
     * @return Una lista de canchas disponibles y sus horarios.
     */
    @Tool(description = "Consulta la disponibilidad de canchas de fútbol en una fecha y por tipo de cancha. Devuelve una lista de horarios libres.")
    public List<AvailabilityResponse> consultar_disponibilidad(String fecha, String tipoCancha) {
        return bookingService.getAvailability(fecha, tipoCancha);
    }

    /**
     * Realiza una reserva de cancha.
     *
     * @param idCancha El identificador de la cancha a reservar.
     * @param horario El horario de la reserva.
     * @param contacto El contacto del usuario (email o teléfono).
     * @return Confirmación de la reserva.
     */
    @Tool(description = "Realiza la reserva de una cancha de fútbol usando su ID, el horario deseado y la información de contacto del usuario. Devuelve un objeto de confirmación con un ID de reserva.")
    public BookingConfirmation realizar_reserva(String idCancha, String horario, String contacto) {
        return bookingService.bookField(idCancha, horario, contacto);
    }
}
