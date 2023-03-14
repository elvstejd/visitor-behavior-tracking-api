package com.elvstejd.visitorbehaviortrackingapi.connection;

import com.elvstejd.visitorbehaviortrackingapi.connectionpoint.ConnectionPoint;
import com.elvstejd.visitorbehaviortrackingapi.connectionpoint.ConnectionPointRepository;
import com.elvstejd.visitorbehaviortrackingapi.device.Device;
import com.elvstejd.visitorbehaviortrackingapi.device.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/connections")
@RestController
public class ConnectionController {
    @Autowired
    private ConnectionRepository connectionRepo;

    @Autowired
    private DeviceRepository deviceRepo;

    @Autowired
    private ConnectionPointRepository ConnectionPointRepo;

    @PostMapping
    public Connection logConnection(@RequestBody ConnectionDTO connectionDTO) {
        Device device = deviceRepo.findByMacAddress(connectionDTO.macAddress());

        // create new device if not found by that mac address
        if (device == null) {
            Device newDevice = new Device();
            newDevice.setMacAddress(connectionDTO.macAddress());
            deviceRepo.save(newDevice);
            device = newDevice;
        }

        ConnectionPoint connectionPoint = ConnectionPointRepo.findById(connectionDTO.connectionPointId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Connection point id was not found on the database"));

        // assemble a connection obj with: device id, connection point id
        Connection newConnection = new Connection();
        newConnection.setDevice(device);
        newConnection.setConnectionPoint(connectionPoint);

        return connectionRepo.save(newConnection);
    }
}
