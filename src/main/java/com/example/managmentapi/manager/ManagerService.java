package com.example.managmentapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;

    public Manager add(Manager manager){
        return managerRepository.save(manager);
    }

    public List<Manager> getManagers(){
        return (List<Manager>) managerRepository.findAll();
    }

    public Manager getManager(Integer id){
        return managerRepository.findById(id).orElse(new Manager());
    }

    public Integer edit(Integer id, Manager manager) {
        if (managerRepository.findById(id).isPresent()) {
            manager.setId(id);
            return managerRepository.save(manager).getId();
        }
        else return -1;
    }

    public void delete(Integer id) {
        if (managerRepository.findById(id).isPresent())
            managerRepository.delete(managerRepository.findById(id).get());
    }

}
