package com.amaizing.crudtemplate.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableEntry {
    private String name;
    private String resourceTable;
    private String tablePathName;
}
