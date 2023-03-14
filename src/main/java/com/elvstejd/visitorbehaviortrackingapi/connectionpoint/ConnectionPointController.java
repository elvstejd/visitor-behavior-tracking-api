package com.elvstejd.visitorbehaviortrackingapi.connectionpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connection-points")
public class ConnectionPointController {

    @Autowired
    private ConnectionPointRepository connectionPointRepo;

    @PostMapping
    public ConnectionPoint registerConnectionPoint(@RequestBody ConnectionPointDTO connectionPointDTO) {
        ConnectionPoint newConnectionPoint = new ConnectionPoint();
        newConnectionPoint.setBrand(connectionPointDTO.brand());
        newConnectionPoint.setType(connectionPointDTO.type());

        return connectionPointRepo.save(newConnectionPoint);
    }
}
