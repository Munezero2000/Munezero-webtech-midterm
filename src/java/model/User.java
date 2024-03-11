package model;

import javax.persistence.*;

/**
 *
 * @author magtech
 */

@Entity
@Table(name="users")
public class User {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
   
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "status")
    private Role status;

    public User() {
    }

    public User(Long id, String email, String password, Role status) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return status;
    }

    public void setRole(Role status) {
        this.status = status;
    }
    
    
}
