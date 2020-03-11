 package com.boco.scms.connector.osberp.model.pms.pmsrequdraftinfo;




/**
 * @ClassName:PmsRequDraftInfo
 * ==============================================================================
 * @Description: PMS集中化-导入工程费用PMS订单草稿信息基本信息
 * 服务标识：
 * 服务名称：PmsRequDraftInfo
 * ==============================================================================
 * @CreateInfo:
 * @Author: Administrator
 * @CreateDate: 2020-03-11T17:13:37.383
 * @Version: V1.0
 *
 * @hibernate.class table = "PMS_I_REQU_DRAFT_INFO" dynamic-update = "false"
 *                  dynamic-insert = "false" 
 *
 */
public class PmsRequDraftInfo extends ErpDomainObject {

	/**
	 * 记录唯一关键字
	*/
	 private String  PRI_KEY;
	/**
	 * 省公司代码
	*/
	 private String  PROVINCE_CODE;
	/**
	 * PMS订单头ID
	*/
	 private Long  REQU_HEAD_ID;
	/**
	 * OU组织ID
	*/
	 private Long  OU_ID;
	/**
	 * OU组织名称
	*/
	 private String  OU_NAME;
	/**
	 * 编制单位
	*/
	 private String  CREATE_COMPANY;
	/**
	 * PMS订单编码
	*/
	 private String  REQU_CODE;
	/**
	 * PMS订单主题
	*/
	 private String  REQU_DESC;
	/**
	 * 项目编码
	*/
	 private String  PROJECT_CODE;
	/**
	 * 项目名称
	*/
	 private String  PROJECT_NAME;
	/**
	 * 项目投资主体
	*/
	 private String  INVESTMENT_SUBJECT;
	/**
	 * 供应商编码
	*/
	 private String  VENDOR_CODE;
	/**
	 * 供应商名称
	*/
	 private String  VENDOR_NAME;
	/**
	 * 不含税订单总金额
	*/
	 private Double  EXCLUDING_TAX_AMOUNT;
	/**
	 * 含税订单总金额
	*/
	 private Double  TAX_INCLUDED_AMOUNT;
	/**
	 * 合同编码
	*/
	 private String  CONTRACT_CODE;
	/**
	 * 合同名称
	*/
	 private String  CONTRACT_NAME;
	/**
	 * 投资主体
	*/
	 private String  CONTRACT_SUBJECT;
	/**
	 * 费用类型
	*/
	 private String  COST_TYPE;
	/**
	 * 要求到货日期
	*/
	 private Date  REQUEST_ARRIVAL_DATE;
	/**
	 * 是否预订单
	*/
	 private Long  IS_ADV_ORDER;
	/**
	 * 采购员编号
	*/
	 private String  AGENT_NUM;
	/**
	 * 采购员姓名
	*/
	 private String  AGENT_NAME;
	/**
	 * 紧急程度
	*/
	 private String  EMERGENCY_LEVEL;
	/**
	 * 备注
	*/
	 private String  REMARKS;
	/**
	 * 创建者用户ID
	*/
	 private Long  CREATED_BY;
	/**
	 * 创建者用户名
	*/
	 private String  CREATED_NAME;
	/**
	 * 创建时间
	*/
	 private Date  CREATION_DATE;
	/**
	 * PMS订单草稿行
	*/
	 private List REQU_LINE;
	/**
	 * 输入扩展
	*/
	 private String  INPUT_EXT;

	/**
	 * @hibernate.property column = "PRI_KEY"
	 * @return
	 */
	public String getPRI_KEY(){
	    return PRI_KEY;
	}

	public void setPRI_KEY(String PRI_KEY){
	    this.PRI_KEY = PRI_KEY;
	}

	/**
	 * @hibernate.property column = "PROVINCE_CODE"
	 * @return
	 */
	public String getPROVINCE_CODE(){
	    return PROVINCE_CODE;
	}

	public void setPROVINCE_CODE(String PROVINCE_CODE){
	    this.PROVINCE_CODE = PROVINCE_CODE;
	}

	/**
	 * @hibernate.property column = "REQU_HEAD_ID"
	 * @return
	 */
	public Long getREQU_HEAD_ID(){
	    return REQU_HEAD_ID;
	}

	public void setREQU_HEAD_ID(Long REQU_HEAD_ID){
	    this.REQU_HEAD_ID = REQU_HEAD_ID;
	}

