package com.websi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websi.app.model.Servico;
import com.websi.app.repository.ServicoRepository;

@Controller
@RequestMapping("/")
public class ServiceController {
    
	@Autowired
	ServicoRepository servicoRepository;
	
	@GetMapping
	public String index() {
		return "redirect:/servicos";
	}
	
    @GetMapping("/servicos")
    public ModelAndView home(ModelAndView mv) {
    	mv.setViewName("servicos");
    	mv.addObject("servicos", servicoRepository.findAll());
    	mv.addObject("tipos", Servico.Tipo.values());
    	mv.addObject("categorias", Servico.Categoria.values());
        return mv;
    }
    
    @PostMapping("/servicos/add")
    public String add(@ModelAttribute("servico") Servico servico) {
    	servicoRepository.save(servico);
    	return index();
    }
    
    @GetMapping("/servicos/{id}/delete")
    public String delete(@PathVariable("id") Servico servico) {
    	servicoRepository.delete(servico);
    	return index();
    }
    
    @PostMapping("/servicos/{id}/update")
    public String update (@ModelAttribute("servico") Servico servico) {
    	servicoRepository.saveAndFlush(servico);
    	return index();
    }
    
}
