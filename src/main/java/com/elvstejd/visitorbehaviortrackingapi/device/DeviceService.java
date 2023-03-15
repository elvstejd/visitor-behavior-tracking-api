package com.elvstejd.visitorbehaviortrackingapi.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepo;

    public Device getByMacAddressOrCreate(String macAddress) {
        Device device = deviceRepo.findByMacAddress(macAddress);

        // create new device if not found by that mac address
        if (device == null) {
            Device newDevice = new Device();
            newDevice.setMacAddress(macAddress);
            deviceRepo.save(newDevice);
            device = newDevice;
        }

        return device;
    }
}
