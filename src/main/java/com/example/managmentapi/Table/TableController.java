package com.example.managmentapi.Table;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TableController {
    private final TableService tableService;
    private final TableRepository tableRepository;

    public TableController(TableService tableService, TableRepository tableRepository) {
        this.tableService = tableService;
        this.tableRepository = tableRepository;
    }

    @GetMapping("/table/{id}")
    public Table fetchTable(@PathVariable Integer id) {
        return tableService.getTable(id);
    }

    @GetMapping("/categories")
    public Set<Table> fetchCategories() {
        return tableService.getCategories();
    }


    @PostMapping("/table")
    private Integer addTable(@RequestBody Table table) {
        return tableService.add(table).getId();
    }

    @PostMapping("/table/{id}")
    private Integer editTable(@RequestBody Table table, @PathVariable("id") Integer id) {
        return tableService.edit(id, table);
    }

    @DeleteMapping("/table/{id}")
    private void deleteTable(@PathVariable("id") Integer id) {
        if (tableRepository.findById(id).isPresent())
            tableService.delete(tableRepository.findById(id).get());

    }
}
