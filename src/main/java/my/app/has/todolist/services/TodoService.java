package my.app.has.todolist.services;

import my.app.has.todolist.models.Todo;
import my.app.has.todolist.repositories.ITodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService implements ITodoService {

    @Autowired
    ITodoRepository todoRepository;

    public Iterable<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTodoDetail(Long id) {
        Optional<Todo> optional = todoRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
