package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(user);
        logger.info("User is successfully added. User details: "+user);
    }

    @Override
    public void editUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User is successfully updated. User details: "+user);
    }

    @Override
    public void deleteUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if (user!=null){
            session.delete(user);
        }

        logger.info("User is successfully removed. User details: "+user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User is successfully loaded. User details: "+user);
        return user;
    }

    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User user : userList){
            logger.info("User list "+user);
        }
        return userList;
    }
}