	/**
	 * @hibernate.property column = "OU_ID"
	 * @return
	 */
	public Long getOU_ID(){
	    return OU_ID;
	}

	public void setOU_ID(Long OU_ID){
	    this.OU_ID = OU_ID;
	}

	/**
	 * @hibernate.property column = "OU_NAME"
	 * @return
	 */
	public String getOU_NAME(){
	    return OU_NAME;
	}

	public void setOU_NAME(String OU_NAME){
	    this.OU_NAME = OU_NAME;
	}

	/**
	 * @hibernate.property column = "CREATE_COMPANY"
	 * @return
	 */
	public String getCREATE_COMPANY(){
	    return CREATE_COMPANY;
	}

	public void setCREATE_COMPANY(String CREATE_COMPANY){
	    this.CREATE_COMPANY = CREATE_COMPANY;
	}

	/**
	 * @hibernate.property column = "REQU_CODE"
	 * @return
	 */
	public String getREQU_CODE(){
	    return REQU_CODE;
	}

	public void setREQU_CODE(String REQU_CODE){
	    this.REQU_CODE = REQU_CODE;
	}

	/**
	 * @hibernate.property column = "REQU_DESC"
	 * @return
	 */
	public String getREQU_DESC(){
	    return REQU_DESC;
	}

	public void setREQU_DESC(String REQU_DESC){
	    this.REQU_DESC = REQU_DESC;
	}

	/**
	 * @hibernate.property column = "PROJECT_CODE"
	 * @return
	 */
	public String getPROJECT_CODE(){
	    return PROJECT_CODE;
	}

	public void setPROJECT_CODE(String PROJECT_CODE){
	    this.PROJECT_CODE = PROJECT_CODE;
	}

	/**
	 * @hibernate.property column = "PROJECT_NAME"
	 * @return
	 */
	public String getPROJECT_NAME(){
	    return PROJECT_NAME;
	}

	public void setPROJECT_NAME(String PROJECT_NAME){
	    this.PROJECT_NAME = PROJECT_NAME;
	}

	/**
	 * @hibernate.property column = "INVESTMENT_SUBJECT"
	 * @return
	 */
	public String getINVESTMENT_SUBJECT(){
	    return INVESTMENT_SUBJECT;
	}

	public void setINVESTMENT_SUBJECT(String INVESTMENT_SUBJECT){
	    this.INVESTMENT_SUBJECT = INVESTMENT_SUBJECT;
	}

	/**
	 * @hibernate.property column = "VENDOR_CODE"
	 * @return
	 */
	public String getVENDOR_CODE(){
	    return VENDOR_CODE;
	}

	public void setVENDOR_CODE(String VENDOR_CODE){
	    this.VENDOR_CODE = VENDOR_CODE;
	}

	/**
	 * @hibernate.property column = "VENDOR_NAME"
	 * @return
	 */
	public String getVENDOR_NAME(){
	    return VENDOR_NAME;
	}

	public void setVENDOR_NAME(String VENDOR_NAME){
	    this.VENDOR_NAME = VENDOR_NAME;
	}

	/**
	 * @hibernate.property column = "EXCLUDING_TAX_AMOUNT"
	 * @return
	 */
	public Double getEXCLUDING_TAX_AMOUNT(){
	    return EXCLUDING_TAX_AMOUNT;
	}

	public void setEXCLUDING_TAX_AMOUNT(Double EXCLUDING_TAX_AMOUNT){
	    this.EXCLUDING_TAX_AMOUNT = EXCLUDING_TAX_AMOUNT;
	}

	/**
	 * @hibernate.property column = "TAX_INCLUDED_AMOUNT"
	 * @return
	 */
	public Double getTAX_INCLUDED_AMOUNT(){
	    return TAX_INCLUDED_AMOUNT;
	}

	public void setTAX_INCLUDED_AMOUNT(Double TAX_INCLUDED_AMOUNT){
	    this.TAX_INCLUDED_AMOUNT = TAX_INCLUDED_AMOUNT;
	}

	/**
	 * @hibernate.property column = "CONTRACT_CODE"
	 * @return
	 */
	public String getCONTRACT_CODE(){
	    return CONTRACT_CODE;
	}

	public void setCONTRACT_CODE(String CONTRACT_CODE){
	    this.CONTRACT_CODE = CONTRACT_CODE;
	}

