package com.example.managmentapi.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TableService {
    @Autowired
    TableRepository tableRepository;

    public Table add(Table table){
        return tableRepository.save(table);
    }

    public List<Table> getTables(){
        return (List<Table>) tableRepository.findAll();
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

    public void delete(Integer id) {
        if (tableRepository.findById(id).isPresent())
            tableRepository.delete(tableRepository.findById(id).get());
    }
}
