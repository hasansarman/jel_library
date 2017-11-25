import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import com.hsarman.radonrad.jel.encryption.LicenseManager;
import com.hsarman.radonrad.jel_library.hw_utils.OSValidator;
import com.hsarman.radonrad.license_creator.encryption.License;

public class Jel_Helper {
	private String licence_path=null;
	

	private String HS_CODE=null;
	private String EXTRA_CODE=null;
	private License license=null;
	 public boolean Check_Licence(String licence_path) {
		 this.licence_path=licence_path;
		 get_License();
		 return Check("simple");
		 
	 }

 private boolean Check(String string) {
	 
	 
	 if(LIC_QUALITY_CHECK()) {
		 if(string=="simple") {

			 	if(license.getL_MAC()==null || license.getL_MAC()=="") {
					//MAC ile kontrol..
			 		return false;//MAC NULL
					
				}
			 	else {
			 		return MAC_CHECK( );
			 		
			 	}
				 
		 
			}
			else if(string=="advanced") {
				if(license.getL_MAC()==null || license.getL_MAC()=="") {
					//HWID ile kontrol..
					return HW_ID_CHECK();
					
				}
				else {
					if(MAC_CHECK( )) {
						return HW_ID_CHECK();
					}
				}
				
				
			}
	 }
	 
	 
		
		return false;
	}



public boolean Check_Licence(String licence_path,String HS_CODE,String EXTRA_CODE) {
	 	this.licence_path=licence_path;
		 this.HS_CODE=HS_CODE;
		 this.EXTRA_CODE=EXTRA_CODE;
		 get_License();
		return  Check("advanced");
		 
	 }
 
	public License get_License() {
		
		if(license!=null) {
			return license;
		}
		if(licence_path==null) {
			return null;
		}
		  try {
				com.hsarman.radonrad.license_creator.encryption.License FOQO = 
						LicenseManager.decrypt(
								new FileInputStream(
										new File(licence_path)));
				
				license=FOQO;
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return license;
		
	}
	private boolean MAC_CHECK() {
		 try {
			    InetAddress ip = InetAddress.getLocalHost();
			    System.out.println("Current IP address : " + ip.getHostAddress());

			    Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
			    while(networks.hasMoreElements()) {
			      NetworkInterface network = networks.nextElement();
			      byte[] mac = network.getHardwareAddress();

			      if(mac != null) {
			        System.out.print("Current MAC address : ");

			        StringBuilder sb = new StringBuilder();
			        for (int i = 0; i < mac.length; i++) {
			          sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			        }
			      if(sb.toString().equals(license.getL_MAC()))
			    	  return true;
			      }
			    }
			    return false;
			  } catch (UnknownHostException e) {
			    e.printStackTrace();
			    return false;
			  } catch (SocketException e){
			    e.printStackTrace();
			    return false;
			  }
	}
	private boolean HW_ID_CHECK() {
		
		return license.CheckHWID(new OSValidator().Validate_and_Get_Serial());
	}
	private boolean LIC_QUALITY_CHECK() {
		return license.quality_Check();
	}

	public String getLicence_path() {
		return licence_path;
	}

	public void setLicence_path(String licence_path) {
		this.licence_path = licence_path;
	}

	public String getHS_CODE() {
		return HS_CODE;
	}

	public void setHS_CODE(String hS_CODE) {
		HS_CODE = hS_CODE;
	}

	public String getEXTRA_CODE() {
		return EXTRA_CODE;
	}

	public void setEXTRA_CODE(String eXTRA_CODE) {
		EXTRA_CODE = eXTRA_CODE;
	}

	public License getLicense() {
		return license;
	}

	public void setLicense(License license) {
		this.license = license;
	}
	 
}
