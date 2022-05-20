package edu.javacourse.student.dao;

import edu.javacourse.student.domain.StudentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kovalyov Anton 20.05.2022
 */
@Repository
public interface StudentOrderRepository extends JpaRepository<StudentOrder, Long> {

}
