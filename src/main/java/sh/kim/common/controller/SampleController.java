package sh.kim.common.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sh.kim.common.Criteria;
import sh.kim.common.PageMaker;
import sh.kim.service.SampleBoard;

@Controller
public class SampleController {

	@Autowired
	private SampleBoard service;
	
	private int prevPage = 1;
	
	/**
	 * 시작화면 겸 글 목록
	 * @method : index
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@RequestMapping("/index")
	public String index(@RequestParam HashMap<String, Object> reqMap, Model model) throws Exception{
		
		List<?> list = service.listAll("sampleboard.listAll", reqMap);	
		model.addAttribute("list", list);
		
		return "/board/index";
	}
	
	/**
	 * 글 읽기
	 * @method : read
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@RequestMapping("/readPage")
	public String readList(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri) throws Exception{		
		
		HashMap<String, Object> list = service.view("sampleboard.read", reqMap);
		service.countup("sampleboard.viewHit", reqMap);
		model.addAttribute("list", list);
		model.addAttribute("cri", cri);	
		model.addAttribute("prevPage", prevPage);
		
		
		return "board/readCri";
	}
	
	/**
	 * 글 삭제하기
	 * @method : delete
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri, RedirectAttributes r) throws Exception{		
		service.delete("sampleboard.delete", reqMap);

		r.addAttribute("page", prevPage);
		return "redirect:/listPage";
	}
	
	/**
	 * 글 수정하기
	 * @method : update
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@RequestMapping("/updateView")
	public String updateView(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri) throws Exception{	
		
		HashMap<String, Object> list = service.view("sampleboard.read", reqMap);
		model.addAttribute("list", list);
		model.addAttribute("cri", cri);
		model.addAttribute("prevPage", prevPage);
		
		return "board/update";
	}
	
	
	@RequestMapping("/update")
	public String update(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri, RedirectAttributes r) throws Exception{		
		service.modify("sampleboard.update", reqMap);
		
		r.addAttribute("page", prevPage);
		
		return "redirect:/listPage";
	}
	
	/**
	 * 글 쓰기
	 * @method : insert
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@RequestMapping("/insertView")
	public String insertView(@RequestParam HashMap<String, Object> reqMap, Model model) throws Exception{		
		return "board/insert";
	}
	
	
	@RequestMapping("/insert")
	public String insert(@RequestParam HashMap<String, Object> reqMap, Model model, RedirectAttributes r) throws Exception{		
		service.insert("sampleboard.save", reqMap);
		r.addAttribute("page", prevPage);
		
		return "redirect:/listPage";
	}
	
	/**
	 * 페이징
	 * @method : listPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri) throws Exception{		
	    
	
		if(reqMap.get("page").equals("1")){
			model.addAttribute("list", service.listCriteria("sampleboard.listCri", reqMap, cri));
		}else{
			System.out.println(reqMap);
			System.out.println(cri);
			model.addAttribute("list", service.listCriteria("sampleboard.listPage", reqMap, cri));			
		}
		
	    PageMaker pg = new PageMaker();
	    pg.setCri(cri);	    
	    pg.setTotalCount(service.count("sampleboard.listCount", reqMap));
	    model.addAttribute("pageMaker", pg);	     
	    prevPage = cri.getPage();
	    
		return "board/listCri";
	}
	
	
	
	
	
	
}
