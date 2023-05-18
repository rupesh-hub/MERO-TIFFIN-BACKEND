package com.merotiffin.role.entity;

import com.merotiffin.shared.enums.Roles;
import com.merotiffin.shared.model.AbstractEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
@Table(name = "roles")
@ToString
public class Role extends AbstractEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq_gen")
    @SequenceGenerator(name = "role_id_seq_gen", sequenceName = "role_id_seq_gen", initialValue = 1, allocationSize = 1)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    @Enumerated(EnumType.STRING)
    private Roles name;

}
