package com.thoughtworks.training.zhangtian.todoservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
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

    @Column(name = "user_id")
    private Integer userId;

    @Builder.Default
    private Boolean deleted = false;
}
