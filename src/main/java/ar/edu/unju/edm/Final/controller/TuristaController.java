package ar.edu.unju.edm.Final.controller;

import ar.edu.unju.edm.Final.model.Turista;
import ar.edu.unju.edm.Final.service.ITuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TuristaController {
    @Autowired
    ITuristaService turistaService;

    @GetMapping("/addTurista")
    public String postTurista(@RequestParam("turista_id") Optional<Integer> codigo, Model model) {
        var turista = codigo.map(turistaService::getTurista).orElse(Optional.of(new Turista()));
        model.addAttribute("turista", turista);
        return "addTurista.html";
    }

    @PostMapping("/addTurista")
    public String getTurista(@ModelAttribute("turista") Turista turista) {
        System.out.println(turista);
        var bcrypt = new BCryptPasswordEncoder();
        var fTurista = turistaService.findTuristaByNombre(turista.getNombre());
        if (fTurista.isPresent()) {
            var fTuristaUnwrapped = fTurista.get();
            fTuristaUnwrapped.setPassword(bcrypt.encode(turista.getPassword()));
            fTuristaUnwrapped.setRol(turista.getRol());
            fTuristaUnwrapped.setEstado(true);
            turistaService.addTurista(fTuristaUnwrapped);
        } else {
            turista.setPassword(bcrypt.encode(turista.getPassword()));
            turista.setEstado(true);
            turistaService.addTurista(turista);
        }
        return "redirect:/puntos";
    }


    @GetMapping("/turista")
    public String getTurista(@RequestParam("turista_id") Integer turistaId, Model model) {
        //var turista = turistaId.map(turistaService::getTurista).orElse(Optional.of(null));
        // TODO ERROR HANDLER Optional
        var turista = turistaService.getTurista(turistaId).orElse(new Turista());
        //var turista = opt_turista.get();
        model.addAttribute("turista", turista);
        return "turista.html";
    }

		/*
		@DeleteMapping("/deletepunto")
		public String deletePunto(@RequestParam("codigo") Integer codigo) {
				turistaService.deleteTurista(codigo);
				return "redirect:/puntos";
		}
		*/

}
