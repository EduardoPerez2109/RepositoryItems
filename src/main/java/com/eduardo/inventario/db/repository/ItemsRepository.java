/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.inventario.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.eduardo.inventario.db.model.Items;

/**
 *
 * @author Eduardo Pérez
 */
@Repository
public interface ItemsRepository  extends CrudRepository<Items, Long>{
    
    public Items findByItemNo(Long id);
    
}
