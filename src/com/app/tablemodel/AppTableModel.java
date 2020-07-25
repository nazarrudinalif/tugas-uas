/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.tablemodel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahza0
 * @param <T>
 */
public class AppTableModel<T> extends AbstractTableModel {
    private List<T> list = new ArrayList<>();
    private String[] columnNames;
    private Method getValue;
    
    public AppTableModel() {
    }    
    
    public AppTableModel(List<T> list, String[] columnNames) {
        this.list = list;
        this.columnNames = columnNames;
        if(list.size() > 0){
            try {
                getValue = list.get(0).getClass().getMethod("getValue", int.class);
            } catch (NoSuchMethodException | SecurityException ex) {
                System.out.println("NoSuchMethodException error: " + ex.getMessage());
            }
        }
    } 

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return getValue.invoke(list.get(rowIndex), columnIndex);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.out.println("IllegalAccessException error: " + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column]; 
    }
    
}
