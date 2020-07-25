/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.services;

import com.app.entity.PageResult;
import com.app.entity.Users;
import com.app.entity.Result;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
/**
 *
 * @author ahza0
 */
public class UserService extends BaseService implements IService<Users>{
    public UserService() {
        baseUrl = "users";
    }
        
    @Override
    public PageResult<Users> getPage(String search, int page, int pageSize, String sort, boolean asc) throws MalformedURLException, ProtocolException, IOException {
        Result result = get(search, page, pageSize, sort, asc);
        PageResult<Users> pageResult = new PageResult<>(result.getData(), Users.class);
        return pageResult;
    }

    @Override
    public Users getByID(Object id) throws IOException, Exception {
        Result result = get(id);
        Users users = new Users(result.getData());
        return users;
    }

    @Override
    public Result create(Users entity) throws IOException {
        return post(entity.toJson());
    }

    @Override
    public Result update(Users entity) throws IOException {
        return put(entity.toJson());
    }

    @Override
    public Result remove(Object id) throws IOException {
        return delete(id);
    }
}
