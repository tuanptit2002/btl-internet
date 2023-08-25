package com.example.BTL_INTERNET_GT.Repo;

import com.example.BTL_INTERNET_GT.Entity.Role;
import com.example.BTL_INTERNET_GT.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleCustomRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getRole(User user) {
        StringBuilder sql = new StringBuilder()
                .append("select r.name as name from user u Join user_role ur on u.user_id= ur.user_id join role r on r.id = ur.role_id where 1=1");

        if (user.getPassword() != null) {
            sql.append(" and email = :email");
        }
        NativeQuery<Role> query = ((Session) entityManager.getDelegate()).createNativeQuery(sql.toString());
        if (user.getEmail() != null) {
            query.setParameter("email", user.getEmail());
        }
        query.addScalar("name", StandardBasicTypes.STRING);
        query.setResultTransformer(Transformers.aliasToBean(Role.class));
        return query.list();
    }
}