	/**
	 * @hibernate.property column = "CONTRACT_NAME"
	 * @return
	 */
	public String getCONTRACT_NAME(){
	    return CONTRACT_NAME;
	}

	public void setCONTRACT_NAME(String CONTRACT_NAME){
	    this.CONTRACT_NAME = CONTRACT_NAME;
	}

	/**
	 * @hibernate.property column = "CONTRACT_SUBJECT"
	 * @return
	 */
	public String getCONTRACT_SUBJECT(){
	    return CONTRACT_SUBJECT;
	}

	public void setCONTRACT_SUBJECT(String CONTRACT_SUBJECT){
	    this.CONTRACT_SUBJECT = CONTRACT_SUBJECT;
	}

	/**
	 * @hibernate.property column = "COST_TYPE"
	 * @return
	 */
	public String getCOST_TYPE(){
	    return COST_TYPE;
	}

	public void setCOST_TYPE(String COST_TYPE){
	    this.COST_TYPE = COST_TYPE;
	}

	/**
	 * @hibernate.property column = "REQUEST_ARRIVAL_DATE"
	 * @return
	 */
	public Date getREQUEST_ARRIVAL_DATE(){
	    return REQUEST_ARRIVAL_DATE;
	}

	public void setREQUEST_ARRIVAL_DATE(Date REQUEST_ARRIVAL_DATE){
	    this.REQUEST_ARRIVAL_DATE = REQUEST_ARRIVAL_DATE;
	}

	/**
	 * @hibernate.property column = "IS_ADV_ORDER"
	 * @return
	 */
	public Long getIS_ADV_ORDER(){
	    return IS_ADV_ORDER;
	}

	public void setIS_ADV_ORDER(Long IS_ADV_ORDER){
	    this.IS_ADV_ORDER = IS_ADV_ORDER;
	}

	/**
	 * @hibernate.property column = "AGENT_NUM"
	 * @return
	 */
	public String getAGENT_NUM(){
	    return AGENT_NUM;
	}

	public void setAGENT_NUM(String AGENT_NUM){
	    this.AGENT_NUM = AGENT_NUM;
	}

	/**
	 * @hibernate.property column = "AGENT_NAME"
	 * @return
	 */
	public String getAGENT_NAME(){
	    return AGENT_NAME;
	}

	public void setAGENT_NAME(String AGENT_NAME){
	    this.AGENT_NAME = AGENT_NAME;
	}

	/**
	 * @hibernate.property column = "EMERGENCY_LEVEL"
	 * @return
	 */
	public String getEMERGENCY_LEVEL(){
	    return EMERGENCY_LEVEL;
	}

	public void setEMERGENCY_LEVEL(String EMERGENCY_LEVEL){
	    this.EMERGENCY_LEVEL = EMERGENCY_LEVEL;
	}

	/**
	 * @hibernate.property column = "REMARKS"
	 * @return
	 */
	public String getREMARKS(){
	    return REMARKS;
	}

	public void setREMARKS(String REMARKS){
	    this.REMARKS = REMARKS;
	}

	/**
	 * @hibernate.property column = "CREATED_BY"
	 * @return
	 */
	public Long getCREATED_BY(){
	    return CREATED_BY;
	}

	public void setCREATED_BY(Long CREATED_BY){
	    this.CREATED_BY = CREATED_BY;
	}

	/**
	 * @hibernate.property column = "CREATED_NAME"
	 * @return
	 */
	public String getCREATED_NAME(){
	    return CREATED_NAME;
	}

	public void setCREATED_NAME(String CREATED_NAME){
	    this.CREATED_NAME = CREATED_NAME;
	}

	/**
	 * @hibernate.property column = "CREATION_DATE"
	 * @return
	 */
	public Date getCREATION_DATE(){
	    return CREATION_DATE;
	}

	public void setCREATION_DATE(Date CREATION_DATE){
	    this.CREATION_DATE = CREATION_DATE;
	}

	public List  getREQU_LINE(){
	    return REQU_LINE;
	}

	public void setREQU_LINE(List  REQU_LINE){
	    this.REQU_LINE = REQU_LINE;
	}

	/**
	 * @hibernate.property column = "INPUT_EXT"
	 * @return
	 */
	public String getINPUT_EXT(){
	    return INPUT_EXT;
	}

	public void setINPUT_EXT(String INPUT_EXT){
	    this.INPUT_EXT = INPUT_EXT;
	}

}
