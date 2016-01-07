package com.fahmi.hardinal.pelatihan.controller;

import com.fahmi.hardinal.pelatihan.dao.PesertaDao;
import com.fahmi.hardinal.pelatihan.entity.Peserta;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/peserta")
public class PesertaHtmlController {

    @Autowired
    private PesertaDao pd;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/list")
    public void daftarPeserta(Model m) {
        m.addAttribute("daftarPeserta", pd.findAll());
    }

    @RequestMapping("/hapus")
    public String hapus(@RequestParam(value = "id") String id) {
        pd.delete(id);
        return "redirect:list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String tampilkanForm(Peserta peserta) {
        return "/peserta/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String prosesForm(@Valid Peserta p, BindingResult error) {
        if (error.hasErrors()) {
            return "/peserta/form";
        }

        pd.save(p);
        return "redirect:list";
    }

    @RequestMapping(value = "/edit{id}", method = RequestMethod.GET)
    public String editForm(@RequestParam(value = "id") String id,
            Model m) {

        //defaultnya isi dengan objek baru
        m.addAttribute("peserta", new Peserta());

        if (id != null && !id.isEmpty()) {
            Peserta p = pd.findOne(id);
            if (p != null) {
                m.addAttribute("peserta", p);
            }
        }
        return "/peserta/edit";
    }

    @RequestMapping(value = "/edit{id}", method = RequestMethod.POST)
    public String prosesUpdateForm(@RequestParam(value = "id") String id,
            @Valid Peserta p,
            BindingResult error) {
        if (error.hasErrors()) {
            return "/peserta/edit";
        }
        p.setId(id);
        pd.save(p);
        return "redirect:list";
    }
    
    @RequestMapping(value = "/view{id}", method = RequestMethod.GET)
    public String viewForm(@RequestParam(value = "id") String id,
            Model m) {

        //defaultnya isi dengan objek baru
        m.addAttribute("peserta", new Peserta());

        if (id != null && !id.isEmpty()) {
            Peserta p = pd.findOne(id);
            if (p != null) {
                m.addAttribute("peserta", p);
            }
        }
        return "/peserta/view";
    }

}
