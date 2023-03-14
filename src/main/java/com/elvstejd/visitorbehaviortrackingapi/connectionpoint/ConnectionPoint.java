package com.elvstejd.visitorbehaviortrackingapi.connectionpoint;

import com.elvstejd.visitorbehaviortrackingapi.connection.Connection;
import com.elvstejd.visitorbehaviortrackingapi.tile.Tile;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConnectionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConnectionPointType type;

    @ManyToMany
    private Set<Tile> tiles;

    @OneToMany(mappedBy = "connectionPoint")
    private List<Connection> connections;
}
