package com.itcast.cn;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class AreaDigester {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		AreaDigester ad = new AreaDigester();
		List list = ad.digester().getAreaList();
		System.out.println(list.toString());
	}
	public ViewCache digester(){
		Digester digester = new Digester();
		
		digester.addObjectCreate("viewcache/areas", ViewCache.class);
		digester.addObjectCreate("viewcache/areas/area", Area.class);
		digester.addBeanPropertySetter("viewcache/areas/area/id", "id");
		digester.addBeanPropertySetter("viewcache/areas/area/parentId", "parentId");
		digester.addBeanPropertySetter("viewcache/areas/area/name", "name");  
        digester.addBeanPropertySetter("viewcache/areas/area/areaType", "areaType");  
        digester.addBeanPropertySetter("viewcache/areas/area/ordering", "ordering");  
        digester.addBeanPropertySetter("viewcache/areas/area/zip", "zip");  
        digester.addBeanPropertySetter("viewcache/areas/area/phoneArea", "phoneArea");
        digester.addSetNext("viewcache/areas/area", "addArea");
        ViewCache vc = null;
        try {
			vc = digester.parse(new File("viewcache.xml"));
			/*
			 * 下面的解析方式会产生一个java.net.MalformedURLException: no protocol: viewcache.xml的异常
			 */
			//vc = digester.parse("viewcache.xml");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {	
			e.printStackTrace();
		}
		return vc;
	}
}
