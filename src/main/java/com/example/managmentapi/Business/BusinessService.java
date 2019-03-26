package com.example.managmentapi.Business;

import com.example.managmentapi.Table.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BusinessService {
    @Autowired
    BusinessRepository businessRepository;

    public Business add(Business business){
        return businessRepository.save(business);
    }

    public List<Business> getBusinesses(){
        return (List<Business>) businessRepository.findAll();
    }

    public Business getBusiness(Integer id){
        return businessRepository.findById(id).orElse(new Business());
    }

    public Integer edit(Integer id, Business business) {
        if (businessRepository.findById(id).isPresent()) {
            business.setId(id);
            return businessRepository.save(business).getId();
        }
        else return -1;
    }

    public void delete(Integer id) {
        if (businessRepository.findById(id).isPresent())
            businessRepository.delete(businessRepository.findById(id).get());
    }

    public void addTable(Integer id, Table table) {
        if (businessRepository.findById(id).isPresent())
            businessRepository.findById(id).get().getTables().add(table);
    }

    public void deleteTable(Integer idb, Integer idt) {
        if (businessRepository.findById(idb).isPresent()) {
            Set<Table> tables = businessRepository.findById(idb).get().getTables();
            for (Table t: tables) {
                if (t.getId() == idt) {
                    tables.remove(t);
                    break;
                }
            }
        }
    }

    public void updateDisponibility(Integer id, int disp){
        businessRepository.findById(id).get().setDisponibility(disp);
    }

}
