package com.vcrmm.todobackend.service;

import com.vcrmm.todobackend.entity.Todo;
import com.vcrmm.todobackend.exception.todo.TodoNotFoundByIdException;

import java.util.List;

public interface TodoService {
    List<Todo> findAll();
    Todo save(Todo todo);
    Todo findById(Long id) throws TodoNotFoundByIdException;
    void deleteById(Long id) throws TodoNotFoundByIdException;
    Todo complete(Long id, Todo todo) throws TodoNotFoundByIdException;
}
