package com.canuncuoglu.runners.run;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        
        @Id
        int id,
        @NotEmpty
        String title, 
        LocalDateTime startedOn, 
        LocalDateTime completedOn,
        @Positive
        Integer km,
        Location location,
        @Version
        Integer version
) {
        public Run{
                if (id < 0) {
                        throw new IllegalArgumentException("Id cannot be negative");
                }
                
        }
}
