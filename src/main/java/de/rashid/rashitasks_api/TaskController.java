package de.rashid.rashitasks_api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
