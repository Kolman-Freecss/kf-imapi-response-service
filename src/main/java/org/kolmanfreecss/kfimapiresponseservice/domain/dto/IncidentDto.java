package org.kolmanfreecss.kfimapiresponseservice.domain.dto;

import java.util.Date;
import java.util.UUID;

/**
 * IncidentDto
 * Used to define the IncidentDto object.
 * 
 * @version 1.0
 * @uthor Kolman-Freecss
 */
public record IncidentDto(UUID id, String title, String description,
                          IncidentStatus status, IncidentPriotity priority, Date reportDate, Date resolutionDate) {
}
