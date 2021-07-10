--
-- PostgreSQL database dump
--

-- Dumped from database version 12.7 (Ubuntu 12.7-1.pgdg20.04+1)
-- Dumped by pg_dump version 12.7 (Ubuntu 12.7-1.pgdg20.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: postgis; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS postgis WITH SCHEMA public;


--
-- Name: EXTENSION postgis; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION postgis IS 'PostGIS geometry, geography, and raster spatial types and functions';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    ativo boolean DEFAULT true NOT NULL,
    cnpj_cpf character varying(14),
    fantasia_apelido character varying(255) NOT NULL,
    nascimento timestamp without time zone,
    razao_nome character varying(255) NOT NULL,
    rg_ie character varying(25),
    sexo character varying(255),
    tipo_pessoa character varying(255),
    users bigint NOT NULL
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- Name: clientes_enderecos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_enderecos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_enderecos_seq OWNER TO postgres;

--
-- Name: clientes_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_seq OWNER TO postgres;

--
-- Name: contato_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contato_cliente (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    contato character varying(255) NOT NULL,
    descricao character varying(45) NOT NULL,
    tipo_contato character varying(255),
    cliente bigint NOT NULL,
    users bigint NOT NULL
);


ALTER TABLE public.contato_cliente OWNER TO postgres;

--
-- Name: contato_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contato_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contato_cliente_seq OWNER TO postgres;

--
-- Name: contato_empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contato_empresa (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    contato character varying(255) NOT NULL,
    descricao character varying(45) NOT NULL,
    tipo_contato character varying(255),
    empresa bigint NOT NULL
);


ALTER TABLE public.contato_empresa OWNER TO postgres;

--
-- Name: contato_empresa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contato_empresa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contato_empresa_seq OWNER TO postgres;

--
-- Name: empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.empresa (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    cnpj character varying(14) NOT NULL,
    data_abertura timestamp without time zone,
    inscricao_estadual character varying(20) NOT NULL,
    nome_fantasia character varying(255) NOT NULL,
    razao_social character varying(255) NOT NULL,
    web_site character varying(255)
);


ALTER TABLE public.empresa OWNER TO postgres;

--
-- Name: empresa_enderecos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empresa_enderecos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empresa_enderecos_seq OWNER TO postgres;

--
-- Name: empresa_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.empresa_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.empresa_seq OWNER TO postgres;

--
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    bairro character varying(150) NOT NULL,
    cep character varying(10),
    cidade character varying(150) NOT NULL,
    gia character varying(150),
    ibge character varying(7),
    logradouro character varying(200) NOT NULL,
    uf character varying(2) NOT NULL,
    unidade character varying(150),
    users bigint NOT NULL
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- Name: endereco_clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco_clientes (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    complemento character varying(200),
    descricao character varying(150) NOT NULL,
    numero character varying(10),
    clientes bigint NOT NULL,
    endereco bigint,
    users bigint NOT NULL,
    point public.geometry(Point,4326),
    bairro character varying(150) NOT NULL,
    cep character varying(10),
    cidade character varying(150) NOT NULL,
    gia character varying(150),
    ibge character varying(7),
    logradouro character varying(200) NOT NULL,
    siafi character varying(10) NOT NULL,
    uf character varying(2) NOT NULL,
    unidade character varying(150)
);


ALTER TABLE public.endereco_clientes OWNER TO postgres;

--
-- Name: endereco_empresa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco_empresa (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    complemento character varying(200),
    descricao character varying(150) NOT NULL,
    numero character varying(10),
    empresa bigint NOT NULL,
    endereco bigint,
    users bigint NOT NULL,
    point public.geometry(Point,4326),
    bairro character varying(150) NOT NULL,
    cep character varying(10),
    cidade character varying(150) NOT NULL,
    gia character varying(150),
    ibge character varying(7),
    logradouro character varying(200) NOT NULL,
    siafi character varying(10) NOT NULL,
    uf character varying(2) NOT NULL,
    unidade character varying(150)
);


ALTER TABLE public.endereco_empresa OWNER TO postgres;

--
-- Name: endereco_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco_users (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    complemento character varying(200),
    descricao character varying(150) NOT NULL,
    numero character varying(10),
    endereco bigint,
    users_id bigint,
    point public.geometry(Point,4326),
    bairro character varying(150) NOT NULL,
    cep character varying(10),
    cidade character varying(150) NOT NULL,
    gia character varying(150),
    ibge character varying(7),
    logradouro character varying(200) NOT NULL,
    siafi character varying(10) NOT NULL,
    uf character varying(2) NOT NULL,
    unidade character varying(150)
);


ALTER TABLE public.endereco_users OWNER TO postgres;

--
-- Name: enderecos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enderecos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enderecos_seq OWNER TO postgres;

--
-- Name: parameters; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parameters (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    address_from character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    port integer NOT NULL,
    smtp character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);


ALTER TABLE public.parameters OWNER TO postgres;

--
-- Name: parameters_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.parameters_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.parameters_seq OWNER TO postgres;

--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    roles_name character varying(25) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_seq OWNER TO postgres;

--
-- Name: roles_users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles_users (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    roles bigint NOT NULL,
    users bigint NOT NULL
);


ALTER TABLE public.roles_users OWNER TO postgres;

--
-- Name: rolesusers_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rolesusers_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rolesusers_seq OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    ativo boolean NOT NULL,
    confirmed boolean NOT NULL,
    cpf character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    hash_confirm character varying(255) NOT NULL,
    nome character varying(50) NOT NULL,
    password character varying(255) NOT NULL,
    sobrenome character varying(100) NOT NULL,
    username character varying(20),
    empresa bigint
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_enderecos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_enderecos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_enderecos_seq OWNER TO postgres;

--
-- Name: users_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_seq OWNER TO postgres;

--
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (id, created_at, updated_at, ativo, cnpj_cpf, fantasia_apelido, nascimento, razao_nome, rg_ie, sexo, tipo_pessoa, users) FROM stdin;
7	2021-06-29 22:26:44.666	2021-06-29 22:56:12.789	f	20867159359	Sueli Sophia Aline Almada	1979-10-23 21:00:00	Sueli Sophia Aline Almada	376704433	FEMININO	FISICA	6
8	2021-06-30 14:31:46.996	2021-06-30 14:31:46.996	f	62156198926	Alícia Luana Nascimento	1969-11-04 21:00:00	Alícia Luana Nascimento	403897142	FEMININO	FISICA	6
9	2021-06-30 14:34:16.769	2021-06-30 14:34:16.769	f	36889987667	Mariane Clarice Pinto	1970-11-03 21:00:00	Mariane Clarice Pinto	171046626	FEMININO	FISICA	6
10	2021-06-30 14:35:51.331	2021-06-30 14:35:51.331	f	74955303242	Sabrina Renata Mariah Ribeiro	1982-09-05 21:00:00	Sabrina Renata Mariah Ribeiro	438123724	FEMININO	FISICA	6
11	2021-06-30 14:37:38.217	2021-06-30 14:37:38.217	f	50393360121	Aurora Adriana Fátima da Costa	1965-09-02 21:00:00	Aurora Adriana Fátima da Costa	431347785	FEMININO	FISICA	6
12	2021-07-01 21:29:30.936	2021-07-01 21:29:30.936	f	68945482000196	Iago e Theo Locações de Automóveis ME	2016-12-04 22:00:00	Iago e Theo Locações de Automóveis ME	023052345775	MASCULINO	JURIDICA	6
\.


--
-- Data for Name: contato_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contato_cliente (id, created_at, updated_at, contato, descricao, tipo_contato, cliente, users) FROM stdin;
1	2021-07-02 23:14:09.365	2021-07-02 23:14:09.365	49999991233	Celular WhatsApp	CELULAR	8	6
\.


--
-- Data for Name: contato_empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contato_empresa (id, created_at, updated_at, contato, descricao, tipo_contato, empresa) FROM stdin;
1	2021-07-05 10:13:08.665	2021-07-05 10:13:08.665	49999991233	Celular Diretor	CELULAR	1
2	2021-07-07 22:14:15.179	2021-07-07 22:14:15.179	perrony.ls@gmail.com	Email SAC	EMAIL	1
4	2021-07-07 22:44:58.247	2021-07-07 22:44:58.247	49999040445	Celular WhatsApp	CELULAR	1
\.


--
-- Data for Name: empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.empresa (id, created_at, updated_at, cnpj, data_abertura, inscricao_estadual, nome_fantasia, razao_social, web_site) FROM stdin;
1	2021-06-28 00:00:00	2021-06-28 00:00:00	79131303000101	2009-01-09 00:00:00	710880693	Elias e Geraldo Publicidade e Propaganda Ltda	Elias e Geraldo Publicidade e Propaganda Ltda	www.eliasegeraldopublicidadeepropagandaltda.com.br
\.


--
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco (id, created_at, updated_at, bairro, cep, cidade, gia, ibge, logradouro, uf, unidade, users) FROM stdin;
\.


--
-- Data for Name: endereco_clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco_clientes (id, created_at, updated_at, complemento, descricao, numero, clientes, endereco, users, point, bairro, cep, cidade, gia, ibge, logradouro, siafi, uf, unidade) FROM stdin;
\.


--
-- Data for Name: endereco_empresa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco_empresa (id, created_at, updated_at, complemento, descricao, numero, empresa, endereco, users, point, bairro, cep, cidade, gia, ibge, logradouro, siafi, uf, unidade) FROM stdin;
1	2021-07-06 23:08:12.307	2021-07-06 23:08:12.307	Casa	Casa em São José	200	1	\N	6	\N	Serraria	88115776	São José		4216602	Rua Flor de Maio	8327	SC	\N
2	2021-07-08 18:23:19.728	2021-07-08 18:23:19.728	Chácara	Chácara	700	1	\N	6	\N	Industrial	89520000	Curitibanos		4204806	Rod SC 120, km 222	8093	SC	\N
\.


--
-- Data for Name: endereco_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco_users (id, created_at, updated_at, complemento, descricao, numero, endereco, users_id, point, bairro, cep, cidade, gia, ibge, logradouro, siafi, uf, unidade) FROM stdin;
\.


--
-- Data for Name: parameters; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parameters (id, created_at, updated_at, address_from, password, port, smtp, username) FROM stdin;
1	2021-07-02 21:25:18.311	2021-07-02 21:25:18.311	scheffer.consultoria@gmail.com	eTJuMG8zUjQ=	587	smtp.gmail.com	scheffer.consultoria@gmail.com
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, created_at, updated_at, roles_name) FROM stdin;
1	2021-06-29 18:35:23.796	2021-06-29 18:35:23.796	GERENTE
2	2021-06-29 19:40:15.248	2021-06-29 19:40:15.248	VENDEDOR
3	2021-07-02 21:38:32.99	2021-07-02 21:38:32.99	ADMIN
4	2021-07-02 21:39:11.482	2021-07-02 21:39:11.482	FINANCEIRO
\.


