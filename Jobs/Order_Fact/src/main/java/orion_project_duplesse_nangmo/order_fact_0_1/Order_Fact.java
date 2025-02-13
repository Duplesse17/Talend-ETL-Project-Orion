// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package orion_project_duplesse_nangmo.order_fact_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_2
	//import java.util.List;

	//the import part of tJava_1
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: Order_Fact Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Order_Fact implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	private Object[] multiThreadLockWrite = new Object[0];
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "Order_Fact";
	private final String projectName = "ORION_PROJECT_DUPLESSE_NANGMO";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>());
		
	
		private final java.util.Map<String, Long> start_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());
		private final java.util.Map<String, Long> end_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());
		private final java.util.Map<String, Boolean> ok_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Boolean>());
		public  final java.util.List<String[]> globalBuffer = java.util.Collections.synchronizedList(new java.util.ArrayList<String[]>());
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				Order_Fact.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Order_Fact.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
						try {
							
								if(this.execStat){
									runStat.updateStatOnConnection("OnComponentError1", 0, "error");
								}
							
							
								((java.util.Map)threadLocal.get()).put("errorCode", null);
								tDBRollback_1Process(globalMap);
								if ( !"failure".equals(((java.util.Map)threadLocal.get()).get("status")) ) {
									((java.util.Map)threadLocal.get()).put("status", "end");
								}
								

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tSendMail_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tJava_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBCommit_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBRollback_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBRollback_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBClose_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBClose_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_orders_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_customer_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				((java.util.Map)threadLocal.get()).put("status", "failure");
				
					tDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBRollback_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBClose_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public long Customer_ID;

				public long getCustomer_ID () {
					return this.Customer_ID;
				}
				
			    public long Employee_ID;

				public long getEmployee_ID () {
					return this.Employee_ID;
				}
				
			    public long Street_ID;

				public long getStreet_ID () {
					return this.Street_ID;
				}
				
			    public long Product_ID;

				public long getProduct_ID () {
					return this.Product_ID;
				}
				
			    public java.util.Date Order_Date;

				public java.util.Date getOrder_Date () {
					return this.Order_Date;
				}
				
			    public int Order_ID;

				public int getOrder_ID () {
					return this.Order_ID;
				}
				
			    public Short Order_Type;

				public Short getOrder_Type () {
					return this.Order_Type;
				}
				
			    public java.util.Date Delivery_Date;

				public java.util.Date getDelivery_Date () {
					return this.Delivery_Date;
				}
				
			    public Short Quantity;

				public Short getQuantity () {
					return this.Quantity;
				}
				
			    public BigDecimal Total_Retail_Proce;

				public BigDecimal getTotal_Retail_Proce () {
					return this.Total_Retail_Proce;
				}
				
			    public BigDecimal Costprice_Per_Unit;

				public BigDecimal getCostprice_Per_Unit () {
					return this.Costprice_Per_Unit;
				}
				
			    public BigDecimal Discount;

				public BigDecimal getDiscount () {
					return this.Discount;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Customer_ID;
						
							result = prime * result + (int) this.Employee_ID;
						
							result = prime * result + (int) this.Street_ID;
						
							result = prime * result + (int) this.Product_ID;
						
						result = prime * result + ((this.Order_Date == null) ? 0 : this.Order_Date.hashCode());
					
							result = prime * result + (int) this.Order_ID;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row1Struct other = (row1Struct) obj;
		
						if (this.Customer_ID != other.Customer_ID)
							return false;
					
						if (this.Employee_ID != other.Employee_ID)
							return false;
					
						if (this.Street_ID != other.Street_ID)
							return false;
					
						if (this.Product_ID != other.Product_ID)
							return false;
					
						if (this.Order_Date == null) {
							if (other.Order_Date != null)
								return false;
						
						} else if (!this.Order_Date.equals(other.Order_Date))
						
							return false;
					
						if (this.Order_ID != other.Order_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

		other.Customer_ID = this.Customer_ID;
	            other.Employee_ID = this.Employee_ID;
	            other.Street_ID = this.Street_ID;
	            other.Product_ID = this.Product_ID;
	            other.Order_Date = this.Order_Date;
	            other.Order_ID = this.Order_ID;
	            other.Order_Type = this.Order_Type;
	            other.Delivery_Date = this.Delivery_Date;
	            other.Quantity = this.Quantity;
	            other.Total_Retail_Proce = this.Total_Retail_Proce;
	            other.Costprice_Per_Unit = this.Costprice_Per_Unit;
	            other.Discount = this.Discount;
	            
	}

	public void copyKeysDataTo(row1Struct other) {

		other.Customer_ID = this.Customer_ID;
	            	other.Employee_ID = this.Employee_ID;
	            	other.Street_ID = this.Street_ID;
	            	other.Product_ID = this.Product_ID;
	            	other.Order_Date = this.Order_Date;
	            	other.Order_ID = this.Order_ID;
	            	
	}




	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.Customer_ID = dis.readLong();
					
			        this.Employee_ID = dis.readLong();
					
			        this.Street_ID = dis.readLong();
					
			        this.Product_ID = dis.readLong();
					
					this.Order_Date = readDate(dis);
					
			        this.Order_ID = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Order_Type = null;
           				} else {
           			    	this.Order_Type = dis.readShort();
           				}
					
					this.Delivery_Date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantity = null;
           				} else {
           			    	this.Quantity = dis.readShort();
           				}
					
						this.Total_Retail_Proce = (BigDecimal) dis.readObject();
					
						this.Costprice_Per_Unit = (BigDecimal) dis.readObject();
					
						this.Discount = (BigDecimal) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.Customer_ID = dis.readLong();
					
			        this.Employee_ID = dis.readLong();
					
			        this.Street_ID = dis.readLong();
					
			        this.Product_ID = dis.readLong();
					
					this.Order_Date = readDate(dis);
					
			        this.Order_ID = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Order_Type = null;
           				} else {
           			    	this.Order_Type = dis.readShort();
           				}
					
					this.Delivery_Date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantity = null;
           				} else {
           			    	this.Quantity = dis.readShort();
           				}
					
						this.Total_Retail_Proce = (BigDecimal) dis.readObject();
					
						this.Costprice_Per_Unit = (BigDecimal) dis.readObject();
					
						this.Discount = (BigDecimal) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Customer_ID);
					
					// long
				
		            	dos.writeLong(this.Employee_ID);
					
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// java.util.Date
				
						writeDate(this.Order_Date,dos);
					
					// int
				
		            	dos.writeInt(this.Order_ID);
					
					// Short
				
						if(this.Order_Type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Order_Type);
		            	}
					
					// java.util.Date
				
						writeDate(this.Delivery_Date,dos);
					
					// Short
				
						if(this.Quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Quantity);
		            	}
					
					// BigDecimal
				
       			    	dos.writeObject(this.Total_Retail_Proce);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Costprice_Per_Unit);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Discount);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Customer_ID);
					
					// long
				
		            	dos.writeLong(this.Employee_ID);
					
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// java.util.Date
				
						writeDate(this.Order_Date,dos);
					
					// int
				
		            	dos.writeInt(this.Order_ID);
					
					// Short
				
						if(this.Order_Type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Order_Type);
		            	}
					
					// java.util.Date
				
						writeDate(this.Delivery_Date,dos);
					
					// Short
				
						if(this.Quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Quantity);
		            	}
					
					// BigDecimal
				
       			    	dos.writeObject(this.Total_Retail_Proce);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Costprice_Per_Unit);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Discount);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Customer_ID="+String.valueOf(Customer_ID));
		sb.append(",Employee_ID="+String.valueOf(Employee_ID));
		sb.append(",Street_ID="+String.valueOf(Street_ID));
		sb.append(",Product_ID="+String.valueOf(Product_ID));
		sb.append(",Order_Date="+String.valueOf(Order_Date));
		sb.append(",Order_ID="+String.valueOf(Order_ID));
		sb.append(",Order_Type="+String.valueOf(Order_Type));
		sb.append(",Delivery_Date="+String.valueOf(Delivery_Date));
		sb.append(",Quantity="+String.valueOf(Quantity));
		sb.append(",Total_Retail_Proce="+String.valueOf(Total_Retail_Proce));
		sb.append(",Costprice_Per_Unit="+String.valueOf(Costprice_Per_Unit));
		sb.append(",Discount="+String.valueOf(Discount));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Customer_ID, other.Customer_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Employee_ID, other.Employee_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Street_ID, other.Street_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Product_ID, other.Product_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Order_Date, other.Order_Date);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Order_ID, other.Order_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class sortieStruct implements routines.system.IPersistableRow<sortieStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public long Customer_ID;

				public long getCustomer_ID () {
					return this.Customer_ID;
				}
				
			    public long Employee_ID;

				public long getEmployee_ID () {
					return this.Employee_ID;
				}
				
			    public long Street_ID;

				public long getStreet_ID () {
					return this.Street_ID;
				}
				
			    public long Product_ID;

				public long getProduct_ID () {
					return this.Product_ID;
				}
				
			    public java.util.Date Order_Date;

				public java.util.Date getOrder_Date () {
					return this.Order_Date;
				}
				
			    public int Order_ID;

				public int getOrder_ID () {
					return this.Order_ID;
				}
				
			    public Short Order_Type;

				public Short getOrder_Type () {
					return this.Order_Type;
				}
				
			    public java.util.Date Delivery_Date;

				public java.util.Date getDelivery_Date () {
					return this.Delivery_Date;
				}
				
			    public Short Quantity;

				public Short getQuantity () {
					return this.Quantity;
				}
				
			    public BigDecimal Total_Retail_Proce;

				public BigDecimal getTotal_Retail_Proce () {
					return this.Total_Retail_Proce;
				}
				
			    public BigDecimal Costprice_Per_Unit;

				public BigDecimal getCostprice_Per_Unit () {
					return this.Costprice_Per_Unit;
				}
				
			    public BigDecimal Discount;

				public BigDecimal getDiscount () {
					return this.Discount;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.Customer_ID;
						
							result = prime * result + (int) this.Employee_ID;
						
							result = prime * result + (int) this.Street_ID;
						
							result = prime * result + (int) this.Product_ID;
						
						result = prime * result + ((this.Order_Date == null) ? 0 : this.Order_Date.hashCode());
					
							result = prime * result + (int) this.Order_ID;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final sortieStruct other = (sortieStruct) obj;
		
						if (this.Customer_ID != other.Customer_ID)
							return false;
					
						if (this.Employee_ID != other.Employee_ID)
							return false;
					
						if (this.Street_ID != other.Street_ID)
							return false;
					
						if (this.Product_ID != other.Product_ID)
							return false;
					
						if (this.Order_Date == null) {
							if (other.Order_Date != null)
								return false;
						
						} else if (!this.Order_Date.equals(other.Order_Date))
						
							return false;
					
						if (this.Order_ID != other.Order_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(sortieStruct other) {

		other.Customer_ID = this.Customer_ID;
	            other.Employee_ID = this.Employee_ID;
	            other.Street_ID = this.Street_ID;
	            other.Product_ID = this.Product_ID;
	            other.Order_Date = this.Order_Date;
	            other.Order_ID = this.Order_ID;
	            other.Order_Type = this.Order_Type;
	            other.Delivery_Date = this.Delivery_Date;
	            other.Quantity = this.Quantity;
	            other.Total_Retail_Proce = this.Total_Retail_Proce;
	            other.Costprice_Per_Unit = this.Costprice_Per_Unit;
	            other.Discount = this.Discount;
	            
	}

	public void copyKeysDataTo(sortieStruct other) {

		other.Customer_ID = this.Customer_ID;
	            	other.Employee_ID = this.Employee_ID;
	            	other.Street_ID = this.Street_ID;
	            	other.Product_ID = this.Product_ID;
	            	other.Order_Date = this.Order_Date;
	            	other.Order_ID = this.Order_ID;
	            	
	}




	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.Customer_ID = dis.readLong();
					
			        this.Employee_ID = dis.readLong();
					
			        this.Street_ID = dis.readLong();
					
			        this.Product_ID = dis.readLong();
					
					this.Order_Date = readDate(dis);
					
			        this.Order_ID = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Order_Type = null;
           				} else {
           			    	this.Order_Type = dis.readShort();
           				}
					
					this.Delivery_Date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantity = null;
           				} else {
           			    	this.Quantity = dis.readShort();
           				}
					
						this.Total_Retail_Proce = (BigDecimal) dis.readObject();
					
						this.Costprice_Per_Unit = (BigDecimal) dis.readObject();
					
						this.Discount = (BigDecimal) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.Customer_ID = dis.readLong();
					
			        this.Employee_ID = dis.readLong();
					
			        this.Street_ID = dis.readLong();
					
			        this.Product_ID = dis.readLong();
					
					this.Order_Date = readDate(dis);
					
			        this.Order_ID = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Order_Type = null;
           				} else {
           			    	this.Order_Type = dis.readShort();
           				}
					
					this.Delivery_Date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantity = null;
           				} else {
           			    	this.Quantity = dis.readShort();
           				}
					
						this.Total_Retail_Proce = (BigDecimal) dis.readObject();
					
						this.Costprice_Per_Unit = (BigDecimal) dis.readObject();
					
						this.Discount = (BigDecimal) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Customer_ID);
					
					// long
				
		            	dos.writeLong(this.Employee_ID);
					
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// java.util.Date
				
						writeDate(this.Order_Date,dos);
					
					// int
				
		            	dos.writeInt(this.Order_ID);
					
					// Short
				
						if(this.Order_Type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Order_Type);
		            	}
					
					// java.util.Date
				
						writeDate(this.Delivery_Date,dos);
					
					// Short
				
						if(this.Quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Quantity);
		            	}
					
					// BigDecimal
				
       			    	dos.writeObject(this.Total_Retail_Proce);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Costprice_Per_Unit);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Discount);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Customer_ID);
					
					// long
				
		            	dos.writeLong(this.Employee_ID);
					
					// long
				
		            	dos.writeLong(this.Street_ID);
					
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// java.util.Date
				
						writeDate(this.Order_Date,dos);
					
					// int
				
		            	dos.writeInt(this.Order_ID);
					
					// Short
				
						if(this.Order_Type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Order_Type);
		            	}
					
					// java.util.Date
				
						writeDate(this.Delivery_Date,dos);
					
					// Short
				
						if(this.Quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Quantity);
		            	}
					
					// BigDecimal
				
       			    	dos.writeObject(this.Total_Retail_Proce);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Costprice_Per_Unit);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Discount);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Customer_ID="+String.valueOf(Customer_ID));
		sb.append(",Employee_ID="+String.valueOf(Employee_ID));
		sb.append(",Street_ID="+String.valueOf(Street_ID));
		sb.append(",Product_ID="+String.valueOf(Product_ID));
		sb.append(",Order_Date="+String.valueOf(Order_Date));
		sb.append(",Order_ID="+String.valueOf(Order_ID));
		sb.append(",Order_Type="+String.valueOf(Order_Type));
		sb.append(",Delivery_Date="+String.valueOf(Delivery_Date));
		sb.append(",Quantity="+String.valueOf(Quantity));
		sb.append(",Total_Retail_Proce="+String.valueOf(Total_Retail_Proce));
		sb.append(",Costprice_Per_Unit="+String.valueOf(Costprice_Per_Unit));
		sb.append(",Discount="+String.valueOf(Discount));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(sortieStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Customer_ID, other.Customer_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Employee_ID, other.Employee_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Street_ID, other.Street_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Product_ID, other.Product_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Order_Date, other.Order_Date);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Order_ID, other.Order_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class outputStruct implements routines.system.IPersistableRow<outputStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];

	
			    public long Customer_ID;

				public long getCustomer_ID () {
					return this.Customer_ID;
				}
				
			    public long Employee_ID;

				public long getEmployee_ID () {
					return this.Employee_ID;
				}
				
			    public long Product_ID;

				public long getProduct_ID () {
					return this.Product_ID;
				}
				
			    public java.util.Date Order_Date;

				public java.util.Date getOrder_Date () {
					return this.Order_Date;
				}
				
			    public int Order_ID;

				public int getOrder_ID () {
					return this.Order_ID;
				}
				
			    public Short Order_Type;

				public Short getOrder_Type () {
					return this.Order_Type;
				}
				
			    public java.util.Date Delivery_Date;

				public java.util.Date getDelivery_Date () {
					return this.Delivery_Date;
				}
				
			    public Short Quantity;

				public Short getQuantity () {
					return this.Quantity;
				}
				
			    public BigDecimal Total_Retail_Proce;

				public BigDecimal getTotal_Retail_Proce () {
					return this.Total_Retail_Proce;
				}
				
			    public BigDecimal Costprice_Per_Unit;

				public BigDecimal getCostprice_Per_Unit () {
					return this.Costprice_Per_Unit;
				}
				
			    public BigDecimal Discount;

				public BigDecimal getDiscount () {
					return this.Discount;
				}
				



	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.Customer_ID = dis.readLong();
					
			        this.Employee_ID = dis.readLong();
					
			        this.Product_ID = dis.readLong();
					
					this.Order_Date = readDate(dis);
					
			        this.Order_ID = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Order_Type = null;
           				} else {
           			    	this.Order_Type = dis.readShort();
           				}
					
					this.Delivery_Date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantity = null;
           				} else {
           			    	this.Quantity = dis.readShort();
           				}
					
						this.Total_Retail_Proce = (BigDecimal) dis.readObject();
					
						this.Costprice_Per_Unit = (BigDecimal) dis.readObject();
					
						this.Discount = (BigDecimal) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.Customer_ID = dis.readLong();
					
			        this.Employee_ID = dis.readLong();
					
			        this.Product_ID = dis.readLong();
					
					this.Order_Date = readDate(dis);
					
			        this.Order_ID = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Order_Type = null;
           				} else {
           			    	this.Order_Type = dis.readShort();
           				}
					
					this.Delivery_Date = readDate(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantity = null;
           				} else {
           			    	this.Quantity = dis.readShort();
           				}
					
						this.Total_Retail_Proce = (BigDecimal) dis.readObject();
					
						this.Costprice_Per_Unit = (BigDecimal) dis.readObject();
					
						this.Discount = (BigDecimal) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Customer_ID);
					
					// long
				
		            	dos.writeLong(this.Employee_ID);
					
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// java.util.Date
				
						writeDate(this.Order_Date,dos);
					
					// int
				
		            	dos.writeInt(this.Order_ID);
					
					// Short
				
						if(this.Order_Type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Order_Type);
		            	}
					
					// java.util.Date
				
						writeDate(this.Delivery_Date,dos);
					
					// Short
				
						if(this.Quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Quantity);
		            	}
					
					// BigDecimal
				
       			    	dos.writeObject(this.Total_Retail_Proce);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Costprice_Per_Unit);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Discount);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// long
				
		            	dos.writeLong(this.Customer_ID);
					
					// long
				
		            	dos.writeLong(this.Employee_ID);
					
					// long
				
		            	dos.writeLong(this.Product_ID);
					
					// java.util.Date
				
						writeDate(this.Order_Date,dos);
					
					// int
				
		            	dos.writeInt(this.Order_ID);
					
					// Short
				
						if(this.Order_Type == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Order_Type);
		            	}
					
					// java.util.Date
				
						writeDate(this.Delivery_Date,dos);
					
					// Short
				
						if(this.Quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeShort(this.Quantity);
		            	}
					
					// BigDecimal
				
       			    	dos.writeObject(this.Total_Retail_Proce);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Costprice_Per_Unit);
					
					// BigDecimal
				
       			    	dos.writeObject(this.Discount);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Customer_ID="+String.valueOf(Customer_ID));
		sb.append(",Employee_ID="+String.valueOf(Employee_ID));
		sb.append(",Product_ID="+String.valueOf(Product_ID));
		sb.append(",Order_Date="+String.valueOf(Order_Date));
		sb.append(",Order_ID="+String.valueOf(Order_ID));
		sb.append(",Order_Type="+String.valueOf(Order_Type));
		sb.append(",Delivery_Date="+String.valueOf(Delivery_Date));
		sb.append(",Quantity="+String.valueOf(Quantity));
		sb.append(",Total_Retail_Proce="+String.valueOf(Total_Retail_Proce));
		sb.append(",Costprice_Per_Unit="+String.valueOf(Costprice_Per_Unit));
		sb.append(",Discount="+String.valueOf(Discount));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(outputStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class order_itemStruct implements routines.system.IPersistableRow<order_itemStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];

	
			    public double order_id;

				public double getOrder_id () {
					return this.order_id;
				}
				
			    public Double order_item_num;

				public Double getOrder_item_num () {
					return this.order_item_num;
				}
				
			    public Double product_id;

				public Double getProduct_id () {
					return this.product_id;
				}
				
			    public Double quantity;

				public Double getQuantity () {
					return this.quantity;
				}
				
			    public Double total_retail_price;

				public Double getTotal_retail_price () {
					return this.total_retail_price;
				}
				
			    public Double costprice_per_unit;

				public Double getCostprice_per_unit () {
					return this.costprice_per_unit;
				}
				
			    public Double discount;

				public Double getDiscount () {
					return this.discount;
				}
				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readDouble();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.order_item_num = null;
           				} else {
           			    	this.order_item_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_id = null;
           				} else {
           			    	this.product_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.quantity = null;
           				} else {
           			    	this.quantity = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_retail_price = null;
           				} else {
           			    	this.total_retail_price = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.costprice_per_unit = null;
           				} else {
           			    	this.costprice_per_unit = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.discount = null;
           				} else {
           			    	this.discount = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readDouble();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.order_item_num = null;
           				} else {
           			    	this.order_item_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_id = null;
           				} else {
           			    	this.product_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.quantity = null;
           				} else {
           			    	this.quantity = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_retail_price = null;
           				} else {
           			    	this.total_retail_price = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.costprice_per_unit = null;
           				} else {
           			    	this.costprice_per_unit = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.discount = null;
           				} else {
           			    	this.discount = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.order_id);
					
					// Double
				
						if(this.order_item_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.order_item_num);
		            	}
					
					// Double
				
						if(this.product_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_id);
		            	}
					
					// Double
				
						if(this.quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.quantity);
		            	}
					
					// Double
				
						if(this.total_retail_price == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_retail_price);
		            	}
					
					// Double
				
						if(this.costprice_per_unit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.costprice_per_unit);
		            	}
					
					// Double
				
						if(this.discount == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.discount);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.order_id);
					
					// Double
				
						if(this.order_item_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.order_item_num);
		            	}
					
					// Double
				
						if(this.product_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_id);
		            	}
					
					// Double
				
						if(this.quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.quantity);
		            	}
					
					// Double
				
						if(this.total_retail_price == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_retail_price);
		            	}
					
					// Double
				
						if(this.costprice_per_unit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.costprice_per_unit);
		            	}
					
					// Double
				
						if(this.discount == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.discount);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("order_id="+String.valueOf(order_id));
		sb.append(",order_item_num="+String.valueOf(order_item_num));
		sb.append(",product_id="+String.valueOf(product_id));
		sb.append(",quantity="+String.valueOf(quantity));
		sb.append(",total_retail_price="+String.valueOf(total_retail_price));
		sb.append(",costprice_per_unit="+String.valueOf(costprice_per_unit));
		sb.append(",discount="+String.valueOf(discount));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(order_itemStruct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_2Struct implements routines.system.IPersistableRow<after_tDBInput_2Struct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double order_id;

				public double getOrder_id () {
					return this.order_id;
				}
				
			    public Double order_item_num;

				public Double getOrder_item_num () {
					return this.order_item_num;
				}
				
			    public Double product_id;

				public Double getProduct_id () {
					return this.product_id;
				}
				
			    public Double quantity;

				public Double getQuantity () {
					return this.quantity;
				}
				
			    public Double total_retail_price;

				public Double getTotal_retail_price () {
					return this.total_retail_price;
				}
				
			    public Double costprice_per_unit;

				public Double getCostprice_per_unit () {
					return this.costprice_per_unit;
				}
				
			    public Double discount;

				public Double getDiscount () {
					return this.discount;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.order_id;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tDBInput_2Struct other = (after_tDBInput_2Struct) obj;
		
						if (this.order_id != other.order_id)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_2Struct other) {

		other.order_id = this.order_id;
	            other.order_item_num = this.order_item_num;
	            other.product_id = this.product_id;
	            other.quantity = this.quantity;
	            other.total_retail_price = this.total_retail_price;
	            other.costprice_per_unit = this.costprice_per_unit;
	            other.discount = this.discount;
	            
	}

	public void copyKeysDataTo(after_tDBInput_2Struct other) {

		other.order_id = this.order_id;
	            	
	}




    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readDouble();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.order_item_num = null;
           				} else {
           			    	this.order_item_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_id = null;
           				} else {
           			    	this.product_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.quantity = null;
           				} else {
           			    	this.quantity = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_retail_price = null;
           				} else {
           			    	this.total_retail_price = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.costprice_per_unit = null;
           				} else {
           			    	this.costprice_per_unit = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.discount = null;
           				} else {
           			    	this.discount = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readDouble();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.order_item_num = null;
           				} else {
           			    	this.order_item_num = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.product_id = null;
           				} else {
           			    	this.product_id = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.quantity = null;
           				} else {
           			    	this.quantity = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.total_retail_price = null;
           				} else {
           			    	this.total_retail_price = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.costprice_per_unit = null;
           				} else {
           			    	this.costprice_per_unit = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.discount = null;
           				} else {
           			    	this.discount = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.order_id);
					
					// Double
				
						if(this.order_item_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.order_item_num);
		            	}
					
					// Double
				
						if(this.product_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_id);
		            	}
					
					// Double
				
						if(this.quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.quantity);
		            	}
					
					// Double
				
						if(this.total_retail_price == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_retail_price);
		            	}
					
					// Double
				
						if(this.costprice_per_unit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.costprice_per_unit);
		            	}
					
					// Double
				
						if(this.discount == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.discount);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.order_id);
					
					// Double
				
						if(this.order_item_num == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.order_item_num);
		            	}
					
					// Double
				
						if(this.product_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.product_id);
		            	}
					
					// Double
				
						if(this.quantity == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.quantity);
		            	}
					
					// Double
				
						if(this.total_retail_price == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.total_retail_price);
		            	}
					
					// Double
				
						if(this.costprice_per_unit == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.costprice_per_unit);
		            	}
					
					// Double
				
						if(this.discount == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.discount);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("order_id="+String.valueOf(order_id));
		sb.append(",order_item_num="+String.valueOf(order_item_num));
		sb.append(",product_id="+String.valueOf(product_id));
		sb.append(",quantity="+String.valueOf(quantity));
		sb.append(",total_retail_price="+String.valueOf(total_retail_price));
		sb.append(",costprice_per_unit="+String.valueOf(costprice_per_unit));
		sb.append(",discount="+String.valueOf(discount));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.order_id, other.order_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_3Process(globalMap);
		tDBInput_1Process(globalMap);

		order_itemStruct order_item = new order_itemStruct();
