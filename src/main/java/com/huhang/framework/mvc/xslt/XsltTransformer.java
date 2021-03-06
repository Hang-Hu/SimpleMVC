package com.huhang.framework.mvc.xslt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;

public class XsltTransformer {
	public void transform(InputStream xmlInput, InputStream xslInput, OutputStream output){
		TransformerFactory factory=TransformerFactory.newInstance();
        Transformer transformer= null;
        try {
            transformer = factory.newTransformer(new StreamSource(xslInput));
            StreamResult outputTarget=new StreamResult(output);
            transformer.transform(new StreamSource(xmlInput), outputTarget);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println(output);
	}
	/*
	@Test
	public void test() throws TransformerException, IOException{
		String name="success_view";
		String xmlPath="src/"+name+".xml";
		String xslPath="src/"+name+".xsl";
		String htmlPath="src/"+name+".html";
		InputStream xmlInput=new FileInputStream(xmlPath);
		InputStream xslInput=new FileInputStream(xslPath);
		OutputStream output=new FileOutputStream(htmlPath);
		transform(xmlInput, xslInput, output);
	}*/
}
