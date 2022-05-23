package edu.javacourse.student.dao;

import edu.javacourse.student.domain.PassportOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kovalyov Anton 23.05.2022
 */
@Repository
public interface PassportOfficeRepository extends JpaRepository<PassportOffice, Long> {
}
