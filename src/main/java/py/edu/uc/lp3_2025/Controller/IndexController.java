package py.edu.uc.lp3_2025.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import py.edu.uc.lp3_2025.dto.SaludoDto;

@RestController
public class IndexController {

    @GetMapping("/")
    public RedirectView redirectToHolaMundo() {
        return new RedirectView("/HolaMundo/Mundo");
    }

    @GetMapping("/HolaMundo/{nombre}")
    public SaludoDto HolaMundo(@PathVariable String nombre) {
        String mensaje =  "¡Hola " + nombre + "!";
        return new SaludoDto(mensaje);
    }

}