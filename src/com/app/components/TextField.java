/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author ahza0
 */
public class TextField extends JTextField {

    private String placeHolder = "";

    public TextField(String text) {
        super.setText(text);
        placeHolder = text;
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(placeHolder)) {
                    setText("");
                    setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals("")) {
                    setText(placeHolder);
                    setForeground(Color.GRAY);
                }
            }
        });
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(0, 5, 0, 5)));
    }
    
    public String getTextSearch() {
        if (super.getText().equals(placeHolder)) {
            return "";
        }
        return super.getText();
    }
    
    
}
