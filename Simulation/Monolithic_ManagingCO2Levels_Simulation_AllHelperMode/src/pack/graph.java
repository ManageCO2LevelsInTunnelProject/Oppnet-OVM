/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import com.mxgraph.view.mxStylesheet;
import java.util.ArrayList;
/**
 *
 * @author hessah
 */
public class graph extends JFrame {
    public static  ArrayList <Node> nodeNames = new ArrayList<Node>();
	public static  ArrayList <Location> nodeLoc = new ArrayList<Location>(); 
      public static  ArrayList <String>  invitNode= new ArrayList<String>();
           public static  ArrayList <ArrayList<String>> node = new ArrayList<ArrayList<String>>();
            public static  ArrayList <ArrayList<Double>> integTime = new ArrayList<ArrayList<Double>>();
            public static  ArrayList <ArrayList<Object>> vertex = new ArrayList<ArrayList<Object>>();
public static  ArrayList <Location> loc = new ArrayList<Location>();
public static  ArrayList <String> comm = new ArrayList<String>();
public static  ArrayList <String> founNode = new ArrayList<String>();
public static  ArrayList <Location> founNodeLoc = new ArrayList<Location>();
public static ArrayList<Object> vertex2= new ArrayList<Object>();
    public graph() {

        super("Monolithic AllHelperMode");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
      //  graph.getModel().setStyle(parent, string)
        
        try {
 for(int ii=0; ii<nodeNames.size();ii++){
     System.out.print(nodeNames.get(ii)+ " ");
 }
 
 System.out.println();
            // get stylesheet
            mxStylesheet stylesheet = graph.getStylesheet();

            // define stylename
            String styleName = "myImageStyle";
   
           
            // create image style
           // Hashtable<String, Object> style = new Hashtable<String, Object>();
           // style.put( mxConstants.STYLE_SHAPE, mxConstants.SHAPE_IMAGE);
           // style.put( mxConstants.STYLE_IMAGE, "/back.png");
           // style.put( mxConstants.STYLE_VERTICAL_LABEL_POSITION, mxConstants.ALIGN_CENTER);
            Hashtable <String, Object> edgeStyle = new Hashtable<String, Object>();
//edgeStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);
edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
edgeStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "#000000");
edgeStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "#ffffff");

stylesheet.setDefaultEdgeStyle(edgeStyle);

   Hashtable <String, Object> vertStyle = new Hashtable<String, Object>();
//edgeStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);

vertStyle.put(mxConstants.STYLE_FONTCOLOR, "#FF0000");
//vertStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "#ffffff");
vertStyle.put(mxConstants.ALIGN_BOTTOM, "#ffffff");
stylesheet.setDefaultVertexStyle(vertStyle);


graph.setStylesheet(stylesheet);


            // make new style available via stylename
        //    stylesheet.putCellStyle( styleName, style);

        
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
               vertex.clear();
            for(int ii=0; ii<node.size();ii++){
                if(ii==0){
                    
                     ArrayList<Object> vertex1= new ArrayList<Object>();
                     vertex1.clear();
                Object v= graph.insertVertex(parent, null, "Sensor", nodeLoc.get(ii).X*5 , nodeLoc.get(ii).Y*5, 80, 50, "shape=image;image=/sen.png");
                   vertex1.add(v); 
                   vertex1.add(node.get(0).get(1));
                   vertex.add(vertex1);
                   
                }
                //String e="v"+ii;
               else if(node.get(ii).get(0)=="Fan"){
                   ArrayList<Object> vertex1= new ArrayList<Object>();
                   Object v=graph.insertVertex(parent, null, "Fan", nodeLoc.get(ii).X*5, nodeLoc.get(ii).Y*5, 80, 50, "shape=image;image=/f.png");
                vertex1.add(v);
               vertex1.add(node.get(ii).get(1));
               vertex1.add(node.get(ii).get(2));
               vertex1.add(node.get(ii).get(3));
               vertex1.add(node.get(ii).get(4));
               vertex.add(vertex1);} 
                
               else if(node.get(ii).get(0)=="Billboard"){
                   ArrayList<Object> vertex1= new ArrayList<Object>();
                   Object v=graph.insertVertex(parent, null, "Billboard", nodeLoc.get(ii).X*5,nodeLoc.get(ii).Y*5, 80, 50, "shape=image;image=/B.jpg"); 
                vertex1.add(v);
                vertex1.add(node.get(ii).get(1));
               vertex1.add(node.get(ii).get(2));
                vertex1.add(node.get(ii).get(3));
                vertex1.add(node.get(ii).get(4));
               vertex.add(vertex1);} 
                
               else if(node.get(ii).get(0)=="Billboard2"){
                   ArrayList<Object> vertex1= new ArrayList<Object>();
                   Object v=graph.insertVertex(parent, null, "Billboard2", nodeLoc.get(ii).X*5 ,nodeLoc.get(ii).Y*5, 80, 50, "shape=image;image=/B.jpg");
                vertex1.add(v);
                vertex1.add(node.get(ii).get(1));
               vertex1.add(node.get(ii).get(2));
               vertex1.add(node.get(ii).get(3));
               vertex1.add(node.get(ii).get(4));
               vertex.add(vertex1);} 
                
               else if(node.get(ii).get(0)=="Smartphone"){
                   ArrayList<Object> vertex1= new ArrayList<Object>();
                   Object v= graph.insertVertex(parent, null, "Smartphone", nodeLoc.get(ii).X*5, nodeLoc.get(ii).Y*5, 80, 50, "shape=image;image=/s.png");
                vertex1.add(v); 
                vertex1.add(node.get(ii).get(1));
               vertex1.add(node.get(ii).get(2));
               vertex1.add(node.get(ii).get(3));
               vertex1.add(node.get(ii).get(4));
               vertex.add(vertex1);}
               
               else if(node.get(ii).get(0)=="Car"){
                   ArrayList<Object> vertex1= new ArrayList<Object>();
                   Object v= graph.insertVertex(parent, null, "Car", nodeLoc.get(ii).X*5, nodeLoc.get(ii).Y*5, 80, 30, "shape=image;image=/car.png");
                vertex1.add(v);
                vertex1.add(node.get(ii).get(1));
               vertex1.add(node.get(ii).get(2));
               vertex1.add(node.get(ii).get(3));
               vertex1.add(node.get(ii).get(4));
               vertex.add(vertex1);}  
               
              }
            
