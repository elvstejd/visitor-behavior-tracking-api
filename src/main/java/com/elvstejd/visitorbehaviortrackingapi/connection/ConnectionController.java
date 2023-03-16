package com.elvstejd.visitorbehaviortrackingapi.connection;

import com.elvstejd.visitorbehaviortrackingapi.connectionpoint.ConnectionPoint;
import com.elvstejd.visitorbehaviortrackingapi.connectionpoint.ConnectionPointService;
import com.elvstejd.visitorbehaviortrackingapi.device.Device;
import com.elvstejd.visitorbehaviortrackingapi.device.DeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/connections")
@RestController
public class ConnectionController {
    @Autowired
    private ConnectionRepository connectionRepo;

    @Autowired
    private ConnectionPointService connectionPointService;

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<ConnectionResponseDTO> logConnection(@Valid @RequestBody ConnectionRequestDTO connectionRequestDTO) {
        ConnectionPoint connectionPoint = connectionPointService.findById(connectionRequestDTO.connectionPointId());
        Device device = deviceService.getByMacAddressOrCreate(connectionRequestDTO.macAddress());

        // assemble a connection obj with reference to device and connection point
        Connection newConnection = new Connection();
        newConnection.setDevice(device);
        newConnection.setConnectionPoint(connectionPoint);

        // then save it
        Connection savedConnection = connectionRepo.save(newConnection);

        // assemble a response
        ConnectionResponseDTO connectionResponseDTO = new ConnectionResponseDTO(
                savedConnection.getId(),
                savedConnection.getDevice().getId(),
                savedConnection.getConnectionPoint().getId()
        );

        return new ResponseEntity<>(connectionResponseDTO, HttpStatus.CREATED);
    }
}
