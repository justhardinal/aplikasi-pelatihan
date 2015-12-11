package com.fahmi.hardinal.pelatihan.dao;

import com.fahmi.hardinal.pelatihan.entity.Materi;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MateriDao extends PagingAndSortingRepository<Materi, String>{
    
}
