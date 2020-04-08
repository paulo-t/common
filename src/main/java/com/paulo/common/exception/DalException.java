package com.paulo.common.exception;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.common.exception
 * @date:2020/4/8
 */
@Data
@ToString
public class DalException extends Exception implements Serializable {
    private static final long serialVersionUID = 397140127855581353L;
    /**
     * 错误代码
     */
    private int errCode;
    public DalException(int errCode, String errMsg){
        super(errMsg);
        this.errCode = errCode;
    }
}
