package TaniaGrup.WorkTable.web;

import TaniaGrup.WorkTable.beans.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class ForgotPasswordController {

    @GetMapping(value = {"/forgot-password.html"})
    public ModelAndView page() throws IOException {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        modelAndView.addObject("listProfession", listProfession);
        modelAndView.setViewName("forgot-password");
        return modelAndView;
    }

    @PostMapping(value = {"/register"})
    public ModelAndView submitForm(@ModelAttribute("user") User user) {
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        modelAndView.addObject("listProfession", listProfession);
        modelAndView.setViewName("forgot-password");
        return modelAndView;
    }
}
