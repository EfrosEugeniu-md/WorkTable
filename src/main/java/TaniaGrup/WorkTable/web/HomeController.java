package TaniaGrup.WorkTable.web;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class HomeController {


    @GetMapping(value = {"", "/", "/home", "/index.html", "/nhgf"})
    public ModelAndView viewHomePage() throws IOException {

        ModelAndView modelAndView = new ModelAndView();
       // modelAndView.addObject("list", trolleybusService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
