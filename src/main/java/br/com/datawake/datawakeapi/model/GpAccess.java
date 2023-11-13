package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "group_access_app")
public class GpAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "group_permission", joinColumns = @JoinColumn(name = "id_group_access")
            , inverseJoinColumns = @JoinColumn(name = "id_permission"))

    private List<Permission> permission;

    public List<Permission> getPermission() {
        return permission;
    }
    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object obj) {
        /*if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GpAccess that = (GpAccess) o;
        return id.equals(that.id);*/
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GpAccess other = (GpAccess) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
       // return Objects.hash(id);
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
