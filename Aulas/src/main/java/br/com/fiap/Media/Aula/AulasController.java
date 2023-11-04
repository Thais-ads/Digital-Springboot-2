package br.com.fiap.Media.Aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/aula")
public class AulasController {

    @Autowired
    AulasService service;
    @GetMapping()
    public String index(Model model){
        model.addAttribute("aulas", service.findAll());
        return "aula/index";
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id, RedirectAttributes redirect){
        if(service.delete(id)){
            redirect.addFlashAttribute("success", "Aula apagada com sucesso");
            return "redirect:/aula";
        }else{
            redirect.addFlashAttribute("error", "Aula Não encontrada");
        }
        return "redirect:/aula";

    }

}
