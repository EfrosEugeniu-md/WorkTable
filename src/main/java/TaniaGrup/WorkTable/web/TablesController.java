package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.ParticleVersion;
import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
import TaniaGrup.WorkTable.repository.VerbParticleVersionRepository;
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

    private VerbParticleVersionRepositoryInitService verbRepositoryInitService;
    private ParticleVersionRepositoryInitService particleVersionRepositoryInitService;
    private VerbParticleVersionRepository verbParticleVersionRepository;
    private ParticleVersionRepository particleVersionRepository;



    @GetMapping(value = {"/tables.html"})
    public ModelAndView page() throws IOException {
        if (verbParticleVersionRepository.count() == 0) {
            verbRepositoryInitService.init();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", (List<VerbParticleVersion>) verbParticleVersionRepository.findAll());
        modelAndView.setViewName("tables");
        return modelAndView;
    }
}
