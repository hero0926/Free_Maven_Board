package sh.kim.common;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 페이지 처리용 클래스
 * @package : sh.kim.common
 * @class   : PageMaker
 * @author  : Seolhwa.Kim
 * @create  : 2017. 05. 24
 */
public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	private Criteria cri;


	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	
	/**
	 * 전체 개시물 개수 구하기
	 * @method : setTotalCount
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	
	/**
	 * 전체 개시물 개수 구하기 구현
	 * @method : calcData
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	private void calcData() {
		
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum ) * displayPageNum);
				
		startPage = (endPage - displayPageNum) + 1;		
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		
		if(endPage > tempEndPage){
			endPage = tempEndPage;
		}
		
		prev = cri.getPage() ==1 ? false : true;
		
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
		
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}
	
}
