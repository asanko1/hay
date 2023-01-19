-- DROP SCHEMA dbo;

CREATE SCHEMA dbo;
-- HAYDB.dbo.Hay_SQL definition

-- Drop table

-- DROP TABLE HAYDB.dbo.Hay_SQL;

CREATE TABLE HAYDB.dbo.Hay_SQL (
	SQL_Id bigint NOT NULL,
	[SQL] varchar(4000) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PK_HAY_SQL PRIMARY KEY (SQL_Id)
);


-- HAYDB.dbo.Hay_Skills definition

-- Drop table

-- DROP TABLE HAYDB.dbo.Hay_Skills;

CREATE TABLE HAYDB.dbo.Hay_Skills (
	Skill_Id bigint IDENTITY(1,1) NOT NULL,
	Skill_Name varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Skill_Type varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PK_HAY_SKILLS PRIMARY KEY (Skill_Id)
);


-- HAYDB.dbo.Hay_Users definition

-- Drop table

-- DROP TABLE HAYDB.dbo.Hay_Users;

CREATE TABLE HAYDB.dbo.Hay_Users (
	UserId bigint IDENTITY(1,1) NOT NULL,
	Email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[Role] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	leadership varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_HAY_USERS PRIMARY KEY (UserId)
);


-- HAYDB.dbo.hay_feedback definition

-- Drop table

-- DROP TABLE HAYDB.dbo.hay_feedback;