outputStruct output = new outputStruct();
sortieStruct sortie = new sortieStruct();
row1Struct row1 = new row1Struct();







	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tLogRow_1 = 0;
		

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
		java.io.PrintStream consoleOut_tLogRow_1 = null;	

 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"sortie");
					}
				
		int tos_count_tDBOutput_1 = 0;
		






int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

String tableName_tDBOutput_1 = "Order_Fact";
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
long date_tDBOutput_1;

java.sql.Connection conn_tDBOutput_1 = null;
		
        String properties_tDBOutput_1 = "useSSL=false&allowPublicKeyRetrieval=true";
        if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
            properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_1 = "jdbc:mariadb://" + "127.0.0.1" + ":" + "3306" + "/" + "db_entrepot" + "?" + properties_tDBOutput_1;
		
		String driverClass_tDBOutput_1 = "org.mariadb.jdbc.Driver";
		
		String dbUser_tDBOutput_1 = "orion_DW_user";
		

		 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:eSBSDNlUE+i4gp2BcLQrVEoqVjV9LUF5J3P4v/Aj3G93cac1ZpU0UYk=");

		String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
		java.lang.Class.forName(driverClass_tDBOutput_1);
		
		conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
		
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

int count_tDBOutput_1=0;
    	
            int rsTruncCountNumber_tDBOutput_1 = 0;
            try(java.sql.Statement stmtTruncCount_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                try (java.sql.ResultSet rsTruncCount_tDBOutput_1 = stmtTruncCount_tDBOutput_1.executeQuery("SELECT COUNT(1) FROM `" + tableName_tDBOutput_1 + "`")) {
                    if(rsTruncCount_tDBOutput_1.next()) {
                        rsTruncCountNumber_tDBOutput_1 = rsTruncCount_tDBOutput_1.getInt(1);
                    }
                }
            }
            try (java.sql.Statement stmtTrunc_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                stmtTrunc_tDBOutput_1.executeUpdate("TRUNCATE TABLE `" + tableName_tDBOutput_1 + "`");
                deletedCount_tDBOutput_1 += rsTruncCountNumber_tDBOutput_1;
            }

				String insert_tDBOutput_1 = "INSERT INTO `" + "Order_Fact" + "` (`Customer_ID`,`Employee_ID`,`Street_ID`,`Product_ID`,`Order_Date`,`Order_ID`,`Order_Type`,`Delivery_Date`,`Quantity`,`Total_Retail_Proce`,`Costprice_Per_Unit`,`Discount`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		        int batchSize_tDBOutput_1 = 100;
	   			int batchSizeCounter_tDBOutput_1=0;
		            
		        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
		        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);


 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"output");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<customerStruct> tHash_Lookup_customer = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<customerStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<customerStruct>) 
					globalMap.get( "tHash_Lookup_customer" ))
					;					
					
	

