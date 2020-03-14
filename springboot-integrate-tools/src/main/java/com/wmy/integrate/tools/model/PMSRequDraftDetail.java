 package com.boco.scms.connector.osberp.model.pms.pmsrequdraftdetail;




/**
 * @ClassName:PMSRequDraftDetail
 * ==============================================================================
 * @Description: PMS集中化-导入工程费用PMS订单草稿信息明细
 * 服务标识：
 * 服务名称：PMSRequDraftDetail
 * ==============================================================================
 * @CreateInfo:
 * @Author: Administrator
 * @CreateDate: 2020-03-11T17:13:37.406
 * @Version: V1.0
 *
 * @hibernate.class table = "PMS_I_REQU_DRAFT_DETAIL" dynamic-update = "false"
 *                  dynamic-insert = "false" 
 *
 */
public class PMSRequDraftDetail extends ErpDomainObject {

	/**
	 * PMS订单草稿行ID
	*/
	 private Long  REQU_LINE_ID;
	/**
	 * 费用所属阶段
	*/
	 private String  COST_STAGE;
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
	 * 请购数量
	*/
	 private Double  QUANTITY;
	/**
	 * 单价（元）
	*/
	 private Double  UNIT_PRICE;
	/**
	 * 税码
	*/
	 private String  TAX_CODE;
	/**
	 * 税率
	*/
	 private Double  TAX;
	/**
	 * 不含税金额合计（元）
	*/
	 private Double  EXCLUDING_TAX_TOTAL;
	/**
	 * 含税金额合计（元）
	*/
	 private Double  TAX_INCLUDED_TOTAL;
	/**
	 * 地市/省公司部门编码
	*/
	 private String  CITY_CODE;
	/**
	 * 地市/省公司部门名称
	*/
	 private String  CITY;
	/**
	 * 任务编码
	*/
	 private String  TASK_CODE;
	/**
	 * 任务名称
	*/
	 private String  TASK_NAME;
	/**
	 * 专业名称
	*/
	 private String  DOMAIN_NAME;
	/**
	 * 专业编码
	*/
	 private String  DOMAIN_CODE;
	/**
	 * 费用任务编码
	*/
	 private String  COST_TASK_CODE;
	/**
	 * 费用任务名称
	*/
	 private String  COST_TASK_NAME;
	/**
	 * 支出类型
	*/
	 private String  EXPENDITURE_TYPE;
	/**
	 * 支出组织ID
	*/
	 private Long  EXPENDITURE_ORG_ID;
	/**
	 * 支出组织名称
	*/
	 private String  EXPENDITURE_ORG_NAME;
	/**
	 * 支出日期
	*/
	 private Date  EXPENDITURE_DATE;
	/**
	 * 输入扩展
	*/
	 private String  INPUT_EXT;

	/**
	 * @hibernate.property column = "REQU_LINE_ID"
	 * @return
	 */
	public Long getREQU_LINE_ID(){
	    return REQU_LINE_ID;
	}

	public void setREQU_LINE_ID(Long REQU_LINE_ID){
	    this.REQU_LINE_ID = REQU_LINE_ID;
	}

	/**
	 * @hibernate.property column = "COST_STAGE"
	 * @return
	 */
	public String getCOST_STAGE(){
	    return COST_STAGE;
	}

	public void setCOST_STAGE(String COST_STAGE){
	    this.COST_STAGE = COST_STAGE;
	}

	/**
	 * @hibernate.property column = "MATERIAL_CODE"
	 * @return
	 */
	public String getMATERIAL_CODE(){
	    return MATERIAL_CODE;
	}

	public void setMATERIAL_CODE(String MATERIAL_CODE){
	    this.MATERIAL_CODE = MATERIAL_CODE;
	}

	/**
	 * @hibernate.property column = "MATERIAL_NAME"
	 * @return
	 */
	public String getMATERIAL_NAME(){
	    return MATERIAL_NAME;
	}

	public void setMATERIAL_NAME(String MATERIAL_NAME){
	    this.MATERIAL_NAME = MATERIAL_NAME;
	}

	/**
	 * @hibernate.property column = "UNIT"
	 * @return
	 */
	public String getUNIT(){
	    return UNIT;
	}

	public void setUNIT(String UNIT){
	    this.UNIT = UNIT;
	}

	/**
	 * @hibernate.property column = "QUANTITY"
	 * @return
	 */
	public Double getQUANTITY(){
	    return QUANTITY;
	}

	public void setQUANTITY(Double QUANTITY){
	    this.QUANTITY = QUANTITY;
	}

	/**
	 * @hibernate.property column = "UNIT_PRICE"
	 * @return
	 */
	public Double getUNIT_PRICE(){
	    return UNIT_PRICE;
	}

	public void setUNIT_PRICE(Double UNIT_PRICE){
	    this.UNIT_PRICE = UNIT_PRICE;
	}

	/**
	 * @hibernate.property column = "TAX_CODE"
	 * @return
	 */
	public String getTAX_CODE(){
	    return TAX_CODE;
	}

	public void setTAX_CODE(String TAX_CODE){
	    this.TAX_CODE = TAX_CODE;
	}

