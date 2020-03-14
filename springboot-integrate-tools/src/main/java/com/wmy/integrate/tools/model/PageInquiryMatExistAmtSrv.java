 package com.boco.scms.connector.osberp.business.pms.pageinquirymatexistamtsrv;




/**
 * @ClassName:PageInquiryMatExistAmtSrv
 * ==============================================================================
 * @Description: PMS集中化-查询SCM库存现有量信息路由服务
 * 服务标识：
 * 服务名称：PageInquiryMatExistAmtSrv
 * ==============================================================================
 * @CreateInfo:
 * @Author: Administrator
 * @CreateDate: 2020-03-11T17:13:37.364
 * @Version: V1.0
 *
 */
public class PageInquiryMatExistAmtSrv {

	/**
	 * 库存组织编码
	*/
	 private String  INVENTORY_ORG_CODE;
	/**
	 * 库存组织名称
	*/
	 private String  INVENTORY_ORG_NAME;
	/**
	 * 子库存
	*/
	 private String  SUBINVENTORY;
	/**
	 * OU组织ID
	*/
	 private Long  ORG_ID;
	/**
	 * OU组织名称
	*/
	 private String  ORG_NAME;
	/**
	 * 货位名称
	*/
	 private String  LOCATION_NAME;
	/**
	 * 投资主体
	*/
	 private String  INVEST_SUBJECT;
	/**
	 * 项目编码
	*/
	 private String  PROJECT_CODE;
	/**
	 * 项目名称
	*/
	 private String  PROJECT_NAME;
	/**
	 * 物料编码
	*/
	 private String  MATERIAL_CODE;
	/**
	 * 物料名称
	*/
	 private String  MATERIAL_NAME;
	/**
	 * 计量单位
	*/
	 private String  UNIT;
	/**
	 * 现有量
	*/
	 private Double  EXIST_AMOUNT;
	/**
	 * 可用量
	*/
	 private Double  AVAILABLE_AMOUNT;
	/**
	 * 批次号
	*/
	 private String  BATCH_NUM;
	/**
	 * 入库时间
	*/
	 private Date  INBOUND_TIME;
	/**
	 * 查询结果扩展
	*/
	 private String  OUTPUT_EXT;

	public String getINVENTORY_ORG_CODE(){
	    return INVENTORY_ORG_CODE;
	}

	public void setINVENTORY_ORG_CODE(String INVENTORY_ORG_CODE){
	    this.INVENTORY_ORG_CODE = INVENTORY_ORG_CODE;
	}

	public String getINVENTORY_ORG_NAME(){
	    return INVENTORY_ORG_NAME;
	}

	public void setINVENTORY_ORG_NAME(String INVENTORY_ORG_NAME){
	    this.INVENTORY_ORG_NAME = INVENTORY_ORG_NAME;
	}

	public String getSUBINVENTORY(){
	    return SUBINVENTORY;
	}

	public void setSUBINVENTORY(String SUBINVENTORY){
	    this.SUBINVENTORY = SUBINVENTORY;
	}

	public Long getORG_ID(){
	    return ORG_ID;
	}

	public void setORG_ID(Long ORG_ID){
	    this.ORG_ID = ORG_ID;
	}

	public String getORG_NAME(){
	    return ORG_NAME;
	}

	public void setORG_NAME(String ORG_NAME){
	    this.ORG_NAME = ORG_NAME;
	}

	public String getLOCATION_NAME(){
	    return LOCATION_NAME;
	}

	public void setLOCATION_NAME(String LOCATION_NAME){
	    this.LOCATION_NAME = LOCATION_NAME;
	}

	public String getINVEST_SUBJECT(){
	    return INVEST_SUBJECT;
	}

	public void setINVEST_SUBJECT(String INVEST_SUBJECT){
	    this.INVEST_SUBJECT = INVEST_SUBJECT;
	}

	public String getPROJECT_CODE(){
	    return PROJECT_CODE;
	}

	public void setPROJECT_CODE(String PROJECT_CODE){
	    this.PROJECT_CODE = PROJECT_CODE;
	}

	public String getPROJECT_NAME(){
	    return PROJECT_NAME;
	}

	public void setPROJECT_NAME(String PROJECT_NAME){
	    this.PROJECT_NAME = PROJECT_NAME;
	}

	public String getMATERIAL_CODE(){
	    return MATERIAL_CODE;
	}

	public void setMATERIAL_CODE(String MATERIAL_CODE){
	    this.MATERIAL_CODE = MATERIAL_CODE;
	}

	public String getMATERIAL_NAME(){
	    return MATERIAL_NAME;
	}

	public void setMATERIAL_NAME(String MATERIAL_NAME){
	    this.MATERIAL_NAME = MATERIAL_NAME;
	}

	public String getUNIT(){
	    return UNIT;
	}

	public void setUNIT(String UNIT){
	    this.UNIT = UNIT;
	}

	public Double getEXIST_AMOUNT(){
	    return EXIST_AMOUNT;
	}

	public void setEXIST_AMOUNT(Double EXIST_AMOUNT){
	    this.EXIST_AMOUNT = EXIST_AMOUNT;
	}

	public Double getAVAILABLE_AMOUNT(){
	    return AVAILABLE_AMOUNT;
	}

	public void setAVAILABLE_AMOUNT(Double AVAILABLE_AMOUNT){
	    this.AVAILABLE_AMOUNT = AVAILABLE_AMOUNT;
	}

	public String getBATCH_NUM(){
	    return BATCH_NUM;
	}

	public void setBATCH_NUM(String BATCH_NUM){
	    this.BATCH_NUM = BATCH_NUM;
	}

	public Date getINBOUND_TIME(){
	    return INBOUND_TIME;
	}

	public void setINBOUND_TIME(Date INBOUND_TIME){
	    this.INBOUND_TIME = INBOUND_TIME;
	}

	public String getOUTPUT_EXT(){
	    return OUTPUT_EXT;
	}

	public void setOUTPUT_EXT(String OUTPUT_EXT){
	    this.OUTPUT_EXT = OUTPUT_EXT;
	}

}
