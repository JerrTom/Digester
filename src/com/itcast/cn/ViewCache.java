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
    
    // ��Digester���õķ���
    @SuppressWarnings("unchecked")
	public void addArea(Area area) {
        this.areaList.add(area);
    }
}
