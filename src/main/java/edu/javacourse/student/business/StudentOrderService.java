package edu.javacourse.student.business;

import edu.javacourse.student.dao.StudentOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kovalyov Anton 20.05.2022
 */
@Service
public class StudentOrderService {
    @Autowired
    private StudentOrderRepository dao;

    @Transactional
    public void test(){
        dao.findAll();
    }
}
