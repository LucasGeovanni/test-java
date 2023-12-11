package br.com.biblioteca.controller;


import br.com.biblioteca.service.MemberService;
import br.com.biblioteca.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

    private final PersonService personService;

    @GetMapping("list-members")
    public String findMembers(@RequestParam("projectId") Long projectId, ModelMap model) {
        personService.setAllEmployees(projectId, model);
        return "list-members";
    }

    @GetMapping("delete-member")
    public String deleteMember(@RequestParam("projectId") Long projectId, @RequestParam("memberId") Long memberId,  ModelMap model) {
        memberService.deleteMember(projectId, memberId);
        personService.setAllEmployees(projectId, model);
        return "redirect:/list-members?projectId=" + projectId;
    }

    @GetMapping("add-member")
    public String addMember(@RequestParam("projectId") Long projectId, @RequestParam("memberId") Long memberId, ModelMap model) {
        memberService.addMember(projectId, memberId);
        personService.setAllEmployees(projectId, model);
        return "redirect:/list-members?projectId=" + projectId;
    }

}
