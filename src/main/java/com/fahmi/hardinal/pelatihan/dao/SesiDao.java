/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fahmi.hardinal.pelatihan.dao;

import com.fahmi.hardinal.pelatihan.entity.Materi;
import com.fahmi.hardinal.pelatihan.entity.Sesi;
import java.util.Date;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Just HardinaL
 */
public interface SesiDao extends PagingAndSortingRepository<Sesi, String>{
    public Page<Sesi> findByMateri(Materi m, Pageable page);
    
    
    @Query("select x from Sesi x where x.mulai >= :m "
            + "and x.mulai < :s "
            + "and x.materi.kode =:k "
            + "order by x.mulai desc ")
    public Page<Sesi> cariBerdasarkanTanggalMulaiDanKodeMateri(
            @Param("m") Date mulai,
            @Param("s") Date sampai,
            @Param("k") String kode,
            Pageable page); 
            
}
