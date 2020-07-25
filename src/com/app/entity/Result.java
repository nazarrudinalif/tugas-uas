/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.entity;

import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author ahza0
 */
public class Result {
    private Meta meta;
    private JSONObject data;

    public Result() {
    }

    public Result(Meta meta, JSONObject data) {
        this.meta = meta;
        this.data = data;
    }

    public Result(JSONObject json) {
        this.meta = new Meta(json.optJSONObject("meta"));
        this.data = json.optJSONObject("data");
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
            
    public class Meta {
        private String message;
        private int status;
        private boolean success;
        private Date timestamp;

        public Meta() {
        }

        public Meta(String message, int status, boolean success, Date timestamp) {
            this.message = message;
            this.status = status;
            this.success = success;
            this.timestamp = timestamp;
        }

        private Meta(JSONObject json) {
            this.message = json.optString("message");
            this.status = json.optInt("status", 0);
            this.success = json.optBoolean("success", false);
            this.timestamp = new Date(json.optLong("timestamp", 0));
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }
        
        
    }
}
