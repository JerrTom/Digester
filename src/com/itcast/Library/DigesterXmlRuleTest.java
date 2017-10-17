package com.itcast.Library;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;
import org.xml.sax.SAXException;


public class DigesterXmlRuleTest {

	public static void main(String[] args) {
		try {
            // ����XML�ļ�,���õ�ROOTԪ��
            //Library library = (Library) digester.parse(MainTest.class.getResourceAsStream("books.xml"));
			/**
			 * Exception in thread "main" org.apache.commons.digester.xmlrules.XmlLoadException
			 * Digester3��������createDigester���������Ը�caseʹ�õ���commons-digester-2.1.jar���������caseʹ�õ���
			 * commons-digester3-3.2.jar��
			 */
			Digester digester = DigesterLoader.createDigester(DigesterXmlRuleTest.class.getResource("books-rule.xml"));
			Library library = (Library) digester.parse(DigesterXmlRuleTest.class.getResourceAsStream("books.xml"));
			//Library library = (Library) digester.parse(new File("books.xml"));
            System.out.println(" ͼ���: " + library.getName());
            System.out.println(" ������: " + library.getBookList().size() + " �� ");
            System.out.println(" ***************************** ");

            for (Book book : library.getBookList()) {
                System.out.println(" ����: " + book.getTitle() + "        ����: " + book.getAuthor());
                System.out.println(" ------------------------------ ");
                // ��ʾ�½�
                System.out.println(" �� " + book.getChapters().size() + " �� ");
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
