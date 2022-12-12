package ru.mike.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mike.todolist.domain.Note;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
}
