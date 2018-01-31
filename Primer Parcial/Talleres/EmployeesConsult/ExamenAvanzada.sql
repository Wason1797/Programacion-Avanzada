/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     27/11/2017 12:38:45                          */
/*==============================================================*/


drop table if exists EMPLEADO;

drop table if exists FAMILIAR;

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO
(
   ID                   int not null,
   NOMBRE               varchar(20) not null,
   DIRECCION            varchar(30),
   TELEFONO             varchar(10),
   EMAIL                varchar(20),
   TRABAJOS             varchar(50),
   FEC_NAC              date,
   primary key (ID)
);

/*==============================================================*/
/* Table: FAMILIAR                                              */
/*==============================================================*/
create table FAMILIAR
(
   ID_FAMILIAR          int not null,
   ID                   int not null,
   NOM_FAMILIAR         varchar(20),
   EDAD_ESCOLAR         varchar(20),
   FEC_NAC_FAMILIAR     date,
   GUSTOS               varchar(30),
   primary key (ID_FAMILIAR)
);

alter table FAMILIAR add constraint FK_TIENE foreign key (ID)
      references EMPLEADO (ID) on delete restrict on update restrict;

