package com.elvstejd.visitorbehaviortrackingapi.connection;

public record ConnectionResponseDTO(
        Long id,
        Long deviceId,
        long connectionPointId
) {
}
