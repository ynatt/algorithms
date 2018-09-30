package com.velvn.algorithms.benchmark;

import java.util.*;

public class Table {

    private Set<String> columnHeaders;

    private String rowNameHeader;

    private Map<String, Map<String, String>> rows;

    private String title;

    public Table(String title, String rowNameHeader) {
        this.title = title;
        this.rowNameHeader = rowNameHeader;
        columnHeaders = new TreeSet<>();
        rows = new TreeMap<>();
    }

    public void addColumnHeader(String columnHeader) {
        columnHeaders.add(columnHeader);
    }

    public void addRow(String rowName, Map<String, String> columnHeaderOnCellValue) {
        rows.put(rowName, columnHeaderOnCellValue);
    }

    public void addRow(String rowName) {
        if(!rows.containsKey(rowName)) {
            rows.put(rowName, new HashMap<>(1));
        }
    }

    public void setCellValue(String rowName, String headerName, String value) {
        if (rows.containsKey(rowName)) {
            rows.get(rowName).put(headerName,value);
        } else {
            HashMap<String, String> cell = new HashMap<>(1);
            cell.put(headerName, value);
            rows.put(rowName, cell);
        }
    }

    public Set<String> getColumnHeaders() {
        return columnHeaders;
    }

    public void setColumnHeaders(Set<String> columnHeaders) {
        this.columnHeaders = columnHeaders;
    }

    public String getRowNameHeader() {
        return rowNameHeader;
    }

    public void setRowNameHeader(String rowNameHeader) {
        this.rowNameHeader = rowNameHeader;
    }

    public Map<String, Map<String, String>> getRows() {
        return rows;
    }

    public void setRows(Map<String, Map<String, String>> rows) {
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
