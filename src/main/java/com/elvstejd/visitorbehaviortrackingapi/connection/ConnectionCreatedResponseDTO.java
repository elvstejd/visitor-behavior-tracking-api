package com.elvstejd.visitorbehaviortrackingapi.connection;

public record ConnectionCreatedResponseDTO(
        Long id,
        Long deviceId,
        long connectionPointId
) {
}
