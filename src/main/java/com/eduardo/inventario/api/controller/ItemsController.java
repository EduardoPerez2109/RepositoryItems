/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.inventario.api.controller;

import com.eduardo.inventario.dto.GenericResponse;
import com.eduardo.inventario.dto.ItemsDto;
import com.eduardo.inventario.dto.ItemsNewDto;
import com.eduardo.inventario.service.ItemsService;
import io.swagger.annotations.Api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eduardo Pérez
 */
@RestController
@Api(value = "ITEMS", tags = {"Items Service API"})
@RequestMapping("/api/items/")
public class ItemsController {



        @Autowired
        private ItemsService itemsService;
        
        @RequestMapping(value = "all", method = RequestMethod.GET)
        public ResponseEntity<List<ItemsDto>> getAll() { 
            
           List<ItemsDto> lista= itemsService.getAll();
           if(!lista.isEmpty()){
               return ResponseEntity.status(HttpStatus.OK).body( lista);
           }else{
               return ResponseEntity.status(HttpStatus.NO_CONTENT).body( lista);
           }
            
        }

        @RequestMapping(value = "item/{noItem}", method = RequestMethod.GET)
        public ResponseEntity<ItemsDto> getItem(@PathVariable("noItem") Long noItem) throws Exception {           
            
             ItemsDto itemsDto = itemsService.getItem( noItem);
             return ResponseEntity.status(HttpStatus.OK).body( itemsDto);
           
        }
        
        @RequestMapping(method = RequestMethod.POST)
        public GenericResponse save(@RequestBody ItemsNewDto inVO) {           
            
            return itemsService.save(inVO);
        }
        
        @RequestMapping(value = "sum/{noItem}/{amount}", method = RequestMethod.PUT)
        public GenericResponse sum(@PathVariable("noItem") Long noItem, @PathVariable("amount") Long amount) throws Exception {           
            
            return itemsService.sum( noItem,amount);
        }
        

        @RequestMapping(value = "subtraction/{noItem}/{amount}", method = RequestMethod.PUT)
        public GenericResponse subtraction(@PathVariable("noItem") Long noItem, @PathVariable("amount") Long amount) throws Exception {           
            
            return itemsService.subtraction( noItem,amount);
        }
        
        @RequestMapping(value = "item/{noItem}", method = RequestMethod.DELETE)
        public GenericResponse delete(@PathVariable("noItem") Long noItem) throws Exception {           
            
            return itemsService.delete( noItem);
        }
    }
