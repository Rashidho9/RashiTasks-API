package de.rashid.rashitasks_api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TaskController {
	
	// Unsere Aufgaben-Liste (vorerst nur im Arbeitsspeicher)
    private final List<Task> tasks = new ArrayList<Task>();
    
    // Konstruktor: ein paar Beispiel-Aufgaben beim Start anlegen
    public TaskController() {
    	tasks.add(new Task(1L, "Java lernen", false));
    	tasks.add(new Task(2L, "Spring Boot verstehen", false));
    	tasks.add(new Task(3L, "GitHub einrichten", true));
    }
    
    // GET /tasks -> gibt alle Aufgaben als JSON zurück
    @GetMapping("/tasks")
    public List<Task> alleTasks(){
    	return tasks;
    }
    
    // POST /tasks -> neue Aufgabe anlegen
    // @RequestBody: Spring wandelt das gesendete JSON in ein Task-Objekt um
    @PostMapping("/tasks")
    public Task neueTask(@RequestBody Task task) {
    	task.setId((long)tasks.size() + 1); // nächste freie Nummer
        tasks.add(task);
		return task;// die neue Aufgabe zurückgeben
    }
    
}
