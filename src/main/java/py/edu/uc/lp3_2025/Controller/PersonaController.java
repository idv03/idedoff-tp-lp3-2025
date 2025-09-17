package py.edu.uc.lp3_2025.Controller;

import org.springframework.web.bind.annotation.*;
import py.edu.uc.lp3_2025.domain.Persona;
import py.edu.uc.lp3_2025.service.PersonaService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    // CREATE
    @PostMapping
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    // READ
    @GetMapping
    public List<Persona> obtenerTodasLasPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> obtenerPersonaPorId(@PathVariable Long id) {
        return personaService.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Persona actualizarPersona(@PathVariable Long id, @RequestBody Persona personaDetalles) {
        return personaService.update(id, personaDetalles);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.deleteById(id);
    }
}