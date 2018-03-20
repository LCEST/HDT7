/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
/**
 *
 * @author Luis
 */
public class Diccionario {
        File arch = null;
        FileReader fr = null;
        BufferedReader br = null;
        BinaryTree<Association<String,String>>rz;
        ArrayList <String> orac = new ArrayList<String>();
    
    public Diccionario(){
        rz=new BinaryTree<Association<String,String>>(null, null, null, null);
        llenDic();
        tradOra();
    }
    
    public void llenDic(){
        ArrayList<String> wor= new ArrayList<String>();
        ArrayList<Association<String,String> >asociaciones= new ArrayList<Association<String,String>>();
    
        try {
           
           arch = new File ("diccionario.txt");
           fr = new FileReader (arch);
           br = new BufferedReader(fr);

         
           String lin;
           int ind=0;
           while((lin=br.readLine())!=null){
              wor.add(lin);
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
          
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }
        
        
        for(int i=0; i<wor.size()-1;i++){
               int lugar=wor.get(i).indexOf(',');
               String ing=wor.get(i).substring(0,lugar);
               String esp=wor.get(i).substring(lugar+1,wor.get(i).length());
               asociaciones.add(new Association(ing, esp));
        }
        
        rz.setValue(asociaciones.get(0));
        for (int i=1; i<asociaciones.size(); i++){
            insertarNodo(rz, asociaciones.get(i));
        }
     }
    
    public void insertarNodo(BinaryTree<Association<String,String>> padre, Association<String,String> dato)
    {

        Association<String,String> asociacion=padre.value();
        String llavPad=asociacion.getKey();
        String llaveDato=dato.getKey();
        int num=llavPad.compareToIgnoreCase(llaveDato);
        if(num>0 && padre.left()==null){

            padre.setLeft(new BinaryTree<Association<String,String>>(null, null, null,null));
            padre.left().setValue(dato);
        }else if(padre.left()!=null){

            insertarNodo(padre.left(),dato);
        }
        
        if(num<0 && padre.right()==null){
            padre.setRight(new BinaryTree<Association<String,String>>(null, null, null,null));
            padre.right().setValue(dato);
        }else if(padre.right()!=null){
            insertarNodo(padre.right(),dato);
        }
    }
    
     public String tradPal(BinaryTree<Association<String,String>> padre, String palabra)
{
	String palTrad = "";
	Association<String,String> asociacion=padre.value();
       	String llavPad=asociacion.getKey();
	int num=llavPad.compareToIgnoreCase(palabra);
	if(num==0){
		palTrad=padre.value().getValue();
	}
	if(num<0){
            if(padre.right()!=null){
                palTrad=tradPal(padre.right(),palabra);
            }else{
                return ("*"+palabra+"*");
            }
	}
	if(num>0){
            if(padre.left()!=null){
                    palTrad=tradPal(padre.left(),palabra);
            }else{
                    return ("*"+palabra+"*");
            }
		
	}

	return palTrad;
    }

     private void leerOracion(){
	String wor="";

        try {

           arch = new File ("texto.txt");
           fr = new FileReader (arch);
           br = new BufferedReader(fr);

           String lin;
           int ind=0;
           while((lin=br.readLine())!=null){
              	wor=lin;
           }
        }
        catch(Exception e){
           e.printStackTrace();
        }finally{
           try{                    
              if( null != fr ){   
                 fr.close();     
              }                  
           }catch (Exception e2){ 
              e2.printStackTrace();
           }
        }

	while(wor.compareTo("")!=0){
	int lugar=wor.indexOf(' ');
            if(lugar!=-1){
                    orac.add(wor.substring(0,lugar));
                    wor=wor.substring(lugar+1);
            }else{
                    orac.add(wor);
                    wor="";
            }
        }
     }
     
     
    public void tradOra(){
        leerOracion();
        String res="";
        for(int i=0; i<orac.size(); i++){
                res+=tradPal(rz, orac.get(i).trim())+" ";
        }
        System.out.println(res);
    }



}