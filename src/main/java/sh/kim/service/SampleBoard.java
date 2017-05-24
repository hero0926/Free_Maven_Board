package sh.kim.service;

import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;

import sh.kim.common.Criteria;



public interface SampleBoard {
	
	List<?> listCriteria(String nameSpace, HashMap<String, Object> map, Criteria cri)  throws Exception;
	
	int count(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	List<?> listAll(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	HashMap<String, Object> view(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	int insert(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	int delete(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	int modify(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	JSONArray jsonListAll(String nameSpace, HashMap<String, Object> map) throws Exception;
	
	void countup(String nameSpace, HashMap<String, Object> map) throws Exception;
}