customerStruct customerHashKey = new customerStruct();
customerStruct customerDefault = new customerStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
sortieStruct sortie_tmp = new sortieStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"order_item");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ordersStruct> tHash_Lookup_orders = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ordersStruct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ordersStruct>) 
					globalMap.get( "tHash_Lookup_orders" ))
					;					
					
	

ordersStruct ordersHashKey = new ordersStruct();
ordersStruct ordersDefault = new ordersStruct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
outputStruct output_tmp = new outputStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
			    String driverClass_tDBInput_2 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_2);
				
			String url_tDBInput_2 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2);
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT ORDER_ITEM.order_id,\n		ORDER_ITEM.order_item_num,\n		ORDER_ITEM.product_id,\n		ORDER_ITEM.quantity,\n		ORDER_ITEM.t"
+"otal_retail_price,\n		ORDER_ITEM.costprice_per_unit,\n		ORDER_ITEM.discount\nFROM	ORDER_ITEM";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								order_item.order_id = 0;
							} else {
	                         		
            order_item.order_id = rs_tDBInput_2.getDouble(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								order_item.order_item_num = null;
							} else {
	                         		
            order_item.order_item_num = rs_tDBInput_2.getDouble(2);
            if(rs_tDBInput_2.wasNull()){
                    order_item.order_item_num = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								order_item.product_id = null;
							} else {
	                         		
            order_item.product_id = rs_tDBInput_2.getDouble(3);
            if(rs_tDBInput_2.wasNull()){
                    order_item.product_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								order_item.quantity = null;
							} else {
	                         		
            order_item.quantity = rs_tDBInput_2.getDouble(4);
            if(rs_tDBInput_2.wasNull()){
                    order_item.quantity = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								order_item.total_retail_price = null;
							} else {
	                         		
            order_item.total_retail_price = rs_tDBInput_2.getDouble(5);
            if(rs_tDBInput_2.wasNull()){
                    order_item.total_retail_price = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								order_item.costprice_per_unit = null;
							} else {
	                         		
            order_item.costprice_per_unit = rs_tDBInput_2.getDouble(6);
            if(rs_tDBInput_2.wasNull()){
                    order_item.costprice_per_unit = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								order_item.discount = null;
							} else {
	                         		
            order_item.discount = rs_tDBInput_2.getDouble(7);
            if(rs_tDBInput_2.wasNull()){
                    order_item.discount = null;
            }
		                    }
					



 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"order_item"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "orders" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooporders = false;
       		  	    	
       		  	    	
 							ordersStruct ordersObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_orders__order_id = order_item.order_id ;
	                        		    	if(exprKeyValue_orders__order_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			ordersHashKey.order_id = (double)(Double) exprKeyValue_orders__order_id;
                        		    		}
                        		    		

								
		                        	ordersHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_orders.lookup( ordersHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_orders.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_orders != null && tHash_Lookup_orders.getCount(ordersHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'orders' and it contains more one result from keys :  orders.order_id = '" + ordersHashKey.order_id + "'");
								} // G 071
							

							ordersStruct orders = null;
                    		  	 
							   
                    		  	 
	       		  	    	ordersStruct fromLookup_orders = null;
							orders = ordersDefault;
										 
							
								 
							
							
								if (tHash_Lookup_orders !=null && tHash_Lookup_orders.hasNext()) { // G 099
								
							
								
								fromLookup_orders = tHash_Lookup_orders.next();

							
							
								} // G 099
							
							

							if(fromLookup_orders != null) {
								orders = fromLookup_orders;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

output = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'output'
output_tmp.Customer_ID = routines.system.TypeConvert.Double2Long(orders.customer_id );
output_tmp.Employee_ID = routines.system.TypeConvert.Double2Long(orders.employee_id );
output_tmp.Product_ID = (((order_item.product_id ) == null) ? null : (routines.system.TypeConvert.Double2Long(order_item.product_id )));
output_tmp.Order_Date = orders.order_date ;
output_tmp.Order_ID = routines.system.TypeConvert.Double2Integer(order_item.order_id );
output_tmp.Order_Type = routines.system.TypeConvert.Double2Short(orders.order_type );
output_tmp.Delivery_Date = orders.delivery_date ;
output_tmp.Quantity = (((order_item.quantity ) == null) ? null : (routines.system.TypeConvert.Double2Short(order_item.quantity )));
output_tmp.Total_Retail_Proce = (((order_item.total_retail_price ) == null) ? null : (routines.system.TypeConvert.Double2BigDecimal(order_item.total_retail_price )));
output_tmp.Costprice_Per_Unit = (((order_item.costprice_per_unit ) == null) ? null : (routines.system.TypeConvert.Double2BigDecimal(order_item.costprice_per_unit )));
output_tmp.Discount = (((order_item.discount ) == null) ? null : (routines.system.TypeConvert.Double2BigDecimal(order_item.discount )));
output = output_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "output"
if(output != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"output"
						
						);
					}
					

			


		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "customer" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLoopcustomer = false;
       		  	    	
       		  	    	
 							customerStruct customerObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
	                        		    	Object exprKeyValue_customer__customer_id = routines.system.TypeConvert.Long2Double(output.Customer_ID );
	                        		    	if(exprKeyValue_customer__customer_id == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_2 = true;
	                        		    	} else {
                        		    			customerHashKey.customer_id = (double)(Double) exprKeyValue_customer__customer_id;
                        		    		}
                        		    		

								
		                        	customerHashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_2) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_customer.lookup( customerHashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_2 || !tHash_Lookup_customer.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_customer != null && tHash_Lookup_customer.getCount(customerHashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'customer' and it contains more one result from keys :  customer.customer_id = '" + customerHashKey.customer_id + "'");
								} // G 071
							

							customerStruct customer = null;
                    		  	 
							   
                    		  	 
	       		  	    	customerStruct fromLookup_customer = null;
							customer = customerDefault;
										 
							
								 
							
							
								if (tHash_Lookup_customer !=null && tHash_Lookup_customer.hasNext()) { // G 099
								
							
								
								fromLookup_customer = tHash_Lookup_customer.next();

							
							
								} // G 099
							
							

							if(fromLookup_customer != null) {
								customer = fromLookup_customer;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

sortie = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'sortie'
sortie_tmp.Customer_ID = output.Customer_ID ;
sortie_tmp.Employee_ID = output.Employee_ID ;
sortie_tmp.Street_ID = (((customer.street_id ) == null) ? null : (routines.system.TypeConvert.Double2Long(customer.street_id )));
sortie_tmp.Product_ID = output.Product_ID ;
sortie_tmp.Order_Date = output.Order_Date ;
sortie_tmp.Order_ID = output.Order_ID ;
sortie_tmp.Order_Type = output.Order_Type ;
sortie_tmp.Delivery_Date = output.Delivery_Date ;
sortie_tmp.Quantity = output.Quantity ;
sortie_tmp.Total_Retail_Proce = output.Total_Retail_Proce ;
sortie_tmp.Costprice_Per_Unit = output.Costprice_Per_Unit ;
sortie_tmp.Discount = output.Discount ;
sortie = sortie_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "sortie"
if(sortie != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"sortie"
						
						);
					}
					



            row1 = null;
        whetherReject_tDBOutput_1 = false;
                            pstmt_tDBOutput_1.setLong(1, sortie.Customer_ID);

                            pstmt_tDBOutput_1.setLong(2, sortie.Employee_ID);

                            pstmt_tDBOutput_1.setLong(3, sortie.Street_ID);

                            pstmt_tDBOutput_1.setLong(4, sortie.Product_ID);

                            if(sortie.Order_Date != null) {
date_tDBOutput_1 = sortie.Order_Date.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(5, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(5, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(5, java.sql.Types.DATE);
}

                            pstmt_tDBOutput_1.setInt(6, sortie.Order_ID);

                            if(sortie.Order_Type == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setShort(7, sortie.Order_Type);
}

                            if(sortie.Delivery_Date != null) {
date_tDBOutput_1 = sortie.Delivery_Date.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(8, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(8, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.DATE);
}

                            if(sortie.Quantity == null) {
pstmt_tDBOutput_1.setNull(9, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setShort(9, sortie.Quantity);
}

                            pstmt_tDBOutput_1.setBigDecimal(10, sortie.Total_Retail_Proce);

                            pstmt_tDBOutput_1.setBigDecimal(11, sortie.Costprice_Per_Unit);

                            pstmt_tDBOutput_1.setBigDecimal(12, sortie.Discount);

                    pstmt_tDBOutput_1.addBatch();
                    nb_line_tDBOutput_1++;

						
                      batchSizeCounter_tDBOutput_1++;
            if(!whetherReject_tDBOutput_1) {
                            row1 = new row1Struct();
                                row1.Customer_ID = sortie.Customer_ID;
                                row1.Employee_ID = sortie.Employee_ID;
                                row1.Street_ID = sortie.Street_ID;
                                row1.Product_ID = sortie.Product_ID;
                                row1.Order_Date = sortie.Order_Date;
                                row1.Order_ID = sortie.Order_ID;
                                row1.Order_Type = sortie.Order_Type;
                                row1.Delivery_Date = sortie.Delivery_Date;
                                row1.Quantity = sortie.Quantity;
                                row1.Total_Retail_Proce = sortie.Total_Retail_Proce;
                                row1.Costprice_Per_Unit = sortie.Costprice_Per_Unit;
                                row1.Discount = sortie.Discount;
            }
                if ( batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
                try {
                        int countSum_tDBOutput_1 = 0;
                        for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                            countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                        insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_1 = 0;
                    for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                        countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                    }
                    rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                    System.err.println(e.getMessage());
                }

                batchSizeCounter_tDBOutput_1 = 0;
            }
                commitCounter_tDBOutput_1++;

                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

                try {
                        int countSum_tDBOutput_1 = 0;
                        for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                            countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                        insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_1 = 0;
                    for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                        countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                    }
                    rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                    System.err.println(e.getMessage());

                }
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                        rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;

                }


 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					
///////////////////////		
						



				strBuffer_tLogRow_1 = new StringBuilder();




              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row1.Customer_ID)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row1.Employee_ID)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row1.Street_ID)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row1.Product_ID)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row1.Order_Date != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.format_Date(row1.Order_Date, "dd-MM-yyyy")				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row1.Order_ID)							
				);


							  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row1.Order_Type != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row1.Order_Type)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row1.Delivery_Date != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								FormatterUtils.format_Date(row1.Delivery_Date, "dd-MM-yyyy")				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row1.Quantity != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(row1.Quantity)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row1.Total_Retail_Proce != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								row1.Total_Retail_Proce.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString()				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row1.Costprice_Per_Unit != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								row1.Costprice_Per_Unit.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString()				
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(row1.Discount != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
								row1.Discount.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString()				
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
                    consoleOut_tLogRow_1.flush();
                    nb_line_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "sortie"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "output"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);

 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_orders != null) {
						tHash_Lookup_orders.endGet();
					}
					globalMap.remove( "tHash_Lookup_orders" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"order_item");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_customer != null) {
						tHash_Lookup_customer.endGet();
					}
					globalMap.remove( "tHash_Lookup_customer" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"output");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



                try {
                		if (batchSizeCounter_tDBOutput_1 != 0) {
							int countSum_tDBOutput_1 = 0;
							
							for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
							
	            	    	
	            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	            	    	
            	    	}

                }catch (java.sql.BatchUpdateException e){
                    globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
            	    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	    	    	
                	System.err.println(e.getMessage());
                	
                }
                batchSizeCounter_tDBOutput_1 = 0;
    		
	

        if(pstmt_tDBOutput_1 != null) {
			
				pstmt_tDBOutput_1.close();
				resourceMap.remove("pstmt_tDBOutput_1");
			
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
    	if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
    		
    	}
    	conn_tDBOutput_1.commit();
    	if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
    		
			rowsToCommitCount_tDBOutput_1 = 0;
    	}
		commitCounter_tDBOutput_1 = 0;
    	
		
    	conn_tDBOutput_1 .close();
    	
    	resourceMap.put("finish_tDBOutput_1", true);
    	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"sortie");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBCommit_1Process(globalMap);



