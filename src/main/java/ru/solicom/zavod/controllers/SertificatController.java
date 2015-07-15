package ru.solicom.zavod.controllers;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.solicom.zavod.domain.Pokupatel;
import ru.solicom.zavod.domain.SertificatIK;
import ru.solicom.zavod.domain.SertificatIM;
import ru.solicom.zavod.domain.SertificatMPN;
import ru.solicom.zavod.fasade.SertificatService;
import ru.solicom.zavod.service.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/sertificat")
public class SertificatController {
    @Autowired
    private SertificatService sertificatService;
    @Autowired
    private SertificatIKService sertificatIKService;
    @Autowired
    private SertificatIMService sertificatIMService;
    @Autowired
    private SertificatMPNService sertificatMPNService;
    @Autowired
    private GruzService gruzService;
    @Autowired
    private PokupatelService pokupatelService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listSertificat(Model model) {

        model.addAttribute("sertificatIKList", sertificatIKService.sertificatIKList());
        model.addAttribute("sertificatIMList", sertificatIMService.sertificatIMList());
        model.addAttribute("sertificatMPNList", sertificatMPNService.sertificatMPNList());
        //model.addAttribute("searchSertificat", new SertificatIK());
        //model.addAttribute("v", sertificatService.kolichectvoSertificatov());
        return "sertificat";
    }

    /**@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addSertificatGet(Model model) {
        SertificatIK sertificatIK = new SertificatIK();
        //sertificatIzvestKomovaya.setGruz(new Gruz());
        sertificatIK.setPokupatel(new Pokupatel());
        //sertificatIzvestKomovaya.getGruz().setId(-1);
        sertificatIK.getPokupatel().setId(-1);
        model.addAttribute("sertificat", sertificatIK);
        model.addAttribute("gruzList", gruzService.gruzList());
        model.addAttribute("pokupatelList", pokupatelService.pokupatelList());
        return "sertificat_add";
    }**/

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSertificat(@ModelAttribute("sertificatIK") @Valid SertificatIK sertificatIK, BindingResult result, Model model) throws JRException {
        String adress = "";
        if (sertificatIK.getData() == null) {
            sertificatIK.setData(new Date());
        }
        Boolean x = sertificatIKService.searchSertificatIKByNomerAndGod(sertificatIK.getId(), sertificatIK.getNomer(), sertificatIK.getData());

//        if (vagon.getRodVagona().getId() == 0) {
//            adress = "vagon_add";
//        }
        if (!x) {
            model.addAttribute("x", 1);
            adress = "sertificat_add";
        }
        if (result.hasErrors()) {
            adress = "sertificat_add";
        }
        if ("".equals(adress)) {
            sertificatIKService.saveSertficatIK(sertificatIK);
            adress = "redirect:/sertificat/all";
        } else {
            model.addAttribute("gruzList", gruzService.gruzList());
            model.addAttribute("pokupatelList", pokupatelService.pokupatelList());
        }
        return adress;
    }

    @RequestMapping(value = "/edit/{gruz}/{id}", method = RequestMethod.GET)
    public ModelAndView searchVagonById(@PathVariable String gruz, @PathVariable int id, ModelAndView model) {
        return sertificatService.selectSertificat(gruz, id, model);
    }

    @RequestMapping(value = "/ik/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String sertificatIKSave(@RequestBody SertificatIK sertificatIK) {
        sertificatIKService.saveSertficatIK(sertificatIK);
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/im/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String sertificatIMSave(@RequestBody SertificatIM sertificatIM) {
        sertificatIMService.saveSertficatIM(sertificatIM);
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/mpn/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String sertificatMPNSave(@RequestBody SertificatMPN sertificatMPN) {
        sertificatMPNService.saveSertificatMPN(sertificatMPN);
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/ik/add", method = RequestMethod.GET)
    public String addSertificatIK(Model model) {
        model.addAttribute("title_modal","Добавление Сертификата на известь комовую");
        model.addAttribute("sertificat", new SertificatIK());
        model.addAttribute("pokupatelList", pokupatelService.pokupatelList());
        return "sertificatIK_edit";
    }

    @RequestMapping(value = "/im/add", method = RequestMethod.GET)
    public String addSertificatIM(Model model) {
        model.addAttribute("title_modal","Добавление Сертификата на известь молотую");
        model.addAttribute("sertificat", new SertificatIM());
        model.addAttribute("pokupatelList", pokupatelService.pokupatelList());
        return "sertificatIM_edit";
    }

    @RequestMapping(value = "/mpn/add", method = RequestMethod.GET)
    public String addSertificatMPN(Model model) {
        model.addAttribute("title_modal","Добавление Сертификата на минеральный порошок неактивированный");
        model.addAttribute("sertificat", new SertificatMPN());
        model.addAttribute("pokupatelList", pokupatelService.pokupatelList());
        return "sertificatMPN_edit";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }
}
