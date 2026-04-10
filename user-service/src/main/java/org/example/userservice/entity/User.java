package org.example.userservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int u_id;
    private String name;
    private String contact;
    private String address;
    private String email;
    private String role;
    private String password;

    public User() {}

    public User(int u_id, String name, String contact, String address, String email, String role, String password) {
        this.u_id = u_id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public int getU_id() { return u_id; }
    public void setU_id(int u_id) { this.u_id = u_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}
