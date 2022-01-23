package com.delala.delala.project;

import java.util.List;

import com.delala.delala.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ProjectService {

    @Autowired
    public ProjectRepository projectRepository;

    public ModelAndView relatedUpdates(User user) {
        ModelAndView modelAndView = new ModelAndView("");
        List<Project> projects = projectRepository.findBySkill(user.getSkill());
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

    public String deleteProject(Long id) {
        projectRepository.deleteById(id);
        return "redirect:/";
    }

    public ModelAndView createProject() {
        ModelAndView modelAndView = new ModelAndView("createproject");
        modelAndView.addObject("project", new Project());
        return modelAndView;
    }

    public ModelAndView updateProject(Long id) {
        ModelAndView modelAndView = new ModelAndView("");
        Project project = projectRepository.findById(id).get();
        modelAndView.addObject("project", project);
        return modelAndView;

    }

    public String saveProject(Project project) {
        projectRepository.save(project);
        return "redirect:/";
    }

    public ModelAndView projectList() {
        ModelAndView modelAndView = new ModelAndView("");
        List<Project> projects = projectRepository.findAll();
        modelAndView.addObject("projects", projects);
        return modelAndView;
    }

}
