package com.elvstejd.visitorbehaviortrackingapi.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByMacAddress(String macAddress);
}
