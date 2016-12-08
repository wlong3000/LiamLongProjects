use SoupaStars;

CREATE TABLE IF NOT EXISTS `posts_tags`(
`PostID` int(11) NOT NULL,
 `TagID` int(11) NOT NULL,
 KEY `PostID` (`PostID`),
 KEY `TagID` (`TagID`)
);