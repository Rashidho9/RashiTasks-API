package de.rashid.rashitasks_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController: Diese Klasse beantwortet Anfragen aus dem Browser
@RestController
public class HalloController {
	
	// @GetMapping: Wenn jemand /hallo aufruft, wird diese Methode ausgeführt
    @GetMapping("/hallo")
    public String hallo() {
    	return "Hallo Rashid! RashiTasks-API läuft 🚀";
    }
}