package edu.javacourse.student.business;

import edu.javacourse.student.dao.StreetRepository;
import edu.javacourse.student.dao.StudentOrderRepository;
import edu.javacourse.student.domain.Address;
import edu.javacourse.student.domain.Adult;
import edu.javacourse.student.domain.Street;
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
    @Autowired
    private StreetRepository daoStreet;

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

    private Adult buildPerson(boolean wife) {
        Adult adult = new Adult();
        adult.setDateOfBirth(LocalDate.now());

        Address address = new Address();
        address.setPostCode("190000");
        address.setBuilding("21");
        address.setExtension("B");
        address.setApartment("190");
        adult.setAddress(address);
        Street street = daoStreet.getById(1L);
        address.setStreet(street);

        if (wife) {
            adult.setSurName("Рюрик");
            adult.setGivenName("Марфа");
            adult.setPatronymic("Васильевна");
            adult.setPassportSeria("WIFE_S");
            adult.setPassportNumber("WIFE_N");
            adult.setIssueDate(LocalDate.now());
        } else {
            adult.setSurName("Рюрик");
            adult.setGivenName("Иван");
            adult.setPatronymic("Васильевич");
            adult.setPassportSeria("HUSB_S");
            adult.setPassportNumber("HUSB_N");
            adult.setIssueDate(LocalDate.now());
        }

        return adult;
    }
}