/**
 * [tDBOutput_1 end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk5", 0, "ok");
				}
				tJava_2Process(globalMap);



/**
 * [tLogRow_1 end ] stop
 */












				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_customer"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_orders"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}
	

public void tJava_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tJava_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_2", false);
		start_Hash.put("tJava_2", System.currentTimeMillis());
		
	
	currentComponent="tJava_2";

	
		int tos_count_tJava_2 = 0;
		


System.out.println("Nombre total de lignes : " + ((Integer) globalMap.get("tDBOutput_1_NB_LINE")));
System.out.println("L\'execution du job de remplisage de la dimension des faits c'est effectuer avec succée." +"\n Fin du Job");
 



/**
 * [tJava_2 begin ] stop
 */
	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 


	tos_count_tJava_2++;

/**
 * [tJava_2 main ] stop
 */
	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_begin ] stop
 */
	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_end ] stop
 */
	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());




/**
 * [tJava_2 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tJava_2:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tSendMail_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_2 finally ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_2_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tSendMail_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_1", false);
		start_Hash.put("tSendMail_1", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_1";

	
		int tos_count_tSendMail_1 = 0;
		

 



/**
 * [tSendMail_1 begin ] stop
 */
	
	/**
	 * [tSendMail_1 main ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 

	String smtpHost_tSendMail_1 = "smtp.gmail.com";
        String smtpPort_tSendMail_1 = "587";
	String from_tSendMail_1 = ("duplusse.nangmo@facsciences-uy1.cm");
    String to_tSendMail_1 = ("richel.kembou@facsciences-uy1.cm").replace(";",",");
    String cc_tSendMail_1 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_1 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_1 = ("Talend Open Studio notification for DIM GeoGraphy");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_1 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_1 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_1 = new java.util.ArrayList<String>();

	String message_tSendMail_1 = (("eecution du job de remplissage de la dimmension Geographie effectuer avec succes") == null || "".equals("eecution du job de remplissage de la dimmension Geographie effectuer avec succes")) ? "\"\"" : ("eecution du job de remplissage de la dimmension Geographie effectuer avec succes") ;
	java.util.Properties props_tSendMail_1 = System.getProperties();     
	props_tSendMail_1.put("mail.smtp.host", smtpHost_tSendMail_1);
	props_tSendMail_1.put("mail.smtp.port", smtpPort_tSendMail_1);
		props_tSendMail_1.put("mail.mime.encodefilename", "true");
		props_tSendMail_1.put("mail.smtp.starttls.enable","true");     
	try {
		
		
			props_tSendMail_1.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_1 = javax.mail.Session.getInstance(props_tSendMail_1, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:FA4PoVEqU9RTymP6t1OSg2PN7RGjYMXYBT0raMH0vh/1U4hfiBHGASD7IFUqHb4=");
				
				
				return new javax.mail.PasswordAuthentication("duplusse.nangmo@facsciences-uy1.cm", decryptedPassword_tSendMail_1); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_1 = new javax.mail.internet.MimeMessage(session_tSendMail_1);
		msg_tSendMail_1.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_1, "Duplesse Nangmo"));
		msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_1, false));
		if (cc_tSendMail_1 != null) msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_1, false));
		if (bcc_tSendMail_1 != null) msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_1, false));
		msg_tSendMail_1.setSubject(subject_tSendMail_1);

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < headers_tSendMail_1.size(); i_tSendMail_1++) {
			java.util.Map<String, String> header_tSendMail_1 = headers_tSendMail_1.get(i_tSendMail_1);
			msg_tSendMail_1.setHeader(header_tSendMail_1.get("KEY"), header_tSendMail_1.get("VALUE"));    
		}  
		msg_tSendMail_1.setSentDate(new Date());
		msg_tSendMail_1.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_1 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_1.setText(message_tSendMail_1,"ISO-8859-15", "plain");
		mp_tSendMail_1.addBodyPart(mbpText_tSendMail_1);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_1 = null;

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < attachments_tSendMail_1.size(); i_tSendMail_1++){
			String filename_tSendMail_1 = attachments_tSendMail_1.get(i_tSendMail_1);
			javax.activation.FileDataSource fds_tSendMail_1 = null;
			java.io.File file_tSendMail_1 = new java.io.File(filename_tSendMail_1);
			
				if (!file_tSendMail_1.exists()){
					continue;
				}
			
    		if (file_tSendMail_1.isDirectory()){
				java.io.File[] subFiles_tSendMail_1 = file_tSendMail_1.listFiles();
				for(java.io.File subFile_tSendMail_1 : subFiles_tSendMail_1){
					if (subFile_tSendMail_1.isFile()){
						fds_tSendMail_1 = new javax.activation.FileDataSource(subFile_tSendMail_1.getAbsolutePath());
						mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1));
						mbpFile_tSendMail_1.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
						if(contentTransferEncoding_tSendMail_1.get(i_tSendMail_1).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
					}
				}
    		}else{
				mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_1 = new javax.activation.FileDataSource(filename_tSendMail_1);
				mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1)); 
				mbpFile_tSendMail_1.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
				if(contentTransferEncoding_tSendMail_1.get(i_tSendMail_1).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
			}
		}
		// -- set the content --
		msg_tSendMail_1.setContent(mp_tSendMail_1);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_1 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_1.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_1.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_1.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_1.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_1.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_1);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_1 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_1);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_1_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_1.remove("mail.smtp.host");
		props_tSendMail_1.remove("mail.smtp.port");
		
		props_tSendMail_1.remove("mail.mime.encodefilename");
		
			props_tSendMail_1.remove("mail.smtp.starttls.enable");
		
		props_tSendMail_1.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_1++;

/**
 * [tSendMail_1 main ] stop
 */
	
	/**
	 * [tSendMail_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_1 end ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 

ok_Hash.put("tSendMail_1", true);
end_Hash.put("tSendMail_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tJava_1Process(globalMap);



/**
 * [tSendMail_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_1 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";

	
		int tos_count_tJava_1 = 0;
		


System.out.println("mail envoyer a  duplesse");
 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());




/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBCommit_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_1", false);
		start_Hash.put("tDBCommit_1", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_1";

	
		int tos_count_tDBCommit_1 = 0;
		

 



/**
 * [tDBCommit_1 begin ] stop
 */
	
	/**
	 * [tDBCommit_1 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

	java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");

if(conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed()) {
	
			
			conn_tDBCommit_1.commit();
			
	
}

 


	tos_count_tDBCommit_1++;

/**
 * [tDBCommit_1 main ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_1 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 

ok_Hash.put("tDBCommit_1", true);
end_Hash.put("tDBCommit_1", System.currentTimeMillis());




/**
 * [tDBCommit_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBCommit_1 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBRollback_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBRollback_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBRollback_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBRollback_1", false);
		start_Hash.put("tDBRollback_1", System.currentTimeMillis());
		
	
	currentComponent="tDBRollback_1";

	
		int tos_count_tDBRollback_1 = 0;
		

 



/**
 * [tDBRollback_1 begin ] stop
 */
	
	/**
	 * [tDBRollback_1 main ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

	java.sql.Connection conn_tDBRollback_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");

if(conn_tDBRollback_1 != null && !conn_tDBRollback_1.isClosed()) {
	
		try{
			
			conn_tDBRollback_1.rollback();
			
		}finally{
	    	
			conn_tDBRollback_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_1"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    }
	
}

 


	tos_count_tDBRollback_1++;

/**
 * [tDBRollback_1 main ] stop
 */
	
	/**
	 * [tDBRollback_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 



/**
 * [tDBRollback_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBRollback_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 



/**
 * [tDBRollback_1 process_data_end ] stop
 */
	
	/**
	 * [tDBRollback_1 end ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 

ok_Hash.put("tDBRollback_1", true);
end_Hash.put("tDBRollback_1", System.currentTimeMillis());




/**
 * [tDBRollback_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBRollback_1 finally ] start
	 */

	

	
	
	currentComponent="tDBRollback_1";

	

 



