package br.com.datawake.datawakeapi.model;

public class UserAppResponse {

    private Long id;
    private String name;
    private String email;
    private Integer firstAccess;

    public UserAppResponse(Long id, String name, String email,Integer firstAccess) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setFirstAccess(firstAccess);
    }

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
        UserAppResponse other = (UserAppResponse) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    public Integer getFirstAccess() {
        return firstAccess;
    }

    public void setFirstAccess(Integer firstAccess) {
        this.firstAccess = firstAccess;
    }
}
