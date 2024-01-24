package com.example.petdiary_server.entity.calender;

import com.example.petdiary_server.dto.calender.res.TodoCalRes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TodoCal")
public class TodoCal {
    @Id
    @Column(nullable = false, length = 13)
    private String id;
    @Column(nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "todoCalId")
    private TodoCalOfDate todoCalOfDate;

    public TodoCalRes createTodoCalRes() {
        return new TodoCalRes(id, text);
    }
}
