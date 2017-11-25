# JEL LIBRARY
Java Easy License Library
Main Applications and everything resides in https://github.com/hasansarman/jel
Use This JAR File to implement and read licence files in your applications.
Download Jar and helper.


Add JEL_LIBRARY.jar to Build Path and then call the function below to check licence.
You can also use Jel_Helper.java to implement functionality.
```Java
String licence_path="licence.jel";
Jel_Helper jel=new Jel_Helper();


 // FOR EASY FAST CHECHING FOR MAC OR HW ID.
if(jel.Check_Licence(licence_path)){
  System.out.println("LICENCE OK !!");
}


//IF YOU ENTERED HS_CODE OR EXTRA CODE THEN YOU SHOULD PASS THIS VLAUES TO Check_Licence(String,String); function
if(jel.Check_Licence(licence_path,HS_CODE,EXTRA_CODE)){
  System.out.println("LICENCE OK !!");
}

License l=jel.get_License();
//INFORMATION CHECK
String s="";
  s+="####Customer Info####\n";
	    //customer name
	    s+="C_NAME -> "+(l.C_NAME==null?"":l.C_NAME)+"\n";
	    s+="C_ADDRESS -> "+(l.C_ADDRESS==null?"":l.C_ADDRESS)+"\n";
	    s+="C_TYPE  ->  "+l.C_TYPE+"\n";
	    s+="C_EMAIL -> "+(l.C_EMAIL==null?"":l.C_EMAIL)+"\n";
	    s+="C_PHONE -> "+(l.C_PHONE==null?"":l.C_PHONE)+"\n";
	    s+="C_COUNTRY -> "+(l.C_COUNTRY==null?"":l.C_COUNTRY)+"\n";
	    s+="C_CITY -> "+(l.C_CITY==null?"":l.C_CITY)+"\n";
	    s+="C_ZIPCODE  ->  "+l.C_ZIPCODE+"\n";
	    
	    
	    s+="C_MOBILE -> "+(l.C_MOBILE==null?"":l.C_MOBILE)+"\n";
	    s+="C_EXTRA_FIELD -> "+(l.C_EXTRA_FIELD==null?"":l.C_EXTRA_FIELD)+"\n";
	    s+="C_ORIGIN -> "+(l.C_ORIGIN==null?"":l.C_ORIGIN)+"\n";
	    
	    
	    s+="####Product Info####\n";
	    s+="P_PRODUCT_ID  ->  "+l.P_PRODUCT_ID+"\n";
	    s+="P_PRODUCT_NAME -> "+(l.P_PRODUCT_NAME==null?"":l.P_PRODUCT_NAME)+"\n";
	    s+="P_PRODUCT_WEBPAGE -> "+(l.P_PRODUCT_WEBPAGE==null?"":l.P_PRODUCT_WEBPAGE)+"\n";
	    s+="P_PRODUCT_HS_CODE -> "+(l.P_PRODUCT_HS_CODE==null?"":l.P_PRODUCT_HS_CODE)+"\n";
	   
	    
	    
```


DO NOT SEND PRIVATE PUBLIC KEYS wiTH LIBRARY !!
DO NOT SEND PUB PRIV KEYS TO THE CUSTOMER !!



