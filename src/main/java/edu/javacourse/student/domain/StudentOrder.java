package edu.javacourse.student.domain;

import javax.persistence.*;

/**
 * @author Kovalyov Anton 20.05.2022
 */
@Entity
@Table(name = "student_order")
public class StudentOrder {
    @Id
    @Column(name = "student_order_id")
    private Long studentOrderId;

    public Long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(Long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }
}
