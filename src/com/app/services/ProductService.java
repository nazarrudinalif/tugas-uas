/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.services;

import com.app.entity.PageResult;
import com.app.entity.Products;
import com.app.entity.Result;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 *
 * @author ahza0
 */
public class ProductService extends BaseService implements IService<Products>{

    public ProductService() {
        baseUrl = "products";
    }
        
    @Override
    public PageResult<Products> getPage(String search, int page, int pageSize, String sort, boolean asc) throws MalformedURLException, ProtocolException, IOException {
        Result result = get(search, page, pageSize, sort, asc);
        PageResult<Products> pageResult = new PageResult<>(result.getData(), Products.class);
        return pageResult;
    }

    @Override
    public Products getByID(Object id) throws IOException, Exception {
        Result result = get(id);
        Products products = new Products(result.getData());
        return products;
    }

    @Override
    public Result create(Products entity) throws IOException {
        return post(entity.toJson());
    }

    @Override
    public Result update(Products entity) throws IOException {
        return put(entity.toJson());
    }

    @Override
    public Result remove(Object id) throws IOException {
        return delete(id);
    }
    
}
