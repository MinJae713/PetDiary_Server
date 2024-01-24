package com.example.petdiary_server.controller;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.calender.req.AddTodoCalReq;
import com.example.petdiary_server.dto.calender.req.TodosCalOfDateReq;
import com.example.petdiary_server.dto.calender.req.EditTodoCalReq;
import com.example.petdiary_server.dto.calender.res.*;
import com.example.petdiary_server.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calender")
public class CalenderController {
    @Autowired
    private CalenderService calenderService;
    @GetMapping("/getTodosCalFromDate")
    public ResponseEntity<ResStatus<AllTodosInfoRes>> getTodosCalFromDate(
        @RequestParam String dateId,
        @RequestParam String userId) {
        ResStatus<AllTodosInfoRes> result = calenderService.getTodoCalFromDate(dateId, userId);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/addTodosCalOfDate")
    public ResponseEntity<ResStatus<TodosCalOfDateRes>> addTodosCalOfDate(
            @RequestBody TodosCalOfDateReq addTodosCalOfDateReq) {
        ResStatus<TodosCalOfDateRes> result = calenderService.addTodosCalOfDate(addTodosCalOfDateReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PostMapping("/addTodoCal")
    public ResponseEntity<ResStatus<AllTodosInfoRes>> addTodoCal(
            @RequestBody AddTodoCalReq addTodoCalReq) {
        ResStatus<AllTodosInfoRes> result = calenderService.addTodoCal(addTodoCalReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PatchMapping("/editTodoCal")
    public ResponseEntity<ResStatus<TodoCalRes>> editTodoCal(
            @RequestBody EditTodoCalReq editTodoCalReq) {
        ResStatus<TodoCalRes> result = calenderService.editTodoCal(editTodoCalReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @PatchMapping("/editFeelIdx")
    public ResponseEntity<ResStatus<TodosCalOfDateRes>> editFeelIdx(
            @RequestBody TodosCalOfDateReq reqData) {
        ResStatus<TodosCalOfDateRes> result = calenderService.editFeelIdx(reqData);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/deleteTodoCal")
    public ResponseEntity<ResStatus<TodoCalRes>> deleteTodoCal(
            @RequestParam String id) {
        ResStatus<TodoCalRes> result = calenderService.deleteTodoCal(id);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
