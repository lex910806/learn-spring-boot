package me.jihoon.learnjpa;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("jihoon");
        account.setPassword("jh");

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);


        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }
}
