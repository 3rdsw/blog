package com.ablog.server;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
public class Result implements Serializable {

    private static final long serialVersionUID = 1;

    private Integer code;

    private String msg;

    private Object data;

    public Result(){};

    public Result(Integer code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    public void setResultCode(ResultCode code)
    {
        this.code = code.code();
        this.msg = code.msg();
    }

    public Map<String, Object> simple() {
        Map<String, Object> simple = new HashMap<String, Object>();
        this.data = simple;

        return simple;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
