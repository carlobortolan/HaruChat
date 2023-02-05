package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @NotBlank
    @Size(min = 8, max = 128)
    private String password;
    @NotBlank
    @Size(min = 1, max = 32)
    private String username;
    @Email
    @Column(unique = true)
    private String email;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> friends;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> blockedUsers;
    @ManyToMany(mappedBy = "participants", cascade = CascadeType.PERSIST)
    private List<GroupChat> groups;
    @ManyToMany(mappedBy = "participants", cascade = CascadeType.PERSIST)
    private List<DirectChat> directChats;

    public void block() {
        //TODO:
    }

    public void addFriend() {
        //TODO:
    }

    public void removeFriend() {
        //TODO:
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("rolePlaceholder");
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(List<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public List<GroupChat> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupChat> groups) {
        this.groups = groups;
    }

    public List<DirectChat> getDirectChats() {
        return directChats;
    }

    public void setDirectChats(List<DirectChat> directChats) {
        this.directChats = directChats;
    }
}
