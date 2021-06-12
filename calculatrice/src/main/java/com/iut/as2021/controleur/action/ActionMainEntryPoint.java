package com.iut.as2021.controleur.action;

import com.iut.as2021.controleur.facade.CalculatriceManager;
import com.iut.as2021.exceptions.MathsTechnicalExceptions;
import com.iut.as2021.metier.MathResultat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@SessionAttributes("mathresultat")
public class ActionMainEntryPoint {

    private static final Logger logger = Logger.getLogger(ActionMainEntryPoint.class);

    private static final String REDIRECT_DEFAULT = "redirect:/";
    private static final String MAIN_PAGE = "calculatrice";

    @Autowired
    private CalculatriceManager manager;

    @ModelAttribute("mathresultat")
    public MathResultat initialisationFormulaire() {
        return new MathResultat();
    }

    private void reinitModele(Model model) {
        model.addAttribute("mathresultat", initialisationFormulaire());
    }

    @GetMapping("/")
    public String formulaireMathResultat(Locale locale, Model model) {
        try {
            model.addAttribute("mathresultats", manager.getMathResultats());
        } catch (MathsTechnicalExceptions e) {
            logger.error(e.getMessage());
        }
        return MAIN_PAGE;
    }

    @PostMapping("/ajoutMathResultat")
    public String saveMathResultat(@ModelAttribute("mathresultat") @Valid MathResultat mathResultat, BindingResult result,
                                   Model model) {
        try {
            if (result.hasErrors()) {
                model.addAttribute("mathresultats", manager.getMathResultats());
                return MAIN_PAGE;
            } else {
                manager.sauverMathResultat(mathResultat);
                reinitModele(model);
            }
        } catch (MathsTechnicalExceptions e) {
            logger.error(e.getMessage());
            model.addAttribute("errorMessage", "Erreur lors de la sauvegarde");
            return MAIN_PAGE;
        }
        return REDIRECT_DEFAULT;
    }

    @RequestMapping(value = "/mathresultat/{id}/modification", method = GET)
    public String modifierMathResultat(@PathVariable("id") String id, Model model) {
        logger.info("Modification MathResultat");
        try {
            model.addAttribute("mathresultat", manager.getMathResultatById(id));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return REDIRECT_DEFAULT;

    }

    @RequestMapping(value = "/mathresultat/{id}/suppression", method = GET)
    public String supprimerUtilisateur(@PathVariable("id") String id, Model model) {
        logger.info("Suppression MathResultat");
        try {
            manager.suppressionMathResultatById(id);
            reinitModele(model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return REDIRECT_DEFAULT;
    }
}
