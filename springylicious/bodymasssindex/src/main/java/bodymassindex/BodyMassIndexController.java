package bodymassindex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BodyMassIndexController {

    @GetMapping("/bodymassindex")
    public String BodyMassIndexForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/report")
    public String greetingSubmit(@ModelAttribute User user, Model model) throws InvalidUserDataException {
    	Calculator calculator = new Calculator(user);
    	model.addAttribute("report", calculator.getReport());
        return "report";
    }
}