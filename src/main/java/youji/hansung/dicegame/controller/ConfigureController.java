package youji.hansung.dicegame.controller;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import youji.hansung.dicegame.model.Cell;
import youji.hansung.dicegame.service.ConfigureService;

@Controller
public class ConfigureController {
	@Autowired
	ConfigureService configureService;
	
	@Autowired
	Cell cell;

	@RequestMapping(value = "/initconfigure", method = RequestMethod.POST)
	public String initConfig(HttpServletRequest request, Model model) {
		configureService.initConfigure();
		model.addAttribute("replacedCells", cell.getCell());
		return "configure";
	}
	
	@RequestMapping(value = "/configure", method = RequestMethod.GET)
	public String configHome(HttpServletRequest request, Model model) {
		model.addAttribute("replacedCells", cell.getCell());
		return "configure";
	}
	
	@RequestMapping(value = "/setconfigure", method = RequestMethod.POST)
	public String setConfig(HttpServletRequest request, Model model) {
		String original = request.getParameter("originalCell");
		String replaced = request.getParameter("replacedCell");

		int originalCell = Integer.parseInt(original);
		int replacedCell = Integer.parseInt(replaced);

		configureService.setConfigure(originalCell, replacedCell);
		model.addAttribute("replacedCells", cell.getCell());

		return "configure";
	}
}
