package rc.bootsecurity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private int active;
    private String roles="";
    private String permission="";

    public User() {
    }

    public User( String username, String password,  String roles, String permission) {
        this.username = username;
        this.password = password;
        this.active = 1;
        this.roles = roles;
        this.permission = permission;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermission() {
        return permission;
    }
    public List<String> getRolesList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }else {
            return new ArrayList<>();
        }
    }
    public List<String> getPermissionList(){
        if(this.permission.length()>0){
            return Arrays.asList(this.permission.split(","));
        }else {
            return new ArrayList<>();
        }
    }
}
