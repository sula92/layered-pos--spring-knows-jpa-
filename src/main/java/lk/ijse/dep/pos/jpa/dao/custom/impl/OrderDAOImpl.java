package lk.ijse.dep.pos.jpa.dao.custom.impl;

import lk.ijse.dep.pos.jpa.dao.CrudDAOImpl;
import lk.ijse.dep.pos.jpa.dao.custom.OrderDAO;
import lk.ijse.dep.pos.jpa.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl extends CrudDAOImpl<Order, String> implements OrderDAO {

    public String getLastOrderId() throws Exception {
        List list =  entityManager.createQuery("SELECT o.id FROM Order o ORDER BY o.id DESC")
                .setMaxResults(1).getResultList();
        return (list.size()> 0)? (String) list.get(0): null;
    }
}