--
-- Data for Name: roles_users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles_users (id, created_at, updated_at, roles, users) FROM stdin;
\.


--
-- Data for Name: spatial_ref_sys; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spatial_ref_sys (srid, auth_name, auth_srid, srtext, proj4text) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, created_at, updated_at, ativo, confirmed, cpf, email, hash_confirm, nome, password, sobrenome, username, empresa) FROM stdin;
6	2021-06-28 21:53:33.371	2021-06-28 21:53:33.371	f	f	52007472953	perrony.ls@gmail.com	6b27b4b55760ff44cd37e40f480ddeac4da30045705ecf1b6e406d1f4a6ba997a92b412208a9a684af3404ac966b5af1286ee86810b722ef40c2ccfc4da1222e	Ladislau	$2a$10$FnQKyTekyYBaXpCzlLqTDOA7Z3zoeDMa3r9PGWFgJjk90/rmrY5P2	Perrony	perrony.ls@gmail.com	1
\.


--
-- Name: clientes_enderecos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_enderecos_seq', 1, false);


--
-- Name: clientes_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_seq', 12, true);


--
-- Name: contato_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contato_cliente_seq', 1, true);


--
-- Name: contato_empresa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contato_empresa_seq', 4, true);


--
-- Name: empresa_enderecos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empresa_enderecos_seq', 2, true);


