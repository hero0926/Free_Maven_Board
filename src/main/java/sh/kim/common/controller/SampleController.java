package sh.kim.common.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sh.kim.common.Criteria;
import sh.kim.common.PageMaker;
import sh.kim.service.SampleBoard;

@Controller
public class SampleController {

	@Autowired
	private SampleBoard service;
	
	
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
	@RequestMapping("/read")
	public String read(@RequestParam HashMap<String, Object> reqMap, Model model) throws Exception{
		
		HashMap<String, Object> list = service.view("sampleboard.read", reqMap);
		service.countup("sampleboard.viewHit", reqMap);
		model.addAttribute("list", list);
		
		return "/board/read";
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
	public String delete(@RequestParam HashMap<String, Object> reqMap, Model model) throws Exception{		
		service.delete("sampleboard.delete", reqMap);
		return "redirect:/index";
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
	public String updateView(@RequestParam HashMap<String, Object> reqMap, Model model) throws Exception{	
		
		HashMap<String, Object> list = service.view("sampleboard.read", reqMap);
		model.addAttribute("list", list);
		return "board/update";
	}
	
	
	@RequestMapping("/update")
	public String update(@RequestParam HashMap<String, Object> reqMap, Model model) throws Exception{		
		service.modify("sampleboard.update", reqMap);
		return "redirect:/index";
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
	public String insert(@RequestParam HashMap<String, Object> reqMap, Model model) throws Exception{		
		service.insert("sampleboard.save", reqMap);
		return "redirect:/index";
	}
	
	/**
	 * 페이징 테스트
	 * @method : listPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri) throws Exception{		
	    model.addAttribute("list", service.listCriteria("sampleboard.listCri", reqMap, cri));
	    
	    PageMaker pg = new PageMaker();
	    pg.setCri(cri);
	    pg.setTotalCount(50);
	    
	    System.out.println("cri : "+cri);
	    model.addAttribute("pg", pg);	    
	    System.out.println("getEndPage : "+pg.getEndPage());	    
	    System.out.println("getDisplayPageNum : "+pg.getDisplayPageNum());	    
	    System.out.println("getCri : "+pg.getCri());	    
	    
		return "board/listCri";
	}
	
	
	/**
	 * 페이징 테스트
	 * @method : listCri
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 *//*
	@RequestMapping("/listCri")
	public String listCri(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri) throws Exception{		
	    model.addAttribute("list", service.listCriteria("sampleboard.listCri", reqMap, cri));
		return "board/listCri";
	}*/
	
}
