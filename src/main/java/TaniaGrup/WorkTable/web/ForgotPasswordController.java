package TaniaGrup.WorkTable.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@AllArgsConstructor
public class ForgotPasswordController {

    @GetMapping(value = {"/forgot-password.html"})
    public ModelAndView page() throws IOException {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("forgot-password");
        return modelAndView;
    }
}
