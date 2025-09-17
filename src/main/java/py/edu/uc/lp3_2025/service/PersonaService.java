package py.edu.uc.lp3_2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.edu.uc.lp3_2025.domain.Persona;
import py.edu.uc.lp3_2025.repository.PersonaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    public Persona save(Persona persona) {
        // Validación para el campo fechaNacimiento antes de guardar
        if (persona.getFechaNacimiento() != null && persona.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
        }
        return personaRepository.save(persona);
    }

    public Persona update(Long id, Persona personaDetalles) {
        Persona personaExistente = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));

        // Validación para el campo fechaNacimiento en la actualización
        if (personaDetalles.getFechaNacimiento() != null && personaDetalles.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser en el futuro.");
        }

        personaExistente.setNombre(personaDetalles.getNombre());
        personaExistente.setApellido(personaDetalles.getApellido());
        personaExistente.setNumeroDocumento(personaDetalles.getNumeroDocumento());
        personaExistente.setFechaNacimiento(personaDetalles.getFechaNacimiento());

        return personaRepository.save(personaExistente);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
}