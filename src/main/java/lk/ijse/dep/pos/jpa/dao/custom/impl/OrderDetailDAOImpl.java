package lk.ijse.dep.pos.jpa.dao.custom.impl;

import lk.ijse.dep.pos.jpa.dao.CrudDAOImpl;
import lk.ijse.dep.pos.jpa.dao.custom.OrderDetailDAO;
import lk.ijse.dep.pos.jpa.entity.OrderDetail;
import lk.ijse.dep.pos.jpa.entity.OrderDetailPK;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailDAOImpl extends CrudDAOImpl<OrderDetail, OrderDetailPK> implements OrderDetailDAO {

    @Override
    public List<OrderDetail> findAll() throws Exception {
        return entityManager.createQuery("FROM OrderDetail", OrderDetail.class).getResultList();
    }
}
