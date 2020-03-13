create table PMS_I_Requ_Draft_Info��
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
  REMARKS VARCHAR2��1000��,
  CREATED_BY NUMBER,
  CREATED_NAME VARCHAR2(50),
  CREATION_DATE DATE,
  REQU_LINE ����ʵ��,
  INPUT_EXT VARCHAR2��2000��,
);
comment on table PMS_I_Requ_Draft_Info
  is '���빤�̷���PMS�����ݸ���Ϣ������Ϣ';
comment on column PMS_I_Requ_Draft_Info.ENTITY_CREATE_DATE
  is '���ݸ���ʱ��';
comment on column PMS_I_Requ_Draft_Info.ENTITY_UPDATE_DATE
  is '���ݴ���ʱ��';
comment on column PMS_I_Requ_Draft_Info.PRI_KEY
  is '��¼Ψһ�ؼ���';
comment on column PMS_I_Requ_Draft_Info.PROVINCE_CODE
  is 'ʡ��˾����';
comment on column PMS_I_Requ_Draft_Info.REQU_HEAD_ID
  is 'PMS����ͷID';
comment on column PMS_I_Requ_Draft_Info.OU_ID
  is 'OU��֯ID';
comment on column PMS_I_Requ_Draft_Info.OU_NAME
  is 'OU��֯����';
comment on column PMS_I_Requ_Draft_Info.CREATE_COMPANY
  is '���Ƶ�λ';
comment on column PMS_I_Requ_Draft_Info.REQU_CODE
  is 'PMS��������';
comment on column PMS_I_Requ_Draft_Info.REQU_DESC
  is 'PMS��������';
comment on column PMS_I_Requ_Draft_Info.PROJECT_CODE
  is '��Ŀ����';
comment on column PMS_I_Requ_Draft_Info.PROJECT_NAME
  is '��Ŀ����';
comment on column PMS_I_Requ_Draft_Info.INVESTMENT_SUBJECT
  is '��ĿͶ������';
comment on column PMS_I_Requ_Draft_Info.VENDOR_CODE
  is '��Ӧ�̱���';
comment on column PMS_I_Requ_Draft_Info.VENDOR_NAME
  is '��Ӧ������';
comment on column PMS_I_Requ_Draft_Info.EXCLUDING_TAX_AMOUNT
  is '����˰�����ܽ��';
comment on column PMS_I_Requ_Draft_Info.TAX_INCLUDED_AMOUNT
  is '��˰�����ܽ��';
comment on column PMS_I_Requ_Draft_Info.CONTRACT_CODE
  is '��ͬ����';
comment on column PMS_I_Requ_Draft_Info.CONTRACT_NAME
  is '��ͬ����';
comment on column PMS_I_Requ_Draft_Info.CONTRACT_SUBJECT
  is 'Ͷ������';
comment on column PMS_I_Requ_Draft_Info.COST_TYPE
  is '��������';
comment on column PMS_I_Requ_Draft_Info.REQUEST_ARRIVAL_DATE
  is 'Ҫ�󵽻�����';
comment on column PMS_I_Requ_Draft_Info.IS_ADV_ORDER
  is '�Ƿ�Ԥ����';
comment on column PMS_I_Requ_Draft_Info.AGENT_NUM
  is '�ɹ�Ա���';
comment on column PMS_I_Requ_Draft_Info.AGENT_NAME
  is '�ɹ�Ա����';
comment on column PMS_I_Requ_Draft_Info.EMERGENCY_LEVEL
  is '�����̶�';
comment on column PMS_I_Requ_Draft_Info.REMARKS
  is '��ע';
comment on column PMS_I_Requ_Draft_Info.CREATED_BY
  is '�������û�ID';
comment on column PMS_I_Requ_Draft_Info.CREATED_NAME
  is '�������û���';
comment on column PMS_I_Requ_Draft_Info.CREATION_DATE
  is '����ʱ��';
comment on column PMS_I_Requ_Draft_Info.REQU_LINE
  is 'PMS�����ݸ���';
comment on column PMS_I_Requ_Draft_Info.INPUT_EXT
  is '������չ';
alter table PMS_I_Requ_Draft_Info
  add constraint PRI_Requ_Draft_Info primary key (ID); 
