package ru.solicom.zavod.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.solicom.zavod.domain.*;
import ru.solicom.zavod.fasade.PogruzkaService;
import ru.solicom.zavod.fasade.SertificatService;
import ru.solicom.zavod.service.*;
import ru.solicom.zavod.util.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.*;

@Controller
@RequestMapping("/pogruzka")
public class PogruzkaController {
    @Autowired
    private PogruzkaService pogruzkaService;
    @Autowired
    private VagonService vagonService;
    @Autowired
    private VagoniPoroznieService vagoniPoroznieService;
    @Autowired
    private GruzService gruzService;
    @Autowired
    private TaraService taraService;
    @Autowired
    private SertificatService sertificatService;
    @Autowired
    private NomeraOtpravkiService nomeraOtpravkiService;
    @Autowired
    private UserService userService;

    public final int DEN = 1;
    public final int MESYAC = 2;
    public final int GOD = 3;
    public int period = 1;

    @RequestMapping(value = "/all/{x}", method = RequestMethod.GET)
    public String listPogruzka(@PathVariable int x, Model model) throws ParseException {
        LocalDate date = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd.MM.yyyy");
        YearMonth y = YearMonth.now();
        int z = y.lengthOfMonth();
        LocalDate x1;
        LocalDate x2;
        if (x != 0) {
            period = x;
        }
        switch (period) {
            case 1:
                List<PogruzkaIK> pogruzkaIKs = pogruzkaService.getPogruzkaIKService().searchPogruzkaIKMesyac(date, date);
                List<PogruzkaIM> pogruzkaIMs = pogruzkaService.getPogruzkaIMService().searchPogruzkaIMMesyac(date, date);
                List<PogruzkaMPN> pogruzkaMPNs = pogruzkaService.getPogruzkaMPNService().searchPogruzkaMPNMesyac(date, date);
                List<PogruzkaMPA> pogruzkaMPAs = pogruzkaService.getPogruzkaMPAService().searchPogruzkaMPAMesyac(date, date);
                model.addAttribute("pogruzkaIKList", pogruzkaIKs);
                model.addAttribute("pogruzkaIMList", pogruzkaIMs);
                model.addAttribute("pogruzkaMPNList", pogruzkaMPNs);
                model.addAttribute("pogruzkaMPAList", pogruzkaMPAs);
                model.addAttribute("period", 1);
                model.addAttribute("zaPeriod", " за " + fmt.print(date));
                break;
            case 2:
                x1 = new LocalDate(y.getYear(), y.getMonthValue(), 1);
                x2 = new LocalDate(y.getYear(), y.getMonthValue(), z);
                model.addAttribute("pogruzkaIKList", pogruzkaService.getPogruzkaIKService().searchPogruzkaIKMesyac(x1, x2));
                model.addAttribute("pogruzkaIMList", pogruzkaService.getPogruzkaIMService().searchPogruzkaIMMesyac(x1, x2));
                model.addAttribute("pogruzkaMPNList", pogruzkaService.getPogruzkaMPNService().searchPogruzkaMPNMesyac(x1, x2));
                model.addAttribute("pogruzkaMPAList", pogruzkaService.getPogruzkaMPAService().searchPogruzkaMPAMesyac(x1, x2));
                model.addAttribute("period", 2);
                model.addAttribute("zaPeriod", " за " + MesyacGod.out(date));
                break;
            case 3:
                x1 = new LocalDate(y.getYear(), 1, 1);
                x2 = new LocalDate(y.getYear(), 12, 31);
                model.addAttribute("pogruzkaIKList", pogruzkaService.getPogruzkaIKService().searchPogruzkaIKMesyac(x1, x2));
                model.addAttribute("pogruzkaIMList", pogruzkaService.getPogruzkaIMService().searchPogruzkaIMMesyac(x1, x2));
                model.addAttribute("pogruzkaMPNList", pogruzkaService.getPogruzkaMPNService().searchPogruzkaMPNMesyac(x1, x2));
                model.addAttribute("pogruzkaMPAList", pogruzkaService.getPogruzkaMPAService().searchPogruzkaMPAMesyac(x1, x2));
                model.addAttribute("period", 3);
                model.addAttribute("zaPeriod", " за " + Integer.toString(date.getYear()) + " г.");
                break;
        }

        //model.addAttribute("pogruzkaIKList", pogruzkaService.getPogruzkaIKService().pogruzkaIKList());
        model.addAttribute("pogruzkaIKNaLiniiList", pogruzkaService.getPogruzkaIKService().pogruzkaIKNaLiniiList());
        //model.addAttribute("pogruzkaIMList", pogruzkaService.getPogruzkaIMService().pogruzkaIMList());
        model.addAttribute("pogruzkaIMNaLiniiList", pogruzkaService.getPogruzkaIMService().pogruzkaIMNaLiniiList());
        //model.addAttribute("pogruzkaMPNList", pogruzkaService.getPogruzkaMPNService().pogruzkaMPNList());
        model.addAttribute("pogruzkaMPNNaLiniiList", pogruzkaService.getPogruzkaMPNService().pogruzkaMPNNaLiniiList());
        //model.addAttribute("pogruzkaMPAList", pogruzkaService.getPogruzkaMPAService().pogruzkaMPAList());
        model.addAttribute("pogruzkaMPANaLiniiList", pogruzkaService.getPogruzkaMPAService().pogruzkaMPANaLiniiList());
        model.addAttribute("data", LocalDate.now());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(new Date());
        Date date33 = null;
        try {
            date33 = format.parse(str);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        //model.addAttribute("today", date33.getTime());
        return "pogruzka";
    }

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String pogruzkaAdd(@PathVariable int id, Model model) throws ParseException, IOException {
        VagoniPoroznie vagonPorozniy = vagoniPoroznieService.retriveVagonPorozniy(id);
        Vagon vagon = vagonPorozniy.getVagon();
        StatusVaiona x = pogruzkaService.searchPogruzka(vagon);
        if (x == StatusVaiona.LOST) {
            return "pogruzka_lost";
        }
        Pogruzka pogruzka = new Pogruzka();
        List<Tara> taraList;
        if (vagon.getRodVagona().getName().equals("полувагон")) {
            taraList = taraService.taraList();
        } else {
            taraList = taraService.taraBezMKRList();
        }
        pogruzka.setVagon(vagon);
        pogruzka.setVagonPorozniy(vagonPorozniy);
        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yyyy");
        //LocalDate date = formatter.parseLocalDate(vagonPorozniy.getDataPribitiya())
        String s = vagonPorozniy.getDataPribitiya().toString(formatter);
        if (vagonPorozniy.getGruz().getId() < 3) {
            model.addAttribute("gruzList", gruzService.opasniyGrusList());
        } else {
            model.addAttribute("gruzList", gruzService.neOpasniyGrusList());
        }
        pogruzka.setDataPribitiyaVagona(s);
        model.addAttribute("taraList", taraList);
        //model.addAttribute("gruzList", gruzService.gruzList());
        model.addAttribute("vagon", vagon);
        model.addAttribute("pogruzka", pogruzka);
        model.addAttribute("title_modal", "Взвешивание вагона!");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(pogruzka);
        model.addAttribute("pogruzkaJSON", json);
        return "pogruzka_add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String pogruzkaSave(@RequestBody String pogruzkaJSON) throws ParseException, IOException {

        User pogruzil = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ObjectMapper mapper = new ObjectMapper();
        Pogruzka pogruzka = mapper.readValue(pogruzkaJSON, Pogruzka.class);
        Vagon vagon = vagonService.retriveVagon(pogruzka.getIdVagon());
        pogruzka.setVagon(vagon);
        pogruzka.setDataPogruzki(LocalDate.now());
        //pogruzka.setPogruzil(pogruzil);
        //SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        //String sdate = pogruzka.getDataPribitiyaVagona();
        //Date date = sdf.parse(sdate);

        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd.MM.yyyy");
        //dtf.p
        LocalDate date = dtf.parseLocalDate(String.valueOf(pogruzka.getDataPribitiyaVagona()));
        switch (pogruzka.getGruz().getId()) {
            case 1:
                PogruzkaIK pogruzkaIK = new PogruzkaIK();
                pogruzkaIK.setVagon(vagon);
                pogruzkaIK.setBrutto(pogruzka.getBrutto());
                pogruzkaIK.setDataPogruzki(pogruzka.getDataPogruzki());
                pogruzkaIK.setDopolneniya(pogruzka.getDopolneniya());
                pogruzkaIK.setTara(pogruzka.getTara());
                SertificatIK sertificatIK = sertificatService.getSertificatIKService().retriveSertificatIK(1);
                pogruzkaIK.setSertificatIK(sertificatIK);
                pogruzkaIK.setDataPribitiyaVagona(date);
                pogruzkaIK.setVagonPorozniy(vagoniPoroznieService.retriveVagonPorozniy(pogruzka.getVagonPorozniy().getId()));
                pogruzkaIK.setPogruzil(pogruzil);
                pogruzkaService.getPogruzkaIKService().savePogruzkaIK(pogruzkaIK);
                break;
            case 2:
                PogruzkaIM pogruzkaIM = new PogruzkaIM();
                pogruzkaIM.setVagon(vagon);
                pogruzkaIM.setBrutto(pogruzka.getBrutto());
                pogruzkaIM.setDataPogruzki(pogruzka.getDataPogruzki());
                pogruzkaIM.setDopolneniya(pogruzka.getDopolneniya());
                pogruzkaIM.setTara(pogruzka.getTara());
                SertificatIM sertificatIM = sertificatService.getSertificatIMService().retriveSertificatIM(1);
                pogruzkaIM.setSertificatIM(sertificatIM);
                pogruzkaIM.setDataPribitiyaVagona(date);
                pogruzkaIM.setVagonPorozniy(vagoniPoroznieService.retriveVagonPorozniy(pogruzka.getVagonPorozniy().getId()));
                pogruzkaIM.setPogruzil(pogruzil);
                pogruzkaService.getPogruzkaIMService().savePogruzkaIM(pogruzkaIM);
                break;
            case 3:
                PogruzkaMPN pogruzkaMPN = new PogruzkaMPN();
                pogruzkaMPN.setVagon(vagon);
                pogruzkaMPN.setBrutto(pogruzka.getBrutto());
                pogruzkaMPN.setDataPogruzki(pogruzka.getDataPogruzki());
                pogruzkaMPN.setDopolneniya(pogruzka.getDopolneniya());
                pogruzkaMPN.setTara(pogruzka.getTara());
                SertificatMPN sertificatMPN = sertificatService.getSertificatMPNService().retriveSertificatMPN(1);
                pogruzkaMPN.setSertificatMPN(sertificatMPN);
                pogruzkaMPN.setDataPribitiyaVagona(date);
                pogruzkaMPN.setVagonPorozniy(vagoniPoroznieService.retriveVagonPorozniy(pogruzka.getVagonPorozniy().getId()));
                pogruzkaMPN.setPogruzil(pogruzil);
                pogruzkaService.getPogruzkaMPNService().savePogruzkaMPN(pogruzkaMPN);
            case 4:
                PogruzkaMPA pogruzkaMPA = new PogruzkaMPA();
                pogruzkaMPA.setVagon(vagon);
                pogruzkaMPA.setBrutto(pogruzka.getBrutto());
                pogruzkaMPA.setDataPogruzki(pogruzka.getDataPogruzki());
                pogruzkaMPA.setDopolneniya(pogruzka.getDopolneniya());
                pogruzkaMPA.setTara(pogruzka.getTara());
                SertificatMPA sertificatMPA = sertificatService.getSertificatMPAService().retriveSertificatMPA(1);
                pogruzkaMPA.setSertificatMPA(sertificatMPA);
                pogruzkaMPA.setDataPribitiyaVagona(date);
                pogruzkaMPA.setVagonPorozniy(vagoniPoroznieService.retriveVagonPorozniy(pogruzka.getVagonPorozniy().getId()));
                pogruzkaMPA.setPogruzil(pogruzil);
                pogruzkaService.getPogruzkaMPAService().savePogruzkaMPA(pogruzkaMPA);
        }
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/saveEdit/{gruz}", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String pogruzkaEditSave(@RequestBody String pogruzkaJSON, @PathVariable String gruz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        switch (gruz) {
            case "IK":
                PogruzkaIK pogruzkaIK = mapper.readValue(pogruzkaJSON, PogruzkaIK.class);
                pogruzkaService.getPogruzkaIKService().savePogruzkaIK(pogruzkaIK);
                break;
            case "IM":
                PogruzkaIM pogruzkaIM = mapper.readValue(pogruzkaJSON, PogruzkaIM.class);
                pogruzkaService.getPogruzkaIMService().savePogruzkaIM(pogruzkaIM);
                break;
            case "MPN":
                PogruzkaMPN pogruzkaMPN = mapper.readValue(pogruzkaJSON, PogruzkaMPN.class);
                pogruzkaService.getPogruzkaMPNService().savePogruzkaMPN(pogruzkaMPN);
                break;
            case "MPA":
                PogruzkaMPA pogruzkaMPA = mapper.readValue(pogruzkaJSON, PogruzkaMPA.class);
                pogruzkaService.getPogruzkaMPAService().savePogruzkaMPA(pogruzkaMPA);
                break;
        }
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/otpravka/{gruz}/{id}", method = RequestMethod.GET)
    public String pogruzkaOtpr(@PathVariable String gruz, @PathVariable int id, Model model) {
        switch (gruz) {
            case "IK":
                model.addAttribute("pogruzka", pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id));
                break;
            case "IM":
                model.addAttribute("pogruzka", pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(id));
                break;
            case "MPN":
                model.addAttribute("pogruzka", pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(id));
                break;
            case "MPA":
                model.addAttribute("pogruzka", pogruzkaService.getPogruzkaMPAService().retrivePogruzkaMPA(id));
                break;
        }
        model.addAttribute("gruz", gruz);
        model.addAttribute("title_modal", "Оформление документов!");
        return "pogruzka_otpr";
    }

