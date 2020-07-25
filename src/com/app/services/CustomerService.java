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
import org.json.JSONObject;

/**
 *
 * @author ahza0
 */
public class CustomerService extends BaseService {

    public CustomerService() {
        baseUrl = "customers";
    }

    public PageResult<Customers> getPage(String search, int page, int pageSize, String sort, boolean asc)
            throws MalformedURLException, ProtocolException, IOException {
        PageResult<Customers> pageResult = null;
        Result result = get(search, page, pageSize, sort, asc);
        pageResult = new PageResult<>(result.getData(), Customers.class);
        return pageResult;
    }

    public Customers getByID(String id) throws IOException, Exception {
        Customers customers = null;
        Result result = get(id);
        JSONObject cus = result.getData();
        customers = new Customers(cus);
        return customers;
    }
    
    public Result create(Customers customers) throws IOException{
        return post(customers.toJson());
    }
    
    public Result update(Customers customers) throws IOException{
        return put(customers.toJson());
    }
        
    public Result remove(String id) throws IOException{
        return delete(id);
    }
}
