use SoupaStars;

Create table if not exists SoupaStars.StaticPage(
PageID int not null auto_increment,
Author varchar(50),
Body text(1000),
ExpirationDate varchar(10),
primary key (PageID)
);

insert into StaticPage (PageID, Author, Body, ExpirationDate)
	values (1,'Liam Long', 'rubarb rubarb rubarb', "01/01/2017");
insert into StaticPage (PageID, Author, Body, ExpirationDate)
	values (2,'Chris Bartley', 'Duck, Duck, Samuel L Jackson', "N/A");

