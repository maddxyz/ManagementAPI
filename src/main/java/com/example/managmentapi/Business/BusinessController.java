package com.example.managmentapi.Business;

import com.example.managmentapi.Table.Table;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class BusinessController {
    private final BusinessService businessService;
    private final BusinessRepository businessRepository;

    public BusinessController(BusinessService businessService, BusinessRepository businessRepository) {
        this.businessService = businessService;
        this.businessRepository = businessRepository;
    }

    @GetMapping("/businesses")
    public Set<Business> fetchBusinesses() {
        return businessService.getBusinesses();
    }

    @GetMapping("/business/{id}")
    public Business fetchBusiness(@PathVariable("id") Integer id) {
        return businessService.getBusiness(id);
    }

    @PostMapping("/business")
    public Integer addBusiness(@RequestBody Business business) {
        return businessService.add(business).getId();
    }

    @PostMapping("/business/{id}")
    public Integer editBusiness(@RequestBody Business business, @PathVariable("id") Integer id) {
        return businessService.edit(id, business);
    }

    @DeleteMapping("/business/{id}")
    public void deleteBusiness(@PathVariable("id") Integer id) {
            businessService.delete(id);
    }

    @PostMapping("/business/{id}/table/add")
    public void addTable(@RequestBody Table table, @PathVariable("id") Integer id) {
        businessService.addTable(id, table);
    }

    @PostMapping("/business/{idb}/table/{idt}/delete")
    public void deleteTable(@PathVariable("idb") Integer idb, @PathVariable("idb") Integer idt) {
        businessService.deleteTable(idb, idt);
    }

    @PostMapping("/business/{id}/disponibility")
    public void updateDisponibility(@RequestBody int dispo, @PathVariable("idb") Integer id){
        businessService.updateDisponibility(id, dispo);
    }
}
