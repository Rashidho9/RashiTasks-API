package de.rashid.rashitasks_api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    // PUT /tasks/{id} -> eine Aufgabe ändern
    // @PathVariable: holt die id aus der Adresse, z. B. /tasks/2
    @PutMapping("/tasks/{id}")
    public Task taskAendern(@PathVariable Long id, @RequestBody Task neu) {
    	for (Task t : tasks) {
			if (t.getId().equals(id)) {
				t.setTitel(neu.getTitel());
				t.setErledigt(neu.isErledigt());
				return t;// die geänderte Aufgabe
			}
		}
    	
    	return null;// nicht gefunden (verbessern wir später)
    }
    
    // DELETE /tasks/{id} -> eine Aufgabe löschen
    @DeleteMapping("/tasks/{id}")
    public String taskloeschen(@PathVariable Long id) {
    	boolean entfert = tasks.removeIf(t -> t.getId().equals(id));
    	return entfert ? "Task " + id + " gelöscht" : "Task " + id + " nicht gefunden";
    }
    
}
