/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.inventario.dto;

import java.io.Serializable;

/**
 *
 * @author Eduardo Pérez
 */
public class GenericResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer code;
    private String description;

    public GenericResponse(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public GenericResponse() {
    }

    
    
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
