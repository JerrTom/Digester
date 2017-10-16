package com.itcast.cn;

import java.util.ArrayList;
import java.util.List;

public class ViewCache {

	@SuppressWarnings("rawtypes")
	private List areaList = new ArrayList();
    @SuppressWarnings("rawtypes")
	public List getAreaList() {
        return areaList;
    }
    @SuppressWarnings("rawtypes")
	public void setAreaList(List areaList) {
        this.areaList = areaList;
    }
    
    // 供Digester调用的方法
    @SuppressWarnings("unchecked")
	public void addArea(Area area) {
        this.areaList.add(area);
    }
}
