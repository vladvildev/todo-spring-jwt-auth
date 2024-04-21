package com.vcrmm.todobackend.service.impl;

import com.vcrmm.todobackend.entity.Todo;
import com.vcrmm.todobackend.exception.message.TodoExceptionMessages;
import com.vcrmm.todobackend.exception.todo.TodoNotFoundByIdException;
import com.vcrmm.todobackend.repo.TodoRepository;
import com.vcrmm.todobackend.service.TodoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo findById(Long id) throws TodoNotFoundByIdException {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundByIdException(TodoExceptionMessages.TODO_NOT_FOUND_BY_ID.getMessage()));
    }

    @Override
    public void deleteById(Long id) throws TodoNotFoundByIdException {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundByIdException(TodoExceptionMessages.TODO_NOT_FOUND_BY_ID.getMessage());
        }

        todoRepository.deleteById(id);
    }

    @Override
    public Todo complete(Long id, Todo todo) throws TodoNotFoundByIdException {
        if(!todoRepository.existsById(id)) {
            throw new TodoNotFoundByIdException(TodoExceptionMessages.TODO_NOT_FOUND_BY_ID.getMessage());
        }

        todo.setCompleted(true);
        return todoRepository.save(todo);
    }
}
