package edu.javacourse.student.business;

import edu.javacourse.student.dao.StudentOrderRepository;
import edu.javacourse.student.domain.Person;
import edu.javacourse.student.domain.StudentOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Kovalyov Anton 20.05.2022
 */
@Service
public class StudentOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);
    @Autowired
    private StudentOrderRepository dao;

    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setHusband(buildPerson(false));
        studentOrder.setWife(buildPerson(true));
        dao.save(studentOrder);
    }
    @Transactional
    public void testGet() {
        List<StudentOrder> studentOrders = dao.findAll();
        LOGGER.info(studentOrders.get(0).getWife().getGivenName());
    }

    private Person buildPerson(boolean wife) {
        Person p = new Person();

        p.setDateOfBirth(LocalDate.now());
        if (wife) {
            p.setSurName("Рюрик");
            p.setGivenName("Марфа");
            p.setPatronymic("Васильевна");
        } else {
            p.setSurName("Рюрик");
            p.setGivenName("Иван");
            p.setPatronymic("Васильевич");
        }

        return p;
    }
}