/**
 * [tDBRollback_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBRollback_1_SUBPROCESS_STATE", 1);
	}
	


public static class ordersStruct implements routines.system.IPersistableComparableLookupRow<ordersStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double order_id;

				public double getOrder_id () {
					return this.order_id;
				}
				
			    public double order_type;

				public double getOrder_type () {
					return this.order_type;
				}
				
			    public double employee_id;

				public double getEmployee_id () {
					return this.employee_id;
				}
				
			    public double customer_id;

				public double getCustomer_id () {
					return this.customer_id;
				}
				
			    public java.util.Date order_date;

				public java.util.Date getOrder_date () {
					return this.order_date;
				}
				
			    public java.util.Date delivery_date;

				public java.util.Date getDelivery_date () {
					return this.delivery_date;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.order_id;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final ordersStruct other = (ordersStruct) obj;
		
						if (this.order_id != other.order_id)
							return false;
					

		return true;
    }

	public void copyDataTo(ordersStruct other) {

		other.order_id = this.order_id;
	            other.order_type = this.order_type;
	            other.employee_id = this.employee_id;
	            other.customer_id = this.customer_id;
	            other.order_date = this.order_date;
	            other.delivery_date = this.delivery_date;
	            
	}

	public void copyKeysDataTo(ordersStruct other) {

		other.order_id = this.order_id;
	            	
	}




	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.order_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.order_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.order_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.order_type = dis.readDouble();
					
			            this.employee_id = dis.readDouble();
					
			            this.customer_id = dis.readDouble();
					
						this.order_date = readDate(dis,ois);
					
						this.delivery_date = readDate(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.order_type = objectIn.readDouble();
					
			            this.employee_id = objectIn.readDouble();
					
			            this.customer_id = objectIn.readDouble();
					
						this.order_date = readDate(dis,objectIn);
					
						this.delivery_date = readDate(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeDouble(this.order_type);
					
		            	dos.writeDouble(this.employee_id);
					
		            	dos.writeDouble(this.customer_id);
					
						writeDate(this.order_date, dos, oos);
					
						writeDate(this.delivery_date, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeDouble(this.order_type);
					
					objectOut.writeDouble(this.employee_id);
					
					objectOut.writeDouble(this.customer_id);
					
						writeDate(this.order_date, dos, objectOut);
					
						writeDate(this.delivery_date, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("order_id="+String.valueOf(order_id));
		sb.append(",order_type="+String.valueOf(order_type));
		sb.append(",employee_id="+String.valueOf(employee_id));
		sb.append(",customer_id="+String.valueOf(customer_id));
		sb.append(",order_date="+String.valueOf(order_date));
		sb.append(",delivery_date="+String.valueOf(delivery_date));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(ordersStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.order_id, other.order_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		ordersStruct orders = new ordersStruct();




	
	/**
	 * [tAdvancedHash_orders begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_orders", false);
		start_Hash.put("tAdvancedHash_orders", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_orders";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"orders");
					}
				
		int tos_count_tAdvancedHash_orders = 0;
		

			   		// connection name:orders
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_2) outputs:(orders,orders) | target node:tAdvancedHash_orders - inputs:(orders) outputs:()
			   		// linked node: tMap_1 - inputs:(order_item,orders) outputs:(output)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_orders = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<ordersStruct> tHash_Lookup_orders =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<ordersStruct>getLookup(matchingModeEnum_orders);
	   						   
		   	   	   globalMap.put("tHash_Lookup_orders", tHash_Lookup_orders);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_orders begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
			    String driverClass_tDBInput_3 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_3);
				
			String url_tDBInput_3 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3);
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT ORDERS.order_id,\n		ORDERS.order_type,\n		ORDERS.employee_id,\n		ORDERS.customer_id,\n		ORDERS.order_date,\n		ORDERS."
+"delivery_date\nFROM	ORDERS";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								orders.order_id = 0;
							} else {
	                         		
            orders.order_id = rs_tDBInput_3.getDouble(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								orders.order_type = 0;
							} else {
	                         		
            orders.order_type = rs_tDBInput_3.getDouble(2);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								orders.employee_id = 0;
							} else {
	                         		
            orders.employee_id = rs_tDBInput_3.getDouble(3);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								orders.customer_id = 0;
							} else {
	                         		
            orders.customer_id = rs_tDBInput_3.getDouble(4);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								orders.order_date = null;
							} else {
										
			orders.order_date = routines.system.JDBCUtil.getDate(rs_tDBInput_3, 5);
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								orders.delivery_date = null;
							} else {
										
			orders.delivery_date = routines.system.JDBCUtil.getDate(rs_tDBInput_3, 6);
		                    }
					



 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_orders main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_orders";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"orders"
						
						);
					}
					


			   
			   

					ordersStruct orders_HashRow = new ordersStruct();
		   	   	   
				
				orders_HashRow.order_id = orders.order_id;
				
				orders_HashRow.order_type = orders.order_type;
				
				orders_HashRow.employee_id = orders.employee_id;
				
				orders_HashRow.customer_id = orders.customer_id;
				
				orders_HashRow.order_date = orders.order_date;
				
				orders_HashRow.delivery_date = orders.delivery_date;
				
			tHash_Lookup_orders.put(orders_HashRow);
			
            




 


	tos_count_tAdvancedHash_orders++;

/**
 * [tAdvancedHash_orders main ] stop
 */
	
	/**
	 * [tAdvancedHash_orders process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_orders";

	

 



/**
 * [tAdvancedHash_orders process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_orders process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_orders";

	

 



/**
 * [tAdvancedHash_orders process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
		if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
			
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);

 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_orders end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_orders";

	

tHash_Lookup_orders.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"orders");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_orders", true);
end_Hash.put("tAdvancedHash_orders", System.currentTimeMillis());




/**
 * [tAdvancedHash_orders end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_orders finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_orders";

	

 



/**
 * [tAdvancedHash_orders finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class customerStruct implements routines.system.IPersistableComparableLookupRow<customerStruct> {
    final static byte[] commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
    static byte[] commonByteArray_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public double customer_id;

				public double getCustomer_id () {
					return this.customer_id;
				}
				
			    public String country;

				public String getCountry () {
					return this.country;
				}
				
			    public String gender;

				public String getGender () {
					return this.gender;
				}
				
			    public String personal_id;

				public String getPersonal_id () {
					return this.personal_id;
				}
				
			    public String customer_name;

				public String getCustomer_name () {
					return this.customer_name;
				}
				
			    public String customer_firstname;

				public String getCustomer_firstname () {
					return this.customer_firstname;
				}
				
			    public String customer_lastname;

				public String getCustomer_lastname () {
					return this.customer_lastname;
				}
				
			    public java.util.Date birth_date;

				public java.util.Date getBirth_date () {
					return this.birth_date;
				}
				
			    public String customer_address;

				public String getCustomer_address () {
					return this.customer_address;
				}
				
			    public Double street_id;

				public Double getStreet_id () {
					return this.street_id;
				}
				
			    public String street_number;

				public String getStreet_number () {
					return this.street_number;
				}
				
			    public Double customer_type_id;

				public Double getCustomer_type_id () {
					return this.customer_type_id;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.customer_id;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final customerStruct other = (customerStruct) obj;
		
						if (this.customer_id != other.customer_id)
							return false;
					

		return true;
    }

	public void copyDataTo(customerStruct other) {

		other.customer_id = this.customer_id;
	            other.country = this.country;
	            other.gender = this.gender;
	            other.personal_id = this.personal_id;
	            other.customer_name = this.customer_name;
	            other.customer_firstname = this.customer_firstname;
	            other.customer_lastname = this.customer_lastname;
	            other.birth_date = this.birth_date;
	            other.customer_address = this.customer_address;
	            other.street_id = this.street_id;
	            other.street_number = this.street_number;
	            other.customer_type_id = this.customer_type_id;
	            
	}

	public void copyKeysDataTo(customerStruct other) {

		other.customer_id = this.customer_id;
	            	
	}



	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.customer_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_ORION_PROJECT_DUPLESSE_NANGMO_Order_Fact) {

        	try {

        		int length = 0;
		
			        this.customer_id = dis.readDouble();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.customer_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// double
				
		            	dos.writeDouble(this.customer_id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.country = readString(dis,ois);
					
						this.gender = readString(dis,ois);
					
						this.personal_id = readString(dis,ois);
					
						this.customer_name = readString(dis,ois);
					
						this.customer_firstname = readString(dis,ois);
					
						this.customer_lastname = readString(dis,ois);
					
						this.birth_date = readDate(dis,ois);
					
						this.customer_address = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.street_id = null;
           				} else {
           			    	this.street_id = dis.readDouble();
           				}
					
						this.street_number = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.customer_type_id = null;
           				} else {
           			    	this.customer_type_id = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.country = readString(dis,objectIn);
					
						this.gender = readString(dis,objectIn);
					
						this.personal_id = readString(dis,objectIn);
					
						this.customer_name = readString(dis,objectIn);
					
						this.customer_firstname = readString(dis,objectIn);
					
						this.customer_lastname = readString(dis,objectIn);
					
						this.birth_date = readDate(dis,objectIn);
					
						this.customer_address = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.street_id = null;
           				} else {
           			    	this.street_id = objectIn.readDouble();
           				}
					
						this.street_number = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.customer_type_id = null;
           				} else {
           			    	this.customer_type_id = objectIn.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.country, dos, oos);
					
						writeString(this.gender, dos, oos);
					
						writeString(this.personal_id, dos, oos);
					
						writeString(this.customer_name, dos, oos);
					
						writeString(this.customer_firstname, dos, oos);
					
						writeString(this.customer_lastname, dos, oos);
					
						writeDate(this.birth_date, dos, oos);
					
						writeString(this.customer_address, dos, oos);
					
						if(this.street_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.street_id);
		            	}
					
						writeString(this.street_number, dos, oos);
					
						if(this.customer_type_id == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.customer_type_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.country, dos, objectOut);
					
						writeString(this.gender, dos, objectOut);
					
						writeString(this.personal_id, dos, objectOut);
					
						writeString(this.customer_name, dos, objectOut);
					
						writeString(this.customer_firstname, dos, objectOut);
					
						writeString(this.customer_lastname, dos, objectOut);
					
						writeDate(this.birth_date, dos, objectOut);
					
						writeString(this.customer_address, dos, objectOut);
					
						if(this.street_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.street_id);
		            	}
					
						writeString(this.street_number, dos, objectOut);
					
						if(this.customer_type_id == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.customer_type_id);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("customer_id="+String.valueOf(customer_id));
		sb.append(",country="+country);
		sb.append(",gender="+gender);
		sb.append(",personal_id="+personal_id);
		sb.append(",customer_name="+customer_name);
		sb.append(",customer_firstname="+customer_firstname);
		sb.append(",customer_lastname="+customer_lastname);
		sb.append(",birth_date="+String.valueOf(birth_date));
		sb.append(",customer_address="+customer_address);
		sb.append(",street_id="+String.valueOf(street_id));
		sb.append(",street_number="+street_number);
		sb.append(",customer_type_id="+String.valueOf(customer_type_id));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(customerStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.customer_id, other.customer_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		customerStruct customer = new customerStruct();




	
	/**
	 * [tAdvancedHash_customer begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_customer", false);
		start_Hash.put("tAdvancedHash_customer", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_customer";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"customer");
					}
				
		int tos_count_tAdvancedHash_customer = 0;
		

			   		// connection name:customer
			   		// source node:tDBInput_1 - inputs:(after_tDBInput_2) outputs:(customer,customer) | target node:tAdvancedHash_customer - inputs:(customer) outputs:()
			   		// linked node: tMap_2 - inputs:(output,customer) outputs:(sortie)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_customer = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<customerStruct> tHash_Lookup_customer =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<customerStruct>getLookup(matchingModeEnum_customer);
	   						   
		   	   	   globalMap.put("tHash_Lookup_customer", tHash_Lookup_customer);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_customer begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
			    String driverClass_tDBInput_1 = "org.sqlite.JDBC";
			    java.lang.Class.forName(driverClass_tDBInput_1);
				
			String url_tDBInput_1 = "jdbc:sqlite:" + "/" + "/home/duplesse/Musique/TP_BI/BDOrion.sqlite";
			
		        conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1);
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT CUSTOMER.customer_id,\n		CUSTOMER.country,\n		CUSTOMER.gender,\n		CUSTOMER.personal_id,\n		CUSTOMER.customer_name,\n	"
+"	CUSTOMER.customer_firstname,\n		CUSTOMER.customer_lastname,\n		CUSTOMER.birth_date,\n		CUSTOMER.customer_address,\n		CUSTOM"
+"ER.street_id,\n		CUSTOMER.street_number,\n		CUSTOMER.customer_type_id\nFROM	CUSTOMER";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								customer.customer_id = 0;
							} else {
	                         		
            customer.customer_id = rs_tDBInput_1.getDouble(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								customer.country = null;
							} else {
	                         		
        	customer.country = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								customer.gender = null;
							} else {
	                         		
        	customer.gender = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								customer.personal_id = null;
							} else {
	                         		
        	customer.personal_id = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								customer.customer_name = null;
							} else {
	                         		
        	customer.customer_name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								customer.customer_firstname = null;
							} else {
	                         		
        	customer.customer_firstname = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								customer.customer_lastname = null;
							} else {
	                         		
        	customer.customer_lastname = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								customer.birth_date = null;
							} else {
										
			customer.birth_date = routines.system.JDBCUtil.getDate(rs_tDBInput_1, 8);
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								customer.customer_address = null;
							} else {
	                         		
        	customer.customer_address = routines.system.JDBCUtil.getString(rs_tDBInput_1, 9, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								customer.street_id = null;
							} else {
	                         		
            customer.street_id = rs_tDBInput_1.getDouble(10);
            if(rs_tDBInput_1.wasNull()){
                    customer.street_id = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								customer.street_number = null;
							} else {
	                         		
        	customer.street_number = routines.system.JDBCUtil.getString(rs_tDBInput_1, 11, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								customer.customer_type_id = null;
							} else {
	                         		
            customer.customer_type_id = rs_tDBInput_1.getDouble(12);
            if(rs_tDBInput_1.wasNull()){
                    customer.customer_type_id = null;
            }
		                    }
					



 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_customer main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_customer";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"customer"
						
						);
					}
					


			   
			   

					customerStruct customer_HashRow = new customerStruct();
		   	   	   
				
				customer_HashRow.customer_id = customer.customer_id;
				
				customer_HashRow.country = customer.country;
				
				customer_HashRow.gender = customer.gender;
				
				customer_HashRow.personal_id = customer.personal_id;
				
				customer_HashRow.customer_name = customer.customer_name;
				
				customer_HashRow.customer_firstname = customer.customer_firstname;
				
				customer_HashRow.customer_lastname = customer.customer_lastname;
				
				customer_HashRow.birth_date = customer.birth_date;
				
				customer_HashRow.customer_address = customer.customer_address;
				
				customer_HashRow.street_id = customer.street_id;
				
				customer_HashRow.street_number = customer.street_number;
				
				customer_HashRow.customer_type_id = customer.customer_type_id;
				
			tHash_Lookup_customer.put(customer_HashRow);
			
            




 


	tos_count_tAdvancedHash_customer++;

/**
 * [tAdvancedHash_customer main ] stop
 */
	
	/**
	 * [tAdvancedHash_customer process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_customer";

	

 



/**
 * [tAdvancedHash_customer process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_customer process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_customer";

	

 



/**
 * [tAdvancedHash_customer process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);

 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tAdvancedHash_customer end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_customer";

	

tHash_Lookup_customer.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"customer");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_customer", true);
end_Hash.put("tAdvancedHash_customer", System.currentTimeMillis());




/**
 * [tAdvancedHash_customer end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_customer finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_customer";

	

 



/**
 * [tAdvancedHash_customer finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	

public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";

	
		int tos_count_tPrejob_1 = 0;
		

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";

	
		int tos_count_tDBConnection_1 = 0;
		
	

	
        String properties_tDBConnection_1 = "serverTimezone=UTC";
        if (properties_tDBConnection_1 == null || properties_tDBConnection_1.trim().length() == 0) {
            properties_tDBConnection_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBConnection_1.contains("rewriteBatchedStatements=")) {
                properties_tDBConnection_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBConnection_1.contains("allowLoadLocalInfile=")) {
                properties_tDBConnection_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBConnection_1 = "jdbc:mariadb://" + "127.0.0.1" + ":" + "3306" + "/" + "db_entrepot" + "?" + properties_tDBConnection_1;
	String dbUser_tDBConnection_1 = "orion_DW_user";
	
	
		 
	final String decryptedPassword_tDBConnection_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:QiEdQatVHRuXNJVnqQub4IEnYAQ8vCBiq3DeIhcONWbiDshoerk/ND0=");
		String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;
	
	
	java.sql.Connection conn_tDBConnection_1 = null;
	
		
			String driverClass_tDBConnection_1 = "org.mariadb.jdbc.Driver";
			java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
			globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);
		
			conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1,dbUser_tDBConnection_1,dbPwd_tDBConnection_1);

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			conn_tDBConnection_1.setAutoCommit(false);
	}

	globalMap.put("db_tDBConnection_1","db_entrepot");
 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());




/**
 * [tDBConnection_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";

	
		int tos_count_tPostjob_1 = 0;
		

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tDBClose_1Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBClose_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBClose_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDBClose_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBClose_1", false);
		start_Hash.put("tDBClose_1", System.currentTimeMillis());
		
	
	currentComponent="tDBClose_1";

	
		int tos_count_tDBClose_1 = 0;
		

 



/**
 * [tDBClose_1 begin ] stop
 */
	
	/**
	 * [tDBClose_1 main ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

	java.sql.Connection conn_tDBClose_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");

	if(conn_tDBClose_1 != null && !conn_tDBClose_1.isClosed())
	{
		
			conn_tDBClose_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_1"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	}

 


	tos_count_tDBClose_1++;

/**
 * [tDBClose_1 main ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBClose_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 process_data_end ] stop
 */
	
	/**
	 * [tDBClose_1 end ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 

ok_Hash.put("tDBClose_1", true);
end_Hash.put("tDBClose_1", System.currentTimeMillis());




/**
 * [tDBClose_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBClose_1 finally ] start
	 */

	

	
	
	currentComponent="tDBClose_1";

	

 



