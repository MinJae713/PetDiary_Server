package com.example.petdiary_server.entity.community;

import com.example.petdiary_server.dto.community.res.ScreenRes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Screen")
public class Screen {
    @Id
    @Column(name = "screenKey", nullable = false, length = 50)
    private String key;
    @Column(nullable = false)
    private String icon_name;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String type;

    public ScreenRes getScreenRes() {
        return new ScreenRes(key, icon_name, title);
    }
}
