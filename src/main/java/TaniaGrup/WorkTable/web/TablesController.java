package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.repository.VerbRepository;
import TaniaGrup.WorkTable.service.FileReadService;
import TaniaGrup.WorkTable.service.VerbRepositoryInitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class TablesController {

    private VerbRepositoryInitService verbRepositoryInitService;
    private VerbRepository verbRepository;

    @GetMapping(value = {"/tables.html"})
    public ModelAndView page() throws IOException {
        if (verbRepository.count() == 0) {
            verbRepositoryInitService.init();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", (List<Verb>) verbRepository.findAll());
        modelAndView.setViewName("tables");
        return modelAndView;
    }
}
