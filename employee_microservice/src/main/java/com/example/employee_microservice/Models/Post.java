package com.example.employee_microservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
public class Post extends RepresentationModel<Post> implements Serializable {
    @Id
    private int postId;
    private int empId;
    private String name;
    private String salary;
    @Transient
    private String alert_message;
}
