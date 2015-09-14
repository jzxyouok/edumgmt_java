

--truncate table sh_questionbank_year;
--truncate table sh_questionbank_type;
--truncate table sh_questionbank_course;
--truncate table sh_questionbank_question_type;

--truncate table sh_questionbank;
--truncate table sh_course;
--truncate table sh_question_type;



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
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (7,'政治','政');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (8,'地理','地');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (9,'历史','史');

INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (10,'文科综合','文综');
INSERT INTO `sh_course` (`id`,`name`,`short`) VALUES (11,'理科综合','理综');



INSERT INTO `sh_question_type` (`id`,`name`) VALUES (1,'单项选择题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (2,'多项选择题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (3,'不定项选择题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (4,'填空题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (5,'主观题');





INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,1);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,1);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,1);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,1);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,2);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,2);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,2);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,2);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,3);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,3);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,3);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,3);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,4);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,4);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,4);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,4);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,5);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,5);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,5);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,5);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,6);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,6);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,6);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,6);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,7);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,7);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,7);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,7);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,8);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,8);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,8);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,8);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,9);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,9);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,9);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,9);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,10);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,10);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,10);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,10);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (1,11);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (2,11);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (3,11);
INSERT INTO `sh_questionbank_course` (`sh_questionbank_id`,`sh_course_id`) VALUES (4,11);



INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2015');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2016');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2017');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2018');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2019');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(1,'2020');

INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2010');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2015');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2016');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2017');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2018');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2019');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(2,'2020');

INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2015');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2016');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2017');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2018');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2019');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(3,'2020');

INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2010');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2011');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2012');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2013');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2014');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2015');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2016');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2017');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2018');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2019');
INSERT INTO sh_questionbank_year(sh_questionbank_id,year) VALUES(4,'2020');






INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (1,1,'山东青岛卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (2,1,'天津卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (3,1,'江苏连云港卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (4,1,'江苏宿迁卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (5,1,'山东淄博卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (6,1,'江苏南通卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (7,1,'江苏盐城卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (8,1,'江苏镇江卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (9,1,'江苏无锡卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (10,1,'江苏徐州卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (11,1,'山东威海卷	');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (12,3,'山东青岛卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (13,3,'天津卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (14,3,'江苏连云港卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (15,3,'江苏宿迁卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (16,3,'山东淄博卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (17,3,'江苏南通卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (18,3,'江苏盐城卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (19,3,'江苏镇江卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (20,3,'江苏无锡卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (21,3,'江苏徐州卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (22,3,'山东威海卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (23,2,'新课标I');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (24,2,'新课标II');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (25,2,'北京卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (26,2,'天津卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (27,2,'上海卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (28,2,'广东卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (29,2,'山东卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (30,2,'江苏卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (31,2,'安徽卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (32,2,'浙江卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (33,2,'福建卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (34,2,'湖南卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (35,2,'湖北卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (36,2,'陕西卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (37,2,'四川卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (38,2,'重庆卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (39,2,'海南卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (40,4,'新课标I');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (41,4,'新课标II');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (42,4,'北京卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (43,4,'天津卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (44,4,'上海卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (45,4,'广东卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (46,4,'山东卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (47,4,'江苏卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (48,4,'安徽卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (49,4,'浙江卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (50,4,'福建卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (51,4,'湖南卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (52,4,'湖北卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (53,4,'陕西卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (54,4,'四川卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (55,4,'重庆卷');
INSERT INTO `sh_questionbank_type` (`id`,`sh_questionbank_id`,`name`) VALUES (56,4,'海南卷');
