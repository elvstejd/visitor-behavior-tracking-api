package com.elvstejd.visitorbehaviortrackingapi.connection;

import com.elvstejd.visitorbehaviortrackingapi.connectionpoint.ConnectionPoint;
import com.elvstejd.visitorbehaviortrackingapi.device.Device;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "connection_point_id", nullable = false)
    private ConnectionPoint connectionPoint;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime timestamp;
}
