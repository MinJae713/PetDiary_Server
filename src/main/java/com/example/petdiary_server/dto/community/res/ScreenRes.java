package com.example.petdiary_server.dto.community.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ScreenRes {
    private String key;
    private String iconName;
    private String title;
}
