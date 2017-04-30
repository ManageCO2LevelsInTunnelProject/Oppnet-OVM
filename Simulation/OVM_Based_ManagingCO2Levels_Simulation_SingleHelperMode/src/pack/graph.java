/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;


import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import java.util.ArrayList;

/**
 *
 * @author hessah
 */
public class graph extends JFrame {
   public static  ArrayList <String> nodeNames = new ArrayList<String>();public static  ArrayList <Location> nodeLoc = new ArrayList<Location>(); 
public static  ArrayList <String> edge = new ArrayList<String>();
public static ArrayList<Object> vertex= new ArrayList<Object>();
public static  ArrayList <String> comm = new ArrayList<String>();
public static  ArrayList <Double> integ = new ArrayList<Double>();
public static  ArrayList <String> founNode = new ArrayList<String>();
public static  ArrayList <Location> founNodeLoc = new ArrayList<Location>();
public static ArrayList<Object> vertex2= new ArrayList<Object>();
    public graph() {

        super("Monolithic SingleHelperMode");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        
        
        try {
 for(int ii=0; ii<comm.size();ii++){
     System.out.print(comm.get(ii)+ " ");
 }
 System.out.println();

            // get stylesheet
            mxStylesheet stylesheet = graph.getStylesheet();

            // define stylename
            String styleName = "myImageStyle";
 
           
            // create image style
            Hashtable<String, Object> style = new Hashtable<String, Object>();
            style.put( mxConstants.STYLE_SHAPE, mxConstants.SHAPE_IMAGE);
            style.put( mxConstants.STYLE_IMAGE, "/back.png");
            style.put( mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_CENTER);
                        Hashtable <String, Object> edgeStyle = new Hashtable<String, Object>();
//edgeStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);
edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
edgeStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "#000000");
//edgeStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "#ffffff");
stylesheet.setDefaultEdgeStyle(edgeStyle);
graph.setStylesheet(stylesheet);

            // make new style available via stylename
            stylesheet.putCellStyle( styleName, style);

        
             vertex.clear();
             /*  for(int ii=0; ii<founNode.size() ;ii++){
            
                if(founNode.get(ii)=="Fan"){
                vertex2.add(graph.insertVertex(parent, null, "Fan", founNodeLoc.get(ii).X*5, founNodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/f.png")); } 
                
               else if(founNode.get(ii)=="Billboard"){
                vertex2.add(graph.insertVertex(parent, null, "Billboard", founNodeLoc.get(ii).X*5,founNodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/B.jpg")); } 
                
               else if(founNode.get(ii)=="BillBoard2"){
                vertex2.add(graph.insertVertex(parent, null, "Billboard2", founNodeLoc.get(ii).X*5,founNodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/B.jpg"));} 
                
               else if(founNode.get(ii)=="Smartphone"){
                vertex2.add(graph.insertVertex(parent, null, "Smartphone", founNodeLoc.get(ii).X*5, founNodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/s.png")); } 
               else if(founNode.get(ii)=="Car"){
                vertex2.add(graph.insertVertex(parent, null, "Car", founNodeLoc.get(ii).X*5, founNodeLoc.get(ii).Y*5, 80, 30, styleName));}  
              }*/
               
            for(int ii=0; ii<nodeNames.size();ii++){
                if(ii==0){
                 
                   vertex.add(graph.insertVertex(parent, null, "Sensor1", nodeLoc.get(ii).X*5 , nodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/sen.png")); 
                   
                }
                //String e="v"+ii;
               else if(nodeNames.get(ii)=="Fan"){
                vertex.add(graph.insertVertex(parent, null, "Fan", nodeLoc.get(ii).X*5, nodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/f.png")); } 
                
               else if(nodeNames.get(ii)=="Billboard"){
                vertex.add(graph.insertVertex(parent, null, "Billboard", nodeLoc.get(ii).X*5,nodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/B.jpg")); } 
                
               else if(nodeNames.get(ii)=="BillBoard2"){
                vertex.add(graph.insertVertex(parent, null, "Billboard2", nodeLoc.get(ii).X*5,nodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/B.jpg"));} 
                
               else if(nodeNames.get(ii)=="SmartPhone"){
                vertex.add(graph.insertVertex(parent, null, "Smartphone", nodeLoc.get(ii).X*5, nodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/s.png")); } 
               else if(nodeNames.get(ii)=="Car"){
                vertex.add(graph.insertVertex(parent, null, "Sensor", nodeLoc.get(ii).X*5, nodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/car.png"));}  
              }
            
        
            
              for(int ii=0; ii<vertex.size();ii++){
                //String e="v"+ii;
                if(ii+1<vertex.size())   {   
             graph.insertEdge(parent, null,comm.get(ii)+" "+integ.get(ii)+"ms", vertex.get(ii), vertex.get(ii+1),"strokeColor=#00FF00;");}
              }
              
           /* // example 1: use style by stylename
            Object v1 = graph.insertVertex(parent, null, "Sensor", 100, 100, 80, 30, styleName);

            // example 2: use style by style definition
            Object v2 = graph.insertVertex(parent, null, "Billboard", 200, 200, 80, 30, "shape=image;image=/B.jpg");
            
             Object v3 = graph.insertVertex(parent, null, "Smartphone", 300, 300, 80, 30, "shape=image;image=/s.png");
            

            // example 2: use style by style definition
            Object v4 = graph.insertVertex(parent, null, "Fan", 400, 400, 80, 30, "shape=image;image=/f.png");*/

            // create edge
        //    graph.insertEdge(parent, null, "Zigbee", v1, v2);
          //  graph.insertEdge(parent, null, "BT", v2, v3);
          //  graph.insertEdge(parent, null, "Zigbee", v3, v4);
          

        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        ImageIcon icon = new ImageIcon("tunnel.png");
 graphComponent.setBackgroundImage(icon);

        getContentPane().add(graphComponent); 
}}
