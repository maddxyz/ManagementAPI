package com.example.managmentapi.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;

    public Table add(Table table){
        return tableRepository.save(table);
    }

    public Set<Table> getCategories(){
        return (Set<Table>) tableRepository.findAll();
    }

    public Table getTable(Integer id){
        return tableRepository.findById(id).orElse(new Table());
    }

    public Integer edit(Integer id, Table table) {
        if (tableRepository.findById(id).isPresent()) {
            table.setId(id);
            return tableRepository.save(table).getId();
        }
        else return -1;
    }

    public void delete(Table table) {
        tableRepository.delete(table);
    }
}
