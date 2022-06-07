package com.example.springtodo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoItemRepository toDoItemRepository;

    public ToDoController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    @GetMapping
    public List<ToDoItem> getToDoItems() {
        return toDoItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ToDoItem getToDoItem(@PathVariable Long id) {
        return toDoItemRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody ToDoItem toDoItem) throws URISyntaxException {
        ToDoItem savedToDoItem = toDoItemRepository.save(toDoItem);
        return ResponseEntity.created(new URI("/clients/" + savedToDoItem.getId())).body(savedToDoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateToDoItem(@PathVariable Long id, @RequestBody ToDoItem toDoItem) {
        ToDoItem currentToDoItem = toDoItemRepository.findById(id).orElseThrow(RuntimeException::new);
        currentToDoItem.setName(toDoItem.getName());
        currentToDoItem = toDoItemRepository.save(toDoItem);

        return ResponseEntity.ok(currentToDoItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteToDoItem(@PathVariable Long id) {
        toDoItemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}