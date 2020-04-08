package com.paulo.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.synway.standardizeconfig.common.exception
 * @date:2020/1/21
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class ExcelException extends Exception implements Serializable {
    private static final long serialVersionUID = 6131724178649049465L;

    public ExcelException(String errMsg) {
        super(errMsg);
    }
}
