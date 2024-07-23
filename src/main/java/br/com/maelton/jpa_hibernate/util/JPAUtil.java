package br.com.maelton.jpa_hibernate.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    
    private static final EntityManagerFactory 
    ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("test");

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
