package com.example.managmentapi.manager;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ManagerController {

    private final ManagerService managerService;
    private final ManagerRepository managerRepository;

    public ManagerController(ManagerService managerService, ManagerRepository managerRepository) {
        this.managerService = managerService;
        this.managerRepository = managerRepository;
    }

    @GetMapping("/managers")
    public List<Manager> fetchManagers() {
        return managerService.getManagers();
    }

    @GetMapping("/manager/{id}")
    public Manager fetchManager(@PathVariable("id") Integer id) {
        return managerService.getManager(id);
    }

    @PostMapping("/manager")
    public Integer addManager(@RequestBody Manager manager) {
        return managerService.add(manager).getId();
    }

    @PostMapping("/manager/{id}")
    public Integer editManager(@RequestBody Manager manager, @PathVariable("id") Integer id) {
        return managerService.edit(id, manager);
    }

    @DeleteMapping("/manager/{id}")
    public void deleteManager(@PathVariable("id") Integer id) {
        managerService.delete(id);
    }

}
