/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.services;

import com.app.entity.Customers;
import com.app.entity.PageResult;
import com.app.entity.Result;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 *
 * @author ahza0
 */
public interface IService<T> {
    public PageResult<T> getPage(String search, int page, int pageSize, String sort, boolean asc)
            throws MalformedURLException, ProtocolException, IOException;
    public T getByID(Object id) throws IOException, Exception;
    public Result create(T entity) throws IOException;
    public Result update(T entity) throws IOException;
    public Result remove(Object id) throws IOException;
}
