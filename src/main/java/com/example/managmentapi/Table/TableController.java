package com.example.managmentapi.Table;

import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/tables")
    public List<Table> fetchTables() {
        return tableService.getTables();
    }


    @PostMapping("/table")
    public Integer addTable(@RequestBody Table table) {
        return tableService.add(table).getId();
    }

    @PostMapping("/table/{id}")
    public Integer editTable(@RequestBody Table table, @PathVariable("id") Integer id) {
        return tableService.edit(id, table);
    }

    @DeleteMapping("/table/{id}")
    public void deleteTable(@PathVariable("id") Integer id) {
        tableService.delete(id);
    }
}
