package com.mytutorial.rateflats.extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLManager {
	
	private File fileWithXMLDocument;

    private Document xmlDocument;

    private Element rootNode;
    
    SAXBuilder saxBuilder;
    
    Element child;
    
	public void setXMLFile(String pathOfFile){
		
		fileWithXMLDocument = new File(pathOfFile);
		saxBuilder = new SAXBuilder();
		
		try {
			xmlDocument = (Document)saxBuilder.build(fileWithXMLDocument);
		} catch (JDOMException e) {
		    System.out.println("Fichero XML no valido");
		    e.printStackTrace();
		} catch (IOException e) {
		    System.out.println("Fichero no valido");
		    e.printStackTrace();
		}
	}
	
	public Element getNode(String nameOfNode){
		try {
			rootNode = this.xmlDocument.getRootElement();
		}catch (NullPointerException e){
			System.out.println("Configure un fichero XML");
		    e.printStackTrace();
		}
		return rootNode.getChild(nameOfNode);
	}
	
	public void setNodes(Double areaWeight, Double rateWeight, Double priceWeight,
			Double distanceWeight){
		try {
			rootNode = this.xmlDocument.getRootElement();
		}catch (NullPointerException e){
			System.out.println("Configure un fichero XML");
		    e.printStackTrace();
		}
		child = rootNode.getChild("area");
		child.setText(areaWeight.toString());
		child = rootNode.getChild("rating");
		child.setText(rateWeight.toString());
		child = rootNode.getChild("distance");
		child.setText(distanceWeight.toString());
		child = rootNode.getChild("price");
		child.setText(priceWeight.toString());
	}
}