        /* for(int ii=0; ii<invitNode.size();ii++){
                if(invitNode.get(ii)=="Sensor"){
                 
                   vertex2.add(graph.insertVertex(parent, null, "Sensor1", 100 , 100, 80, 30, styleName)); 
                   
                }
                //String e="v"+ii;
               else if(invitNode.get(ii)=="Fan"){
                vertex2.add(graph.insertVertex(parent, null, "Fan",200, 200, 80, 30, "shape=image;image=/f.png")); } 
                
               else if(invitNode.get(ii)=="Billboard"){
                vertex2.add(graph.insertVertex(parent, null, "Billboard", 300,300, 80, 30, "shape=image;image=/B.jpg")); } 
                
               else if(invitNode.get(ii)=="Billboard2"){
                vertex2.add(graph.insertVertex(parent, null, "Billboard2", 400,400, 80, 30, "shape=image;image=/B.jpg"));} 
                
               else if(invitNode.get(ii)=="Smartphone"){
                vertex2.add(graph.insertVertex(parent, null, "Smartphone", 500,500, 80, 30, "shape=image;image=/s.png")); } 
               else if(invitNode.get(ii)=="Car"){
                vertex2.add(graph.insertVertex(parent, null, "Sensor", 600,600, 80, 30, styleName));}  
              }*/
            boolean n=true;
              for(int ii=0; ii<vertex.size();ii++){
                //String e="v"+ii;
               
                for(int i=0; i<vertex.size();i++){
                if(ii+1<vertex.size()){
                    
               if(vertex.get(ii+1).get(2).equals(vertex.get(i).get(1))){ 
                   n=true;
                   for(int nu=0;nu<nodeNames.size();nu++){
                       if(vertex.get(ii+1).get(1).equals(String.valueOf(nodeNames.get(nu).get_id()))){
                         
                         graph.insertEdge(parent, null,vertex.get(ii+1).get(3)+" "+vertex.get(ii+1).get(4)+"ms", vertex.get(i).get(0), vertex.get(ii+1).get(0),"strokeColor=#00FF00;");   
                       
                   n=false;}
                   
                          }
                  /* edgeStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "#000000");
edgeStyle.put(mxConstants.STYLE_LABEL_BACKGROUNDCOLOR, "#ffffff");


stylesheet.setDefaultEdgeStyle(edgeStyle);
graph.setStylesheet(stylesheet);*/
        
             if(n){  
                 
            graph.insertEdge(parent, null,vertex.get(ii+1).get(3)+" "+vertex.get(ii+1).get(4)+"ms", vertex.get(i).get(0), vertex.get(ii+1).get(0),"strokeColor=#FF0000;");}}}
            
            
               }
              }
    
              /* for(int ii=0; ii<vertex2.size();ii++){
                //String e="v"+ii;
                
                   
             graph.insertEdge(parent, null,"", vertex.get(0), vertex2.get(ii));
              }*/
              
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
        ImageIcon icon = new ImageIcon("bg11.png");
 graphComponent.setBackgroundImage(icon);

        getContentPane().add(graphComponent); 
}
    
}
