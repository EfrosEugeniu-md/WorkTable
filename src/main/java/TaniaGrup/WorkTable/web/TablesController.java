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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TablesController {
    private VerbParticleVersionRepository verbParticleVersionRepository;

    @GetMapping(value = {"/tables"})
    public ModelAndView page(@RequestParam Optional<String> verb, @RequestParam Optional<String> particle) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        String v = verb.orElse("");
        String p = particle.orElse("");

        List<VerbParticleVersion> list = ((List<VerbParticleVersion>) verbParticleVersionRepository.findAll())
                .stream()
                .filter(a -> v.equals("") || (a.getVerb().getVerb().equals(v)))
                .filter(a -> p.equals("") || (a.getParticleVersion().getParticle().getParticle().equals(p)))
                .collect(Collectors.toList());

        modelAndView.addObject("list", list);
        modelAndView.setViewName("tables");
        return modelAndView;
    }
}
