package lk.ijse.dep.pos.jpa.dao.custom.impl;

import lk.ijse.dep.pos.jpa.dao.CrudDAOImpl;
import lk.ijse.dep.pos.jpa.dao.custom.ItemDAO;
import lk.ijse.dep.pos.jpa.entity.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDAOImpl extends CrudDAOImpl<Item, String> implements ItemDAO {

    public String getLastItemCode() throws Exception {
        List list = entityManager.createQuery("SELECT i.code FROM entity.Item i ORDER BY i.code DESC")
                .setMaxResults(1).getResultList();
        return list.size() > 0 ? (String) list.get(0) : null;
    }
}
