package sh.kim.common;

import java.util.HashMap;
import java.util.List;


/**
 * 공통 DAO
 * @package : sh.kim.common
 * @interface : CommonDAO
 * @author : Seolhwa.Kim
 * @create : 2017. 5. 23
 */
public interface CommonDAO {

	int count(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	List<?> list(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	HashMap<String, Object> read(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	int create(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	int delete(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	int update(String nameSpace, HashMap<String, Object> map) throws Exception;

	void countup(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	List<?> listPage(String nameSpace, HashMap<String, Object> map, Criteria cri) throws Exception;
	
}
