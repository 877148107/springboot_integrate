create table PMS_I_Requ_Draft_detail��
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
  INPUT_EXT VARCHAR2��2000��,
);
comment on table PMS_I_Requ_Draft_detail
  is '���빤�̷���PMS�����ݸ���Ϣ��ϸ';
comment on column PMS_I_Requ_Draft_detail.ENTITY_CREATE_DATE
  is '���ݸ���ʱ��';
comment on column PMS_I_Requ_Draft_detail.ENTITY_UPDATE_DATE
  is '���ݴ���ʱ��';
comment on column PMS_I_Requ_Draft_detail.REQU_LINE_ID
  is 'PMS�����ݸ���ID';
comment on column PMS_I_Requ_Draft_detail.COST_STAGE
  is '���������׶�';
comment on column PMS_I_Requ_Draft_detail.MATERIAL_CODE
  is '���ϱ���';
comment on column PMS_I_Requ_Draft_detail.MATERIAL_NAME
  is '��������';
comment on column PMS_I_Requ_Draft_detail.UNIT
  is '������λ';
comment on column PMS_I_Requ_Draft_detail.QUANTITY
  is '�빺����';
comment on column PMS_I_Requ_Draft_detail.UNIT_PRICE
  is '���ۣ�Ԫ��';
comment on column PMS_I_Requ_Draft_detail.TAX_CODE
  is '˰��';
comment on column PMS_I_Requ_Draft_detail.TAX
  is '˰��';
comment on column PMS_I_Requ_Draft_detail.EXCLUDING_TAX_TOTAL
  is '����˰���ϼƣ�Ԫ��';
comment on column PMS_I_Requ_Draft_detail.TAX_INCLUDED_TOTAL
  is '��˰���ϼƣ�Ԫ��';
comment on column PMS_I_Requ_Draft_detail.CITY_CODE
  is '����/ʡ��˾���ű���';
comment on column PMS_I_Requ_Draft_detail.CITY
  is '����/ʡ��˾��������';
comment on column PMS_I_Requ_Draft_detail.TASK_CODE
  is '�������';
comment on column PMS_I_Requ_Draft_detail.TASK_NAME
  is '��������';
comment on column PMS_I_Requ_Draft_detail.DOMAIN_NAME
  is 'רҵ����';
comment on column PMS_I_Requ_Draft_detail.DOMAIN_CODE
  is 'רҵ����';
comment on column PMS_I_Requ_Draft_detail.COST_TASK_CODE
  is '�����������';
comment on column PMS_I_Requ_Draft_detail.COST_TASK_NAME
  is '������������';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_TYPE
  is '֧������';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_ORG_ID
  is '֧����֯ID';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_ORG_NAME
  is '֧����֯����';
comment on column PMS_I_Requ_Draft_detail.EXPENDITURE_DATE
  is '֧������';
comment on column PMS_I_Requ_Draft_detail.INPUT_EXT
  is '������չ';
alter table PMS_I_Requ_Draft_detail
  add constraint PRI_Requ_Draft_detail primary key (ID); 
