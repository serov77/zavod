package ru.solicom.zavod.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleUser implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> users = new HashSet<User>(0);

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


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
