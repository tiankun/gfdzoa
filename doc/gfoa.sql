
/*==============================================================*/
/* Table: zhb_clxx   车辆信息表   */
/*==============================================================*/
create table zhb_clxx  (
   id               NVARCHAR2(50)  primary key not null,
   clmc             NVARCHAR2(50)  not null,
   cphm             NVARCHAR2(50)  not null,
   pp               NVARCHAR2(50)  not null,
   cx               NVARCHAR2(50)  not null,
   fdjh             NVARCHAR2(30)  not null,
   gmsj             DATE,
   gmjg             NUMBER,
   njsj             DATE           not null,
   bxgmsj           DATE,
   bz               NVARCHAR2(100),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

comment on table zhb_clxx is '车辆信息';
comment on column zhb_clxx.create_name is '创建人名称';
comment on column zhb_clxx.create_by is '创建人登录名称';
comment on column zhb_clxx.create_date is '创建日期';
comment on column zhb_clxx.update_name is '更新人名称';
comment on column zhb_clxx.update_by is '更新人登录名称';
comment on column zhb_clxx.update_date is '更新日期';
comment on column zhb_clxx.id is '编号';
comment on column zhb_clxx.clmc is '车辆名称';
comment on column zhb_clxx.cphm is '车牌号码';
comment on column zhb_clxx.pp is '品牌';
comment on column zhb_clxx.cx is '车型';
comment on column zhb_clxx.fdjh is '发动机号';
comment on column zhb_clxx.gmsj is '购买时间';
comment on column zhb_clxx.gmjg is '购买价格';
comment on column zhb_clxx.njsj is '年检时间';
comment on column zhb_clxx.bxgmsj is '保险购买时间';
comment on column zhb_clxx.bz is '备注';

/*==============================================================*/
/* Table: zhb_clxx   车辆信息附件表                                           */
/*==============================================================*/
create table zhb_clxx_files  (
   id         NVARCHAR2(50)  primary key not null,
   clxx_id    VARCHAR2(50)
);
comment on table zhb_clxx_files is '车辆信息附件';
comment on column zhb_clxx_files.id is '编号';
comment on column zhb_clxx_files.clxx_id is '车辆id';

/*==============================================================*/
/* Table: zhb_ycsq   用车申请                                           */
/*==============================================================*/
create table zhb_ycsq  (
   id         NVARCHAR2(50)    primary key not null,
   lxbh       NVARCHAR2(50)    not null,
   jhkssj     DATE             not null,
   jhjssj     DATE             not null,
   ycyy       NVARCHAR2(100)   not null,
   xclx       NVARCHAR2(50),
   bz         NVARCHAR2(100),
   sqr        NVARCHAR2(50)    not null,
   sqsj       DATE,
   processInstanceId    VARCHAR2(32 CHAR),
   sqzt     NUMBER(1)
);
comment on table zhb_ycsq is '用车申请';
comment on column zhb_ycsq.id is '编号';
comment on column zhb_ycsq.lxbh is '类型编号';
comment on column zhb_ycsq.jhkssj is '计划开始时间';
comment on column zhb_ycsq.jhjssj is '计划结束时间';
comment on column zhb_ycsq.ycyy is '用车原因';
comment on column zhb_ycsq.xclx is '行车路线';
comment on column zhb_ycsq.bz is '备注';
comment on column zhb_ycsq.sqr is '申请人';
comment on column zhb_ycsq.sqsj is '申请时间';
comment on column zhb_ycsq.processInstanceId is '流程id';
comment on column zhb_ycsq.sqzt is '申请状态';




/*==============================================================*/
/* Table: zhb_zzxx   证章信息                                           */
/*==============================================================*/
create table zhb_zzxx  (
   id        NVARCHAR2(50) primary key  not null,
   lxbh      NVARCHAR2(50)              not null,
   zzmc      NVARCHAR2(50)              not null,
   zrbm      NVARCHAR2(50),
   zrr       NVARCHAR2(50),
   cfwz      NVARCHAR2(50),
   bz        NVARCHAR2(100),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

comment on table zhb_zzxx is '证章信息';
comment on column zhb_zzxx.id is '编号';
comment on column zhb_zzxx.lxbh is '类型编号';
comment on column zhb_zzxx.zzmc is '证章名称';
comment on column zhb_zzxx.zrbm is '责任部门';
comment on column zhb_zzxx.zrr is '责任人';
comment on column zhb_zzxx.cfwz is '存放位置';
comment on column zhb_zzxx.bz is '备注';
comment on column zhb_zzxx.create_name is '创建人名称';
comment on column zhb_zzxx.create_by is '创建人登录名称';
comment on column zhb_zzxx.create_date is '创建日期';
comment on column zhb_zzxx.update_name is '更新人名称';
comment on column zhb_zzxx.update_by is '更新人登录名称';
comment on column zhb_zzxx.update_date is '更新日期';



/*==============================================================*/
/* Table: zhb_zzsq                                              */
/*==============================================================*/
create table zhb_zzsq  (
   id         NVARCHAR2(50)  primary key not null,
   jyxm       NVARCHAR2(50),
   sysj       DATE        not null,
   jyyt       NVARCHAR2(100)  not null,
   jylx       NVARCHAR2(200),
   syfs       NUMBER,
   bz         NVARCHAR2(100),
   sqr        NVARCHAR2(50)   not null,
   sqsj       DATE,
   processInstanceId    VARCHAR2(32 CHAR),
   sqzt       NUMBER(1)
);

comment on table zhb_zzsq is '证章申请';
comment on column zhb_zzsq.id is '编号';
comment on column zhb_zzsq.jyxm is '借用项目';
comment on column zhb_zzsq.sysj is '使用时间';
comment on column zhb_zzsq.jyyt is '借用用途';
comment on column zhb_zzsq.jylx is '借用类型（可多选）';
comment on column zhb_zzsq.syfs is '使用份数';
comment on column zhb_zzsq.bz is '备注';
comment on column zhb_zzsq.sqr is '申请人';
comment on column zhb_zzsq.sqsj is '申请时间';
comment on column zhb_zzsq.sqzt is '申请状态';
comment on column zhb_zzsq.processInstanceId is '流程id';


/*==============================================================*/
/* Table: zhb_bhgpdj  不合格产品登记                                        */
/*==============================================================*/
create table zhb_bhgpdj  (
   id     NVARCHAR2(50)  primary key  not null,
   cpmc   NVARCHAR2(50)     not null,
   ggxh   NVARCHAR2(50)     not null,
   gfmc   NVARCHAR2(100)    not null,
   bhgyy  NVARCHAR2(100)    not null,
   bhgsl  NUMBER(5)         not null,
   jbr    NVARCHAR2(50)     not null,
   jbsj   DATE,
   bhgpcz NVARCHAR2(100),
   pzr    NVARCHAR2(50),
   pzsj   DATE,
   bz     NVARCHAR2(100),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

comment on table zhb_bhgpdj is '不合格品登记';
comment on column zhb_bhgpdj.id is '编号';
comment on column zhb_bhgpdj.cpmc is '产品名称';
comment on column zhb_bhgpdj.ggxh is '规格型号';
comment on column zhb_bhgpdj.gfmc is '供方名称';
comment on column zhb_bhgpdj.bhgyy is '不合格原因';
comment on column zhb_bhgpdj.bhgsl is '不合格数量';
comment on column zhb_bhgpdj.jbr is '经办人';
comment on column zhb_bhgpdj.jbsj is '经办时间';
comment on column zhb_bhgpdj.bhgpcz is '不合格品处置';
comment on column zhb_bhgpdj.pzr is '批准人';
comment on column zhb_bhgpdj.pzsj is '批准时间';
comment on column zhb_bhgpdj.bz is '备注';
comment on column zhb_bhgpdj.create_name is '创建人名称';
comment on column zhb_bhgpdj.create_by is '创建人登录名称';
comment on column zhb_bhgpdj.create_date is '创建日期';
comment on column zhb_bhgpdj.update_name is '更新人名称';
comment on column zhb_bhgpdj.update_by is '更新人登录名称';
comment on column zhb_bhgpdj.update_date is '更新日期';


/*==============================================================*/
/* Table: zhb_htdj  合同信息登记                                            */
/*==============================================================*/
create table zhb_htdj  (
   id      NVARCHAR2(50)  primary key  not null,
   lxbh    NVARCHAR2(50),
   htbh    NVARCHAR2(50)      not null,
   htmc    NVARCHAR2(50)      not null,
   htnr    NVARCHAR2(100)     not null,
   htdw    NVARCHAR2(50)      not null,
   htrq    DATE  not null,
   htje    NUMBER not null,
   cdfs    NUMBER(2)          not null,
   jbr     NVARCHAR2(50)      not null,
   cfwz    NVARCHAR2(50),
   bz      NVARCHAR2(100),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

comment on table zhb_htdj is '合同信息登记';
comment on column zhb_htdj.id is '编号';
comment on column zhb_htdj.lxbh is '类型编号';
comment on column zhb_htdj.htbh is '合同编号';
comment on column zhb_htdj.htmc is '合同名称';
comment on column zhb_htdj.htnr is '合同内容';
comment on column zhb_htdj.htdw is '合同单位';
comment on column zhb_htdj.htrq is '合同日期';
comment on column zhb_htdj.htje is '合同金额';
comment on column zhb_htdj.cdfs is '存档份数';
comment on column zhb_htdj.jbr is '经办人';
comment on column zhb_htdj.cfwz is '存放位置';
comment on column zhb_htdj.bz is '备注';
comment on column zhb_htdj.create_name is '创建人名称';
comment on column zhb_htdj.create_by is '创建人登录名称';
comment on column zhb_htdj.create_date is '创建日期';
comment on column zhb_htdj.update_name is '更新人名称';
comment on column zhb_htdj.update_by is '更新人登录名称';
comment on column zhb_htdj.update_date is '更新日期';

/*==============================================================*/
/* Table: zhb_clxx   合同信息附件表                                           */
/*==============================================================*/
create table zhb_htdj_files  (
   id         NVARCHAR2(50)  primary key not null,
   htxx_id    VARCHAR2(50)
);
comment on table zhb_htdj_files is '合同信息附件';
comment on column zhb_htdj_files.id is '编号';
comment on column zhb_htdj_files.clxx_id is '合同信息附件id';



/*==============================================================*/
/* Table: zhb_sfwdj  收发文登记                                    */
/*==============================================================*/
create table zhb_sfwdj  (
   id       NVARCHAR2(50)  primary key  not null,
   lxbh     NVARCHAR2(50),
   wjmc     NVARCHAR2(50)       not null,
   wjbh     NVARCHAR2(50)       not null,
   sfwlx    NUMBER(1),
   wjfs     NUMBER(5)           not null,
   fjr      NVARCHAR2(50)       not null,
   qsr      NVARCHAR2(50)       not null,
   qsrq     DATE    not null,
   bz       NVARCHAR2(100),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

comment on table zhb_sfwdj is '收发文登记';
comment on column zhb_sfwdj.id is '编号';
comment on column zhb_sfwdj.lxbh is '类型编号';
comment on column zhb_sfwdj.wjmc is '文件名称';
comment on column zhb_sfwdj.wjbh is '文件编号';
comment on column zhb_sfwdj.sfwlx is '收发文类型(1：收文；2：发文)';
comment on column zhb_sfwdj.wjfs is '文件份数';
comment on column zhb_sfwdj.fjr is '收/发件人';
comment on column zhb_sfwdj.qsr is '签收人';
comment on column zhb_sfwdj.qsrq is '签收日期';
comment on column zhb_sfwdj.bz is '备注';
comment on column zhb_sfwdj.create_name is '创建人名称';
comment on column zhb_sfwdj.create_by is '创建人登录名称';
comment on column zhb_sfwdj.create_date is '创建日期';
comment on column zhb_sfwdj.update_name is '更新人名称';
comment on column zhb_sfwdj.update_by is '更新人登录名称';
comment on column zhb_sfwdj.update_date is '更新日期';


/*==============================================================*/
/* Table: zhb_sfwdj_files   收发文登记附件表                                           */
/*==============================================================*/
create table zhb_sfwdj_files  (
   id         NVARCHAR2(50)  primary key not null,
   sfwdj_id    VARCHAR2(50)
);
comment on table zhb_sfwdj_files is '收发文登记附件';
comment on column zhb_sfwdj_files.id is '编号';
comment on column zhb_sfwdj_files.sfwdj_id is '收发文登记附件id';


/*==============================================================*/
/* Table: zhb_gysml  供应商名录                                  */
/*==============================================================*/
create table zhb_gysml  (
   id       NVARCHAR2(50)  primary key  not null,
   lxbh     NVARCHAR2(50),
   gysbh    NVARCHAR2(50)       not null,
   gsmc     NVARCHAR2(100)      not null,
   gsdh     NVARCHAR2(50)       not null,
   dwcz     NVARCHAR2(50)       not null,
   gsdz     NVARCHAR2(100),
   gswz     NVARCHAR2(50),
   gsfr     NVARCHAR2(50),
   zczb     NVARCHAR2(50),
   clsj     DATE,
   fzr      NVARCHAR2(50),
   fzrdh    NVARCHAR2(50),
   lxr      NVARCHAR2(50)       not null,
   lxrdh    NVARCHAR2(50)       not null,
   fktj     NVARCHAR2(100),
   ghq      NVARCHAR2(50),
   psfs     NVARCHAR2(50),
   sfjszc   NUMBER(1),
   sfybnsr  NUMBER(1)           not null,
   pjbgbh   NVARCHAR2(50),
   sclrrq   DATE,
   ndfpjg   NUMBER(1),
   fpsj     DATE,
   pdjl     NVARCHAR2(50),
   bz       NVARCHAR2(100),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

comment on table zhb_gysml is '供应商名录';
comment on column zhb_gysml.id is '编号';
comment on column zhb_gysml.lxbh is '类型编号';
comment on column zhb_gysml.gysbh is '供应商编号';
comment on column zhb_gysml.gsmc is '公司名称';
comment on column zhb_gysml.gsdh is '公司电话';
comment on column zhb_gysml.dwcz is '公司传真';
comment on column zhb_gysml.gsdz is '公司地址';
comment on column zhb_gysml.gswz is '公司网址';
comment on column zhb_gysml.gsfr is '公司法人';
comment on column zhb_gysml.zczb is '注册资本';
comment on column zhb_gysml.clsj is '成立时间';
comment on column zhb_gysml.fzr is '负责人';
comment on column zhb_gysml.fzrdh is '负责人电话';
comment on column zhb_gysml.lxr is '联系人';
comment on column zhb_gysml.lxrdh is '联系人电话';
comment on column zhb_gysml.fktj is '付款条件';
comment on column zhb_gysml.ghq is '供货期';
comment on column zhb_gysml.psfs is '配送方式';
comment on column zhb_gysml.sfjszc is '是否技术支持';
comment on column zhb_gysml.sfybnsr is '是否一般纳税人';
comment on column zhb_gysml.pjbgbh is '调查及评价报告编号';
comment on column zhb_gysml.sclrrq is '首次列入日期';
comment on column zhb_gysml.ndfpjg is '年度复评结果（0：不合格；1：合格）';
comment on column zhb_gysml.fpsj is '复评时间';
comment on column zhb_gysml.pdjl is '评定结论';
comment on column zhb_gysml.bz is '备注';
comment on column zhb_gysml.create_name is '创建人名称';
comment on column zhb_gysml.create_by is '创建人登录名称';
comment on column zhb_gysml.create_date is '创建日期';
comment on column zhb_gysml.update_name is '更新人名称';
comment on column zhb_gysml.update_by is '更新人登录名称';
comment on column zhb_gysml.update_date is '更新日期';



/*==============================================================*/
/* Table: zhb_gysml_files  供应商名录  附件表                                */
/*==============================================================*/
create table zhb_gysml_files  (
   id         NVARCHAR2(50)  primary key not null,
   gysml_id    VARCHAR2(50)
);
comment on table zhb_gysml_files is '供应商名录附件';
comment on column zhb_gysml_files.id is '编号';
comment on column zhb_gysml_files.gysml_id is '供应商名录id';


/*==============================================================*/
/* Table: zhb_cp 产品表                                              */
/*==============================================================*/
create table zhb_cp  (
   id     NVARCHAR2(50)  primary key not null,
   lxbh   NVARCHAR2(50),
   standard NVARCHAR2(50),
   brand NVARCHAR2(50),
   unit NVARCHAR2(50),
   cpmc   NVARCHAR2(50)     not null,
   bz     NVARCHAR2(100)
);

comment on table zhb_cp is '采购产品表';
comment on column zhb_cp.id is '编号';
comment on column zhb_cp.standard is '规格';
comment on column zhb_cp.brand is '品牌';
comment on column zhb_cp.unit is '单位';
comment on column zhb_cp.lxbh is '类型';
comment on column zhb_cp.cpmc is '产品名称';
comment on column zhb_cp.bz is '备注';


/*==============================================================*/
/* Table: zhb_cplx 产品类型表                                              */
/*==============================================================*/
create table zhb_cplx  (
   id     NVARCHAR2(50)  primary key not null,
   lxmc   NVARCHAR2(50),
   sjfl   NVARCHAR2(50),
   bz     NVARCHAR2(1000)
);

comment on table zhb_cplx is '产品类类型表';
comment on column zhb_cplx.id is '编号';
comment on column zhb_cplx.lxmc is '类型名称';
comment on column zhb_cplx.sjfl is '上级分类';
comment on column zhb_cplx.bz is '备注';


/*==============================================================*/
/* Table: zhb_gyscp                                             */
/*==============================================================*/
create table zhb_gyscp  (
   id     NVARCHAR2(50) primary key  not null,
   gysbh  NVARCHAR2(50)     not null,
   cpbh   NVARCHAR2(50)     not null
);

comment on table zhb_gyscp is '供应商产品表';
comment on column zhb_gyscp.id is '编号';
comment on column zhb_gyscp.gysbh is '供应商编号';
comment on column zhb_gyscp.cpbh is '产品编号';


/*==============================================================*/
/* Table: xsb_xsxm  销售项目表                                            */
/*==============================================================*/
create table xsb_xsxm  (
   id    NVARCHAR2(50) primary key  not null,
   xmmc  NVARCHAR2(100)   not null,
   khmc  NVARCHAR2(100)   not null,
   xmje  NUMBER,
   xmms  NVARCHAR2(100),
   jffzr NVARCHAR2(50),
   lxdh  NVARCHAR2(50),
   jzds  NVARCHAR2(200),
   bz    NVARCHAR2(100),
   xmjd  NUMBER(1)
);

comment on table xsb_xsxm is '销售项目表';
comment on column xsb_xsxm.id is '编号';
comment on column xsb_xsxm.xmmc is '项目名称';
comment on column xsb_xsxm.khmc is '客户名称';
comment on column xsb_xsxm.xmje is '项目金额';
comment on column xsb_xsxm.xmms is '项目描述';
comment on column xsb_xsxm.jffzr is '甲方负责人';
comment on column xsb_xsxm.lxdh is '联系电话';
comment on column xsb_xsxm.jzds is '竞争对手';
comment on column xsb_xsxm.bz is '备注';
comment on column xsb_xsxm.xmjd is '项目进度';


/*==============================================================*/
/* Table: hr_leave  请假申请表                                            */
/*==============================================================*/
create table hr_leave  (
   ID           VARCHAR2(32 CHAR) primary key not null,
   leave_Type   VARCHAR2(32 CHAR),
   leave_user   VARCHAR2(32 CHAR),
   begin_date   TIMESTAMP,
   behin_scope  VARCHAR2(1),
   end_date     TIMESTAMP,
   end_scope    VARCHAR2(1),
   leave_reason VARCHAR2(255 CHAR),
   leave_days   NUMBER(10,2),
   processInstanceId    VARCHAR2(32 CHAR)
);

/*==============================================================*/
/* Table: hr_leave_type  请假申请表                                            */
/*==============================================================*/
create table hr_leave_type  (
   ID           VARCHAR2(32 CHAR) primary key not null,
   type_name   VARCHAR2(32 CHAR),
   parent_id   VARCHAR2(32 CHAR),
   leave_days   NUMBER(10,2),
   note VARCHAR2(255 CHAR)
);
/*==============================================================*/
/* Table: hr_work_summary  工作总结表                                     */
/*==============================================================*/
create table hr_work_summary  (
   id         VARCHAR2(32 CHAR)  primary key not null,
   summary_date         TIMESTAMP,
   summary_weeks        NUMBER,
   summary_note         VARCHAR2(2000 CHAR),
   summary_user         VARCHAR2(32 CHAR),
   summary_num       VARCHAR2(32 CHAR)
);


/*==============================================================*/
/* Table: hr_performance    绩效考核表                                    */
/*==============================================================*/
create table hr_performance  (
   id                   VARCHAR2(32 CHAR)   primary key not null,
   username             VARCHAR2(32 CHAR),
   depart               VARCHAR2(32 CHAR),
   performance_date     TIMESTAMP,
   note              VARCHAR2(255 CHAR),
   results              VARCHAR2(32 CHAR)
);


/*==============================================================*/
/* Table: hr_attendance  考勤表                                       */
/*==============================================================*/
create table hr_attendance  (
   id                   VARCHAR2(32 CHAR)  primary key not null,
   username             VARCHAR2(32 CHAR),
   depart               TIMESTAMP,
   attendance_date      VARCHAR2(32 CHAR),
   attendance_am        VARCHAR2(32 CHAR),
   attendance_pm        VARCHAR2(32 CHAR)
);

/*==============================================================*/
/* Table: hr_travel  出差申请表                                               */
/*==============================================================*/
create table hr_travel  (
   id                   VARCHAR2(32 CHAR)  primary key   not null,
   travel_user          VARCHAR2(32 CHAR),
   depart               VARCHAR2(32 CHAR),
   travel_otherUser     VARCHAR2(255 CHAR),
   begin_date           TIMESTAMP,
   end_date             TIMESTAMP,
   travel_reason        VARCHAR2(255 CHAR),
   iszanzhi             VARCHAR(1),
   travel_path          VARCHAR2(32 CHAR),
   processInstanceId    VARCHAR2(32 CHAR)
);

/*==============================================================*/
/* Table: hr_travel_path     出差路径                                      */
/*==============================================================*/
create table hr_travel_path  (
   id          VARCHAR2(32 CHAR)  primary key   not null,
   province    VARCHAR2(32 CHAR),
   city        VARCHAR2(32 CHAR),
   county      VARCHAR2(32 CHAR),
   begin_date  TIMESTAMP,
   end_date    TIMESTAMP,
   vehicle     VARCHAR2(32 CHAR),
   criterion   NUMBER(10,2),
   travel_id   VARCHAR2(32 CHAR),
   travel_type VARCHAR2(10)
);

/*==============================================================*/
/* Table: gc_purchase_plan   项目材料采购计划                                   */
/*==============================================================*/
create table gc_purchase_plan  (
   id         VARCHAR(32) primary key not null,
   project_id VARCHAR(32) not null,
   user_id    VARCHAR(32) not null,
   apply_time TIMESTAMP   not null,
   remark     VARCHAR2(500)
);

comment on table gc_purchase_plan is'项目材料采购计划';
comment on column gc_purchase_plan.id is'主键';
comment on column gc_purchase_plan.project_id is'项目主键';
comment on column gc_purchase_plan.user_id is'申请人';
comment on column gc_purchase_plan.apply_time is'申请时间';
comment on column gc_purchase_plan.remark is'备注';



/*==============================================================*/
/* Table: gc_purchase_plan_detail 采购计划明细                              */
/*==============================================================*/
create table gc_purchase_plan_detail  (
   id                   VARCHAR2(32) primary key  not null,
   project_plan_id      VARCHAR2(32)   not null,
   project_material_id  VARCHAR2(32)   not null,
   plan_number          NUMBER         not null,
   plan_price           NUMBER         not null,
   palan_explain        VARCHAR2(500),
   examine_number       NUMBER,
   examine_price        NUMBER,
   examine_explain      VARCHAR2(500),
   remark               VARCHAR2(500)
);

comment on table gc_purchase_plan_detail is'项目采购计划详细列表';
comment on column gc_purchase_plan_detail.id is'主键';
comment on column gc_purchase_plan_detail.project_plan_id is'采购计划主键';
comment on column gc_purchase_plan_detail.project_material_id is'材料主键';
comment on column gc_purchase_plan_detail.plan_number is'计划数量';
comment on column gc_purchase_plan_detail.plan_price is'计划单价';
comment on column gc_purchase_plan_detail.palan_explain is'申请说明';
comment on column gc_purchase_plan_detail.examine_number is'审核数量';
comment on column gc_purchase_plan_detail.examine_price is'审核单价';
comment on column gc_purchase_plan_detail.examine_explain is'审批说明';
comment on column gc_purchase_plan_detail.remark is'备注';


/*==============================================================*/
/* Table: gc_purchase 项目采购申请单                                          */
/*==============================================================*/
create table gc_purchase  (
   id           NUMBER primary key not null,
   project_id   NUMBER,
   user_id      NUMBER,
   input_time   TIMESTAMP,
   require_time date,
   linkman      VARCHAR2(30),
   contact_number       VARCHAR2(50),
   processInstanceId    VARCHAR2(32 CHAR),
   remark       VARCHAR2(500)
);

comment on table gc_purchase is'项目采购申请单';
comment on column gc_purchase.id is'主键';
comment on column gc_purchase.project_id is'项目主键';
comment on column gc_purchase.user_id is'用户主键';
comment on column gc_purchase.input_time is'申请时间';
comment on column gc_purchase.require_time is'要求到货时间';
comment on column gc_purchase.linkman is'到货联系人';
comment on column gc_purchase.contact_number is'到货联系人电话';
comment on column gc_purchase.processInstanceId is'流程id';
comment on column gc_purchase.remark is'备注';


/*==============================================================*/
/* Table: gc_purchase_detail   项目采购申请详单                                         */
/*==============================================================*/
create table gc_purchase_detail  (
   id                   VARCHAR2(32)  primary key  not null,
   project_plan_id      VARCHAR2(32)    not null,
   project_material_id  VARCHAR2(32)    not null,
   apply_number         NUMBER          not null,
   remark               VARCHAR2(500)
);

comment on table gc_purchase_detail is'采购申请物品详细列表';
comment on column gc_purchase_detail.id is'主键';
comment on column gc_purchase_detail.project_plan_id is'采购单主键';
comment on column gc_purchase_detail.project_material_id is'材料主键';
comment on column gc_purchase_detail.apply_number is'申请数量';
comment on column gc_purchase_detail.remark is'备注';


/*==============================================================*/
/* Table: gc_purchase_execute   采购执行单                              */
/*==============================================================*/
create table gc_purchase_execute  (
   id                   VARCHAR2(32)  primary key   not null,
   project_plan_id      VARCHAR2(32)     not null,
   input_time           TIMESTAMP        not null,
   input_user           VARCHAR2(32)     not null,
   suppliers            VARCHAR2(32)     not null,
   processInstanceId    VARCHAR2(32 CHAR),
   remark VARCHAR2(500)
);

comment on table gc_purchase_execute is'采购执行单';
comment on column gc_purchase_execute.id is'主键';
comment on column gc_purchase_execute.project_plan_id is'采购单主键';
comment on column gc_purchase_execute.input_time is'创建时间';
comment on column gc_purchase_execute.input_user is'创建人';
comment on column gc_purchase_execute.processInstanceId is'流程id';
comment on column gc_purchase_execute.suppliers is'供货单位';
comment on column gc_purchase_execute.remark is'备注';


/*==============================================================*/
/* Table: gc_purchase_execute_detail  采购执行物品详细列表                          */
/*==============================================================*/
create table gc_purchase_execute_detail  (
   id         VARCHAR2(32) primary key not null,
   project_plan_id      VARCHAR2(32) not null,
   project_material_id  VARCHAR2(32) not null,
   amount     NUMBER      not null,
   price      NUMBER,
   remark     VARCHAR2(500)
);

comment on table gc_purchase_execute_detail is'采购执行物品详细列表';
comment on column gc_purchase_execute_detail.id is'主键';
comment on column gc_purchase_execute_detail.project_plan_id is'采购单主键';
comment on column gc_purchase_execute_detail.project_material_id is'采购申请物品主键';
comment on column gc_purchase_execute_detail.amount is'计划数量';
comment on column gc_purchase_execute_detail.price is'采购单价';
comment on column gc_purchase_execute_detail.remark is'备注';

/*==============================================================*/
/* Table: gc_purchase_execute_confirm   采购到货记录                      */
/*==============================================================*/
create table gc_purchase_execute_confirm  (
   id          VARCHAR2(32) primary key  not null,
   detailed_id VARCHAR2(32),
   Confirm_number       NUMBER,
   Confirm_time DATE,
   sj_suppliers VARCHAR2(32),
   Confirm_user VARCHAR2(32),
   remark      VARCHAR2(500)
);

comment on table gc_purchase_execute_confirm is'采购到货记录';
comment on column gc_purchase_execute_confirm.id is'主键';
comment on column gc_purchase_execute_confirm.detailed_id is'采购执行详单主键';
comment on column gc_purchase_execute_confirm.Confirm_number is'到货数量';
comment on column gc_purchase_execute_confirm.Confirm_time is'到货日期';
comment on column gc_purchase_execute_confirm.sj_suppliers is'实际供货商';
comment on column gc_purchase_execute_confirm.Confirm_user is'确认到货人';
comment on column gc_purchase_execute_confirm.remark is'备注';


/*==============================================================*/
/* Table: CW_EXPENSES_PLAN                                      */
/*==============================================================*/
create table CW_EXPENSES_PLAN  (
   ID        VARCHAR2(32)  primary key  not null,
   USER_ID   VARCHAR2(32)         not null,
   APPLY_TIME TIMESTAMP not null,
   ADVANCE_TIME         DATE      not null,
   TOTAL_SUM number(19,2)         not null,
   FINAL_SUM number(19,2),
   BUY       VARCHAR2(2),
   REMARK    VARCHAR2(500),
   print     TIMESTAMP,
   ADVANCE_id VARCHAR2(32)
   );

comment on table CW_EXPENSES_PLAN is'费用开支计划';
comment on column CW_EXPENSES_PLAN.ID is'费用开支计划主键';
comment on column CW_EXPENSES_PLAN.USER_ID is'用户主键';
comment on column CW_EXPENSES_PLAN.APPLY_TIME is'申请时间';
comment on column CW_EXPENSES_PLAN.ADVANCE_TIME is'预支时间';
comment on column CW_EXPENSES_PLAN.TOTAL_SUM is'申请金额';
comment on column CW_EXPENSES_PLAN.FINAL_SUM is'最终审批金额';
comment on column CW_EXPENSES_PLAN.BUY is'是否要综合办购买';
comment on column CW_EXPENSES_PLAN.REMARK is'备注';
comment on column CW_EXPENSES_PLAN.print is'打印时间';
comment on column CW_EXPENSES_PLAN.ADVANCE_id is'暂支主键';


/*==============================================================*/
/* Table: CW_EXPENSES_PLAN_DETAIL                               */
/*==============================================================*/
create table CW_EXPENSES_PLAN_DETAIL  (
   id                   VARCHAR2(32)  primary key  not null,
   EXPENSES_PLAN_ID     VARCHAR2(32),
   ITEM VARCHAR2(200)   not null,
   PLAN_MONEY           NUMBER(19,2)    not null,
   remark               VARCHAR2(500)
);

comment on table CW_EXPENSES_PLAN_DETAIL is'开支计划细项说明';
comment on column CW_EXPENSES_PLAN_DETAIL.id is'主键';
comment on column CW_EXPENSES_PLAN_DETAIL.EXPENSES_PLAN_ID is'费用开支计划主键';
comment on column CW_EXPENSES_PLAN_DETAIL.ITEM is'开支项';
comment on column CW_EXPENSES_PLAN_DETAIL.PLAN_MONEY is'开支金额';
comment on column CW_EXPENSES_PLAN_DETAIL.remark is'备注';

/*==============================================================*/
/* Table: cw_advance                                            */
/*==============================================================*/
create table cw_advance  (
   id      VARCHAR2(32)  primary key      not null,
   user_id VARCHAR2(32)       not null,
   APPLY_TIME           TIMESTAMP,
   APPLY_MONEY          NUMBER(19,2),
   ADVANCE_TYPE         VARCHAR2(32),
   APPLY_REASON         VARCHAR2(32),
   PAYEEID VARCHAR2(32),
   PAYEENAME            VARCHAR2(300),
   FUKUAN_UNIT          VARCHAR2(10)
);

comment on table cw_advance is'暂支单';
comment on column cw_advance.id is'主键';
comment on column cw_advance.user_id is'用户主键';
comment on column cw_advance.APPLY_TIME is'申请时间';
comment on column cw_advance.APPLY_MONEY is'申请金额';
comment on column cw_advance.ADVANCE_TYPE is'借支类型';
comment on column cw_advance.APPLY_REASON is'申请原因';
comment on column cw_advance.PAYEEID is'收款单位ID';
comment on column cw_advance.PAYEENAME is'收款单位';
comment on column cw_advance.FUKUAN_UNIT is'付款单位(km,kj)';

/*==============================================================*/
/* Table: cw_advance_back                                       */
/*==============================================================*/
create table cw_advance_back  (
   id         VARCHAR2(32) primary key not null,
   ADVANCE_id VARCHAR2(32) not null,
   BACKED_MONEY         NUMBER(19,2) not null,
   BACK_DATE  DATE        not null,
   REMARK     VARCHAR2(500)
);

comment on table cw_advance_back is'暂支还款';
comment on column cw_advance_back.id is'主键';
comment on column cw_advance_back.ADVANCE_id is'暂支单主键';
comment on column cw_advance_back.BACKED_MONEY is'归还金额';
comment on column cw_advance_back.BACK_DATE is'归还时间';
comment on column cw_advance_back.REMARK is'备注';



/*==============================================================*/
/* Table: cw_bill                                               */
/*==============================================================*/
create table cw_bill  (
   id      VARCHAR2(32) primary key not null,
   user_id VARCHAR2(32)       not null,
   FTYPE   VARCHAR2(32),
   STYPE   VARCHAR2(32),
   UNIT    VARCHAR2(500),
   MONEY   number(19, 2),
   PLAN_DATE     TIMESTAMP,
   INPUT_DATE    TIMESTAMP,
   CONTENT VARCHAR2(500),
   PATH    VARCHAR2(500),
   pay_UNIT VARCHAR2(10),
   num     VARCHAR2(200),
   DISGSH  VARCHAR2(200),
   SHIBH   VARCHAR2(200),
   ADDR    VARCHAR2(300),
   PHONE   VARCHAR2(100),
   KAIHH   VARCHAR2(300),
   ACCOUNT VARCHAR2(100),
   remark  VARCHAR2(500),
   STATE   VARCHAR2(10),
   REASON  VARCHAR2(500)
);

comment on table cw_bill is'开具发票记录';
comment on column cw_bill.id is'主键';
comment on column cw_bill.user_id is'用户主键';
comment on column cw_bill.FTYPE is'开具发票类型（父类：工程类(1)、其他类(3)、收据(2)）';
comment on column cw_bill.STYPE is'开具发票类型（子类：那5种增值税等）';
comment on column cw_bill.UNIT is'客户单位名称';
comment on column cw_bill.MONEY is'开具金额';
comment on column cw_bill.PLAN_DATE is'计划收款时间';
comment on column cw_bill.INPUT_DATE is'申请时间';
comment on column cw_bill.CONTENT is'开具发票内容';
comment on column cw_bill.PATH is'附件路径（针对增值税）';
comment on column cw_bill.pay_UNIT is'付款单位';
comment on column cw_bill.num is'发票号';
comment on column cw_bill.DISGSH is'地税国税号';
comment on column cw_bill.SHIBH is'纳税人识别号(针对增值税)';
comment on column cw_bill.ADDR is'地址(针对增值税)';
comment on column cw_bill.PHONE is'电话(针对增值税)';
comment on column cw_bill.KAIHH is'开户行(针对增值税)';
comment on column cw_bill.ACCOUNT is'账号(针对增值税)';
comment on column cw_bill.remark is'备注';
comment on column cw_bill.STATE is'状态';
comment on column cw_bill.REASON is'作废原因';

/*==============================================================*/
/* Table: cw_bill_receipt                                       */
/*==============================================================*/
create table cw_bill_receipt  (
   id         VARCHAR2(32)  primary key  not null,
   bill_id    VARCHAR2(32)          not null,
   MONEY      NUMBER(19,2)          not null,
   RDATE      DATE        not null,
   remark     VARCHAR2(200)
);

comment on table cw_bill_receipt is'发票收款记录';
comment on column cw_bill_receipt.id is'主键';
comment on column cw_bill_receipt.bill_id is'发票主键';
comment on column cw_bill_receipt.MONEY is'收款金额';
comment on column cw_bill_receipt.RDATE is'收款日期';
comment on column cw_bill_receipt.remark is'备注';

/*==============================================================*/
/* Table: cw_reimburse                                          */
/*==============================================================*/
create table cw_reimburse  (
   id                   VARCHAR2(32)  primary key   not null,
   user_id              VARCHAR2(32)   not null,
   project_id           VARCHAR2(32),
   APPLY_DATE           TIMESTAMP      not null,
   APPLY_MONEY          number(19,2)  not null,
   Validation_MONEY     number(19,2),
   ADVANCE_TYPE         VARCHAR2(32),
   SKDW                 VARCHAR2(500),
   FUKUAN_UNIT          VARCHAR2(10),
   remark               VARCHAR2(500),
   print                DATE,
   ZF_TIME              date,
   ZF_PERSON            VARCHAR2(32),
   ZF_REASON            VARCHAR2(300)
);

comment on table cw_reimburse is'财务报账主表';
comment on column cw_reimburse.id is'主键';
comment on column cw_reimburse.user_id is'申请人ID';
comment on column cw_reimburse.project_id is'项目ID';
comment on column cw_reimburse.APPLY_DATE is'申请时间';
comment on column cw_reimburse.APPLY_MONEY is'申请金额';
comment on column cw_reimburse.Validation_MONEY is'审定金额';
comment on column cw_reimburse.ADVANCE_TYPE is'支付方式';
comment on column cw_reimburse.SKDW is'收款单位';
comment on column cw_reimburse.FUKUAN_UNIT is'付款单位';
comment on column cw_reimburse.remark is'备注';
comment on column cw_reimburse.print is'打印时间';
comment on column cw_reimburse.ZF_TIME is'作废时间';
comment on column cw_reimburse.ZF_PERSON is'作废人';
comment on column cw_reimburse.ZF_REASON is'作废原因';


/*==============================================================*/
/* Table: cw_reimburse_detail                                   */
/*==============================================================*/
create table cw_reimburse_detail  (
   id                   VARCHAR2(32) primary key not null,
   reimburse         VARCHAR2(32)  not null,
   PAYTYPE              VARCHAR2(32)  not null,
   OTHER                VARCHAR2(200),
   PAYMONEY             number(19, 2)not null,
   DOCUMENTSNUM         NUMBER        not null,
   remark               VARCHAR2(500)
);

comment on table cw_reimburse_detail is'财务报账细项';
comment on column cw_reimburse_detail.id is'主键';
comment on column cw_reimburse_detail.reimburse is'报账主表id';
comment on column cw_reimburse_detail.PAYTYPE is'类型';
comment on column cw_reimburse_detail.OTHER is'其他类型说明';
comment on column cw_reimburse_detail.PAYMONEY is'支付金额';
comment on column cw_reimburse_detail.DOCUMENTSNUM is'单据数';
comment on column cw_reimburse_detail.remark is'备注';


/*==============================================================*/
/* Table: GC_Project_info      工程项目表                                 */
/*==============================================================*/
create table GC_Project_info  (
   Project_ID           VARCHAR2(50 char) primary key not null,
   Project_Name         VARCHAR(100),
   Sales_Manager        VARCHAR(20),
   Customer             VARCHAR(100),
   Contacts             VARCHAR(20),
   Contact_Phone        VARCHAR(20),
   Agreement_Number     VARCHAR(50),
   Money_Amount         NUMBER,
   Project_Manager      VARCHAR(20),
   Project_Status       VARCHAR(10)
);

comment on table GC_Project_info is '工程项目表/该表应该有销售、工程两个部门逐步完善';
comment on column GC_Project_info.Project_ID is '项目编号';
comment on column GC_Project_info.Project_Name is '项目名称';
comment on column GC_Project_info.Sales_Manager is '销售经理';
comment on column GC_Project_info.Customer is '客户名称';
comment on column GC_Project_info.Contacts is '联系人';
comment on column GC_Project_info.Contact_Phone is '联系电话';
comment on column GC_Project_info.Agreement_Number is '合同编号';
comment on column GC_Project_info.Money_Amount is '合同金额';
comment on column GC_Project_info.Project_Manager is '项目经理';
comment on column GC_Project_info.Project_Status is '项目状态';



/*==============================================================*/
/* Table: GC_safety_check                                   */
/*==============================================================*/
create table GC_safety_check  (
   Safe_inspection_ID   VARCHAR2(50 CHAR)   primary key   not null,
   Project_ID           VARCHAR2(50 char),
   Engineering          VARCHAR(100),
   Project_Manager      VARCHAR(100),
   Construction_Team    VARCHAR(50),
   Quality_man          VARCHAR(500),
   Inspection_Place     VARCHAR(500),
   question             VARCHAR(500),
   Implement_person     VARCHAR(20),
   Conclusion           VARCHAR(500),
   Quality_Date         DATE
);

comment on table GC_safety_check is '施工安全检查记录表';
comment on column GC_safety_check.Safe_inspection_ID is '巡检编号';
comment on column GC_safety_check.Project_ID is '项目编号';
comment on column GC_safety_check.Engineering is '工程名称';
comment on column GC_safety_check.Project_Manager is '参检人员';
comment on column GC_safety_check.Construction_Team is '检查类别';
comment on column GC_safety_check.Quality_man is '检查内容';
comment on column GC_safety_check.Inspection_Place is '存在隐患';
comment on column GC_safety_check.question is '整改措施';
comment on column GC_safety_check.Implement_person is '落实人';
comment on column GC_safety_check.Conclusion is '检查结论';
comment on column GC_safety_check.Quality_Date is '检查日期';



/*==============================================================*/
/* Table: GC_Quality_check                                      */
/*==============================================================*/
create table GC_Quality_check  (
   Quality_inspection_ID VARCHAR2(50 CHAR)   primary key not null,
   Project_ID           VARCHAR2(50 char),
   Engineering          VARCHAR(100),
   Project_Manager      VARCHAR(20),
   Construction_Team    VARCHAR(50),
   Quality_person       VARCHAR(20),
   Inspection_Place     VARCHAR(100),
   question             VARCHAR(500),
   Quality_Date         DATE
);

comment on table GC_Quality_check is '质量管理检查记录表';
comment on column GC_Quality_check.Quality_inspection_ID is '巡检编号';
comment on column GC_Quality_check.Project_ID is '项目编号';
comment on column GC_Quality_check.Engineering is '工程名称';
comment on column GC_Quality_check.Project_Manager is '项目经理';
comment on column GC_Quality_check.Construction_Team is '操作组';
comment on column GC_Quality_check.Quality_person is '质检员';
comment on column GC_Quality_check.Inspection_Place is '检查地点';
comment on column GC_Quality_check.question is '问题描述';
comment on column GC_Quality_check.Quality_Date is '巡检日期';

create table GC_Quality_check  (
   Quality_inspection_ID VARCHAR2(50 CHAR)   primary key not null,
   Project_ID           VARCHAR2(50 char),
   Engineering          VARCHAR(100),
   Project_Manager      VARCHAR(20),
   Construction_Team    VARCHAR(50),
   Quality_person       VARCHAR(20),
   Inspection_Place     VARCHAR(100),
   question             VARCHAR(500),
   Quality_Date         DATE
);

comment on table GC_Quality_check is '质量管理检查记录表';
comment on column GC_Quality_check.Quality_inspection_ID is '巡检编号';
comment on column GC_Quality_check.Project_ID is '项目编号';
comment on column GC_Quality_check.Engineering is '工程名称';
comment on column GC_Quality_check.Project_Manager is '项目经理';
comment on column GC_Quality_check.Construction_Team is '操作组';
comment on column GC_Quality_check.Quality_person is '质检员';
comment on column GC_Quality_check.Inspection_Place is '检查地点';
comment on column GC_Quality_check.question is '问题描述';
comment on column GC_Quality_check.Quality_Date is '巡检日期';

/*==============================================================*/
/* Table: XSB_Transfer                                           */
/*==============================================================*/
create table XSB_Transfer  (
   Transfer_ID          VARCHAR2(50 char) primary key  not null,
   Project_ID           VARCHAR2(50 char),
   Operator             VARCHAR(15),
   Transfer_Date        DATE,
   Remarks              VARCHAR(200)
);


comment on table XSB_Transfer is '销售移交记录表';
comment on column XSB_Transfer.Transfer_ID is '交底记录编号';
comment on column XSB_Transfer.Project_ID is '项目编号';
comment on column XSB_Transfer.Operator is '经办人';
comment on column XSB_Transfer.Transfer_Date is '交底日期';
comment on column XSB_Transfer.Remarks is '备注说明';


/*==============================================================*/
/* Table: GC_Project_Task                                       */
/*==============================================================*/
create table GC_Project_Task  (
   Trask_ID             VARCHAR2(50 char)               not null,
   Project_ID           VARCHAR2(50 char),
   Total_cost           NUMBER,
   Responsible          VARCHAR(20),
   constraint PK_GC_PROJECT_TASK primary key (Trask_ID)
);

comment on table GC_Project_Task is '项目任务表';
comment on column GC_Project_Task.Trask_ID is '任务编号';
comment on column GC_Project_Task.Project_ID is '项目编号';
comment on column GC_Project_Task.Total_cost is '费用总额';
comment on column GC_Project_Task.Responsible is '责任人';

/*==============================================================*/
/* Table: JS_Transfer                                           */
/*==============================================================*/
create table JS_Transfer  (
   Transfer_ID          VARCHAR2(50 char)               not null,
   Project_ID           VARCHAR2(50 char),
   Transfer_Tiem        DATE,
   Lecturer             VARCHAR(20),
   Remarks              VARCHAR(500),
   constraint PK_JS_Transfer primary key (Transfer_ID)
);

comment on table JS_Transfer is '技术交底记录';

comment on column JS_Transfer.Transfer_ID is '交底记录编号';

comment on column JS_Transfer.Project_ID is '项目编号';

comment on column JS_Transfer.Transfer_Tiem is '交底时间';

comment on column JS_Transfer.Lecturer is '交底人';

comment on column JS_Transfer.Remarks is '备注说明';

/*==============================================================*/
/* Table: GC_Safe_Education                                     */
/*==============================================================*/
create table GC_Safe_Education  (
   Safe_Education_ID    VARCHAR2(50 CHAR)               not null,
   Engineering          VARCHAR(100),
   Project_ID           VARCHAR2(50 char),
   Lecturer             VARCHAR(20),
   Trainee              VARCHAR(20),
   Education_Date       TIMESTAMP,
   Education_Type       VARCHAR(10),
   Education_content    VARCHAR(500),
   constraint PK_GC_SAFE_EDUCATION primary key (Safe_Education_ID)
);

comment on table GC_Safe_Education is '安全教育记录';

comment on column GC_Safe_Education.Safe_Education_ID is '安全教育编号';

comment on column GC_Safe_Education.Engineering is '工程名称';

comment on column GC_Safe_Education.Project_ID is '项目编号';

comment on column GC_Safe_Education.Lecturer is '主讲人';

comment on column GC_Safe_Education.Trainee is '受教育人';

comment on column GC_Safe_Education.Education_Date is '培训日期';

comment on column GC_Safe_Education.Education_Type is '培训类别';

comment on column GC_Safe_Education.Education_content is '教育内容';

/*==============================================================*/
/* Table: GC_Budget_approval                                    */
/*==============================================================*/
create table GC_Budget_approval  (
   审批单号                 VARCHAR2(50 char)               not null,
   Project_ID           VARCHAR2(50 char),
   建设单位                 VARCHAR(100),
   编制说明                 VARCHAR(1000),
   编制人                  VARCHAR(20),
   编制日期                 DATE,
   审核意见                 VARCHAR(500),
   审核人                  VARCHAR(20),
   审核日期                 DATE,
   财务意见                 VARCHAR(500),
   经办人                  VARCHAR(20),
   经办日期                 DATE,
   审批意见                 VARCHAR(500),
   批准人                  VARCHAR(20),
   批准日期                 DATE,
   constraint PK_GC_BUDGET_APPROVAL primary key (审批单号)
);

comment on table GC_Budget_approval is '预算审批表、附件预算汇总表';

comment on column GC_Budget_approval.审批单号 is '审批单号';

comment on column GC_Budget_approval.Project_ID is '项目编号';

comment on column GC_Budget_approval.建设单位 is '建设单位';

comment on column GC_Budget_approval.编制说明 is '编制说明';

comment on column GC_Budget_approval.编制人 is '编制人';

comment on column GC_Budget_approval.编制日期 is '编制日期';

comment on column GC_Budget_approval.审核意见 is '审核意见';

comment on column GC_Budget_approval.审核人 is '审核人';

comment on column GC_Budget_approval.审核日期 is '审核日期';

comment on column GC_Budget_approval.财务意见 is '财务意见';

comment on column GC_Budget_approval.经办人 is '经办人';

comment on column GC_Budget_approval.经办日期 is '经办日期';

comment on column GC_Budget_approval.审批意见 is '审批意见';

comment on column GC_Budget_approval.批准人 is '批准人';

comment on column GC_Budget_approval.批准日期 is '批准日期';

/*==============================================================*/
/* Table: GC_Material_base                                      */
/*==============================================================*/
create table GC_Material_base  (
   material_ID          VARCHAR2(50 CHAR)               not null,
   Project_ID           VARCHAR2(50 char),
   material_Name        VARCHAR(50),
   Brand                VARCHAR(20),
   Model                VARCHAR(20),
   Parameter            VARCHAR(200),
   Unit                 VARCHAR(20),
   Design_Amount        NUMBER,
   Purchase_Amount      NUMBER,
   Receive_Amount       NUMBER,
   Install_Amount       NUMBER,
   Transfer_Amount      NUMBER,
   constraint PK_GC_MATERIAL_BASE primary key (material_ID)
);

comment on table GC_Material_base is '项目材料审计表';

comment on column GC_Material_base.material_ID is '材料编号';

comment on column GC_Material_base.Project_ID is '项目编号';

comment on column GC_Material_base.material_Name is '设备名称';

comment on column GC_Material_base.Brand is '品牌';

comment on column GC_Material_base.Model is '规格型号';

comment on column GC_Material_base.Parameter is '技术参数';

comment on column GC_Material_base.Unit is '单位';

comment on column GC_Material_base.Design_Amount is '设计数量';

comment on column GC_Material_base.Purchase_Amount is '采购数量';

comment on column GC_Material_base.Receive_Amount is '实到数量';

comment on column GC_Material_base.Install_Amount is '安装数量';

comment on column GC_Material_base.Transfer_Amount is '移交数量';


/*==============================================================*/
/* Table: GC_project_schedule                                */
/*==============================================================*/
create table GC_project_schedule  (
    project_schedule_ID VARCHAR2(50 CHAR)               not null,
   Project_ID           VARCHAR2(50 char),
   Start_Date           DATE,
   End_Date             DATE,
   Image_progress       NUMBER,
   constraint PK_GC_project_schedule primary key ( project_schedule_ID)
);

comment on table GC_project_schedule is '项目进度报告';

comment on column GC_project_schedule. project_schedule_ID is '报告编号';

comment on column GC_project_schedule.Project_ID is '项目编号';

comment on column GC_project_schedule.Start_Date is '开始日期';

comment on column GC_project_schedule.End_Date is '截止日期';

comment on column GC_project_schedule.Image_progress is '月形象进度';

/*==============================================================*/
/* Table: GC_PROJECT_SCHEDULE_DETAIL                         */
/*==============================================================*/
create table GC_PROJECT_SCHEDULE_DETAIL  (
   Progress_List_ID     VARCHAR2(50 CHAR)               not null,
   Progress_statistics_ID VARCHAR2(50 CHAR),
   material             VARCHAR(50),
   Brand                VARCHAR(20),
   Specifications       VARCHAR(20),
   Unit                 VARCHAR(10),
   Amount               NUMBER,
   Position             VARCHAR(50),
   Remarks              VARCHAR(200),
   constraint PK_GC_PROJECT_SCHEDULE_DETAIL primary key (Progress_List_ID)
);

comment on table GC_PROJECT_SCHEDULE_DETAIL is '进度明细表';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Progress_List_ID is '明细编号';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Progress_statistics_ID is '报告编号';

comment on column GC_PROJECT_SCHEDULE_DETAIL.material is '材料名称';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Brand is '品牌';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Specifications is '规格';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Unit is '单位';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Amount is '数量';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Position is '使用部位';

comment on column GC_PROJECT_SCHEDULE_DETAIL.Remarks is '备注';



/*==============================================================*/
/* Table: gc_cost_approval                                      */
/*==============================================================*/
create table gc_cost_approval  (
   核定编号                 VARCHAR2(50 CHAR)               not null,
   Project_ID           VARCHAR2(50 char),
   审定施工费                NUMBER,
   增减变更金额               NUMBER,
   管网进度                 NUMBER,
   线缆进度                 NUMBER,
   设备进度                 NUMBER,
   总体进度                 NUMBER,
   constraint PK_GC_COST_APPROVAL primary key (核定编号)
);

comment on table gc_cost_approval is '工程费用核定表';

comment on column gc_cost_approval.核定编号 is '核定编号';

comment on column gc_cost_approval.Project_ID is '项目编号';

comment on column gc_cost_approval.审定施工费 is '审定施工费';

comment on column gc_cost_approval.增减变更金额 is '增减变更金额';

comment on column gc_cost_approval.管网进度 is '管网进度';

comment on column gc_cost_approval.线缆进度 is '线缆进度';

comment on column gc_cost_approval.设备进度 is '设备进度';

comment on column gc_cost_approval.总体进度 is '总体进度';



/*==============================================================*/
/* Table: GC_Wages_Declare                                      */
/*==============================================================*/
create table GC_Wages_Declare  (
   Wages_Declare_ID     VARCHAR2(50 CHAR)               not null,
   Project_ID           VARCHAR2(50 char),
   Month                VARCHAR(50),
   Amount               NUMBER,
   Guarantee_Money      NUMBER,
   Mutual_Money         NUMBER,
   Construction_Team    VARCHAR(20),
   Declare              VARCHAR(20),
   Declare_Date         DATE,
   Remarks              VARCHAR(500),
   Project_Opinion      VARCHAR(200),
   Department_Opinion   VARCHAR(200),
   Company_Opinion      VARCHAR(200),
   constraint PK_GC_WAGES_DECLARE primary key (Wages_Declare_ID)
);

comment on table GC_Wages_Declare is '工资申报表';

comment on column GC_Wages_Declare.Wages_Declare_ID is '申报编号';

comment on column GC_Wages_Declare.Project_ID is '项目编号';

comment on column GC_Wages_Declare.Month is '月份';

comment on column GC_Wages_Declare.Amount is '本次申报金额';

comment on column GC_Wages_Declare.Guarantee_Money is '质保金';

comment on column GC_Wages_Declare.Mutual_Money is '安全互助金';

comment on column GC_Wages_Declare.Construction_Team is '施工队';

comment on column GC_Wages_Declare.Declare is '申报人';

comment on column GC_Wages_Declare.Declare_Date is '申报日期';

comment on column GC_Wages_Declare.Remarks is '备注';

comment on column GC_Wages_Declare.Project_Opinion is '项目经理审核';

comment on column GC_Wages_Declare.Department_Opinion is '部门经理审核';

comment on column GC_Wages_Declare.Company_Opinion is '分管领导审核';




/*==============================================================*/
/* Table: 公告管理                                   */
/*==============================================================*/
create table hr_notice  (
   ID     VARCHAR2(50 CHAR)  primary key   not null,
   notice_title     VARCHAR2(250 char),
   notice_files     VARCHAR(200),
   notice_type      VARCHAR(200),
   notice_Remarks   VARCHAR(500),
   notice_files_num   VARCHAR(200),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);



/*==============================================================*/
/* Table: 公告管理附件表                                   */
/*==============================================================*/
create table hr_notice_files  (
   ID     VARCHAR2(50 CHAR)  primary key   not null,
   notice_id     VARCHAR2(250 char),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

/*==============================================================*/
/* Table: XSB_Transfer_files  项目交底附件表                                           */
/*==============================================================*/
create table XSB_Transfer_files  (
   ID          VARCHAR2(50 char) primary key  not null,
   Project_ID           VARCHAR2(50 char),
   Remarks              VARCHAR(200),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);


/*==============================================================*/
/* Table: JS_Transfer_files  项目交底附件表                                           */
/*==============================================================*/
create table JS_Transfer_files  (
   ID          VARCHAR2(50 char) primary key  not null,
   Project_ID           VARCHAR2(50 char),
   Remarks              VARCHAR(200),
   create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);

/*==============================================================*/
/* Table: hr_person_info                                        */
/*==============================================================*/
create table hr_person_info  (
   id                   NVARCHAR2(32)              not null,
   sex                  NVARCHAR2(32),
   birthday             TIMESTAMP,
   native_place         NVARCHAR2(32),
   nation               NVARCHAR2(32),
   health               NVARCHAR2(32),
   education            NVARCHAR2(32),
   politics             NVARCHAR2(32),
   ismarried            NVARCHAR2(32),
   second_major         NVARCHAR2(32),
   id_card              NVARCHAR2(32),
   shcool               NVARCHAR2(32),
   major                NVARCHAR2(32),
   expect_salary        NVARCHAR2(32),
   min_salary           NVARCHAR2(32),
   now_unit             NVARCHAR2(32),
   work_state           NVARCHAR2(32),
   Leave_reason         NVARCHAR2(32),
   arrival_date         NVARCHAR2(32),
   home_addr            NVARCHAR2(32),
   home_phone           NVARCHAR2(32),
   contact              NVARCHAR2(32),
   job_id               NVARCHAR2(32),
   family_id            NVARCHAR2(32),
   person_state         NVARCHAR2(32),
   constraint PK_HR_PERSON_INFO primary key (id)
);

comment on table hr_person_info is '员工人才信息表';

comment on column hr_person_info.id is 'id';

comment on column hr_person_info.sex is '性别';

comment on column hr_person_info.birthday is '出生日期';

comment on column hr_person_info.native_place is '籍贯';

comment on column hr_person_info.nation is '民族';

comment on column hr_person_info.health is '健康状况';

comment on column hr_person_info.education is '学历';

comment on column hr_person_info.politics is '政治面貌';

comment on column hr_person_info.ismarried is '婚否';

comment on column hr_person_info.second_major is '第二学历/专业';

comment on column hr_person_info.id_card is '身份证号';

comment on column hr_person_info.shcool is '毕业学校';

comment on column hr_person_info.major is '专业';

comment on column hr_person_info.expect_salary is '希望待遇';

comment on column hr_person_info.min_salary is '最低试用期工资';

comment on column hr_person_info.now_unit is '现工作单位';

comment on column hr_person_info.work_state is '现职业状况';

comment on column hr_person_info.Leave_reason is '离职原因';

comment on column hr_person_info.arrival_date is '可到岗日期';

comment on column hr_person_info.home_addr is '家庭住址';

comment on column hr_person_info.home_phone is '家庭电话';

comment on column hr_person_info.contact is '紧急联系人';

comment on column hr_person_info.job_id is '工作简历';

comment on column hr_person_info.family_id is '家庭成员';

comment on column hr_person_info.person_state is '人员状态';


/*==============================================================*/
/* Table: HR_FAMILY                                             */
/*==============================================================*/
create table HR_FAMILY  (
   id                   NVARCHAR2(32)                   not null,
   person_id            NVARCHAR2(32),
   appellation          NVARCHAR2(32),
   name                 NVARCHAR2(32),
   work_unit            NVARCHAR2(255),
   phone                NVARCHAR2(32),
   depar                NVARCHAR2(255),
   position             NVARCHAR2(32),
   addr                 NVARCHAR2(255),
   remark               NVARCHAR2(255),
   constraint PK_HR_FAMILY primary key (id)
);

comment on table HR_FAMILY is '家庭成员';

comment on column HR_FAMILY.id is 'id';

comment on column HR_FAMILY.person_id is '人员id';

comment on column HR_FAMILY.appellation is '称谓';

comment on column HR_FAMILY.name is '姓名';

comment on column HR_FAMILY.work_unit is '工作单位';

comment on column HR_FAMILY.phone is '联系方式';

comment on column HR_FAMILY.depar is '部门';

comment on column HR_FAMILY.position is '职务';

comment on column HR_FAMILY.addr is '住址';

comment on column HR_FAMILY.remark is '备注';


/*==============================================================*/
/* Table: hr_work_exp                                           */
/*==============================================================*/
create table hr_work_exp  (
   id                   NVARCHAR2(32),
   person_id            NVARCHAR2(32),
   unit                 NVARCHAR2(32),
   position             NVARCHAR2(32),
   certifier            NVARCHAR2(32),
   phone                NVARCHAR2(32),
   begin_date           DATE,
   end_date             DATE,
   leave_reason         NVARCHAR2(255),
   remark               NVARCHAR2(255)
);

comment on table hr_work_exp is '工作履历';

comment on column hr_work_exp.id is 'id';

comment on column hr_work_exp.person_id is '人员id';

comment on column hr_work_exp.unit is '单位';

comment on column hr_work_exp.position is '职务';

comment on column hr_work_exp.certifier is '证明人';

comment on column hr_work_exp.phone is '联系方式';

comment on column hr_work_exp.begin_date is '开始时间';

comment on column hr_work_exp.end_date is '结束时间';

comment on column hr_work_exp.leave_reason is '离职愿意';

comment on column hr_work_exp.remark is '备注';

/*==============================================================*/
/* Table: hr_reward                                             */
/*==============================================================*/
create table hr_reward  (
   id                   NVARCHAR2(32)                   not null,
   person_id            NVARCHAR2(32),
   reward_type          NVARCHAR2(32),
   name                 NVARCHAR2(32),
   reward_date          date,
   reward_files         NVARCHAR2(32),
   remark               NVARCHAR2(32),
   constraint PK_HR_REWARD primary key (id)
);

comment on table hr_reward is '奖惩信息';

comment on column hr_reward.id is 'id';

comment on column hr_reward.person_id is '人员id';

comment on column hr_reward.reward_type is '类型';

comment on column hr_reward.name is '名称';

comment on column hr_reward.reward_date is '日期';

comment on column hr_reward.reward_files is '相关资料';

comment on column hr_reward.remark is '备注';


/*==============================================================*/
/* Table: hr_person_contract                                    */
/*==============================================================*/
create table hr_person_contract  (
   id                   NVARCHAR2(32)                   not null,
   person_id            NVARCHAR2(32),
   contract_no          NVARCHAR2(32),
   contract_type        NVARCHAR2(32),
   signed_type          NVARCHAR2(32),
   signed_date          DATE,
   begin_date           DATE,
   end_date             DATE,
   sy_bedin_date        DATE,
   sy_end_date          DATE,
   over_contract_date   DATE,
   compensation         NUMBER,
   breach               number,
   contract_files       NVARCHAR2(32),
   remark               NVARCHAR2(255),
   constraint PK_HR_PERSON_CONTRACT primary key (id)
);

comment on table hr_person_contract is '个人合同信息';

comment on column hr_person_contract.id is 'id';

comment on column hr_person_contract.person_id is '人员id';

comment on column hr_person_contract.contract_no is '合同编号';

comment on column hr_person_contract.contract_type is '合同类型';

comment on column hr_person_contract.signed_type is '签订方式';

comment on column hr_person_contract.signed_date is '签订日期';

comment on column hr_person_contract.begin_date is '开始时间';

comment on column hr_person_contract.end_date is '结束时间';

comment on column hr_person_contract.sy_bedin_date is '试用期开始时间';

comment on column hr_person_contract.sy_end_date is '试用期结束时间';

comment on column hr_person_contract.over_contract_date is '合同解除/终止时间';

comment on column hr_person_contract.compensation is '补偿金额';

comment on column hr_person_contract.breach is '违约金额';

comment on column hr_person_contract.contract_files is '附件';

comment on column hr_person_contract.remark is '备注';

/*==============================================================*/
/* Table: hr_leave_office                                       */
/*==============================================================*/
create table hr_leave_office  (
   id                   NVARCHAR2(32),
   person_id            NVARCHAR2(32),
   depart_id            NVARCHAR2(32),
   apply_type           date,
   state                NVARCHAR2(32),
   leave_reason         NVARCHAR2(32),
   process_id           NVARCHAR2(32)
);

comment on table hr_leave_office is '人员离职表';

comment on column hr_leave_office.id is 'id';

comment on column hr_leave_office.person_id is '人员id';

comment on column hr_leave_office.depart_id is '部门id';

comment on column hr_leave_office.apply_type is '申请时间';

comment on column hr_leave_office.state is '审核状态';

comment on column hr_leave_office.leave_reason is '离职原因';

comment on column hr_leave_office.process_id is '流程id';

/*==============================================================*/
/* Table: hr_education                                          */
/*==============================================================*/
create table hr_education  (
   id                   NVARCHAR2(32)                   not null,
   person_id            NVARCHAR2(32),
   education            NVARCHAR2(32),
   shcool               NVARCHAR2(32),
   major                NVARCHAR2(32),
   begin_date           date,
   end_date             date,
   edu_type             NVARCHAR2(32),
   isgradua             NVARCHAR2(32),
   card_pic             NVARCHAR2(32),
   degree               NVARCHAR2(32),
   Certificate_no       NVARCHAR2(32),
   remark               NVARCHAR2(32),
   constraint PK_HR_EDUCATION primary key (id)
);

comment on table hr_education is '员工学历信息';

comment on column hr_education.id is 'id';

comment on column hr_education.person_id is '人员id';

comment on column hr_education.education is '学历';

comment on column hr_education.shcool is '学校';

comment on column hr_education.major is '专业';

comment on column hr_education.begin_date is '开始时间';

comment on column hr_education.end_date is '结束时间';

comment on column hr_education.edu_type is '学历类型';

comment on column hr_education.isgradua is '毕业/结业';

comment on column hr_education.card_pic is '证件照';

comment on column hr_education.degree is '学位';

comment on column hr_education.Certificate_no is '证书编号';

comment on column hr_education.remark is '备注';

/*==============================================================*/
/* Table: hr_person_change                                      */
/*==============================================================*/
create table hr_person_change  (
   id                   NVARCHAR2(32)                   not null,
   person_id            NVARCHAR2(32),
   before_unit          NVARCHAR2(32),
   before_depart        NVARCHAR2(32),
   before_job           NVARCHAR2(32),
   before_level         NVARCHAR2(32),
   after_unir           NVARCHAR2(32),
   after_depart         NVARCHAR2(32),
   after_job            NVARCHAR2(32),
   after_level          NVARCHAR2(32),
   change_type          NVARCHAR2(32),
   change_date          TIMESTAMP,
   change_files         NVARCHAR2(32),
   explain              NVARCHAR2(255),
   before_state         NVARCHAR2(32),
   after_state          NVARCHAR2(32),
   remark               NVARCHAR2(255),
   constraint PK_HR_PERSON_CHANGE primary key (id)
);

comment on table hr_person_change is '内部人事变动信息';

comment on column hr_person_change.id is 'id';

comment on column hr_person_change.person_id is '人员id';

comment on column hr_person_change.before_unit is '变动前单位';

comment on column hr_person_change.before_depart is '变动前部门';

comment on column hr_person_change.before_job is '变动前岗位';

comment on column hr_person_change.before_level is '变动前行政级别';

comment on column hr_person_change.after_unir is '变动后单位';

comment on column hr_person_change.after_depart is '变动后部门';

comment on column hr_person_change.after_job is '变动后岗位';

comment on column hr_person_change.after_level is '变动后行政级别';

comment on column hr_person_change.change_type is '变动类型';

comment on column hr_person_change.change_date is '变动日期';

comment on column hr_person_change.change_files is '附件';

comment on column hr_person_change.explain is '说明';

comment on column hr_person_change.before_state is '变动前状态';

comment on column hr_person_change.after_state is '变动后状态';

comment on column hr_person_change.remark is '备注';


/*==============================================================*/
/* Table:hr_interview                                      */
/*==============================================================*/
create table hr_interview
(
  id            VARCHAR2(80) primary key not null,
  p_id          VARCHAR2(80) not null,
  want_pay      VARCHAR2(80),
  pay_underline VARCHAR2(80),
  position      VARCHAR2(160),
  about_pst     VARCHAR2(600),
  superiority   VARCHAR2(600),
  unit_now      VARCHAR2(200),
  u_status      VARCHAR2(200),
  reason_l      VARCHAR2(600),
  pos_time      VARCHAR2(40),
  character     VARCHAR2(400),
  form          VARCHAR2(400),
  manner        VARCHAR2(400),
  expression    VARCHAR2(400),
  deal_ab       VARCHAR2(400),
  exp_ab        VARCHAR2(200),
  u_scale       NUMBER,
  p_scale       NUMBER,
  m_scale       NUMBER,
  r_scale       NUMBER,
  other         VARCHAR2(200),
  o_scale       NUMBER,
  anti_pres     VARCHAR2(400),
  extract_way   VARCHAR2(400),
  willpower     VARCHAR2(400),
  back          VARCHAR2(600),
  examine       VARCHAR2(600),
  result        VARCHAR2(40),
  language      VARCHAR2(400),
  voice         VARCHAR2(400),
  behavior      VARCHAR2(400),
  listen        VARCHAR2(400),
  thinking      VARCHAR2(400),
  o_character   VARCHAR2(400),
  o_language    VARCHAR2(400),
  o_form        VARCHAR2(400),
  o_manner      VARCHAR2(400),
  o_behavior    VARCHAR2(400),
  o_expression  VARCHAR2(400),
  o_deal_ab     VARCHAR2(400),
  o_listen      VARCHAR2(400),
  o_thinking    VARCHAR2(400),
  entry_pay     NUMBER,
  entry_date    DATE
)
-- Add comments to the table 
comment on table hr_interview
  is '应聘人员面试表';
-- Add comments to the columns 
comment on column hr_interview.id
  is '主键';
comment on column hr_interview.p_id
  is '人员编号';
comment on column hr_interview.want_pay
  is '希望待遇';
comment on column hr_interview.pay_underline
  is '待遇底线';
comment on column hr_interview.position
  is '应聘岗位';
comment on column hr_interview.about_pst
  is '对岗位的认识';
comment on column hr_interview.superiority
  is '优势特点';
comment on column hr_interview.unit_now
  is '现工作单位';
comment on column hr_interview.u_status
  is '现职业状况';
comment on column hr_interview.reason_l
  is '离职原因';
comment on column hr_interview.pos_time
  is '到岗时间';
comment on column hr_interview.character
  is '性格';
comment on column hr_interview.form
  is '形象气质';
comment on column hr_interview.manner
  is '态度举止';
comment on column hr_interview.expression
  is '表达方式';
comment on column hr_interview.deal_ab
  is '问题解决能力';
comment on column hr_interview.exp_ab
  is '表达能力';
comment on column hr_interview.u_scale
  is '公司比重';
comment on column hr_interview.p_scale
  is '个人比重';
comment on column hr_interview.m_scale
  is '薪酬比重';
comment on column hr_interview.r_scale
  is '人际比重';
comment on column hr_interview.other
  is '其他';
comment on column hr_interview.o_scale
  is '其他比重';
comment on column hr_interview.anti_pres
  is '抗压能力';
comment on column hr_interview.extract_way
  is '解压方式';
comment on column hr_interview.willpower
  is '吃苦能力';
comment on column hr_interview.back
  is '其他描述';
comment on column hr_interview.examine
  is '考题方案评价';
comment on column hr_interview.result
  is '结果';
comment on column hr_interview.language
  is '语言';
comment on column hr_interview.voice
  is '声音';
comment on column hr_interview.behavior
  is '行为';
comment on column hr_interview.listen
  is '倾听能力';
comment on column hr_interview.thinking
  is '思维能力';
comment on column hr_interview.o_character
  is '性格补充';
comment on column hr_interview.o_language
  is '语言补充';
comment on column hr_interview.o_form
  is '形象气质补充';
comment on column hr_interview.o_manner
  is '态度举止补充';
comment on column hr_interview.o_behavior
  is '行为补充';
comment on column hr_interview.o_expression
  is '表达方式补充';
comment on column hr_interview.o_deal_ab
  is '解决能力补充';
comment on column hr_interview.o_listen
  is '倾听补充';
comment on column hr_interview.o_thinking
  is '思维补充';
comment on column hr_interview.entry_pay
  is '试用工资';
comment on column hr_interview.entry_date
  is '试用期';
  
  -- Create table
create table HR_CERTIFICATE
(
  id         VARCHAR2(100) primary key not null,
  p_id       VARCHAR2(100) not null,
  cert_type  VARCHAR2(20),
  diaplay    VARCHAR2(2),
  ming_cheng VARCHAR2(100),
  cert_level VARCHAR2(20),
  zhuang_ye  VARCHAR2(100),
  major_type VARCHAR2(50),
  bian_hao   VARCHAR2(50),
  rd_time    DATE,
  xq_s_time  DATE,
  xq_e_time  DATE,
  bao_guan   VARCHAR2(300),
  ti_xing    VARCHAR2(2),
  zheng_jian VARCHAR2(500),
  remark     VARCHAR2(1000),
  nian_jian  VARCHAR2(2),
  fa_zheng   VARCHAR2(300)
);
-- Add comments to the table 
comment on table HR_CERTIFICATE
  is '证书管理';
-- Add comments to the columns 
comment on column HR_CERTIFICATE.id
  is '主键';
comment on column HR_CERTIFICATE.p_id
  is '员工编号';
comment on column HR_CERTIFICATE.cert_type
  is '证书分类';
comment on column HR_CERTIFICATE.diaplay
  is '是否主页显示';
comment on column HR_CERTIFICATE.ming_cheng
  is '证书名称';
comment on column HR_CERTIFICATE.cert_level
  is '证书级别';
comment on column HR_CERTIFICATE.zhuang_ye
  is '证书专业';
comment on column HR_CERTIFICATE.major_type
  is '证书类型';
comment on column HR_CERTIFICATE.bian_hao
  is '证书编号';
comment on column HR_CERTIFICATE.rd_time
  is '认定时间';
comment on column HR_CERTIFICATE.xq_s_time
  is '有效期开始';
comment on column HR_CERTIFICATE.xq_e_time
  is '有效期结束';
comment on column HR_CERTIFICATE.bao_guan
  is '证书保管部门';
comment on column HR_CERTIFICATE.ti_xing
  is '是否到期提醒';
comment on column HR_CERTIFICATE.zheng_jian
  is '证件扫描件';
comment on column HR_CERTIFICATE.remark
  is '备注';
comment on column HR_CERTIFICATE.nian_jian
  is '是否年检提醒';
comment on column HR_CERTIFICATE.fa_zheng
  is '发证部门';

  
  -- Create table
create table HR_EVALUATION
(
  id                VARCHAR2(200) primary key not null,
  p_id              VARCHAR2(200),
  ep_id             VARCHAR2(200),
  dept_id           VARCHAR2(200),
  ev_time          DATE,
  p_quality        NUMBER,
  e_quality        VARCHAR2(200),
  p_quantity       NUMBER,
  e_quantity       VARCHAR2(200),
  p_discipline     NUMBER,
  e_discipline     VARCHAR2(200),
  p_collective     NUMBER,
  e_collective     VARCHAR2(200),
  p_positivity     NUMBER,
  e_positivity     VARCHAR2(200),
  p_responsibility NUMBER,
  e_responsibility VARCHAR2(200),
  p_knowledge      NUMBER,
  e_knowledge      VARCHAR2(200),
  p_judge          NUMBER,
  e_judge          VARCHAR2(200),
  p_plan           NUMBER,
  e_plan           VARCHAR2(200),
  p_relationships  NUMBER,
  e_relationships  VARCHAR2(200),
  p_performance    NUMBER,
  r_performance    VARCHAR2(10),
  s_performance    NUMBER,
  p_attitude       NUMBER,
  r_attitude       VARCHAR2(10),
  s_attitude       NUMBER,
  p_capability     NUMBER,
  r_capability     VARCHAR2(10),
  s_capability     NUMBER,
  s_personal       NUMBER,
  s_total          NUMBER
)

-- Add comments to the table 
comment on table HR_EVALUATION
  is '人员转正考评表';
-- Add comments to the columns 
comment on column HR_EVALUATION.id
  is '主键';
comment on column HR_EVALUATION.p_id
  is '被考评人ID';
comment on column HR_EVALUATION.ep_id
  is '考评人ID';
comment on column HR_EVALUATION.dept_id
  is '部门ID';
comment on column HR_EVALUATION.ev_time
  is '考评时间';
comment on column HR_EVALUATION.p_quality
  is '工作质量得分';
comment on column HR_EVALUATION.e_quality
  is '工作质量说明';
comment on column HR_EVALUATION.p_quantity
  is '工作数量得分';
comment on column HR_EVALUATION.e_quantity
  is '工作数量说明';
comment on column HR_EVALUATION.p_discipline
  is '纪律性得分';
comment on column HR_EVALUATION.e_discipline
  is '纪律性说明';
comment on column HR_EVALUATION.p_collective
  is '集体观念得分';
comment on column HR_EVALUATION.e_collective
  is '集体观念说明';
comment on column HR_EVALUATION.p_positivity
  is '积极性得分';
comment on column HR_EVALUATION.e_positivity
  is '积极性说明';
comment on column HR_EVALUATION.p_responsibility
  is '责任感得分';
comment on column HR_EVALUATION.e_responsibility
  is '责任感说明';
comment on column HR_EVALUATION.p_knowledge
  is '知识得分';
comment on column HR_EVALUATION.e_knowledge
  is '知识说明';
comment on column HR_EVALUATION.p_judge
  is '判断得分';
comment on column HR_EVALUATION.e_judge
  is '判断说明';
comment on column HR_EVALUATION.p_plan
  is '计划得分';
comment on column HR_EVALUATION.e_plan
  is '计划说明';
comment on column HR_EVALUATION.p_relationships
  is '人际得分';
comment on column HR_EVALUATION.e_relationships
  is '人际说明';
comment on column HR_EVALUATION.p_performance
  is '成绩得分';
comment on column HR_EVALUATION.r_performance
  is '成绩比例';
comment on column HR_EVALUATION.s_performance
  is '成绩评分';
comment on column HR_EVALUATION.p_attitude
  is '态度得分';
comment on column HR_EVALUATION.r_attitude
  is '态度比例';
comment on column HR_EVALUATION.s_attitude
  is '态度评分';
comment on column HR_EVALUATION.p_capability
  is '能力得分';
comment on column HR_EVALUATION.r_capability
  is '能力比例';
comment on column HR_EVALUATION.s_capability
  is '能力评分';
comment on column HR_EVALUATION.s_personal
  is '个人评分';
comment on column HR_EVALUATION.s_total
  is '综合评分';

  
  drop table t_s_workFlowSet cascade constraints;

/*==============================================================*/
/* Table: t_s_workFlowSet                                       */
/*==============================================================*/
create table t_s_workFlowSet  (
   id                   NVARCHAR2(32)                   not null,
   deployment_id        NVARCHAR2(255),
   process_key          NVARCHAR2(255),
   process_definition_id NVARCHAR2(255),
   begin_url            NVARCHAR2(255),
   handle_url           NVARCHAR2(255),
   detail_url           NVARCHAR2(255),
   process_type         NVARCHAR2(255),
   process_explain      NVARCHAR2(255),
   constraint PK_T_S_WORKFLOWSET primary key (id)
);

comment on table t_s_workFlowSet is '流程设置';

comment on column t_s_workFlowSet.id is 'id';

comment on column t_s_workFlowSet.deployment_id is '部署id';

comment on column t_s_workFlowSet.process_key is '流程key';

comment on column t_s_workFlowSet.process_definition_id is '流程定义id';

comment on column t_s_workFlowSet.begin_url is '开始请求';

comment on column t_s_workFlowSet.handle_url is '处理请求';

comment on column t_s_workFlowSet.detail_url is '查看请求';

comment on column t_s_workFlowSet.process_type is '流程分类';

comment on column t_s_workFlowSet.process_explain is '流程说明';


-- Create table
create table HR_VACATION_ARRANGEMENT
(
  id            VARCHAR2(200) not  primary key null,
  vacation_date DATE,
  note          VARCHAR2(200),
  create_name      VARCHAR2(50),
   create_by        VARCHAR2(50),
   create_date      DATE,
   update_name      VARCHAR2(50),
   update_by        VARCHAR2(50),
   update_date      DATE
);
-- Add comments to the table 
comment on table HR_VACATION_ARRANGEMENT
  is '法定假日安排';
-- Add comments to the columns 
comment on column HR_VACATION_ARRANGEMENT.id
  is '主键id';
comment on column HR_VACATION_ARRANGEMENT.vacation_date
  is '节假日';
comment on column HR_VACATION_ARRANGEMENT.note
  is '说明';

  
  create table hr_education_files  (
   id         NVARCHAR2(50)  primary key not null,
   education_id    VARCHAR2(50)
);
comment on table hr_education_files is '学历信息附件';
comment on column hr_education_files.id is '编号';
comment on column hr_education_files.education_id is '学历信息id';

  create table hr_certificate_files  (
   id         NVARCHAR2(50)  primary key not null,
   certificate_id    VARCHAR2(50)
);
comment on table hr_certificate_files is '证书信息附件';
comment on column hr_certificate_files.id is '编号';
comment on column hr_certificate_files.certificate_id is '证书信息id';

  create table hr_personContract_files  (
   id         NVARCHAR2(50)  primary key not null,
   personContract_id    VARCHAR2(50)
);
comment on table hr_personContract_files is '合同信息附件';
comment on column hr_personContract_files.id is '编号';
comment on column hr_personContract_files.personContract_id is '合同信息id';
