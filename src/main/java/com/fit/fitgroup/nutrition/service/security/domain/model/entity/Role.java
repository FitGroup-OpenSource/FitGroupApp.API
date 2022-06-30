package com.fit.fitgroup.nutrition.service.security.domain.model.entity;

import com.fit.fitgroup.nutrition.service.security.domain.model.enumeration.Roles;
import com.fit.fitgroup.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "roles")
public class Role extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;
}