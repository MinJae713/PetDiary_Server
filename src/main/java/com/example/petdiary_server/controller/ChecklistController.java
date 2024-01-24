package com.example.petdiary_server.controller;

import com.example.petdiary_server.dto.ResStatus;
import com.example.petdiary_server.dto.checklist.req.AddTodoCheckReq;
import com.example.petdiary_server.dto.checklist.res.TodoCheckRes;
import com.example.petdiary_server.service.ChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklist")
public class ChecklistController {
    @Autowired
    private ChecklistService checklistService;
    @PostMapping("/addTodoCheck")
    public ResponseEntity<ResStatus<List<TodoCheckRes>>> addTodoCheck(@RequestBody AddTodoCheckReq addTodoCheckReq) {
        ResStatus<List<TodoCheckRes>> result = checklistService.addTodoCheck(addTodoCheckReq);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping("/deleteTodoCheck")
    public ResponseEntity<ResStatus<List<TodoCheckRes>>> deleteTodoCheck(
        @RequestParam String todoId,
        @RequestParam String userId,
        @RequestParam String writeDate) {
        ResStatus<List<TodoCheckRes>> result = checklistService.deleteTodoCheck(todoId, userId, writeDate);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/toggleTodoCheck")
    public ResponseEntity<ResStatus<List<TodoCheckRes>>> toggleTodoCheck(
        @RequestParam String todoId,
        @RequestParam String userId,
        @RequestParam String writeDate) {
        ResStatus<List<TodoCheckRes>> result = checklistService.toggleTodoCheck(todoId, userId, writeDate);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/loadTodosCheck")
    public ResponseEntity<ResStatus<List<TodoCheckRes>>> loadTodosCheck(
        @RequestParam String userId,
        @RequestParam String writeDate) {
        ResStatus<List<TodoCheckRes>> result = checklistService.loadTodosCheck(userId, writeDate);
        return result != null ?
                ResponseEntity.status(HttpStatus.OK).body(result) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
