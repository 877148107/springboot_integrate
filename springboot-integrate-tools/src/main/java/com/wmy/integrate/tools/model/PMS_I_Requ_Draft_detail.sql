create table PMS_I_Requ_Draft_detail（
  id           NUMBER(19) not null, 
  ENTITY_CREATE_DATE Date, 
  ENTITY_UPDATE_DATE Date, 
  REQU_LINE_ID NUMBER,
  COST_STAGE VARCHAR2(50),
  MATERIAL_CODE VARCHAR2(50),
  MATERIAL_NAME VARCHAR2(240),
  UNIT VARCHAR2(100),
  QUANTITY NUMBER,
  UNIT_PRICE NUMBER,
  TAX_CODE VARCHAR2(150) ,
  TAX NUMBER,
  EXCLUDING_TAX_TOTAL NUMBER,
  TAX_INCLUDED_TOTAL NUMBER,
  CITY_CODE VARCHAR2(50),
  CITY VARCHAR2(100),
  TASK_CODE VARCHAR2(100),
  TASK_NAME VARCHAR2(240),
  DOMAIN_NAME VARCHAR2(100),
  DOMAIN_CODE VARCHAR2(50),
  COST_TASK_CODE VARCHAR2(100),
  COST_TASK_NAME VARCHAR2(240),
  EXPENDITURE_TYPE VARCHAR2(30),
  EXPENDITURE_ORG_ID NUMBER,
  EXPENDITURE_ORG_NAME VARCHAR2(240),
  EXPENDITURE_DATE DATE,
  INPUT_EXT VARCHAR2（2000）,
);
comment on table PMS_I_Requ_Draft_detail
  is '导入工程费用PMS订单草稿信息明细';
comment on column PMS_I_Requ_Draft_detail.ENTITY_CREATE_DATE
  is '数据更新时间';
comment on column PMS_I_Requ_Draft_detail.ENTITY_UPDATE_DATE
  is '数据创建时间';
comment on column PMS_I_Requ_Draft_detail.REQU_LINE_ID
  is 'PMS订单草稿行ID';
comment on column PMS_I_Requ_Draft_detail.COST_STAGE
  is '费用所属阶段';
comment on column PMS_I_Requ_Draft_detail.MATERIAL_CODE
  is '物料编码';
comment on column PMS_I_Requ_Draft_detail.MATERIAL_NAME
  is '物料名称';
comment on column PMS_I_Requ_Draft_detail.UNIT
  is '计量单位';
comment on column PMS_I_Requ_Draft_detail.QUANTITY
  is '请购数量';
comment on column PMS_I_Requ_Draft_detail.UNIT_PRICE
  is '单价（元）';
comment on column PMS_I_Requ_Draft_detail.TAX_CODE
  is '税码';
comment on column PMS_I_Requ_Draft_detail.TAX
  is '税率';
comment on column PMS_I_Requ_Draft_detail.EXCLUDING_TAX_TOTAL
  is '不含税金额合计（元）';
comment on column PMS_I_Requ_Draft_detail.TAX_INCLUDED_TOTAL
  is '含税金额合计（元）';
comment on column PMS_I_Requ_Draft_detail.CITY_CODE
  is '地市/省公司部门编码';
comment on column PMS_I_Requ_Draft_detail.CITY
  is '地市/省公司部门名称';
comment on column PMS_I_Requ_Draft_detail.TASK_CODE
  is '任务编码';
comment on column PMS_I_Requ_Draft_detail.TASK_NAME
  is '任务名称';
comment on column PMS_I_Requ_Draft_detail.DOMAIN_NAME
  is '专业名称';
comment on column PMS_I_Requ_Draft_detail.DOMAIN_CODE
  is '专业编码';
comment on column PMS_I_Requ_Draft_detail.COST_TASK_CODE
  is '费用任务编码';
comment on column PMS_I_Requ_Draft_detail.COST_TASK_NAME
  is '费用任务名称';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_TYPE
  is '支出类型';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_ORG_ID
  is '支出组织ID';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_ORG_NAME
  is '支出组织名称';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_DATE
  is '支出日期';
comment on column PMS_I_Requ_Draft_detail.INPUT_EXT
  is '输入扩展';
alter table PMS_I_Requ_Draft_detail
  add constraint PRI_Requ_Draft_detail primary key (ID); 
