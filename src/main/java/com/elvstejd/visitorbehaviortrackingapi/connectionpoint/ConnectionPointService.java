package com.elvstejd.visitorbehaviortrackingapi.connectionpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConnectionPointService {
    @Autowired
    private ConnectionPointRepository connectionPointRepo;

    public ConnectionPoint findById(Long id) {
        return connectionPointRepo.findById(id).orElseThrow(() -> new ConnectionPointNotFoundException(id));
    }
}
