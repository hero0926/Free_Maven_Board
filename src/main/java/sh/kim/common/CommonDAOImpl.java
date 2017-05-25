package sh.kim.common;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 공통DAO 구현
 * @package : sh.kim.common
 * @class   : CommonDAOImpl
 * @author  : Seolhwa.Kim
 * @create  : 2017. 05. 24
 */
@Repository
public class CommonDAOImpl implements CommonDAO{

	@Autowired
	private SqlSessionTemplate session;

	
	/**
	 * 글 개수
	 * @method : count
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@Override
	public int count(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub

		return session.selectOne(nameSpace, map);
	}
	
	
	/**
	 * 글 목록
	 * @method : list
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@Override
	public List<?> list(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(nameSpace, map);
	}

	
	/**
	 * 글 읽기
	 * @method : read
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@Override
	public HashMap<String, Object> read(String nameSpace,
			HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(nameSpace, map);
	}
		
	
	/**
	 * 글 쓰기
	 * @method : create
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@Override
	public int create(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return session.insert(nameSpace, map);
	}

	
	/**
	 * 글 지우기
	 * @method : delete
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@Override
	public int delete(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return session.delete(nameSpace, map);
	}

	
	/**
	 * 글 수정하기
	 * @method : update
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@Override
	public int update(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		return session.update(nameSpace, map);
	}

	/**
	 * 글 조회수 증가시키기
	 * @method : countup
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	@Override
	public void countup(String nameSpace, HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		session.update(nameSpace, map);
	}
	
	
	/**
	 * 글 페이징 처리
	 * @method : listPage
     * @author  : Seolhwa.Kim
     * @create  : 2017. 05. 24
	 * @param : map
	 * @return
	 */
	
	@Override
	public List<?> listPage(String nameSpace, HashMap<String, Object> map,
			Criteria cri) throws Exception {
		// TODO Auto-generated method stub		
			return session.selectList(nameSpace, cri);		
	}


	
}
