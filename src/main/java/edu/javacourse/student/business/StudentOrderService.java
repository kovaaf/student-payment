package edu.javacourse.student.business;

import edu.javacourse.student.dao.*;
import edu.javacourse.student.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Kovalyov Anton 20.05.2022
 */
@Service
public class StudentOrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);
    @Autowired
    private StudentOrderRepository daoOrder;
    @Autowired
    private StreetRepository daoStreet;
    @Autowired
    private StudentOrderStatusRepository daoStatus;
    @Autowired
    private RegisterOfficeRepository daoRegisterOffice;
    @Autowired
    private PassportOfficeRepository daoPassportOffice;
    @Autowired
    private CountryAreaRepository daoCountryArea;
    @Autowired
    private UniversityRepository daoUniversity;
    @Autowired
    private ChildRepository childRepository;


    @Transactional
    public void testSave() {
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setOrderDate(LocalDateTime.now());
        studentOrder.setOrderStatus(daoStatus.getById(1L));

        studentOrder.setHusband(buildPerson(false));
        studentOrder.setWife(buildPerson(true));

        studentOrder.setCertificateNumber("CERTIFICATE NUMBER");
        studentOrder.setRegisterOffice(daoRegisterOffice.getById(1L));
        studentOrder.setMarriageDate(LocalDate.now());

        daoOrder.save(studentOrder);

        childRepository.save(buildChild(studentOrder));
    }
    @Transactional
    public void testGet() {
        List<StudentOrder> studentOrders = daoOrder.findAll();
        LOGGER.info(studentOrders.get(0).getWife().getGivenName());
        LOGGER.info(studentOrders.get(0).getChildren().get(0).getGivenName());

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
            adult.setPassportOffice(daoPassportOffice.getById(1L));
            adult.setIssueDate(LocalDate.now());
            adult.setStudentNumber("12345");
            adult.setUniversity(daoUniversity.getById(1L));
        } else {
            adult.setSurName("Рюрик");
            adult.setGivenName("Иван");
            adult.setPatronymic("Васильевич");
            adult.setPassportSeria("HUSB_S");
            adult.setPassportNumber("HUSB_N");
            adult.setPassportOffice(daoPassportOffice.getById(1L));
            adult.setIssueDate(LocalDate.now());
            adult.setStudentNumber("67890");
            adult.setUniversity(daoUniversity.getById(1L));
        }

        return adult;
    }
    private Child buildChild(StudentOrder studentOrder) {
        Child child = new Child();
        child.setDateOfBirth(LocalDate.now());

        Address address = new Address();
        address.setPostCode("190000");
        address.setBuilding("21");
        address.setExtension("B");
        address.setApartment("190");
        child.setAddress(address);
        Street street = daoStreet.getById(1L);
        address.setStreet(street);

        child.setSurName("Рюрик");
        child.setGivenName("Дмитрий");
        child.setPatronymic("Иванович");

        child.setCertificateDate(LocalDate.now());
        child.setCertificateNumber("BIRTH NUM");
        child.setRegisterOffice(daoRegisterOffice.getById(1L));

        child.setStudentOrder(studentOrder);

        return child;
    }
}