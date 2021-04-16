INSERT INTO USER VALUES
(111,'Matt','matt82@gmail.com'),
(222,'Sam','samuel@outlook.com'),
(333,'Elle','ellej@hotmail.com');

INSERT INTO BLOG VALUES
(100,'Spring boot Introduction - Content for Beginners','Spring Guide',222),
(200,'How to make a cake from Scratch','Simple Cake Recipe',111),
(300,'Dolphins, Octopus','Aquatic Creatures in Australia',222);

INSERT INTO COMMENT VALUES
(10,'Good Work',200,111),
(15,'Easy guide',100,333),
(20,'Simple to Follow',200,222),
(30,'Very good',200,333),
(35,'Keep it up',100,222);

INSERT INTO CATEGORY VALUES
(1,'Travel'),
(2,'Music'),
(3,'Technology'),
(4,'Food'),
(5,'Animals');

INSERT INTO Category_Blog VALUES
(3,100),
(4,200),
(1,300),
(5,300);