/**
 * [tDBClose_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBClose_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };

    private SyncInt runningThreadCount =new SyncInt();

    private class SyncInt
    {
        private int count = 0;
        public synchronized void add(int i)
        {
            count +=i;
        }

        public synchronized int getCount()
        {
            return count;
        }
    }

    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final Order_Fact Order_FactClass = new Order_Fact();

        int exitCode = Order_FactClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Order_Fact.class.getClassLoader().getResourceAsStream("orion_project_duplesse_nangmo/order_fact_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Order_Fact.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}




this.globalResumeTicket = false;//to run others jobs
final Thread launchingThread = Thread.currentThread();
        runningThreadCount.add(1);
        new Thread(){
            public void run() {
                java.util.Map threadRunResultMap = new java.util.HashMap();
                threadRunResultMap.put("errorCode", null);
                threadRunResultMap.put("status", "");
                threadLocal.set(threadRunResultMap);

                try {
((java.util.Map) threadLocal.get()).put("errorCode", null);tDBInput_2Process(globalMap);
if ( !"failure".equals(((java.util.Map)threadLocal.get()).get("status")) ) {
((java.util.Map) threadLocal.get()).put("status", "end");
}
}catch (TalendException e_tDBInput_2) {
globalMap.put("tDBInput_2_SUBPROCESS_STATE", -1);

e_tDBInput_2.printStackTrace();

}catch (java.lang.Error e_tDBInput_2) {
globalMap.put("tDBInput_2_SUBPROCESS_STATE", -1);
((java.util.Map) threadLocal.get()).put("status", "failure");throw e_tDBInput_2;

}
                finally {
                    Integer localErrorCode = (Integer)(((java.util.Map)threadLocal.get()).get("errorCode"));
                    String localStatus = (String)(((java.util.Map)threadLocal.get()).get("status"));
                    if (localErrorCode != null) {
                        if (errorCode == null || localErrorCode.compareTo(errorCode) > 0) {
                           errorCode = localErrorCode;
                        }
                    }
                    if (!status.equals("failure")){
                        status = localStatus;
                    }

                    if ("true".equals(((java.util.Map) threadLocal.get()).get("JobInterrupted"))) {
                        launchingThread.interrupt();
                    }

                    runningThreadCount.add(-1);
                }
            }
        }.start();

    boolean interrupted = false;
    while (runningThreadCount.getCount() > 0) {
        try {
            Thread.sleep(10);
        } catch (java.lang.InterruptedException e) {
            interrupted = true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    if (interrupted) {
        Thread.currentThread().interrupt();
    }



this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Order_Fact");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;

        Integer localErrorCode = (Integer)(((java.util.Map)threadLocal.get()).get("errorCode"));
        String localStatus = (String)(((java.util.Map)threadLocal.get()).get("status"));
        if (localErrorCode != null) {
            if (errorCode == null || localErrorCode.compareTo(errorCode) > 0) {
                   errorCode = localErrorCode;
            }
        }
        if (localStatus != null && !status.equals("failure")){
            status = localStatus;
        }

    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     209416 characters generated by Talend Open Studio for Data Integration 
 *     on the 13 février 2025 à 06:01:10 WAT
 ************************************************************************************************/