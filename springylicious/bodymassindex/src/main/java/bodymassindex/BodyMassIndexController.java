package bodymassindex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class BodyMassIndexController {	
    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/bodymassindex")
    public String BodyMassIndexForm(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/report")
    public String greetingSubmit(@ModelAttribute User user, Model model) throws InvalidUserDataException {
    	Calculator calculator = new Calculator(user);
    	Report report = calculator.getReport();
    	
    	reportRepository.save(report);
    	model.addAttribute("report", report);
    	
        return "report";
    }
}