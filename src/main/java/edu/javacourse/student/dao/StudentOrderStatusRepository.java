package edu.javacourse.student.dao;

import edu.javacourse.student.domain.StudentOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kovalyov Anton 23.05.2022
 */
@Repository
public interface StudentOrderStatusRepository extends JpaRepository<StudentOrderStatus, Long> {
}
