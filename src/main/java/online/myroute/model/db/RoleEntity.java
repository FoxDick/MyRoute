package online.myroute.model.db;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles", schema = "public")
public class RoleEntity implements GrantedAuthority {
    @Id
    private int id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    public RoleEntity() {
    }

    public RoleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
