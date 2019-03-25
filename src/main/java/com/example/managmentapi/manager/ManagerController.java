package com.example.managmentapi.manager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    private final ManagerService managerService;
    private final ManagerRepository managerRepository;

    public ManagerController(ManagerService managerService, ManagerRepository managerRepository) {
        this.managerService = managerService;
        this.managerRepository = managerRepository;
    }

    @GetMapping("/managers")
    private List<Manager> fetchManagers() {
        return managerService.getManagers();
    }

    @GetMapping("/manager/{id}")
    private Manager fetchManager(@PathVariable("id") Integer id) {
        return managerService.getManager(id);
    }

    @PostMapping("/manager")
    private Integer addManager(@RequestBody Manager manager) {
        return managerService.add(manager).getId();
    }

    @PostMapping("/manager/{id}")
    private Integer editManager(@RequestBody Manager manager, @PathVariable("id") Integer id) {
        return managerService.edit(id, manager);
    }

    @DeleteMapping("/manager/{id}")
    private void deleteManager(@PathVariable("id") Integer id) {
        if (managerRepository.findById(id).isPresent())
            managerService.delete(managerRepository.findById(id).get());

    }

}
