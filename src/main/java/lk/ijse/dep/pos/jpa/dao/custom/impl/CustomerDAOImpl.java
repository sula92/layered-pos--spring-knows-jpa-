package lk.ijse.dep.pos.jpa.dao.custom.impl;

import lk.ijse.dep.pos.jpa.dao.CrudDAOImpl;
import lk.ijse.dep.pos.jpa.dao.custom.CustomerDAO;
import lk.ijse.dep.pos.jpa.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {

    @Override
    public String getLastCustomerId() throws Exception {
        try {
            return (String) entityManager.createNativeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1").getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
