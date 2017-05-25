package sh.kim.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import sh.kim.common.CommonDAO;
import sh.kim.common.Criteria;
import sh.kim.common.Excel;


@Service
public class SampleBoardImpl implements SampleBoard{

	@Autowired
	private CommonDAO dao;

	@Override
	public List<?> listAll(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		return  dao.list(nameSpace, map);
	}

	@Override
	public HashMap<String, Object> view(String nameSpace,
			HashMap<String, Object> map) throws Exception {
		return dao.read(nameSpace, map);
	}
	
	@Override
	public int insert(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		
		return dao.create(nameSpace, map);		
	}
	

	@Override
	public int delete(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		return dao.delete(nameSpace, map);
	}

	@Override
	public int modify(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		return dao.update(nameSpace, map);
	}
	
	@Override
	public int count(String nameSpace, HashMap<String, Object> map) throws Exception {
		return dao.count(nameSpace, map);
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONArray jsonListAll(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		List<EgovMap> list = (List<EgovMap>) dao.list(nameSpace, map);
		JSONArray json = new JSONArray();
		
		for(EgovMap eMap : list){
			JSONObject jsonObj = new JSONObject();
			Set<String> keys   = eMap.keySet();
			for(String key:keys){
                jsonObj.put(key, eMap.get(key));
            }
			json.add(jsonObj);
		}
		
		return json;
	}

	@Override
	public void countup(String nameSpace, HashMap<String, Object> map)
			throws Exception {
		// TODO Auto-generated method stub
		dao.countup(nameSpace, map);
		
	}

	@Override
	public List<?> listCriteria(String nameSpace, HashMap<String, Object> map, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(nameSpace, map, cri);
	}
	



	
}
