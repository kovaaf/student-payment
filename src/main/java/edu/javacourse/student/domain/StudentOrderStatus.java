package edu.javacourse.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kovalyov Anton 23.05.2022
 */
@Entity
@Table(name = "order_status")
public class StudentOrderStatus {
    @Id
    @Column(name = "status_id")
    private Long statusId;
    @Column(name = "status_name")
    private String statusName;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
