create table ITS_TBL_User_Credentials
(UserId VARCHAR2(6) Primary Key
,
Password VARCHAR2(20) Not Null
,
Usertype VARCHAR2(1) CHECK (Usertype='A' OR Usertype='T' OR Usertype='H'),
Loginstatus NUMBER(1) CHECK(Loginstatus IN(0,1)));

create table ITS_TBL_Candidate
(candidateId VARCHAR2(6) Primary Key,
PrimarySkills VARCHAR2(30) Not Null,
SecondarySkills VARCHAR2(30) Not Null,
Experience NUMBER(5,2) Not Null,
Qualification VARCHAR2(20) Not Null
,
Designation VARCHAR2(20),
NoticePeriod NUMBER(3),
Location VARCHAR2(20),
ShareDetails NUMBER(1) CHECK (ShareDetails BETWEEN 0 AND 3));

create table ITS_TBL_User_Profile
(CandidateId VARCHAR2(6) references ITS_TBL_Candidate(CandidateId) ON DELETE CASCADE,
Firstname VARCHAR2(15) Not Null,
Lastname VARCHAR2(15) Not Null,
Dateofbirth DATE Not Null,
Gender VARCHAR2(7) Not Null,
Street VARCHAR2(30) Not Null,
Location VARCHAR2(15) Not Null,
City VARCHAR2(15) Not Null,
State VARCHAR2(15) Not Null,
Pincode VARCHAR2(6) Not Null,
MobileNo VARCHAR(10) CHECK(Length(MobileNo)=10),
EmailId VARCHAR2(30));

create table  ITS_TBL_TechPanel
(techId VARCHAR2 (6) Primary Key,
techName VARCHAR2(25) Not Null,
Subjects VARCHAR2(40) Not Null);

create table ITS_TBL_HRPanel
(empHRId VARCHAR2(6) Primary Key,
empHRName VARCHAR2(25) Not Null
);

create table ITS_TBL_Interview_Schedule
(InterviewID VARCHAR2(6) Primary Key,
CandidateID VARCHAR2(6) references ITS_TBL_Candidate(CandidateID) ON DELETE CASCADE,
Subject VARCHAR2(20) Not Null,
TechID VARCHAR2(6) references  ITS_TBL_TechPanel(TechID) ON DELETE CASCADE,
InterviewDate DATE Not Null,
InterviewTime VARCHAR2(8) Not Null,
TechRating NUMBER(2,1) CHECK (TechRating BETWEEN 1.0 AND 5.0),
empHRID VARCHAR2(6) references ITS_TBL_HRPanel(empHRID) ON DELETE CASCADE,
empHRInterviewDate DATE,
empHRInterviewTime VARCHAR2(8),
empHRRating NUMBER(2,1) CHECK (empHRRating BETWEEN 1.0 AND 5.0), 
Result VARCHAR2(20),
ShareResult NUMBER(1));

CREATE TABLE ITS_TBL_Remember(
UserId VARCHAR2(6) REFERENCES ITS_TBL_User_Credentials (UserId) ON DELETE CASCADE,
Password VARCHAR2(20) NOT NULL);

create SEQUENCE its_seq_candidateID
START WITH 1000
INCREMENT BY 1;

create SEQUENCE its_seq_interviewID
START WITH 1000
INCREMENT BY 1;
