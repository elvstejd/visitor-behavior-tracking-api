package com.elvstejd.visitorbehaviortrackingapi.device;

import com.elvstejd.visitorbehaviortrackingapi.connection.Connection;
import com.elvstejd.visitorbehaviortrackingapi.visitor.Visitor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String macAddress;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Visitor owner;

    @OneToMany(mappedBy = "device")
    private List<Connection> connections;
}
