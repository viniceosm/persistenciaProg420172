package org.ftd.educational.catolica.prog4.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.ftd.educational.catolica.prog4.entities.User;

/**
 *
 * @author Fabio Tavares Dippold
 *
 */
public class UserDAO extends UserJpaController {

    private static final long serialVersionUID = 1L;

    public UserDAO(EntityManagerFactory emf) {
        super(emf);
    }

    public User find(Long id) {
        return super.findUser(id);
    }

    public User findUser(String login, String passwd) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (User) em.createNamedQuery("User.authenticate")
                    .setParameter("login", login)
                    .setParameter("passwd", passwd)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public User findUser(String email) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (User) em.createNamedQuery("User.findby.email")
                    .setParameter("email", email)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public User findUserByName(String name) throws NoResultException {
        EntityManager em = getEntityManager();
        try {
            return (User) em.createNamedQuery("User.findby.name")
                    .setParameter("name", name)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<User> findAll() {
        return super.findUserEntities();
    }

    public List<User> findUserByKeyword(String keyword) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findby.keyword");
            q.setParameter("keyword", "%" + keyword + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<User> findUserByRule(Long ruleId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findby.rule");
            q.setParameter("ruleId", ruleId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<User> findUserOrderByName() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findall.by.name");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<User> findUserByCompany(Long companyId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findby.company");
            q.setParameter("companyId", companyId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<User> findUserByProject(Long projectId) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findby.project");
            q.setParameter("projectId", projectId);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

}
