package com.velvn.algorithms.benchmark;

import java.util.Map;
import java.util.Objects;

public class TableView {

    public void show(Table table) {
        System.out.println(table.getTitle());
        int maxRowNameSize = table.getRowNameHeader().length();
        for (String rowName : table.getRows().keySet()) {
            if (rowName.length() > maxRowNameSize) {
                maxRowNameSize = rowName.length();
            }
        }
        int maxColumnsHeadersSize = 20;
        for (String column : table.getColumnHeaders()) {
            if (column.length() > maxColumnsHeadersSize) {
                maxColumnsHeadersSize = column.length();
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("%-" + maxRowNameSize + "s", table.getRowNameHeader()));
        for (String header : table.getColumnHeaders()) {
            builder.append(" | ");
            builder.append(String.format("%-" + maxColumnsHeadersSize + "s", header));
        }
        builder.append("\n");
        int separatorSize = builder.length();
        String result;
        for (String rowName : table.getRows().keySet()) {
            appendSeparator(builder, separatorSize);
            builder.append("\n");
            builder.append(String.format("%-" + maxRowNameSize + "s", rowName));
            Map<String, String> row = table.getRows().get(rowName);
            for (String header : table.getColumnHeaders()) {
                builder.append(" | ");
                result = row.get(header);
                builder.append(String.format("%-" + maxColumnsHeadersSize + "s", Objects.isNull(result)? "---":result));
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    private void appendSeparator(StringBuilder builder, int length) {
        for (int i = 0; i < length; i++) {
            builder.append("-");
        }
    }
}
