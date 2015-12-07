package com.fahmi.hardinal.pelatihan.controller;

import com.fahmi.hardinal.pelatihan.dao.PesertaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/peserta")
public class PesertaHtmlController {
    @Autowired private PesertaDao pd;
    
    @RequestMapping("/list")   
    public void daftarPeserta(Model m){
        m.addAttribute("daftarPeserta", pd.findAll());
    }
    
    @RequestMapping("/hapus")
    public String hapus(@RequestParam(value = "id") String id){
        pd.delete(id);
        return "redirect:list";
    }
    
}