--
-- Name: empresa_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.empresa_seq', 1, false);


--
-- Name: enderecos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.enderecos_seq', 1, false);


--
-- Name: parameters_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.parameters_seq', 1, true);


--
-- Name: roles_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_seq', 4, true);


--
-- Name: rolesusers_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rolesusers_seq', 1, false);


--
-- Name: users_enderecos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_enderecos_seq', 1, false);


--
-- Name: users_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_seq', 7, true);


--
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);


--
-- Name: contato_cliente contato_cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato_cliente
    ADD CONSTRAINT contato_cliente_pkey PRIMARY KEY (id);


--
-- Name: contato_empresa contato_empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato_empresa
    ADD CONSTRAINT contato_empresa_pkey PRIMARY KEY (id);


--
-- Name: empresa empresa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);


--
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- Name: parameters parameters_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parameters
    ADD CONSTRAINT parameters_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: roles_users roles_users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles_users
    ADD CONSTRAINT roles_users_pkey PRIMARY KEY (id);


--
-- Name: users uk_r43af9ap4edm43mmtq01oddj6; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username);


--
-- Name: clientes ukek76xnaf0gejyt2rjpryd9kfk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT ukek76xnaf0gejyt2rjpryd9kfk UNIQUE (cnpj_cpf);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: roles_users fk464ffd4sf8xy1eiclsviplrcs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles_users
    ADD CONSTRAINT fk464ffd4sf8xy1eiclsviplrcs FOREIGN KEY (roles) REFERENCES public.roles(id);