	/**
	 * @hibernate.property column = "TAX"
	 * @return
	 */
	public Double getTAX(){
	    return TAX;
	}

	public void setTAX(Double TAX){
	    this.TAX = TAX;
	}

	/**
	 * @hibernate.property column = "EXCLUDING_TAX_TOTAL"
	 * @return
	 */
	public Double getEXCLUDING_TAX_TOTAL(){
	    return EXCLUDING_TAX_TOTAL;
	}

	public void setEXCLUDING_TAX_TOTAL(Double EXCLUDING_TAX_TOTAL){
	    this.EXCLUDING_TAX_TOTAL = EXCLUDING_TAX_TOTAL;
	}

	/**
	 * @hibernate.property column = "TAX_INCLUDED_TOTAL"
	 * @return
	 */
	public Double getTAX_INCLUDED_TOTAL(){
	    return TAX_INCLUDED_TOTAL;
	}

	public void setTAX_INCLUDED_TOTAL(Double TAX_INCLUDED_TOTAL){
	    this.TAX_INCLUDED_TOTAL = TAX_INCLUDED_TOTAL;
	}

	/**
	 * @hibernate.property column = "CITY_CODE"
	 * @return
	 */
	public String getCITY_CODE(){
	    return CITY_CODE;
	}

	public void setCITY_CODE(String CITY_CODE){
	    this.CITY_CODE = CITY_CODE;
	}

	/**
	 * @hibernate.property column = "CITY"
	 * @return
	 */
	public String getCITY(){
	    return CITY;
	}

	public void setCITY(String CITY){
	    this.CITY = CITY;
	}

	/**
	 * @hibernate.property column = "TASK_CODE"
	 * @return
	 */
	public String getTASK_CODE(){
	    return TASK_CODE;
	}

	public void setTASK_CODE(String TASK_CODE){
	    this.TASK_CODE = TASK_CODE;
	}

	/**
	 * @hibernate.property column = "TASK_NAME"
	 * @return
	 */
	public String getTASK_NAME(){
	    return TASK_NAME;
	}

	public void setTASK_NAME(String TASK_NAME){
	    this.TASK_NAME = TASK_NAME;
	}

	/**
	 * @hibernate.property column = "DOMAIN_NAME"
	 * @return
	 */
	public String getDOMAIN_NAME(){
	    return DOMAIN_NAME;
	}

	public void setDOMAIN_NAME(String DOMAIN_NAME){
	    this.DOMAIN_NAME = DOMAIN_NAME;
	}

	/**
	 * @hibernate.property column = "DOMAIN_CODE"
	 * @return
	 */
	public String getDOMAIN_CODE(){
	    return DOMAIN_CODE;
	}

	public void setDOMAIN_CODE(String DOMAIN_CODE){
	    this.DOMAIN_CODE = DOMAIN_CODE;
	}

	/**
	 * @hibernate.property column = "COST_TASK_CODE"
	 * @return
	 */
	public String getCOST_TASK_CODE(){
	    return COST_TASK_CODE;
	}

	public void setCOST_TASK_CODE(String COST_TASK_CODE){
	    this.COST_TASK_CODE = COST_TASK_CODE;
	}

	/**
	 * @hibernate.property column = "COST_TASK_NAME"
	 * @return
	 */
	public String getCOST_TASK_NAME(){
	    return COST_TASK_NAME;
	}

	public void setCOST_TASK_NAME(String COST_TASK_NAME){
	    this.COST_TASK_NAME = COST_TASK_NAME;
	}

	/**
	 * @hibernate.property column = "EXPENDITURE_TYPE"
	 * @return
	 */
	public String getEXPENDITURE_TYPE(){
	    return EXPENDITURE_TYPE;
	}

	public void setEXPENDITURE_TYPE(String EXPENDITURE_TYPE){
	    this.EXPENDITURE_TYPE = EXPENDITURE_TYPE;
	}

	/**
	 * @hibernate.property column = "EXPENDITURE_ORG_ID"
	 * @return
	 */
	public Long getEXPENDITURE_ORG_ID(){
	    return EXPENDITURE_ORG_ID;
	}

	public void setEXPENDITURE_ORG_ID(Long EXPENDITURE_ORG_ID){
	    this.EXPENDITURE_ORG_ID = EXPENDITURE_ORG_ID;
	}

	/**
	 * @hibernate.property column = "EXPENDITURE_ORG_NAME"
	 * @return
	 */
	public String getEXPENDITURE_ORG_NAME(){
	    return EXPENDITURE_ORG_NAME;
	}

	public void setEXPENDITURE_ORG_NAME(String EXPENDITURE_ORG_NAME){
	    this.EXPENDITURE_ORG_NAME = EXPENDITURE_ORG_NAME;
	}

	/**
	 * @hibernate.property column = "EXPENDITURE_DATE"
	 * @return
	 */
	public Date getEXPENDITURE_DATE(){
	    return EXPENDITURE_DATE;
	}

	public void setEXPENDITURE_DATE(Date EXPENDITURE_DATE){
	    this.EXPENDITURE_DATE = EXPENDITURE_DATE;
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
