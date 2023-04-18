package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.Particle;
import TaniaGrup.WorkTable.beans.ParticleVersion;
import TaniaGrup.WorkTable.beans.VerbParticleVersion;
import TaniaGrup.WorkTable.repository.ParticleRepository;
import TaniaGrup.WorkTable.repository.ParticleVersionRepository;
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
public class TablesParticleVersionsController {

    private ParticleVersionRepository particleVersionRepository;

    @GetMapping(value = {"/tablesParticleVersions"})
    public ModelAndView page(@RequestParam Optional<String> particle) throws IOException {
        String p = particle.orElse("");

        List<ParticleVersion> list = ((List<ParticleVersion>) particleVersionRepository.findAll())
                .stream()
                .filter(a -> p.equals("") || (a.getParticle().getParticle().equals(p)))
                .collect(Collectors.toList());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("tables-particle-versions");
        return modelAndView;
    }
}