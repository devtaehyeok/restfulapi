/*jpa id 중복 막기 위해 수정*/
insert into user values(901,sysdate(),'User1','test1111','701010-1111111');
insert into user values(902,sysdate(),'User2','test1111','801010-2222222');
insert into user values(903,sysdate(),'User3','test1111','901010-3333333');


insert into post values(10001,'90001',901);
insert into post values(10002,'90002',901);