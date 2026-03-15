package com.playmatch.mcpserver.model;

public record AvailabilityResponse(String id, String fieldType, String time, boolean isAvailable) {
}
