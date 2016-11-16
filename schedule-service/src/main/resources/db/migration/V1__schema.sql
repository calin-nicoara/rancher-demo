CREATE SEQUENCE appointment_seq;

create table appointment (
  id bigint not null,
  name character varying(255) NOT NULL,
  client_name character varying(255) NOT NULL,
  doctor_name character varying(255) NOT NULL
);

ALTER TABLE appointment
  ADD CONSTRAINT appointment_pkey PRIMARY KEY(id);