-- TABLES
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

CREATE TABLE TEACHER (
	TCHID BIGINT PRIMARY KEY,
	FULL_NAME VARCHAR(255) NOT NULL,
	SPECIALTY VARCHAR(255) NOT NULL
);
CREATE TABLE STUDENT (
	STID BIGINT PRIMARY KEY,
	FULL_NAME VARCHAR(255) NOT NULL,
	FIELD VARCHAR(255) NOT NULL
);
CREATE TABLE COURSE (
	COID BIGINT PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL,
	UNIT INT NOT NULL,
	TYPE VARCHAR(11) NOT NULL
);
CREATE TABLE TOPIC (
	TOID BIGINT PRIMARY KEY,
	NAME VARCHAR(255) NOT NULL,
	COID BIGINT NOT NULL,
	CONSTRAINT FK_TO_COID
      FOREIGN KEY(COID)
	  REFERENCES COURSE(COID)
	  ON DELETE CASCADE
);
CREATE TABLE BASIC_TOPIC (
	BTID BIGINT PRIMARY KEY,
	SCORE_SHARE DECIMAL(3,1) NOT NULL,
	CONSTRAINT FK_BTID
      FOREIGN KEY(BTID)
	  REFERENCES TOPIC(TOID)
	  ON DELETE CASCADE
);
CREATE TABLE OPTIONAL_TOPIC (
	OTID BIGINT PRIMARY KEY,
	CONSTRAINT FK_OTID
      FOREIGN KEY(OTID)
	  REFERENCES TOPIC(TOID)
	  ON DELETE CASCADE
);
CREATE TABLE TOPIC_PREREQUISITE (
    TPID BIGSERIAL PRIMARY KEY,
	TOID BIGINT NOT NULL,
	PRE_TOID BIGINT NOT NULL,
	UNIQUE (TOID, PRE_TOID),
	CONSTRAINT FK_TOID
      FOREIGN KEY(TOID)
	  REFERENCES TOPIC(TOID)
	  ON DELETE CASCADE,
	CONSTRAINT FK_PRE_TOID
      FOREIGN KEY(TOID)
	  REFERENCES TOPIC(TOID)
	  ON DELETE CASCADE
);
CREATE TABLE COURSE_GROUP (
	CGID BIGINT PRIMARY KEY,
	TCHID BIGINT NOT NULL,
	COID BIGINT NOT NULL,
	YEAR INT NOT NULL,
	TERM INT NOT NULL,
	UNIQUE(TCHID, COID, YEAR, TERM),
	CONSTRAINT FK_CG_TCHID
      FOREIGN KEY(TCHID)
	  REFERENCES TEACHER(TCHID)
	  ON DELETE CASCADE,
	CONSTRAINT FK_CG_COID
      FOREIGN KEY(COID)
	  REFERENCES COURSE(COID)
	  ON DELETE CASCADE
);
CREATE TABLE SESSION (
	SEID BIGINT PRIMARY KEY,
	TIME VARCHAR(255) NOT NULL,
	CGID BIGINT NOT NULL,
	CONSTRAINT FK_SESSION_CGID
      FOREIGN KEY(CGID)
	  REFERENCES COURSE_GROUP(CGID)
	  ON DELETE CASCADE
);
CREATE TABLE SESSION_TOPIC (
    ST_ID BIGINT PRIMARY KEY,
	SEID BIGINT NOT NULL,
	TOID BIGINT NOT NULL,
	UNIQUE (SEID, TOID),
	CONSTRAINT FK_ST_SEID
      FOREIGN KEY(SEID)
	  REFERENCES SESSION(SEID)
	  ON DELETE CASCADE,
	CONSTRAINT FK_ST_TOID
      FOREIGN KEY(TOID)
	  REFERENCES TOPIC(TOID)
	  ON DELETE CASCADE
);
CREATE TABLE OTCG ( -- RELATION OF COURSE_GROUP AND OPTIONAL TOPIC
	OTCGID BIGINT PRIMARY KEY,
	CGID BIGINT NOT NULL,
	OTID BIGINT NOT NULL,
	SCORE_SHARE DECIMAL(3,1) NOT NULL,
	UNIQUE(CGID, OTID),
	CONSTRAINT FK_OTCG_CGID
      FOREIGN KEY(CGID)
	  REFERENCES COURSE_GROUP(CGID),
	CONSTRAINT FK_OTCG_OTID
      FOREIGN KEY(OTID)
	  REFERENCES OPTIONAL_TOPIC(OTID)
);
CREATE TABLE COURSE_STUDENT (
	CSID BIGINT PRIMARY KEY,
	STID BIGINT NOT NULL,
	CGID BIGINT NOT NULL,
	GRADE DECIMAL(3,1) CHECK (GRADE >= 0 AND GRADE <= 20),
	UNIQUE(STID, CGID),
	CONSTRAINT FK_CS_STID
      FOREIGN KEY(STID)
	  REFERENCES STUDENT(STID)
	  ON DELETE CASCADE,
	CONSTRAINT FK_CS_CGID
      FOREIGN KEY(CGID)
	  REFERENCES COURSE_GROUP(CGID)
	  ON DELETE CASCADE
);
CREATE TABLE COMPONENT (
	CMPID BIGINT PRIMARY KEY,
	TITLE VARCHAR(255) NOT NULL,
	CGID BIGINT NOT NULL,
	GRADE DECIMAL(3,1),
	RELEASE_DATE TIMESTAMP NOT NULL,
	FINISH_DATE TIMESTAMP NOT NULL,
	CONSTRAINT FK_CMP_CGID
      FOREIGN KEY(CGID)
	  REFERENCES COURSE_GROUP(CGID)
	  ON DELETE CASCADE
);
CREATE TABLE COMPONENT_DELIVERY (
	CDID BIGINT PRIMARY KEY,
	CMPID BIGINT NOT NULL,
	CSID BIGINT NOT NULL,
	GRADE DECIMAL(3,1),
	DELIVERY_TIME TIMESTAMP NOT NULL,
	UNIQUE(CMPID, CSID),
	CONSTRAINT FK_CD_CMPID
      FOREIGN KEY(CMPID)
	  REFERENCES COMPONENT(CMPID)
	  ON DELETE CASCADE,
	CONSTRAINT FK_CD_CSID
      FOREIGN KEY(CSID)
	  REFERENCES COURSE_STUDENT(CSID)
	  ON DELETE CASCADE
);
CREATE TABLE COMPONENT_TOPIC (
    CT_ID BIGSERIAL PRIMARY KEY,
	TOID BIGINT NOT NULL,
	CMPID BIGINT NOT NULL,
	UNIQUE (TOID, CMPID),
	CONSTRAINT FK_CT_TOID
      FOREIGN KEY(TOID)
	  REFERENCES TOPIC(TOID)
	  ON DELETE CASCADE,
	CONSTRAINT FK_CT_CMPID
      FOREIGN KEY(CMPID)
	  REFERENCES COMPONENT(CMPID)
	  ON DELETE CASCADE
);
CREATE TABLE EXAM(
	CMPID BIGINT PRIMARY KEY,
	UNIT_TYPE VARCHAR(7) NOT NULL,
	CONSTRAINT FK_EXAM_CMPID
      FOREIGN KEY(CMPID)
	  REFERENCES COMPONENT(CMPID)
	  ON DELETE CASCADE
);
CREATE TABLE PRACTICE(
    CMPID BIGINT PRIMARY KEY,
	UNIT_TYPE VARCHAR(8) NOT NULL,
	PPD INT CHECK (PPD < 100 AND PPD > 0), -- percent per day
	DELAY_DAYS INT,
	CONSTRAINT FK_PRACTICE_CMPID
      FOREIGN KEY(CMPID)
	  REFERENCES COMPONENT(CMPID)
	  ON DELETE CASCADE
);
-- VIEWS
CREATE VIEW STUDENT_COURSES AS
	SELECT
		row_number() OVER () AS id,
		CS.STID AS STUDENT_ID,
		CO.COID AS COURSE_ID,
		CO.NAME AS COURSE_NAME,
		CG.YEAR AS YEAR,
		CG.TERM AS TERM,
		TCH.FULL_NAME AS TEACHER_NAME,
		CS.GRADE AS GRADE
		FROM COURSE_STUDENT AS CS
		INNER JOIN COURSE_GROUP AS CG ON CS.CGID = CG.CGID
		INNER JOIN COURSE AS CO ON CG.COID = CO.COID
		INNER JOIN TEACHER AS TCH ON CG.TCHID = TCH.TCHID;

