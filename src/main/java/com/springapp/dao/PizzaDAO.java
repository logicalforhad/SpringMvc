package com.springapp.dao;

import com.springapp.domain.Pizza;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by logical on 1/5/14.
 */
@Repository
@SuppressWarnings({"unchecked", "rawtypes"})
public class PizzaDAO {
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @Transactional annotation below will trigger Spring Hibernate transaction manager to automatically create
     * a hibernate session. See src/main/webapp/WEB-INF/servlet-context.xml
     */
    @Transactional
    public List<Pizza> getAll() {

        List<Pizza> pizzaList = getCurrentSession().createCriteria(Pizza.class).list();
        return pizzaList;
    }

    @Transactional
    public void save(Pizza pizza) {
        getCurrentSession().save(pizza);
    }

    @Transactional
    public void update(Pizza pizza) {
        Pizza pizzaToUpdate = getPizzaById(pizza.getId());
        pizzaToUpdate.setName(pizza.getName());
        pizzaToUpdate.setPrice(pizza.getPrice());

        getCurrentSession().update(pizzaToUpdate);
    }

    @Transactional
    public Pizza getPizzaById(long id) {
        Pizza pizza = (Pizza) getCurrentSession().get(Pizza.class, id);
        return pizza;
    }

    @Transactional
    public void delete(long id) {
        Pizza pizza = getPizzaById(id);
        if (pizza != null) {
            getCurrentSession().delete(pizza);
        }

    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


}
