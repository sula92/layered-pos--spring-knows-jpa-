package lk.ijse.dep.pos.jpa.dao.custom.impl;

import lk.ijse.dep.pos.jpa.dao.custom.QueryDAO;
import lk.ijse.dep.pos.jpa.entity.CustomEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.sql.Date;

@Repository
public class QueryDAOImpl implements QueryDAO {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public CustomEntity getOrderDetail(String orderId) throws Exception {
        try {
            Object[] result = (Object[]) entityManager.createNativeQuery("SELECT  o.id AS orderId," +
                    " c.name AS customerName, o.date AS orderDate FROM `Order` o\n" +
                    "INNER JOIN Customer c on o.customerId = c.id\n" +
                    "WHERE o.id=?1").setParameter(1, orderId).getSingleResult();
            return new CustomEntity((String) result[0], (String) result[1], (Date) result[2]);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public CustomEntity getOrderDetail2(String orderId) throws Exception {
        try {
            return (CustomEntity) entityManager.createQuery("SELECT NEW entity.CustomEntity(C.id, C.name, O.id) " +
                    "FROM Order O INNER JOIN O.customer C WHERE O.id=:id")
                    .setParameter("id", orderId).getSingleResult();
        }catch (NoResultException ex){
            return null;
        }
    }
}
