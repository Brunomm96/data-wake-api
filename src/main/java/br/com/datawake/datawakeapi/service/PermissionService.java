package br.com.datawake.datawakeapi.service;

import br.com.datawake.datawakeapi.model.Permission;
import br.com.datawake.datawakeapi.repository.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {

    @Autowired
    private Permissions permissions;

    public List<Permission> findAll() {
        return permissions.findAll();
    }

    public Page<Permission> findAll(Pageable pageable) {
        return permissions.findAll(pageable);
    }

    @Transactional

    public void save( Permission permission ) {

        permissions.save(permission);
        return ;

    }
    public Optional<Permission> findById(Long id) {
        return permissions.findById(id);
    }

    //@Query(value="DELETE FROM user_roles WHERE role_id = ?1", nativeQuery=true)
    //public void deleteRoleFromUsersWithRole(Long roleId);

    @Transactional
    public void delete(Permission permissionDel) {

        permissions.delete(permissionDel);
        return;
    }
}
