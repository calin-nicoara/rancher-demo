CREATE SEQUENCE client_seq;

create table client (
  id bigint not null,
  full_name character varying(255) NOT NULL,
  birth_date character varying(255) NOT NULL
);

ALTER TABLE client
  ADD CONSTRAINT client_pkey PRIMARY KEY(id);