package br.com.biblioteca.controller;


import br.com.biblioteca.model.dto.ProjectRequest;
import br.com.biblioteca.model.dto.ProjectResponse;
import br.com.biblioteca.model.enuns.RiskEnum;
import br.com.biblioteca.model.enuns.StatusProjectEnum;
import br.com.biblioteca.service.PersonService;
import br.com.biblioteca.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class ProjetoController {

    private final ProjetoService projetoService;

    private final PersonService personService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @GetMapping("/")
    public String home(ModelMap model, HttpServletRequest httpServletRequest) {
        loadIndexPage(model, new ProjectResponse());
        return "index";
    }

    @GetMapping("list-projects")
    public String findAllProjects(ModelMap model) {
        model.put("projects", projetoService.findAll());
        return "list-projects";
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<ProjectResponse> findById(@PathVariable("id") Long id) {
        return projetoService.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public String save(@Valid ProjectRequest projectRequest) {
        projetoService.save(projectRequest);
        return "redirect:/list-projects";
    }

    @GetMapping("delete-project")
    public String deleteById(@RequestParam("id") Long id) {
        projetoService.delete(id);
        return "redirect:/list-projects";
    }

    @GetMapping("update-project")
    public String updateGet(@RequestParam("id") Long id, ModelMap model) {
        loadIndexPage(model, projetoService.findById(id).orElse(null));
        return "index";
    }

    @PostMapping(value = "update-project")
    public String updatePost(ModelMap model, @Valid ProjectRequest request, BindingResult result) {
        if (result.hasErrors()) {
            loadIndexPage(model, null);
            return "index";
        }
        projetoService.update(request);
        return "redirect:/list-projects";
    }

    private void loadIndexPage(ModelMap model, ProjectResponse projectResponse) {
        model.addAttribute("project", Objects.nonNull(projectResponse) ? projectResponse : new ProjectResponse());
        model.addAttribute("status", StatusProjectEnum.values());
        model.addAttribute("risks", RiskEnum.values());
        model.addAttribute("managers", personService.findAllByGerenteIs(Boolean.TRUE));
    }

}
