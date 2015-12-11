package com.fahmi.hardinal.pelatihan.controller;

import com.fahmi.hardinal.pelatihan.dao.MateriDao;
import com.fahmi.hardinal.pelatihan.entity.Materi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class MateriController {
    @Autowired private MateriDao md;
    
    @RequestMapping(value = "/materi", method = RequestMethod.GET )
    public Page<Materi> daftarMateri(Pageable page){
        return md.findAll(page);
    }
    
    @RequestMapping(value="/materi/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void hapusMateri(@PathVariable("id") String id){
        md.delete(id);
    }
    
}
