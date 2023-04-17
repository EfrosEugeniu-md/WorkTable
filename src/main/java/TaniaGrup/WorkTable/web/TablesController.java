package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.ParticleVersion;
import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import TaniaGrup.WorkTable.repository.ParticleRepository;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
import TaniaGrup.WorkTable.repository.VerbParticleVersionRepository;
import TaniaGrup.WorkTable.repository.VerbRepository;
import TaniaGrup.WorkTable.service.ParticleVersionRepositoryInitService;
import TaniaGrup.WorkTable.service.VerbParticleVersionRepositoryInitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class TablesController {
    private VerbParticleVersionRepository verbParticleVersionRepository;

    @GetMapping(value = {"/tables"})
    public ModelAndView page() throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", (List<VerbParticleVersion>) verbParticleVersionRepository.findAll());
        modelAndView.setViewName("tables");
        return modelAndView;
    }
}
