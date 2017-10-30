package org.ftd.educational.catolica.prog4.daos;

import javax.persistence.EntityManagerFactory;


public class ClienteDAO extends ClienteJpaController {
    
    public ClienteDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
}
