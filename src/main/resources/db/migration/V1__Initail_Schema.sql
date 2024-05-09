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
SET default_tablespace = '';

CREATE TABLE public.ads (
                            id bigint PRIMARY KEY,
                    header character varying(1000),
                    content text,
                    user_id bigint);

CREATE SEQUENCE public.ads_id_seq AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.images (
                               id bigint PRIMARY KEY,
                               name character varying(255) NOT NULL,
                               type character varying(255),
                               image_data bytea
);


CREATE SEQUENCE public.images_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.news (
                             id bigint PRIMARY KEY,
                             header character varying(255) NOT NULL,
                             content character varying(1000),
                             date timestamp(6) without time zone DEFAULT CURRENT_TIMESTAMP
);


CREATE SEQUENCE public.news_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.refreshtoken (
                                     id bigint PRIMARY KEY,
                                     user_id bigint NOT NULL,
                                     token character varying(255) NOT NULL,
                                     expiry_date timestamp(6) with time zone NOT NULL
);


CREATE SEQUENCE public.refreshtoken_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE public.users (
                              id bigint PRIMARY KEY,
                              email character varying(50),
                              password character varying(120),
                              username character varying(20)
);

CREATE TABLE public.roles (
                              id bigint PRIMARY KEY,
                              name character varying(20)
);


CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE public.user_roles (
                                   user_id bigint NOT NULL,
                                   role_id integer NOT NULL
);


CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
