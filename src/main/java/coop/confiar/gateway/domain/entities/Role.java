package coop.confiar.gateway.domain.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "created_at")
    private LocalDateTime CreatedAt;

    @Column(name = "updated_at")
    private LocalDateTime UpdatedAt;

    @Column(name = "status")
    private boolean Status;
}
