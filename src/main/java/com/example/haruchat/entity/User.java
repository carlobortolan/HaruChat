package com.example.haruchat.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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
import java.util.LinkedList;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "APP_USER")
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class User
        implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @JsonProperty(access = Access.WRITE_ONLY)
    @Size(min = 8, max = 128)
    private String password;

    @NotBlank
    @Column(unique = true)
    @Size(min = 1, max = 32)
    private String username;

    @Email
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole userRole = UserRole.ROLE_USER;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> friends;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<User> blockedUsers;

    @ManyToMany()
    private List<Conversation> chats = new LinkedList<>();

    @OneToMany(mappedBy = "from", cascade = CascadeType.PERSIST)
    private List<Message> messagesSent;
//    @OneToMany(mappedBy = "to")
//    private List<Message> messagesReceived;

    public User(Integer id, String password, String username, String email, List<User> friends, List<User> blockedUsers, List<Conversation> chats, List<Message> messagesSent) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.email = email;
        this.friends = friends;
        this.blockedUsers = blockedUsers;
        this.chats = chats;
        this.messagesSent = messagesSent;
    }

    public User() {
    }

    public void block() {
        //TODO:
    }

    public void addFriend() {
        //TODO:
    }

    public void removeFriend() {
        //TODO:
    }

    public void promoteToAdmin() {
        this.userRole = UserRole.ROLE_ADMIN;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.userRole.name());
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

    public List<Conversation> getChats() {
        return chats;
    }

    public void setChats(List<Conversation> groups) {
        this.chats = groups;
    }

    public List<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(List<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}
