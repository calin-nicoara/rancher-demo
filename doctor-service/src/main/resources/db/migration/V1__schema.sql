CREATE SEQUENCE doctor_seq;

create table doctor (
  id bigint not null,
  full_name character varying(255) NOT NULL,
  speciality character varying(255) NOT NULL
);

ALTER TABLE doctor
  ADD CONSTRAINT doctor_pkey PRIMARY KEY(id);