CREATE TABLE HAYDB.dbo.hay_feedback (
	feedback_id bigint IDENTITY(1,1) NOT NULL,
	round_synthetic_key varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[Result] varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Tech_Skill_Score varchar(4000) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Comm_Score varchar(4000) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Proposed_Employment_type varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Proposed_Designation varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Comment varchar(4000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	Biz_Skill_Score varchar(4000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_HAY_FEEDBACK PRIMARY KEY (feedback_id)
);


-- HAYDB.dbo.hay_organizer definition

-- Drop table

-- DROP TABLE HAYDB.dbo.hay_organizer;

CREATE TABLE HAYDB.dbo.hay_organizer (
	organizer_id bigint IDENTITY(1,1) NOT NULL,
	organizer_synthetic_key varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	first_name varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	last_name varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	city varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	country varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	timezone varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	email varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	dept varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Phone varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	teams_link varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	last_updated datetime DEFAULT getdate() NOT NULL,
	leadership_profile varchar(200) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	CONSTRAINT PK_HAY_ORGANIZER PRIMARY KEY (organizer_id)
);


-- HAYDB.dbo.hay_panelist definition

-- Drop table

-- DROP TABLE HAYDB.dbo.hay_panelist;

CREATE TABLE HAYDB.dbo.hay_panelist (
	panelist_id bigint IDENTITY(1,1) NOT NULL,
	panelist_synthetic_key varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	first_name varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	last_name varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	city varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	country varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	timezone varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	email varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	dept varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	skillset varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	Phone varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	last_updated datetime DEFAULT getdate() NOT NULL,
	linkedin_url varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	leadership_profile varchar(200) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	core_skills varchar(1000) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_HAY_PANELIST PRIMARY KEY (panelist_id)
);


-- HAYDB.dbo.hay_profile definition

-- Drop table

-- DROP TABLE HAYDB.dbo.hay_profile;

CREATE TABLE HAYDB.dbo.hay_profile (
	profile_id bigint IDENTITY(1,1) NOT NULL,
	profile_synthetic_key varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	first_name varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	last_name varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	primary_phn varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	primary_email varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	sec_phn varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	sec_email varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	city varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	country varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[source] varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	ref_emp_id varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	resume varbinary(MAX) NULL,
	last_updated datetime DEFAULT getdate() NOT NULL,
	blacklisted char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	visa_status varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	linkedin_url varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	github_url varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	status varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	last_updated_by varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	gender varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	exemployee varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	exempid varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	department varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	job_id varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	tag varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_HAY_PROFILE PRIMARY KEY (profile_id)
);


-- HAYDB.dbo.hay_rounds definition

-- Drop table

-- DROP TABLE HAYDB.dbo.hay_rounds;

CREATE TABLE HAYDB.dbo.hay_rounds (
	Round_id bigint IDENTITY(1,1) NOT NULL,
	Round_Name varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	panelist_id varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	organizer_id varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	profile_id varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	scheduled_on varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	mode varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	isRescheduled varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	last_updated datetime DEFAULT getdate() NOT NULL,
	duration varchar(40) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	round_type varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	round_synthetic_key varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	status varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK_HAY_ROUNDS PRIMARY KEY (Round_id)
);



DROP TRIGGER IF EXISTS trg_profile;
CREATE  TRIGGER trg_profile
ON haydb.dbo.hay_profile 
AFTER INSERT
AS
DECLARE @PID INT
BEGIN
	SELECT @PID = ins.profile_id FROM INSERTED ins
	update haydb.dbo.hay_profile set profile_synthetic_key=concat('P-',profile_id) where profile_id = @PID
END
;

DROP TRIGGER IF EXISTS trg_panelist;
CREATE  TRIGGER trg_panelist
ON haydb.dbo.hay_panelist 
AFTER INSERT
AS
DECLARE @PID INT
BEGIN
	SELECT @PID = ins.panelist_id FROM INSERTED ins
	update haydb.dbo.hay_panelist set panelist_synthetic_key=concat('I-',panelist_id) where panelist_id = @PID
END
;

DROP TRIGGER IF EXISTS trg_organizer;
CREATE  TRIGGER trg_organizer
ON haydb.dbo.hay_organizer 
AFTER INSERT
AS
DECLARE @PID INT
BEGIN
	SELECT @PID = ins.organizer_id FROM INSERTED ins
	update haydb.dbo.hay_organizer set organizer_synthetic_key=concat('R-',organizer_id) where organizer_id = @PID
END
;
DROP TRIGGER IF EXISTS trg_round;
CREATE  TRIGGER trg_round
ON haydb.dbo.hay_rounds 
AFTER INSERT
AS
DECLARE @PID INT
BEGIN
	SELECT @PID = ins.round_id FROM INSERTED ins
	update haydb.dbo.hay_rounds set round_synthetic_key=concat('IR-',round_id) where round_id = @PID
END
;
DROP TRIGGER IF EXISTS trg_round;

CREATE  TRIGGER trg_round_update
ON haydb.dbo.hay_rounds 
AFTER UPDATE
AS
DECLARE @PID INT
BEGIN
	SELECT @PID = ins.round_id FROM UPDATED upd
	update haydb.dbo.hay_rounds set last_updated=CURRENT_TIMESTAMP  where round_id = @PID
END
;

INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(1, N'Select distinct email from haydb.dbo.Hay_Users');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(2, N'Select count(*) from haydb.dbo.Hay_Users where email=? and role=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(3, N'insert into haydb.dbo.hay_profile (profile_synthetic_key,first_name, last_name, primary_phn, primary_email, sec_phn, sec_email, city, country, source, ref_emp_id,  blacklisted, visa_status, linkedin_url, github_url, status,last_updated_by,gender,exemployee,exempid,department,job_id,tag) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(4, N'select max(profile_id) from haydb.dbo.hay_profile where (upper(first_name) = ? and upper(last_name) = ? and primary_phn = ?) or (upper(first_name) = ? and upper(last_name) = ? and sec_phn = ?) or upper(primary_email)  = ? or upper(sec_email)  = ?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(5, N'select profile_synthetic_key from haydb.dbo.hay_profile where upper(profile_synthetic_key)=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(6, N'select profile_synthetic_key from haydb.dbo.hay_profile where primary_phn=? or sec_phn=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(7, N'select profile_synthetic_key from haydb.dbo.hay_profile where upper(primary_email)=? or upper(sec_email)=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(8, N'SELECT profile_id, profile_synthetic_key, first_name, last_name, primary_phn, primary_email, sec_phn, sec_email, city, country, source, ref_emp_id, resume, last_updated, blacklisted, visa_status, linkedin_url, github_url, status, last_updated_by, gender, exemployee, exempid, department, job_id,tag
FROM HAYDB.dbo.hay_profile where upper(profile_synthetic_key)=? order by  last_updated ');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(9, N'SELECT profile_synthetic_key FROM HAYDB.dbo.hay_profile ');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(10, N'insert into haydb.dbo.hay_organizer (organizer_synthetic_key,first_name, last_name, city, country, timezone, email, dept, Phone, teams_link, leadership_profile)
values (?,?,?,?,?,?,?,?,?,?,?)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(11, N'insert into haydb.dbo.Hay_Users (email, role,leadership) values (?,?,?)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(12, N'insert into haydb.dbo.hay_panelist (panelist_synthetic_key, first_name, last_name, city, country, timezone, email, skillset, dept, Phone, linkedin_url, leadership_profile)
values (?,?,?,?,?,?,?,?,?,?,?,?)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(13, N'SELECT Skill_Id, Skill_Name, Skill_Type FROM HAYDB.dbo.Hay_Skills');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(14, N'select profile_synthetic_key from haydb.dbo.hay_profile where upper(tag) like ?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(15, N'Select Round_id,Round_Name,panelist_id,organizer_id,profile_id,scheduled_on,mode,isRescheduled,last_updated,duration,round_type, round_synthetic_key, status from HAYDB.dbo.hay_rounds where profile_id=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(16, N'Select concat(concat(first_name,'' ''),last_name) from HAYDB.dbo.hay_panelist where panelist_synthetic_key=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(17, N'Select concat(concat(first_name,'' ''),last_name) from HAYDB.dbo.hay_organizer where organizer_synthetic_key=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(18, N'Select organizer_synthetic_key from HAYDB.dbo.hay_organizer where email=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(19, N'Select panelist_synthetic_key from HAYDB.dbo.hay_panelist  where email=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(20, N'Select panelist_synthetic_key, email  from HAYDB.dbo.hay_panelist  ');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(21, N'Select organizer_synthetic_key, email  from HAYDB.dbo.hay_organizer ');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(22, N'insert into haydb.dbo.hay_rounds (Round_Name,panelist_id,organizer_id,profile_id,scheduled_on,mode,isRescheduled,duration,round_type,round_synthetic_key, status)
values (?,?,?,?,?,?,?,?,?,?,?) ');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(23, N'Select Round_id,Round_Name,panelist_id,organizer_id,profile_id,scheduled_on,mode,isRescheduled,last_updated,duration,round_type,round_synthetic_key, status from HAYDB.dbo.hay_rounds where panelist_id=? and status=''Scheduled''');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(24, N'Select teams_link from haydb.dbo.hay_organizer where organizer_synthetic_key=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(25, N'insert into haydb.dbo.hay_feedback (round_synthetic_key,Result,Tech_Skill_Score,Comm_Score,Proposed_Employment_type,Proposed_Designation,Comment,Biz_Skill_Score) values (?,?,?,?,?,?,?,?)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(26, N'update haydb.dbo.hay_rounds set status=''Completed'', last_updated=current_timestamp where round_synthetic_key=?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(28, N'select Result,Tech_Skill_Score,Comm_Score,Proposed_Employment_type,Proposed_Designation,Comment,Biz_Skill_Score from haydb.dbo.hay_feedback  where round_synthetic_key=? ');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(29, N'select ''Total Profile Created'',count(*) from haydb.dbo.hay_profile where  last_updated_by =? and last_updated >cast(? as date) and last_updated < cast(? as Date)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(30, N'select ''Total Interview Completed'',count(*) from haydb.dbo.hay_rounds   where  panelist_id  =? and status =?  and last_updated >cast(? as date) and last_updated < cast(? as Date)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(31, N'select ''Total Screening Completed'',count(*) from haydb.dbo.hay_rounds   where  Round_Name=''Screening'' and panelist_id  =? and status=? and last_updated >cast(? as date) and last_updated < cast(? as Date)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(32, N'select ''Total Interview Scheduled'',count(*) from haydb.dbo.hay_rounds   where  organizer_id  =? and (status =? or status=?) and last_updated >cast(? as date) and last_updated < cast(? as Date)');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(33, N'select f.Result ,count(1) from haydb.dbo.hay_rounds r join haydb.dbo.hay_feedback f on r.round_synthetic_key  =f.round_synthetic_key  where r.panelist_id = ? and r.status = ''Completed''  and last_updated >cast(? as date) and last_updated < cast(? as Date) group by f.result ');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(34, N'select Round_id, Round_Name, panelist_id, organizer_id, profile_id, scheduled_on, mode, isRescheduled, last_updated, duration, round_type, round_synthetic_key, status FROM ( Select Round_id, Round_Name, panelist_id, organizer_id, profile_id, scheduled_on, mode, isRescheduled, last_updated, duration, round_type, round_synthetic_key, status , rank() over(PARTITION by profile_id ORDER by last_updated desc) AS RN from HAYDB.dbo.hay_rounds where status = ''Completed'' and last_updated > GETDATE() - 7 and organizer_id =?) s where RN=1');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(35, N'Select linkedin_url,github_url from HAYDB.dbo.hay_profile where profile_synthetic_key =?');
INSERT INTO HAYDB.dbo.Hay_SQL (SQL_Id, [SQL]) VALUES(36, N'Select linkedin_url from HAYDB.dbo.hay_panelist where email =?');
