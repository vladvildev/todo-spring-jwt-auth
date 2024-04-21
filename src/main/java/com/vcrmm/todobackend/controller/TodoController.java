package com.vcrmm.todobackend.controller;

import com.vcrmm.todobackend.entity.Todo;
import com.vcrmm.todobackend.exception.todo.TodoNotFoundByIdException;
import com.vcrmm.todobackend.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) throws TodoNotFoundByIdException {
        return ResponseEntity.ok(todoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.save(todo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> complete(@PathVariable Long id,@RequestBody Todo todo) throws TodoNotFoundByIdException {
        return ResponseEntity.ok(todoService.complete(id, todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) throws TodoNotFoundByIdException {
        todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
