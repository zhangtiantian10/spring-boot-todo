package com.thoughtworks.training.zhangtian.todoservice.model;

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
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SQLDelete(sql = "UPDATE todo SET deleted=1 WHERE id=?")
@Where(clause = "deleted = false")
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;
    private String value;
    private Boolean isComplete;
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "todo_id")
    private List<Task> tasks;

    private Integer userId;

    @Column(name = "deleted", columnDefinition = "int default 0")
    private Boolean deleted = false;
}
