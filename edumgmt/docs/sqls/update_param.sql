delete from sh_video_base_keyword;
delete from sh_video_base_knowledge_point;
delete from sh_video_detail;
delete from sh_video_pastpaper;
delete from sh_video_point;
delete from sh_video_self;
delete from sh_video_pic;
delete from sh_video_base;
delete from `sh_knowledge_point`;

delete from sh_questionbank_year;
delete from sh_questionbank_type;
delete from sh_questionbank_course;
delete from sh_questionbank_question_type;

delete from sh_questionbank;
delete from sh_course;
delete from sh_question_type;

INSERT INTO `sh_questionbank` (`id`,`name`,`type`) VALUES (1,'中考真题','0');
INSERT INTO `sh_questionbank` (`id`,`name`,`type`) VALUES (2,'高考真题','0');
INSERT INTO `sh_questionbank` (`id`,`name`,`type`) VALUES (3,'中考模拟','0');
INSERT INTO `sh_questionbank` (`id`,`name`,`type`) VALUES (4,'高考模拟','0');


INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (1,'语文','语');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (2,'数学','数');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (3,'外语','外');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (4,'物理','理');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (5,'化学','化');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (6,'生物','生');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (7,'历史','史');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (8,'地理','地');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (9,'政治','政');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (10,'文科综合','文综');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (11,'理科综合','理综');


INSERT INTO `sh_question_type` (`id`,`name`) VALUES (1,'单选题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (2,'多选题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (3,'填空题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (4,'计算题');


insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,1);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,2);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,3);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,4);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,5);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,6);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,7);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,8);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,9);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,10);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(2,11);

insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,1);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,2);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,3);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,4);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,5);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,6);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,7);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,8);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,9);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,10);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(4,11);

insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,1);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,2);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,3);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,4);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,5);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,6);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,7);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,8);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(1,9);

insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,1);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,2);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,3);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,4);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,5);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,6);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,7);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,8);
insert into sh_questionbank_course(sh_questionbank_id,sh_course_id) values(3,9);


INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2015');

INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2010');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2015');

INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2015');

INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2010');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2015');


insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (1,1);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (1,2);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (1,3);


insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (2,1);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (2,2);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (2,3);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (2,4);

insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (3,1);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (3,2);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (3,3);


insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (4,1);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (4,2);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (4,3);
insert into sh_questionbank_question_type(sh_questionbank_id,sh_question_type_id) values (4,4);


INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'北京卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'河北卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'北京卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'天津卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'上海卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'广东卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'山东卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'江苏卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'安徽卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'浙江卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'福建卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'湖南卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'湖北卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'陕西卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'重庆卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (2,'海南卷');

INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'北京卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'河北卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'北京卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'天津卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'上海卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'广东卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'山东卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'江苏卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'安徽卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'浙江卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'福建卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'湖南卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'湖北卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'陕西卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'重庆卷');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (4,'海南卷');

INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (1,'新课标');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (1,'老课标');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (3,'新课标');
INSERT INTO `sh_questionbank_type` (`sh_questionbank_id`,`name`) VALUES (3,'老课标');
