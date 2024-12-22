package sn.uasz.genseignement.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sn.uasz.genseignement.entities.Enseignant;
import sn.uasz.genseignement.repositories.EnseignantRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class EnseignantController {

    private EnseignantRepository enseignantRepository;

    @GetMapping("/index")
    public String listEnseignants(Model model){
        List<Enseignant> listEnseignants=enseignantRepository.findAll();
        model.addAttribute("listePatientsM",listEnseignants);
        return "enseignants";
    }
}
