package com.example.tienda.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "First name cannot be empty")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "First name cannot contain numbers or characters other than letters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "Last name cannot contain numbers or characters other than letters")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"})
    )
    private List<Role> roles = new ArrayList<>();

    private boolean deleted;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public UserEntity(){
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        for (Role role:this.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return roles;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

}
