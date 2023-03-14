package com.elvstejd.visitorbehaviortrackingapi.connectionpoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionPointRepository extends JpaRepository<ConnectionPoint,Long> {
}
