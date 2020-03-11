create table PMS_I_Requ_Draft_Info（
  id           NUMBER(19) not null, 
  ENTITY_CREATE_DATE Date, 
  ENTITY_UPDATE_DATE Date, 
  PRI_KEY VARCHAR2(60),
  PROVINCE_CODE VARCHAR2(30),
  REQU_HEAD_ID NUMBER,
  OU_ID NUMBER,
  OU_NAME VARCHAR2(240),
  CREATE_COMPANY VARCHAR2(50),
  REQU_CODE VARCHAR2(50),
  REQU_DESC VARCHAR2(240),
  PROJECT_CODE VARCHAR2(100),
  PROJECT_NAME VARCHAR2(240),
  INVESTMENT_SUBJECT VARCHAR2(50),
  VENDOR_CODE VARCHAR2(30),
  VENDOR_NAME VARCHAR2(240),
  EXCLUDING_TAX_AMOUNT NUMBER,
  TAX_INCLUDED_AMOUNT NUMBER,
  CONTRACT_CODE VARCHAR2(100),
  CONTRACT_NAME VARCHAR2(240),
  CONTRACT_SUBJECT VARCHAR2(20),
  COST_TYPE VARCHAR2(50),
  REQUEST_ARRIVAL_DATE DATE,
  IS_ADV_ORDER NUMBER,
  AGENT_NUM VARCHAR2(30),
  AGENT_NAME VARCHAR2(240),
  EMERGENCY_LEVEL VARCHAR2(10),
  REMARKS VARCHAR2（1000）,
  CREATED_BY NUMBER,
  CREATED_NAME VARCHAR2(50),
  CREATION_DATE DATE,
  REQU_LINE 数据实体,
  INPUT_EXT VARCHAR2（2000）,
);
comment on table PMS_I_Requ_Draft_Info
  is '导入工程费用PMS订单草稿信息基本信息';
comment on column PMS_I_Requ_Draft_Info.ENTITY_CREATE_DATE
  is '数据更新时间';
comment on column PMS_I_Requ_Draft_Info.ENTITY_UPDATE_DATE
  is '数据创建时间';
comment on column PMS_I_Requ_Draft_Info.PRI_KEY
  is '记录唯一关键字';
comment on column PMS_I_Requ_Draft_Info.PROVINCE_CODE
  is '省公司代码';
comment on column PMS_I_Requ_Draft_Info.REQU_HEAD_ID
  is 'PMS订单头ID';
comment on column PMS_I_Requ_Draft_Info.OU_ID
  is 'OU组织ID';
comment on column PMS_I_Requ_Draft_Info.OU_NAME
  is 'OU组织名称';
comment on column PMS_I_Requ_Draft_Info.CREATE_COMPANY
  is '编制单位';
comment on column PMS_I_Requ_Draft_Info.REQU_CODE
  is 'PMS订单编码';
comment on column PMS_I_Requ_Draft_Info.REQU_DESC
  is 'PMS订单主题';
comment on column PMS_I_Requ_Draft_Info.PROJECT_CODE
  is '项目编码';
comment on column PMS_I_Requ_Draft_Info.PROJECT_NAME
  is '项目名称';
comment on column PMS_I_Requ_Draft_Info.INVESTMENT_SUBJECT
  is '项目投资主体';
comment on column PMS_I_Requ_Draft_Info.VENDOR_CODE
  is '供应商编码';
comment on column PMS_I_Requ_Draft_Info.VENDOR_NAME
  is '供应商名称';
comment on column PMS_I_Requ_Draft_Info.EXCLUDING_TAX_AMOUNT
  is '不含税订单总金额';
comment on column PMS_I_Requ_Draft_Info.TAX_INCLUDED_AMOUNT
  is '含税订单总金额';
comment on column PMS_I_Requ_Draft_Info.CONTRACT_CODE
  is '合同编码';
comment on column PMS_I_Requ_Draft_Info.CONTRACT_NAME
  is '合同名称';
comment on column PMS_I_Requ_Draft_Info.CONTRACT_SUBJECT
  is '投资主体';
comment on column PMS_I_Requ_Draft_Info.COST_TYPE
  is '费用类型';
comment on column PMS_I_Requ_Draft_Info.REQUEST_ARRIVAL_DATE
  is '要求到货日期';
comment on column PMS_I_Requ_Draft_Info.IS_ADV_ORDER
  is '是否预订单';
comment on column PMS_I_Requ_Draft_Info.AGENT_NUM
  is '采购员编号';
comment on column PMS_I_Requ_Draft_Info.AGENT_NAME
  is '采购员姓名';
comment on column PMS_I_Requ_Draft_Info.EMERGENCY_LEVEL
  is '紧急程度';
comment on column PMS_I_Requ_Draft_Info.REMARKS
  is '备注';
comment on column PMS_I_Requ_Draft_Info.CREATED_BY
  is '创建者用户ID';
comment on column PMS_I_Requ_Draft_Info.CREATED_NAME
  is '创建者用户名';
comment on column PMS_I_Requ_Draft_Info.CREATION_DATE
  is '创建时间';
comment on column PMS_I_Requ_Draft_Info.REQU_LINE
  is 'PMS订单草稿行';
comment on column PMS_I_Requ_Draft_Info.INPUT_EXT
  is '输入扩展';
alter table PMS_I_Requ_Draft_Info
  add constraint PRI_Requ_Draft_Info primary key (ID); 
