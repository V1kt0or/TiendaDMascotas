package com.example.tiendadmascotas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;

    @Column(name = "edad",nullable = false)
    private Integer edad;

    @Column(name = "direccion",nullable = false)
    private String direccion;

    @Column(name = "correo",nullable = false)
    private String correo;

    @Column(name = "fechaRegistro",nullable = false)
    private Date fechaRegistro;

    @Column(name = "activo")
    private Boolean activo = true;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rol rol;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Carrito carrito;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authoridades = new HashSet<>();

            authoridades.add(new Authority(rol.getRolNombre()));
        ;
        return authoridades;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activo;
    }
}
