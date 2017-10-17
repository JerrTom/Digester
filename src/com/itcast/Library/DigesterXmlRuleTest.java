package com.itcast.Library;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.xml.sax.SAXException;


public class DigesterXmlRuleTest {

	public static void main(String[] args) {
		try {
            // 解析XML文件,并得到ROOT元素
            //Library library = (Library) digester.parse(MainTest.class.getResourceAsStream("books.xml"));
			/**
			 * Exception in thread "main" org.apache.commons.digester.xmlrules.XmlLoadException
			 */
			Digester digester = DigesterLoader.createDigester(DigesterXmlRuleTest.class.getResource("books-rule.xml"));
			Library library = (Library) digester.parse(DigesterXmlRuleTest.class.getResourceAsStream("books.xml"));
			//Library library = (Library) digester.parse(new File("books.xml"));
            System.out.println(" 图书馆: " + library.getName());
            System.out.println(" 共藏书: " + library.getBookList().size() + " 本 ");
            System.out.println(" ***************************** ");

            for (Book book : library.getBookList()) {
                System.out.println(" 书名: " + book.getTitle() + "        作者: " + book.getAuthor());
                System.out.println(" ------------------------------ ");
                // 显示章节
                System.out.println(" 共 " + book.getChapters().size() + " 章 ");
                for (Chapter chapter : book.getChapters()) {
                    System.out.println(chapter.getNo() + ": " + chapter.getCaption());
                }
                System.out.println(" ------------------------------ ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
	}
}
