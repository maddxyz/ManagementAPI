package com.example.managmentapi.Business;

import com.example.managmentapi.Table.Table;
import com.example.managmentapi.Table.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BusinessService {
    @Autowired
    BusinessRepository businessRepository;
    @Autowired
    TableRepository tableRepository;

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

    public void addTable(Integer id, Integer idTable) {
        if (businessRepository.findById(id).isPresent() && tableRepository.findById(idTable).isPresent()) {
            tableRepository.findById(idTable).get().setBusiness(businessRepository.findById(id).get());
            tableRepository.save(tableRepository.findById(idTable).get());
        }

    }

    public void deleteTable(Integer id, Integer idTable) {
        if (businessRepository.findById(id).isPresent() && tableRepository.findById(idTable).isPresent()) {
            tableRepository.findById(idTable).get().setBusiness(null);
            tableRepository.save(tableRepository.findById(idTable).get());
        }
    }

    public void updateDisponibility(Integer id, int disp){
        businessRepository.findById(id).get().setDisponibility(disp);
    }

}
