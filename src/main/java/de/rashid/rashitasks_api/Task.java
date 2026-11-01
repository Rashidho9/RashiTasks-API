package de.rashid.rashitasks_api;

//Eine Aufgabe (Task) mit id, Titel und Status erledigt ja/nein
public class Task {
	
	private Long id;          // eindeutige Nummer
    private String titel;     // z. B. "Java lernen"
    private boolean erledigt; // true = fertig, false = offen

	
	// Leerer Konstruktor (braucht Spring, um JSON in ein Objekt umzuwandeln)
    public Task() {}
    
    // Konstruktor mit allen Werten
    public Task(Long id, String titel, boolean erledigt) {
    	this.id = id;
    	this.titel = titel;
    	this.erledigt = erledigt;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }
    public boolean isErledigt() { return erledigt; }
    public void setErledigt(boolean erledigt) { this.erledigt = erledigt; }

}
