package com.exyna.pos_api.users.internal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.sql.Types;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;

import com.exyna.pos_api.DateAudit;
import com.exyna.pos_api.authorities.Authorities;

@Entity
public class Users extends DateAudit {

    @Id
    @UuidGenerator
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(Types.CHAR)
    private UUID id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Authorities> authorities;

    public Users() {
    }

    public Users(UUID id, String fullName, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users id(UUID id) {
        setId(id);
        return this;
    }

    public Users fullName(String fullName) {
        setFullName(fullName);
        return this;
    }

    public Users username(String username) {
        setUsername(username);
        return this;
    }

    public Users password(String password) {
        setPassword(password);
        return this;
    }

    public List<Authorities> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Users)) {
            return false;
        }
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(fullName, users.fullName)
                && Objects.equals(username, users.username) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, username, password);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", fullName='" + getFullName() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

}