CREATE VIEW STUDENT_COMPONENTS AS
	SELECT
		row_number() OVER () AS id,
		CS.STID AS STUDENT_ID,
		CO.COID AS COURSE_ID,
		CO.NAME AS COURSE_NAME,
		CG.YEAR AS YEAR,
		CG.TERM AS TERM,
		CMP.TITLE AS COMPONENT_TITLE,
		CMP.GRADE AS COMPONENT_GRADE
		FROM COURSE_STUDENT AS CS
		INNER JOIN COURSE_GROUP AS CG ON CS.CGID = CG.CGID
		INNER JOIN COURSE AS CO ON CG.COID = CO.COID
		INNER JOIN COMPONENT AS CMP ON CG.CGID = CMP.CGID;

CREATE VIEW STUDENT_TERMS_AVERAGE AS
	SELECT
		row_number() OVER () AS id,
		CS.STID AS STUDENT_ID,
		CG.YEAR AS YEAR,
		CG.TERM AS TERM,
		AVG(CS.GRADE) AS AVERAGE
		FROM COURSE_STUDENT AS CS
		INNER JOIN COURSE_GROUP AS CG ON CS.CGID = CG.CGID
		GROUP BY CS.STID, CG.YEAR, CG.TERM;

CREATE VIEW TEACHER_COURSES_AVERAGE AS
	SELECT
		row_number() OVER () AS id,
		TCH.TCHID AS TEACHER_ID,
		CO.COID AS COURSE_ID,
		CO.NAME AS COURSE_NAME,
		CG.YEAR AS YEAR,
		CG.TERM AS TERM,
		AVG(CS.GRADE) AS AVERAGE
		FROM COURSE_STUDENT AS CS
		INNER JOIN COURSE_GROUP AS CG ON CS.CGID = CG.CGID
		INNER JOIN COURSE AS CO ON CG.COID = CO.COID
		INNER JOIN TEACHER AS TCH ON CG.TCHID = TCH.TCHID
		GROUP BY TCH.TCHID, CO.COID, CO.NAME, CG.YEAR, CG.TERM;

