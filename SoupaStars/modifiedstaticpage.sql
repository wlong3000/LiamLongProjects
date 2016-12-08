USE SoupaStars;
alter table StaticPage add column Title varchar(100)after Author;
select * from StaticPage;
