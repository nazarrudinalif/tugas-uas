/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author ahza0
 * @param <T>
 */
public class PageResult<T> {

    private List<T> content;
    private int totalElements;
    private int totalPages;
    private boolean first;
    private boolean last;

    public PageResult() {
    }

    public PageResult(JSONObject data, Class<T> cls) {
        JSONArray items = data.optJSONArray("content");
        content = new ArrayList<>();
        items.forEach(item -> {
            JSONObject jItem = (JSONObject) item;
            try {
                T e = cls.getDeclaredConstructor(JSONObject.class).newInstance(jItem);
                content.add(e);
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            }
        });
        totalElements = data.optInt("totalElements", 0);
        totalPages = data.optInt("totalPages", 0);
        first = data.optBoolean("first", false);
        last = data.optBoolean("last", false);
    }

    public PageResult(List<T> content, int totalElements, int totalPages, boolean first, boolean last) {
        this.content = content;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.first = first;
        this.last = last;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

}
