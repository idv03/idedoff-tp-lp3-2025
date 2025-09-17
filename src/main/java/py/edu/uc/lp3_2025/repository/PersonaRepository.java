package py.edu.uc.lp3_2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import py.edu.uc.lp3_2025.domain.Persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}