package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.Predlog;
import TaniaGrup.WorkTable.beans.Verb;
import TaniaGrup.WorkTable.repository.PredlogRepository;
import TaniaGrup.WorkTable.repository.VerbRepository;
import TaniaGrup.WorkTable.service.FileReadService;
import TaniaGrup.WorkTable.service.PredlogRepositoryInitService;
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
    private PredlogRepositoryInitService predlogRepositoryInitService;
    private VerbRepository verbRepository;
    private PredlogRepository predlogRepository;



    @GetMapping(value = {"/tables.html"})
    public ModelAndView page() throws IOException {
        if (predlogRepository.count() == 0) {
            predlogRepositoryInitService.init();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", (List<Predlog>) predlogRepository.findAll());
        modelAndView.setViewName("tables");
        return modelAndView;
    }
}
