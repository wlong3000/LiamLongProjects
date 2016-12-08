create database SoupaStarsBkup;

use SoupaStarsBkup;

create table if not exists SoupaStars.Post
(PostID int not null auto_increment,
Title varchar(50) not null,
PostYear int not null,
PostMonth varchar(10) not null,
PostDay int not null,
Author varchar(50) not null,
PostBody text(999999) not null,
Category varchar(50) not null,
primary key (PostID) );

Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(1,'How Not to Use Sriracha', 2016, 'November', 21, 'Liam Long', 'Number 1: Ketchup','Cooking Fails');
Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(2,"Use ovenmits, kids", 2016, 'November', 22, 'Chris Bartley', 'Ovens are hot.','Miscellaneous');
Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(3,'Why Pie Is Objectively Better Than Cake', 2016, 'November', 17, 'Matt Drozdz', 'It just is.','Pretentious Pedagogy');
Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(4, 'How the Cinammon Challenge Changed My Life', 2016, 'October', 29, 'Alyssa Rice', 'Cinammon is dangerous.','Food Challenges');
Insert into Post (PostID, Title, PostYear, PostMonth, PostDay, Author, PostBody, Category)
	values(5, "Top 10 Grossest Foods and How They're Made", 2016, 'November', 25, 'Liam Long', 'Number 1: Hotdogs','Investigative Journalism');

create table if not exists SoupaStars.Comments
(CommentID int not null auto_increment,
commentText varchar(200) not null,
userName varchar(50) not null,
email varchar(50),
commentDate varchar(50),
primary key (CommentID));

insert into Comments (CommentID, commentText, userName, email, commentDate)
	values(1, 'I was the first to comment!', 'LiamL', 'liam@gmail.com', 'November 17, 2016');
insert into Comments (CommentID, commentText, userName, email, commentDate)
	values(2, "I'm the second person to comment!", 'ChrisB', 'chris@gmail.com', 'November 17, 2016');
insert into Comments (CommentID, commentText, userName, email, commentDate)
	values(3, "What should I say here?", 'MattD', 'matt@gmail.com', 'November 18, 2016');
insert into Comments (CommentID, commentText, userName, email, commentDate)
	values(4, 'I was the first to comment! Oh wait...', 'AlyssaR', 'alyssa@gmail.com', 'November 20, 2016');

create table if not exists SoupaStars.Tag
(TagID int not null auto_increment,
TagBody varchar(50),
primary key (TagID));

insert into Tag (TagID, TagBody) values (1,"tooManyRs");
insert into Tag (TagID, TagBody) values (2,'isTheStoveOn');
insert into Tag (TagID, TagBody) values (3,"ICan'tFeelMyFingers");
insert into Tag (TagID, TagBody) values (4,'appleStreudel');
insert into Tag (TagID, TagBody) values (5,"'nufSaid");
insert into Tag (TagID, TagBody) values (6,"tryThisAtHome");
insert into Tag (TagID, TagBody) values (7, "clickBait");

create table if not exists SoupaStars.User
(UserID int auto_increment not null,
Username varchar(50) not null,
UserPassword varchar(20) not null,
primary key (UserID));

Insert into User (UserID, Username, UserPassword)
	values(1, 'LiamL', 'password');

create table if not exists SoupaStars.PostComment
(PostID int not null, CommentID int);
alter table PostComment add constraint fk_PostComment_PostID foreign key (PostID) references Post(PostID);
alter table PostComment add constraint fk_PostComment_CommentID foreign key (CommentID) references Comments(CommentID);

Insert into PostComment (PostID, CommentID) values(1,1);
Insert into PostComment (PostID, CommentID) values(1,2);
Insert into PostComment (PostID, CommentID) values(2,3);
Insert into PostComment (PostID, CommentID) values(2,4);
Insert into PostComment (PostID, CommentID) values(2,5);

create table if not exists SoupaStars.PostTag
(PostID int not null, TagID int);

insert into PostTag (PostID, TagID) values(1,1);
insert into PostTag (PostID, TagID) values (2,2);
insert into PostTag (PostID, TagID) values (2,3);
insert into PostTag (PostID, TagID) values (3,4);
insert into PostTag (PostID, TagID) values (3,5);
insert into PostTag (PostID, TagID) values (4,6);
insert into PostTag (PostId, TagID) values (5,7);

select * from Post;
select * from PostComment;
select * from PostTag;
select * from Comments;
select * from Tag;
UPDATE `SoupaStars`.`Post` SET `PostMonth`='October', `PostDay`='23' WHERE `PostID`='1';
UPDATE `SoupaStars`.`Post` SET `PostMonth`='October', `PostDay`='29' WHERE `PostID`='2';
UPDATE `SoupaStars`.`Post` SET `PostDay`='8' WHERE `PostID`='3';
UPDATE `SoupaStars`.`Post` SET `PostMonth`='November', `PostDay`='14' WHERE `PostID`='4';
select commentText, userName, email, commentDate from PostComment join Comments using (CommentID) where PostID = 2;
select TagBody from PostTag join Tag using (TagID) where PostID = 2;
select CommentID from PostComment join Comments using (CommentID) where PostID = 1;
