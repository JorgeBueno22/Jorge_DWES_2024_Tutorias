package com.spring.tutoriasEDU.enmarca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tutoriasEDU.actividad.Actividad;
import com.spring.tutoriasEDU.actividad.ActividadDao;
import com.spring.tutoriasEDU.planes.Plan;
import com.spring.tutoriasEDU.planes.PlanDao;

@Controller
public class EnmarcaController {

	@Autowired
	PlanDao planDao;
	
	@Autowired
	ActividadDao actividadDao;
	
	@Autowired
	EnmarcaDao enmarcaDao;
	
	
	@GetMapping("/enmarca")
	public ModelAndView enmarcados() {

		ModelAndView model = new ModelAndView();
		model.setViewName("enmarca");

		List<Enmarca> enmarcados = (List<Enmarca>) enmarcaDao.findAll();
		model.addObject("enmarca", enmarcados);

		List<Plan> planes = (List<Plan>) planDao.findAll();
		model.addObject("enmarca", planes);
		
		List<Actividad> actividades = (List<Actividad>) actividadDao.findAll();
		model.addObject("enmarca", actividades);
		
		return model;
	}
}
