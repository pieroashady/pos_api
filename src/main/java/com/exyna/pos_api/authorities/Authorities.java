package com.exyna.pos_api.authorities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Types;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import com.exyna.pos_api.DateAudit;

@Entity
public class Authorities extends DateAudit {

    @Id
    @UuidGenerator
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @UuidGenerator
    @Column(name = "user_id", columnDefinition = "CHAR(36)")
    @JdbcTypeCode(Types.CHAR)
    private UUID userId;

    @Column(name = "role")
    private String role;

    public Authorities() {
    }

    public Authorities(UUID id, UUID userId, String role) {
        this.id = id;
        this.userId = userId;
        this.role = role;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Authorities id(UUID id) {
        setId(id);
        return this;
    }

    public Authorities userId(UUID userId) {
        setUserId(userId);
        return this;
    }

    public Authorities role(String role) {
        setRole(role);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Authorities)) {
            return false;
        }
        Authorities authorities = (Authorities) o;
        return Objects.equals(id, authorities.id) && Objects.equals(userId, authorities.userId)
                && Objects.equals(role, authorities.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, role);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", userId='" + getUserId() + "'" +
                ", role='" + getRole() + "'" +
                "}";
    }

}
