package com.itcast.Library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;
/**
 * �����������
 * @author JINXIN
 *
 */
public class MainTest2 {

	public static void main(String[] args) {
		Digester digester = new Digester();
		digester.setValidating(false);
		//Ԥ����library�ڵ����
		digester.addObjectCreate("library", Library.class);
		digester.addSetProperties("library");
		//Ԥ����book�ڵ����
		digester.addObjectCreate("library/book", Book.class);
		digester.addSetProperties("library/book");
		//Ԥ����chapter�ڵ����
		digester.addObjectCreate("library/book/chapter", Chapter.class);
		digester.addBeanPropertySetter("library/book/chapter/no");
		digester.addBeanPropertySetter("library/book/chapter/caption");
		//Ԥ����ڵ����һ����������
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
