package com.emezon.user.infra.outbound.mysql.jpa.entities;

import com.emezon.user.infra.outbound.mysql.jpa.constants.RoleEntityConstants;
import com.emezon.user.infra.security.SecurityConstants;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = RoleEntityConstants.ENTITY_NAME)
@Table(name = RoleEntityConstants.TABLE_NAME)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity implements GrantedAuthority {

    @Id
    @UuidGenerator
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "role")
    private Set<UserEntity> users;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public String getAuthority() {
        return SecurityConstants.ROLE_PREFIX + this.name;
    }

}