CREATE VIEW TEACHER_COMPONENTS_AVERAGE AS
	SELECT
		row_number() OVER () AS id,
		TCH.TCHID AS TEACHER_ID,
		CO.COID AS COURSE_ID,
		CO.NAME AS COURSE_NAME,
		CG.YEAR AS YEAR,
		CG.TERM AS TERM,
		CMP.CMPID AS COMPONENT_ID,
		CMP.TITLE AS COMPONENT_TITLE,
		AVG(CD.GRADE) AS AVERAGE
		FROM COURSE_STUDENT AS CS
		INNER JOIN COURSE_GROUP AS CG ON CS.CGID = CG.CGID
		INNER JOIN COURSE AS CO ON CG.COID = CO.COID
		INNER JOIN TEACHER AS TCH ON CG.TCHID = TCH.TCHID
		INNER JOIN COMPONENT AS CMP ON CG.CGID = CMP.CGID
		INNER JOIN COMPONENT_DELIVERY AS CD ON CD.CMPID = CMP.CMPID
		GROUP BY TCH.TCHID, CO.COID, CO.NAME, CG.YEAR, CG.TERM, CMP.CMPID, CMP.TITLE;

-- TRIGGERS

create or replace function student_grade_func() returns trigger language plpgsql
    as $$
    begin
        if tg_op = 'INSERT' or tg_op = 'UPDATE'then
            if (select sum(grade) from component_delivery where csid = new.csid) > 20 then
                update course_student set grade = 20 where course_student.csid = new.csid;
            else
                update course_student set grade = (select sum(grade) from component_delivery where csid = new.csid)
                where course_student.csid = new.csid;
            end if;
        elsif tg_op = 'DELETE' then
            if (select sum(grade) from component_delivery where csid = old.csid) > 20 then
                update course_student set grade = 20 where course_student.csid = old.csid;
            else
                update course_student set grade = (select sum(grade) from component_delivery where csid = old.csid)
                where course_student.csid = old.csid;
            end if;
        end if;
		return new;
    end;
    $$;

create trigger student_grade
    after insert or update of grade or delete on component_delivery
    for each row
    execute procedure student_grade_func();
------------------------------------------------------------------------------------

create or replace function cg_optimal_topic_func() returns trigger language plpgsql
    as $$
    begin
        if tg_op = 'INSERT' or tg_op = 'UPDATE' then
            if new.otid not in (select toid from topic where coid = (
                select coid from course_group where course_group.cgid = new.cgid)) then
                raise exception 'This topic is not valid for this course';
            end if;
        end if;
		return new;
    end;
    $$;

create trigger cg_optimal_topic
    before insert or update of otid on otcg
    for each row
    execute procedure cg_optimal_topic_func();

--------------------------------------------------------------------------------------

create or replace function comp_topic_func() returns trigger language plpgsql
    as $$
    begin
        if tg_op = 'INSERT' or tg_op = 'UPDATE' then
            if new.toid not in (select toid from topic where coid = (select coid from course_group where
         			cgid = (select cgid from component where component.cmpid = 1) intersect (select btid from basic_topic))) and
               new.toid not in (select otid from otcg where cgid = (select cgid from component where component.cmpid = new.cmpid)) then
                raise exception 'This topic is not valid for this component';
            end if;
        end if;
		return new;
    end;
    $$;

create trigger comp_topic
    before insert or update of toid on component_topic
    for each row
    execute procedure comp_topic_func();

-------------------------------------------------------------------------------------

create or replace function comp_delivery_func() returns trigger language plpgsql
    as $$
    begin
        if tg_op = 'INSERT' or tg_op = 'UPDATE' then
            if (select cgid from component where component.cmpid = new.cmpid) <>
               (select cgid from course_student where course_student.csid = new.csid) then
                raise exception 'This delivery_component dose not match with course component';
            end if;
        end if;
		return new;
    end;
    $$;

create trigger comp_delivery
    before insert or update on component_delivery
    for each row
    execute procedure comp_delivery_func();

---------------------------------------------------------------------------------------------

create or replace function se_topic_func() returns trigger language plpgsql
    as $$
    begin
        if tg_op = 'INSERT' or tg_op = 'UPDATE' then
            if new.toid not in (select toid from topic where
                                     coid = (select coid from course_group where
                                         cgid = (select cgid from session where
                                            session.seid = new.seid)) intersect (select btid from basic_topic)) and
               new.toid not in (select otid from otcg inner join session s on otcg.cgid = s.cgid where s.seid = new.seid) then
                raise exception 'Topic of this session dose not match with course topics';
            end if;
        end if;
        return new;
    end;
    $$;

create trigger se_topic
    before insert or update on session_topic
    for each row
    execute procedure se_topic_func();


