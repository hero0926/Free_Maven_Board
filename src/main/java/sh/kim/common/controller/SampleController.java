package sh.kim.common.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sh.kim.common.Criteria;
import sh.kim.common.Excel;
import sh.kim.common.FileModel;
import sh.kim.common.PageMaker;
import sh.kim.service.SampleBoard;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



@Controller
public class SampleController {

	@Autowired
	private SampleBoard service;
	
	@Autowired
	ServletContext context;
	
	private String uploadPath = "D:\\test_file";
	
	private int prevPage = 1;
	
	private ModelAndView modelAndView;
	
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
		System.out.println("글 등록");
		
		
		
		System.out.println(reqMap);
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
	

	@SuppressWarnings("unchecked")
	@RequestMapping("/fileUpload")
	public String fileUpload(HttpServletRequest request, Model model, Criteria cri, RedirectAttributes r) throws Exception{		
		
		request.setCharacterEncoding("UTF-8");
	    int maxSize  = 1024*1024*10;      
	    String root = request.getSession().getServletContext().getRealPath("/");
	    String savePath = "D:\\test_file\\";
	    String uploadFile = "\\";
	    String newFileName = "\\";	 
	    int read = 0;
	    byte[] buf = new byte[1024];
	    FileInputStream fin = null;
	    FileOutputStream fout = null;
	    long currentTime = System.currentTimeMillis(); 
	    SimpleDateFormat simDf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss"); 
	 
	    try{
	 
	        MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	        
	        String b_title = multi.getParameter("b_title");
	        String b_writer_name = multi.getParameter("b_writer_name");
	        String b_password = multi.getParameter("b_password");
	        String b_content = multi.getParameter("b_content");
	        
	        HashMap<String, Object> insertmap = new HashMap<String, Object>();
	        insertmap.put("b_writer_name", b_writer_name);
	        insertmap.put("b_title", b_title);
	        insertmap.put("b_password", b_password);
	        insertmap.put("b_content", b_content);
	        
	        uploadFile = multi.getFilesystemName("file");
	        
	        newFileName = simDf.format(new Date(currentTime)) +"."+ uploadFile.substring(uploadFile.lastIndexOf(".")+1);
	        
	        File oldFile = new File(savePath + uploadFile);
	        File newFile = new File(savePath + newFileName);
	        
	        service.insert("sampleboard.save", insertmap);		
			r.addAttribute("page", prevPage);	         
	 
	        // 파일명 rename
	        if(!oldFile.renameTo(newFile)){
	 
	            // rename이 되지 않을경우 강제로 파일을 복사하고 기존파일은 삭제
	 
	            buf = new byte[1024];
	            fin = new FileInputStream(oldFile);
	            fout = new FileOutputStream(newFile);
	            read = 0;
	            while((read=fin.read(buf,0,buf.length))!=-1){
	                fout.write(buf, 0, read);
	            }
	             
	            fin.close();
	            fout.close();
	            oldFile.delete();
	        }
	        
	        

	        insertmap.put("b_writer_name", b_writer_name);
	        insertmap.put("b_title", b_title);
	        
	        
	        int b_idx = service.count("sampleboard.file_idx", insertmap);
	        
	        insertmap.put("b_writer_name", b_writer_name);
	        insertmap.put("b_title", b_title);
	        insertmap.put("b_password", b_password);
	        insertmap.put("b_content", b_content);
	        insertmap.put("b_idx", b_idx);
	        insertmap.put("f_board_name", "sample");
	        insertmap.put("f_ori_name", uploadFile);
	        insertmap.put("f_name", newFileName);
	        insertmap.put("f_size", oldFile.length());
	        
	        service.insert("sampleboard.addAttach", insertmap);
	 
	    }catch(Exception e){
	        e.printStackTrace();
	    }
		
		return "redirect:/listPage";

	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@RequestParam HashMap<String, Object> reqMap, Model model, RedirectAttributes r) throws Exception{
		
		service.insert("sampleboard.save", reqMap);		
		r.addAttribute("page", prevPage);
		
		return "redirect:/listPage";
	}
	
	/**
	 * 페이징
	 * @method : listPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 25
	 * @param : map
	 * @return
	 */
	@RequestMapping("/listPage")
	public String listPage(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri) throws Exception{		
	    
	
		if(reqMap.get("page").equals("1")){
			model.addAttribute("list", service.listCriteria("sampleboard.listCri", reqMap, cri));
		}else{
			model.addAttribute("list", service.listCriteria("sampleboard.listPage", reqMap, cri));			
		}
		
	    PageMaker pg = new PageMaker();
	    pg.setCri(cri);	    
	    pg.setTotalCount(service.count("sampleboard.listCount", reqMap));
	    model.addAttribute("pageMaker", pg);	     
	    prevPage = cri.getPage();
		model.addAttribute("prevPage", prevPage);
	    
		return "board/listCri";
	}
	
	/**
	 * 현재시간 구하기
	 * @method : rightNow
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 25
	 * @param 
	 * @return
	 */
	public String rightNow(){
	    long time = System.currentTimeMillis();
	    SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss", Locale.KOREA);
	    return dayTime.format(new Date(time));
	}
	
	/**
	 * 엑셀 다운
	 * @method : report
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 25
	 * @param : map
	 * @return
	 */
	@RequestMapping("/excel")
	public ModelAndView report(@RequestParam HashMap<String, Object> reqMap, Model model, Criteria cri) throws Exception{
		
		List<?> excellist;
		
		if(reqMap.get("page").equals("1")){
			excellist = service.listCriteria("sampleboard.listCri", reqMap, cri);			
		}else{
			excellist = service.listCriteria("sampleboard.listPage", reqMap, cri);
		}
			    
		return new ModelAndView(new Excel(), "list", excellist);
	}
	
	
	/**
	 * 파일 올리기
	 * @method : report
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 25
	 * @param : map
	 * @return
	 */
	
	public ModelAndView fileUploadPage() {
		  FileModel file = new FileModel();
	      ModelAndView modelAndView = new ModelAndView("fileUpload", "command", file);
	      return modelAndView;
	   }
	
	
}