--
-- Name: endereco_clientes fk5cmoy7928r2ikhj5tmgq75d9r; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_clientes
    ADD CONSTRAINT fk5cmoy7928r2ikhj5tmgq75d9r FOREIGN KEY (users) REFERENCES public.users(id);


--
-- Name: clientes fk8n9v7qqb61ibnq4kamv2n9kfn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT fk8n9v7qqb61ibnq4kamv2n9kfn FOREIGN KEY (users) REFERENCES public.users(id);


--
-- Name: users fk9bfpg708is9pjeowsg4b90g15; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk9bfpg708is9pjeowsg4b90g15 FOREIGN KEY (empresa) REFERENCES public.empresa(id);


--
-- Name: contato_cliente fkbocqwpm5nvpeybgkjhx6lxn6q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato_cliente
    ADD CONSTRAINT fkbocqwpm5nvpeybgkjhx6lxn6q FOREIGN KEY (users) REFERENCES public.users(id);


--
-- Name: endereco_clientes fkdegj8q2p7741luaatrk581eyr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_clientes
    ADD CONSTRAINT fkdegj8q2p7741luaatrk581eyr FOREIGN KEY (clientes) REFERENCES public.clientes(id);


--
-- Name: roles_users fkee22i839p6qp8fcnjb3hmf7il; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles_users
    ADD CONSTRAINT fkee22i839p6qp8fcnjb3hmf7il FOREIGN KEY (users) REFERENCES public.users(id);


--
-- Name: endereco_clientes fkgb3cxc31krp32et38b6f8i4qv; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_clientes
    ADD CONSTRAINT fkgb3cxc31krp32et38b6f8i4qv FOREIGN KEY (endereco) REFERENCES public.endereco(id);


--
-- Name: endereco fkh1o855veuslnjlk6yesv4p2tg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT fkh1o855veuslnjlk6yesv4p2tg FOREIGN KEY (users) REFERENCES public.users(id);


--
-- Name: users fkhwxxsovt1xxol6upd7iq26m8w; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fkhwxxsovt1xxol6upd7iq26m8w FOREIGN KEY (id) REFERENCES public.users(id);


--
-- Name: endereco_empresa fkiqv2w8x39of5n0csc1n5hbho6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_empresa
    ADD CONSTRAINT fkiqv2w8x39of5n0csc1n5hbho6 FOREIGN KEY (endereco) REFERENCES public.endereco(id);


--
-- Name: endereco_empresa fklv9l25qpbm0qr8a4yl0qatv9u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_empresa
    ADD CONSTRAINT fklv9l25qpbm0qr8a4yl0qatv9u FOREIGN KEY (users) REFERENCES public.users(id);


--
-- Name: contato_empresa fkoieqdblhxwpest7xma6wa26hi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato_empresa
    ADD CONSTRAINT fkoieqdblhxwpest7xma6wa26hi FOREIGN KEY (empresa) REFERENCES public.empresa(id);


--
-- Name: endereco_users fkow29fs0oc8l9x3h5ukc1y0j3x; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_users
    ADD CONSTRAINT fkow29fs0oc8l9x3h5ukc1y0j3x FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- Name: endereco_users fkrrfbk0kcomrxs4ubu9g906q9g; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_users
    ADD CONSTRAINT fkrrfbk0kcomrxs4ubu9g906q9g FOREIGN KEY (endereco) REFERENCES public.endereco(id);


--
-- Name: contato_cliente fktdk559angwirp18yfv8vc0pvf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contato_cliente
    ADD CONSTRAINT fktdk559angwirp18yfv8vc0pvf FOREIGN KEY (cliente) REFERENCES public.clientes(id);


--
-- Name: endereco_empresa fktmxmrk4tglu8u89ebajyvl06j; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco_empresa
    ADD CONSTRAINT fktmxmrk4tglu8u89ebajyvl06j FOREIGN KEY (empresa) REFERENCES public.empresa(id);


--
-- PostgreSQL database dump complete
--

