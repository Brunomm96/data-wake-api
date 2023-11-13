package br.com.datawake.datawakeapi.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_app")
public class UserApp_v2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private Integer firstAccess;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_gpaccess", joinColumns = @JoinColumn(name = "id_user")
            , inverseJoinColumns = @JoinColumn(name = "id_gpaccess"))

    private List<GpAccess> GpAccess;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserApp_v2 other = (UserApp_v2) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public void encryptPassWord() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.setPassword( encoder.encode( this.getPassword() ) );

    }

    public Integer getFirstAccess() {
        return firstAccess;
    }

    public void setFirstAccess(Integer firstAccess) {
        this.firstAccess = firstAccess;
    }

    public List<GpAccess> getGpAccess() {
        return GpAccess;
    }

    public void setGpAccess(List<GpAccess> gpAccess) {
        GpAccess = gpAccess;
    }
}
