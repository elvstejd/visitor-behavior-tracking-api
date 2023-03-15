package com.elvstejd.visitorbehaviortrackingapi.connectionpoint;

import jakarta.validation.constraints.NotBlank;

public record ConnectionPointDTO(
        @NotBlank(message = "Brand cannot be blank")
        String brand,
        @NotBlank(message = "Type cannot be blank")
        ConnectionPointType type
) {
}
