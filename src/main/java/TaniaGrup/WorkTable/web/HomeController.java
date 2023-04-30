package TaniaGrup.WorkTable.web;


import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import TaniaGrup.WorkTable.repository.ParticleRepository;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
import TaniaGrup.WorkTable.repository.VerbParticleVersionRepository;
import TaniaGrup.WorkTable.repository.VerbRepository;
import TaniaGrup.WorkTable.service.MoldElecService;
import TaniaGrup.WorkTable.service.ParticleVersionRepositoryInitService;
import TaniaGrup.WorkTable.service.VerbParticleVersionRepositoryInitService;
import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private VerbParticleVersionRepositoryInitService verbRepositoryInitService;
    private ParticleVersionRepositoryInitService particleVersionRepositoryInitService;
    private MoldElecService moldElecService;

    private VerbParticleVersionRepository verbParticleVersionRepository;
    private ParticleVersionRepository particleVersionRepository;
    private ParticleRepository particleRepository;
    private VerbRepository verbRepository;
    @GetMapping(value = {"", "/", "/home", "/index.html", "/nhgf"})
    public ModelAndView viewHomePage() throws IOException, InvalidFormatException {
        moldElecService.init();
        if (verbParticleVersionRepository.count() == 0) {
            verbRepositoryInitService.init();
            particleVersionRepositoryInitService.init();
        }
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("verbParticleVersions", verbParticleVersionRepository.count());
        modelAndView.addObject("particleVersions", particleVersionRepository.count());
        modelAndView.addObject("particles", particleRepository.count());
        modelAndView.addObject("verbs", verbRepository.count());


        modelAndView.setViewName("index");
        return modelAndView;
    }
}
