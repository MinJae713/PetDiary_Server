package com.example.petdiary_server.entity.checklist;

import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "TodoCheck")
public class TodoCheck {
    @Id
    @Column(nullable = false, length = 36)
    private String id;
    @Column(nullable = false)
    private String textValue;
    @Column(nullable = false)
    private boolean checked;
    @ManyToOne
    @JoinColumn(name = "todoCheckId")
    private TodoCheckOfDate todoCheckOfDate;

    public TodoCheckRes createTodoCheckRes() {
        return new TodoCheckRes(id, textValue, checked, todoCheckOfDate.getWriteDate());
    }
}
