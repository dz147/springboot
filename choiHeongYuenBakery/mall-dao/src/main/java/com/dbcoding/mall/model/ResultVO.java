package com.dbcoding.mall.model;

import com.dbcoding.mall.model.enums.ResultCode;

/**
 * @ClassName: AAA
 * @Description: TODO
 * @Author: Stephen.Zhang
 * @CreateDate: 2020-05-14 10:44
 * @Version: 1.0
 **/
public class ResultVO {
    private int code;
    private String message;
    private Object data;
    private int PageCount;
    private int PageNum;

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getPageNum() {
        return PageNum;
    }

    public void setPageNum(int pageNum) {
        PageNum = pageNum;
    }


    public ResultVO() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");
    }

    public ResultVO(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

    public ResultVO(ResultCode code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ResultVO(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public ResultVO(ResultCode code, String message, Object data,int pageCount,int pageNum) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
        this.setPageCount(pageCount);
        this.setPageNum(pageNum);
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", PageCount=" + PageCount +
                ", PageNum=" + PageNum +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.val();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}