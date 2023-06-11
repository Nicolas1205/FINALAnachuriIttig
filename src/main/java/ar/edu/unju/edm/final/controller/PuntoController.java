package ar.edu.unju.edm.Final.controller;

import ar.edu.unju.edm.Final.model.Punto;
import ar.edu.unju.edm.Final.service.IPuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PuntoController {
		//@Autowired
		//Punto punto;
		@Autowired
		IPuntoService puntoService;

		@GetMapping("/addPunto")
		public String postPuntoDeInteres(@RequestParam("codigo") Optional<Integer> codigo, Model model) {
				var punto = codigo.map(puntoService::getPunto).orElse(Optional.of(new Punto()));
				model.addAttribute("punto", punto);
				return "addPunto.html";
		}
		@PostMapping("/addPunto")
		public String getPuntoDeInteres(@ModelAttribute("punto") Punto punto) {
				puntoService.addPunto(punto);
				return "redirect:/puntos";
		}
		
		@GetMapping("/puntos")
		public String getPuntos(Model model) {
				var puntos = puntoService.getPuntos();
				model.addAttribute("puntos", puntos);
				return "puntos.html";
		}

		@DeleteMapping("/deletepunto")
		public String deletePunto(@RequestParam("codigo") Integer codigo) {
				puntoService.deletePunto(codigo);
				return "redirect:/puntos";
		}

		/*
		@GetMapping("/comentarios")
		public String getComentarios(Model model) {
				return "comentarios.html";
		}
		@PostMapping("/valorar")
		public String postValoracion(Integer valoracion, Model model) {
				return "redirect:/puntos";
		}
		*/
}
