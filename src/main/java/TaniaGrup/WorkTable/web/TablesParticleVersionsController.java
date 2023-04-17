package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.ParticleVersion;
import TaniaGrup.WorkTable.repository.ParticleRepository;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class TablesParticleVersionsController {

    private ParticleVersionRepository particleVersionRepository;

    @GetMapping(value = {"/tablesParticleVersions"})
    public ModelAndView page() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", (List<ParticleVersion>) particleVersionRepository.findAll());
        modelAndView.setViewName("tables-particle-versions");
        return modelAndView;
    }
}
