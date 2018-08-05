package com.thoughtworks.training.zhangtian.todoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SQLDelete(sql = "UPDATE task SET deleted=1 WHERE id=?")
@Where(clause = "deleted=false")
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    @Column(name = "todo_id")
    private Integer todoId;

    @Column(name = "deleted", columnDefinition = "int default 0")
    private Boolean deleted = false;
}
