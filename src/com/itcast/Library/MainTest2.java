package com.itcast.Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;
/**
 * 纯属个人理解
 * @author JINXIN
 *
 */
public class MainTest2 {

	public static void main(String[] args) {
		Digester digester = new Digester();
		digester.setValidating(false);
		//预定义library节点规则
		digester.addObjectCreate("library", Library.class);
		digester.addSetProperties("library");
		//预定义book节点规则
		digester.addObjectCreate("library/book", Book.class);
		digester.addSetProperties("library/book");
		//预定义chapter节点规则
		digester.addObjectCreate("library/book/chapter", Chapter.class);
		digester.addBeanPropertySetter("library/book/chapter/no");
		digester.addBeanPropertySetter("library/book/chapter/caption");
		//预定义节点的下一个动作规则
		digester.addSetNext("library/book/chapter", "addChapter");
		digester.addSetNext("library/book", "addBook");
		
		try {
			Library library = digester.parse(new File("books.xml"));
			System.out.println(library.getName());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
