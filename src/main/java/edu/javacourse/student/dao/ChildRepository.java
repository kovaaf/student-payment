package edu.javacourse.student.dao;

import edu.javacourse.student.domain.StudentOrderChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kovalyov Anton 24.05.2022
 */
@Repository
public interface ChildRepository extends JpaRepository<StudentOrderChild, Long> {
}
