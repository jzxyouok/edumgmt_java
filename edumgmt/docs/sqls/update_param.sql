

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



INSERT INTO `sh_question_type` (`id`,`name`) VALUES (1,'单选题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (2,'不定项选择题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (3,'填空题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (4,'计算题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (5,'解答题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (28,'阅读简答题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (29,'阅读选择题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (30,'阅读填空题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (31,'诗句填空题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (32,'句型转换题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (33,'简答题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (34,'实验选择题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (35,'实验填空题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (36,'实验解答题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (37,'实验计算题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (38,'作图题');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (39,'单词拼写');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (40,'选词填空');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (41,'完型填空');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (42,'诗词填空');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (43,'诗词鉴赏');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (44,'书面表达');
INSERT INTO `sh_question_type` (`id`,`name`) VALUES (45,'作文');




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


/*
-- Query: SELECT * FROM sh_eduonline.sh_questionbank_question_type
LIMIT 0, 1000

-- Date: 2015-08-26 11:44
*/
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,1);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,1);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,1);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,1);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,2);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,2);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,2);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,2);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,3);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,3);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,3);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,3);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,4);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,4);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,4);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,4);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,5);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,5);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,5);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,5);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,28);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,28);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,28);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,28);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,29);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,29);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,29);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,29);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,30);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,30);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,30);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,30);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,31);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,31);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,31);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,31);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,32);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,32);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,32);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,32);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,33);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,33);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,33);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,33);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,34);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,34);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,34);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,34);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,35);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,35);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,35);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,35);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,36);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,36);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,36);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,36);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,37);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,37);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,37);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,37);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,38);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,38);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,38);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,38);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,39);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,39);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,39);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,39);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,40);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,40);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,40);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,40);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,41);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,41);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,41);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,41);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,42);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,42);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,42);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,42);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,43);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,43);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,43);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,43);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,44);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,44);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,44);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,44);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (1,45);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (2,45);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (3,45);
INSERT INTO `sh_questionbank_question_type` (`sh_questionbank_id`,`sh_question_type_id`) VALUES (4,45);



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
