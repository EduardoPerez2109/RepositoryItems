/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.inventario.assembler;

import com.eduardo.inventario.dto.ItemsDto;
import com.eduardo.inventario.dto.ItemsNewDto;
import com.eduardo.inventario.db.model.Items;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Eduardo Pérez
 */
@Component
public class ItemsAssembler {

    public List<ItemsDto> getListDtoOfListEntity(List<Items> list) {
        List<ItemsDto> listOut = new ArrayList<>();

        for (Items item : list) {
            listOut.add(getDtoOfEntity(item));
        }
        
        return listOut;
    }

    public ItemsDto getDtoOfEntity(Items item) {

        ModelMapper modelMapper = new ModelMapper();

        ItemsDto itemOut = modelMapper.map(item, ItemsDto.class);

        return itemOut;
    }
    
    public Items getEntityOfDto(ItemsNewDto itemDto) {

        ModelMapper modelMapper = new ModelMapper();

        Items item = modelMapper.map(itemDto, Items.class);
        return item;
    }
}
