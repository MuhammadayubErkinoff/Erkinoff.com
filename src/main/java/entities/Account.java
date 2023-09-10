package entities;


import jakarta.persistence.*;

@Entity
public class Account {
    public Account() {
    }

    public Account(String username, String password, boolean isAdmin) {
        Username = username;
        Password = password;
        this.isAdmin = isAdmin;
    }

    @Id
    @Column(unique = true)
    private String Username;
    private String Password;
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