    @RequestMapping(value = "/otmena/{gruz}/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String oformlDokumentovOtmena(@PathVariable String gruz, @PathVariable int id) {
        User nullUser = userService.getNullUser();
        switch (gruz) {
            case "IK":
                SertificatIK sertificatIK = sertificatService.getSertificatIKService().retriveSertificatIK(1);
                PogruzkaIK pogruzkaIK = pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id);
                pogruzkaIK.setSertificatIK(sertificatIK);
                pogruzkaIK.setDataOtpravleniya(null);
                pogruzkaIK.setOtpravil(nullUser);
                pogruzkaService.getPogruzkaIKService().savePogruzkaIK(pogruzkaIK);
                //model.addAttribute("pogruzka", pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id));
                break;
            case "IM":
                SertificatIM sertificatIM = sertificatService.getSertificatIMService().retriveSertificatIM(1);
                PogruzkaIM pogruzkaIM = pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(id);
                pogruzkaIM.setSertificatIM(sertificatIM);
                pogruzkaIM.setDataOtpravleniya(null);
                pogruzkaIM.setOtpravil(nullUser);
                pogruzkaService.getPogruzkaIMService().savePogruzkaIM(pogruzkaIM);
                break;
            case "MPN":
                SertificatMPN sertificatMPN = sertificatService.getSertificatMPNService().retriveSertificatMPN(1);
                PogruzkaMPN pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(id);
                pogruzkaMPN.setSertificatMPN(sertificatMPN);
                pogruzkaMPN.setDataOtpravleniya(null);
                pogruzkaMPN.setOtpravil(nullUser);
                pogruzkaService.getPogruzkaMPNService().savePogruzkaMPN(pogruzkaMPN);
                break;
            case "MPA":
                SertificatMPA sertificatMPA = sertificatService.getSertificatMPAService().retriveSertificatMPA(1);
                PogruzkaMPA pogruzkaMPA = pogruzkaService.getPogruzkaMPAService().retrivePogruzkaMPA(id);
                pogruzkaMPA.setSertificatMPA(sertificatMPA);
                pogruzkaMPA.setDataOtpravleniya(null);
                pogruzkaMPA.setOtpravil(nullUser);
                pogruzkaService.getPogruzkaMPAService().savePogruzkaMPA(pogruzkaMPA);
                break;
        }
        return "Оформление документов отменено";
    }

    @RequestMapping(value = "/otmena_pogr/{gruz}/{nomerOtpravki}/{vagonPorozniyId}", method = RequestMethod.GET)
    @ResponseBody
    public String pogruzkaOtmena(@PathVariable String gruz, @PathVariable int nomerOtpravki, @PathVariable int vagonPorozniyId) {
        /**switch (gruz) {
         case "IK":
         nomeraOtpravkiService.deleteNomerOtpravki(nomerOtpravki, vagonPorozniyId);
         break;
         case "IM":
         SertificatIM sertificatIM = sertificatService.getSertificatIMService().retriveSertificatIM(1);
         PogruzkaIM pogruzkaIM = pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(nomerOtpravki);
         pogruzkaIM.setSertificatIM(sertificatIM);
         pogruzkaIM.setDataOtpravleniya(null);
         pogruzkaService.getPogruzkaIMService().savePogruzkaIM(pogruzkaIM);
         break;
         case "MPN":
         SertificatMPN sertificatMPN = sertificatService.getSertificatMPNService().retriveSertificatMPN(1);
         PogruzkaMPN pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(nomerOtpravki);
         pogruzkaMPN.setSertificatMPN(sertificatMPN);
         pogruzkaMPN.setDataOtpravleniya(null);
         pogruzkaService.getPogruzkaMPNService().savePogruzkaMPN(pogruzkaMPN);
         break;
         }**/
        nomeraOtpravkiService.deleteNomerOtpravki(nomerOtpravki, vagonPorozniyId);
        return "Оформление погрузки отменено";
    }

    @RequestMapping(value = "/edit/{gruz}/{id}", method = RequestMethod.GET)
    public String pogruzkaEdit(@PathVariable String gruz, @PathVariable int id, Model model) throws IOException {
        Vagon vagon = new Vagon();
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        switch (gruz) {
            case "IK":
                PogruzkaIK pogruzkaIK = pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id);
                model.addAttribute("pogruzka", pogruzkaIK);
                vagon = pogruzkaIK.getVagon();
                json = mapper.writeValueAsString(pogruzkaIK);
                break;
            case "IM":
                PogruzkaIM pogruzkaIM = pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(id);
                model.addAttribute("pogruzka", pogruzkaIM);
                vagon = pogruzkaIM.getVagon();
                json = mapper.writeValueAsString(pogruzkaIM);
                break;
            case "MPN":
                PogruzkaMPN pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(id);
                model.addAttribute("pogruzka", pogruzkaMPN);
                vagon = pogruzkaMPN.getVagon();
                json = mapper.writeValueAsString(pogruzkaMPN);
                break;
            case "MPA":
                PogruzkaMPA pogruzkaMPA = pogruzkaService.getPogruzkaMPAService().retrivePogruzkaMPA(id);
                model.addAttribute("pogruzka", pogruzkaMPA);
                vagon = pogruzkaMPA.getVagon();
                json = mapper.writeValueAsString(pogruzkaMPA);
                break;
        }
        List<Tara> taraList;
        if (vagon.getRodVagona().getName().equals("полувагон")) {
            taraList = taraService.taraList();
        } else {
            taraList = taraService.taraBezMKRList();
        }
        model.addAttribute("pogruzkaJSON", json);
        model.addAttribute("taraList", taraList);
        model.addAttribute("gruz", gruz);
        model.addAttribute("title_modal", "Редактирование погрузки!");
        return "pogruzka_edit";
    }

    @RequestMapping(value = "/setDate/{gruz}/{x}/{y}/{z}")
    public String setDate(@PathVariable String gruz, @PathVariable int x, @PathVariable int y, @PathVariable int z, Model model) {
        Date date1 = new Date((z - 1900), y, x);
        LocalDate date = LocalDate.fromDateFields(date1);
        //date.getYear()
        switch (gruz) {
            case "IK":
                model.addAttribute("sertificatList", sertificatService.getSertificatIKService().searchSertificatIKByData(date));
                break;
            case "IM":
                model.addAttribute("sertificatList", sertificatService.getSertificatIMService().searchSertificatIMByData(date));
                break;
            case "MPN":
                model.addAttribute("sertificatList", sertificatService.getSertificatMPNService().searchSertificatMPNByData(date));
                break;
            case "MPA":
                model.addAttribute("sertificatList", sertificatService.getSertificatMPAService().searchSertificatMPAByData(date));
                break;
        }
        return "pogr_sert_data";
    }

    @RequestMapping(value = "/otpr/save/{gruz}/{id}/{sertId}")
    @ResponseBody
    public String pogruzkaOtprSave(@PathVariable String gruz, @PathVariable int id, @PathVariable int sertId) {
        User otpravil = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //Vagon vagon = vagonService.retriveVagon(pogruzka.getIdVagon());
        //pogruzka.setVagon(vagon);
        //pogruzka.setDataPogruzki(new Date());
        switch (gruz) {
            case "IK":
                PogruzkaIK pogruzkaIK = pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(id);
                SertificatIK sertificatIK = sertificatService.getSertificatIKService().retriveSertificatIK(sertId);
                pogruzkaIK.setSertificatIK(sertificatIK);
                pogruzkaIK.setDataOtpravleniya(LocalDate.now());
                pogruzkaIK.setOtpravil(otpravil);
                pogruzkaService.getPogruzkaIKService().savePogruzkaIK(pogruzkaIK);
                break;
            case "IM":
                PogruzkaIM pogruzkaIM = pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(id);
                SertificatIM sertificatIM = sertificatService.getSertificatIMService().retriveSertificatIM(sertId);
                pogruzkaIM.setSertificatIM(sertificatIM);
                pogruzkaIM.setDataOtpravleniya(LocalDate.now());
                pogruzkaIM.setOtpravil(otpravil);
                pogruzkaService.getPogruzkaIMService().savePogruzkaIM(pogruzkaIM);
                break;
            case "MPN":
                PogruzkaMPN pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(id);
                SertificatMPN sertificatMPN = sertificatService.getSertificatMPNService().retriveSertificatMPN(sertId);
                pogruzkaMPN.setSertificatMPN(sertificatMPN);
                pogruzkaMPN.setDataOtpravleniya(LocalDate.now());
                pogruzkaMPN.setOtpravil(otpravil);
                pogruzkaService.getPogruzkaMPNService().savePogruzkaMPN(pogruzkaMPN);
                break;
            case "MPA":
                PogruzkaMPA pogruzkaMPA = pogruzkaService.getPogruzkaMPAService().retrivePogruzkaMPA(id);
                SertificatMPA sertificatMPA = sertificatService.getSertificatMPAService().retriveSertificatMPA(sertId);
                pogruzkaMPA.setSertificatMPA(sertificatMPA);
                pogruzkaMPA.setDataOtpravleniya(LocalDate.now());
                pogruzkaMPA.setOtpravil(otpravil);
                pogruzkaService.getPogruzkaMPAService().savePogruzkaMPA(pogruzkaMPA);
                break;
        }
        return "Изминения успешно внесены!";
    }

    @RequestMapping(value = "/pechatIK", method = RequestMethod.POST)
    //@ResponseBody
    public String pechatIK(@RequestParam("y") List<Integer> list, Model model, HttpSession httpSession) {
        List<PogruzkaIK> pogruzkaIKs = new ArrayList<>();
        Set<Pokupatel> pokupatels = new HashSet<>();
        PogruzkaIK pogruzkaIK;
        for (Integer i : list) {
            pogruzkaIK = pogruzkaService.getPogruzkaIKService().retrivePogruzkaIK(i);
            pokupatels.add(pogruzkaIK.getSertificatIK().getPokupatel());
            pogruzkaIKs.add(pogruzkaIK);
        }
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            user = new User();
            user.setObrashenie("Гость");
        }
        PechatDokumentovIK ik = new PechatDokumentovIK(2, 1, 1, pogruzkaIKs, user.getObrashenie());
        model.addAttribute("listIK", ik);
        model.addAttribute("setPokupatel", pokupatels);
        httpSession.setAttribute("listIKSession", ik);
        return "pogruzkaIK_pechat";
    }

    @RequestMapping(value = "/pechatIM", method = RequestMethod.POST)
    public String pechatIM(@RequestParam("y") List<Integer> list, Model model, HttpSession httpSession) {
        List<PogruzkaIM> pogruzkaIMs = new ArrayList<>();
        Set<Pokupatel> pokupatels = new HashSet<>();
        PogruzkaIM pogruzkaIM;
        for (Integer i : list) {
            pogruzkaIM = pogruzkaService.getPogruzkaIMService().retrivePogruzkaIM(i);
            pokupatels.add(pogruzkaIM.getSertificatIM().getPokupatel());
            pogruzkaIMs.add(pogruzkaIM);
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PechatDokumentovIM im = new PechatDokumentovIM(2, 1, 1, pogruzkaIMs, user.getObrashenie());
        model.addAttribute("listIM", im);
        model.addAttribute("setPokupatel", pokupatels);
        httpSession.setAttribute("listIMSession", im);
        return "pogruzkaIM_pechat";
    }

    @RequestMapping(value = "/pechatMPN", method = RequestMethod.POST)
    public String pechatMPN(@RequestParam("y") List<Integer> list, Model model, HttpSession httpSession) {
        List<PogruzkaMPN> pogruzkaMPNs = new ArrayList<>();
        Set<Pokupatel> pokupatels = new HashSet<>();
        PogruzkaMPN pogruzkaMPN;
        for (Integer i : list) {
            pogruzkaMPN = pogruzkaService.getPogruzkaMPNService().retrivePogruzkaMPN(i);
            pokupatels.add(pogruzkaMPN.getSertificatMPN().getPokupatel());
            pogruzkaMPNs.add(pogruzkaMPN);
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PechatDokumentovMPN mpn = new PechatDokumentovMPN(2, 1, pogruzkaMPNs, user.getObrashenie());
        model.addAttribute("listMPN", mpn);
        model.addAttribute("setPokupatel", pokupatels);
        httpSession.setAttribute("listMPNSession", mpn);
        return "pogruzkaMPN_pechat";
    }

    @RequestMapping(value = "/pechatMPA", method = RequestMethod.POST)
    public String pechatMPA(@RequestParam("y") List<Integer> list, Model model, HttpSession httpSession) {
        List<PogruzkaMPA> pogruzkaMPAs = new ArrayList<>();
        Set<Pokupatel> pokupatels = new HashSet<>();
        PogruzkaMPA pogruzkaMPA;
        for (Integer i : list) {
            pogruzkaMPA = pogruzkaService.getPogruzkaMPAService().retrivePogruzkaMPA(i);
            pokupatels.add(pogruzkaMPA.getSertificatMPA().getPokupatel());
            pogruzkaMPAs.add(pogruzkaMPA);
        }
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PechatDokumentovMPA mpa = new PechatDokumentovMPA(2, 1, pogruzkaMPAs, user.getObrashenie());
        model.addAttribute("listMPA", mpa);
        model.addAttribute("setPokupatel", pokupatels);
        httpSession.setAttribute("listMPASession", mpa);
        return "pogruzkaMPA_pechat";
    }

    @RequestMapping(value = "/statistica", method = RequestMethod.GET)
    public String statisticaAll(Model model) throws ParseException {
        LocalDate date = LocalDate.now();
        YearMonth y = YearMonth.now();

        int z = y.lengthOfMonth();
        LocalDate x1;
        LocalDate x2;
        x1 = new LocalDate(y.getYear(), y.getMonthValue(), 1);
        x2 = new LocalDate(y.getYear(), y.getMonthValue(), z);
        int yearMonth = date.getDayOfMonth();
        List<PogruzkaIK> pogruzkaIKs = pogruzkaService.getPogruzkaIKService().searchPogruzkaIKMesyac(x1, x2);
        List<PogruzkaIM> pogruzkaIMs = pogruzkaService.getPogruzkaIMService().searchPogruzkaIMMesyac(x1, x2);
        List<PogruzkaMPN> pogruzkaMPNs = pogruzkaService.getPogruzkaMPNService().searchPogruzkaMPNMesyac(x1, x2);
        List<PogruzkaMPA> pogruzkaMPAs = pogruzkaService.getPogruzkaMPAService().searchPogruzkaMPAMesyac(x1, x2);

        model.addAttribute("listIK", pogruzkaIKs);
        model.addAttribute("listIM", pogruzkaIMs);
        model.addAttribute("listMPN", pogruzkaMPNs);
        model.addAttribute("listMPA", pogruzkaMPAs);
        model.addAttribute("data_1", x1);
        model.addAttribute("data_2", x2);
        return "statistica";
    }

}
