package com.elvstejd.visitorbehaviortrackingapi.connection;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConnectionRequestDTO(
        @NotNull(message = "Connection point id cannot be null")
        Long connectionPointId,
        @Pattern(regexp = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$", message = "Mac address is not valid")
        String macAddress
) {
}
