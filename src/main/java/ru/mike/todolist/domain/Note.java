package ru.mike.todolist.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "note")
public class Note {
    @Id
    private UUID id;

    @Column(name = "text")
    private String text;

    @Column(name = "timestamp")
    private long timestamp;

    @Column(name = "done")
    private boolean done;

    @Column(name = "user_id")
    private String userId;
}
