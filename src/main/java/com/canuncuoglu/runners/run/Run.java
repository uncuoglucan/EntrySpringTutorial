package com.canuncuoglu.runners.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        int id,
        @NotEmpty
        String title, 
        LocalDateTime startedOn, 
        LocalDateTime completedOn,
        @Positive
        Integer km,
        Location Location
) {
        public Run{
                if (id < 0) {
                        throw new IllegalArgumentException("Id cannot be negative");
                }
                
        }
}
