package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class test {

    public static void main(String[] args) {
        //1. ����EntityManagerFactory
        String persistenceUnitName = "jpa"; 
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);

        //2. ����EntityManager
        EntityManager entityManager = factory.createEntityManager();

        //3.��������
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //4. �־û�����
        User user = new User();
        user.setName("tom");
        user.setEmail("222@qq.com");

        //���user�����ݿ⣬�൱��hibernate��save();
        entityManager.persist(user);

        //5. �ύ����
        transaction.commit();

        //6. �ر�EntityManager
        entityManager.close();

        //7. �ر�EntityManagerFactory
        factory.close();

    }

}