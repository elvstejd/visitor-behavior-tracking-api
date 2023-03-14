package com.elvstejd.visitorbehaviortrackingapi.tile;

import com.elvstejd.visitorbehaviortrackingapi.connectionpoint.ConnectionPoint;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tile {
    @Id
    private String id;

    @ManyToMany
    private Set<ConnectionPoint> coveringPoints;
}
