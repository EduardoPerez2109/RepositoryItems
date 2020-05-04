/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.inventario.service;

import com.eduardo.inventario.assembler.ItemsAssembler;
import com.eduardo.inventario.db.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eduardo.inventario.db.model.Items;
import com.eduardo.inventario.dto.GenericResponse;
import com.eduardo.inventario.dto.ItemsDto;
import com.eduardo.inventario.dto.ItemsNewDto;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Eduardo Pérez
 */
@Service
public class ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private ItemsAssembler itemsAssembler;

    private final Logger log = LoggerFactory.getLogger(ItemsService.class);

    public List<ItemsDto> getAll() {
        log.info("method: getAll");
        return itemsAssembler.getListDtoOfListEntity((List<Items>) itemsRepository.findAll());
    }

    public ItemsDto getItem(Long noItem) throws Exception {
        log.info("method: getItem");

        Items items = itemsRepository.findByItemNo(noItem);

        if (items == null) {
            throw  new Exception("item non-existent");
        }
        return itemsAssembler.getDtoOfEntity(itemsRepository.findByItemNo(noItem));
    }

    public GenericResponse save(ItemsNewDto itemInVO) {
        log.info("method: save");
        Items item = itemsAssembler.getEntityOfDto(itemInVO);
        item.setCreationDate(new Date());
        itemsRepository.save(item);

        return new GenericResponse(200, "Success");
    }

    public GenericResponse sum(Long noItem, Long amount) throws Exception {
        log.info("method: sum");

        Items items = itemsRepository.findByItemNo(noItem);

        if (items == null) {            
            throw  new Exception("item non-existent");
        }

        items.setAmount(items.getAmount() + amount);
        items.setUpdateDate(new Date());
        itemsRepository.save(items);

        return new GenericResponse(200, "Success");
    }

    public GenericResponse subtraction(Long noItem, Long amount) throws Exception {
        log.info("method: subtraction");

        Items items = itemsRepository.findByItemNo(noItem);

        if (items == null) {            
            throw  new Exception("item non-existent");
        }
        if (items.getAmount() == 0) {
            throw  new Exception("empty stock");
        }
        

        if (items.getAmount() < amount) {
            throw  new Exception("The quantity requested is greater than the existing one");
        }

        items.setAmount(items.getAmount() - amount);
        items.setUpdateDate(new Date());
        itemsRepository.save(items);

        return new GenericResponse(200, "Success");
    }

    public GenericResponse delete(Long noItem) throws Exception {
        log.info("method: delete");
        Items items = itemsRepository.findByItemNo(noItem);

        if (items == null) {
            throw  new Exception("item non-existent");            
        }
        itemsRepository.deleteById(noItem);

        return new GenericResponse(200, "Success");
    }

}
