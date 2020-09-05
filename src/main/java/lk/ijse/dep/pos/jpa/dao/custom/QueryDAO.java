package lk.ijse.dep.pos.jpa.dao.custom;

import lk.ijse.dep.pos.jpa.dao.SuperDAO;
import lk.ijse.dep.pos.jpa.entity.CustomEntity;

public interface QueryDAO extends SuperDAO {

    CustomEntity getOrderDetail(String orderId) throws Exception;

    CustomEntity getOrderDetail2(String orderId) throws Exception;
}
