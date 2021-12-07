//package j16.t03.springboot.c.controller;
//
//import java.util.List;
//
//import javax.servlet.ServletContext;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import j16.t03.springboot.m.entity._02_customerService.DmBean;
//import j16.t03.springboot.m.service.DmService;
//
//@Controller
//public class DmController {
//	
//	DmService dmService;
//	ServletContext servletContext;
//	
//	public DmController(DmService dmService, ServletContext servletContext) {
//		this.dmService = dmService;
//		this.servletContext = servletContext;
//	}
//	
//	
//	@GetMapping({ "/dmMenu", "/dmMenu/{dmId}" })
//	public String buyProductMenu(@PathVariable(name = "dmId",required = false) 
//									Integer dmId, Model model) {
//		List<DmBean> dms = dmService.getAllDms();
//		model.addAttribute("dms", dms);
//
//		
//		List<DmBean> dmo = dmService.getDmid(dmId);
//		model.addAttribute("dmo", dmo);
//		return "_02_onlineDM";
//	}
//
//}
