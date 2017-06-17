package com.websi.app.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.websi.app.model.Servico;
import com.websi.app.repository.ServicoRepository;

@Controller
@RequestMapping("/")
public class ServiceController {
    private static final String MENSAGEM = "erros", COR = "cor";
    
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping
	public ModelAndView index(Servico servico) {
		return new ModelAndView("redirect:/servicos");
	}
	
    @GetMapping("/servicos")
    public ModelAndView home(Servico servico, ModelAndView mv) {
    	mv.setViewName("servicos");
    	mv.addObject("newServico", servico);
    	mv.addObject("servicos", servicoRepository.findAll());
    	mv.addObject("tipos", Servico.Tipo.values());
    	mv.addObject("categorias", Servico.Categoria.values());
        return mv;
    }
    
    @PostMapping("/servicos/add")
    public ModelAndView add(@Valid @ModelAttribute("servico") Servico servico, BindingResult result, RedirectAttributes rd) {
    	if (result.hasErrors()) {
    		rd.addFlashAttribute(COR, "red");
            ArrayList<String> erros = new ArrayList<>();
            for (FieldError err : result.getFieldErrors()) erros.add(err.getDefaultMessage());
    		rd.addFlashAttribute(MENSAGEM, erros);
    		return index(servico);
    	}
    	servicoRepository.save(servico);
    	rd.addFlashAttribute(COR, "green");
    	rd.addFlashAttribute(MENSAGEM, "Serviço adicionado com sucesso.");
    	return index(new Servico());
    }
    
    @GetMapping("/servicos/{id}/delete")
    public ModelAndView delete(@PathVariable("id") Servico servico, RedirectAttributes rd) {
    	servicoRepository.delete(servico);
    	rd.addFlashAttribute(COR, "green");
    	rd.addFlashAttribute(MENSAGEM, "Serviço excluido com sucesso.");
    	return index(new Servico());
    }
    
    @PostMapping("/servicos/{id}/update")
    public ModelAndView update (@Valid @ModelAttribute("servico") Servico servico, BindingResult result, RedirectAttributes rd) {
    	if (result.hasErrors()) {
    		rd.addFlashAttribute(COR, "red");
            ArrayList<String> erros = new ArrayList<>();
            for (FieldError err : result.getFieldErrors()) erros.add(err.getDefaultMessage());
    		rd.addFlashAttribute(MENSAGEM, erros);
    		return index(servico);
    	}
    	servicoRepository.saveAndFlush(servico);
    	rd.addFlashAttribute(COR, "green");
    	rd.addFlashAttribute(MENSAGEM, "Serviço alterado com sucesso.");
    	return index(new Servico());
    }
    
}
