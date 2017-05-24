package sh.kim.common;

/**
 * 페이징 용 기준 클래스
 * @package : sh.kim.common
 * @interface : Criteria
 * @author : Seolhwa.Kim
 * @create : 2017. 5. 22
 */
public class Criteria {
	
	
	//페이지 계산공식
	//시작 데이터 번호 = (페이지번호-1)*페이지당 보여줄 개수(여기서는 10)

	private int page;	
	private int perPageNum;
	private int endPage;
	
	
	
	/**
	 * 페이징 기준제작
	 * @method : Criteria
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public Criteria(){
		this.page = 1;
		this.perPageNum = 10;
	}
	
	
	/**
	 * 페이지번호-1
	 * @method : setPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public void setPage(int page){
		
		if(page <= 0){
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	/**
	 * 페이지 당 번호 설정
	 * @method : setPerPageNum
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public void setPerPageNum(int perPageNum){
		
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	/**
	 * 페이지 얻기
	 * @method : getPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public int getPage() {
		return page;
	}	
	
	
	/**
	 * 페이지 계산 공식 적용하기
	 * @method : getPageStart
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public int getPageStart() {
		
		return (this.page -1)* perPageNum;
	}
	
	
	/**
	 * 페이지당 페이지 얻기
	 * @method : getPerPageNum
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public int getPerPageNum(){
		
		return this.perPageNum;
	}
	
	/**
	 * 끝에 인쇄할 페이지 얻기
	 * @method : getEndPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public int getEndPage() {

		endPage = perPageNum * getPage();
		System.out.println(endPage);
		return endPage;
	}

	/**
	 * 끝에 인쇄할 페이지 정하기
	 * @method : setEndPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	public void setEndPage(int endPage) {
		
		this.endPage = endPage;
	}



	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
}


