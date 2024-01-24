package com.example.petdiary_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResStatus<T> {
    private boolean success;
    private String message;
    private T content;
}
