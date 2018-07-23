package bodymassindex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class ApiController {
    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/reports")
    public Page<Report> getReports(Pageable pageable) {
    	return reportRepository.findAll(pageable);
    }
}