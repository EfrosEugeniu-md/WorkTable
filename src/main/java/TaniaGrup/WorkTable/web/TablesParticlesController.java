package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.repository.ParticleRepository;
import TaniaGrup.WorkTable.repository.VerbRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class TablesParticlesController {

    private ParticleRepository particleRepository;

    @GetMapping(value = {"/tablesParticles"})
    public ModelAndView page() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", (List<Particle>) particleRepository.findAll());
        modelAndView.setViewName("tables-particles");
        return modelAndView;
    }
}
