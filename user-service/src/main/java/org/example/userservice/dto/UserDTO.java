package org.example.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int u_id;
    private String name;
    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be digits")
    private String contact;
    private String address;
    @Email(message = "Invalid Email address")
    private String email;
    private String role;
    private String password;

    // Constructors
    public UserDTO() {
    }

    public UserDTO(int u_id, String name, String contact, String address, String email, String role, String password) {
        this.u_id = u_id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    // Getters
    public int getU_id() {
        return u_id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
