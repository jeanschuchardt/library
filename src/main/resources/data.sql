INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (1,'Jean','Burda')
INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (2,'Gilleanes','Guedes')
INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (3,'Robert','Martin')
INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (4,'Ralph','Johnson')
INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (5,'Erich','Gamma')
INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (6,'Richard','Helm')
INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (7,'John','Vlissides')
INSERT INTO AUTHOR (ID,FIRST_NAME,LAST_NAME) VALUES (8,'Douglas','Adams')

INSERT INTO GENER (ID,NAME) VALUES (1,'sci-fi')
INSERT INTO GENER (ID,NAME) VALUES (2,'IT_BOOK')

INSERT INTO BOOK (ID,NUMBER,PAGE_COUNT,TITLE) VALUES (1,154,1000,'Clean Code')
INSERT INTO BOOK (ID,NUMBER,PAGE_COUNT,TITLE) VALUES (2,333,130,'The Ultimate Hitchhikers Guide')
INSERT INTO BOOK (ID,NUMBER,PAGE_COUNT,TITLE) VALUES (3,222,1450,'design patterns: elements of reusable object-oriented software')


INSERT INTO BOOK_AUTHOR_LIST (BOOK_LIST_ID,AUTHOR_LIST_ID) VALUES (1,3)
INSERT INTO BOOK_AUTHOR_LIST (BOOK_LIST_ID,AUTHOR_LIST_ID) VALUES (2,8)
INSERT INTO BOOK_AUTHOR_LIST (BOOK_LIST_ID,AUTHOR_LIST_ID) VALUES (3,4)
INSERT INTO BOOK_AUTHOR_LIST (BOOK_LIST_ID,AUTHOR_LIST_ID) VALUES (3,5)
INSERT INTO BOOK_AUTHOR_LIST (BOOK_LIST_ID,AUTHOR_LIST_ID) VALUES (3,6)
INSERT INTO BOOK_AUTHOR_LIST (BOOK_LIST_ID,AUTHOR_LIST_ID) VALUES (3,7)

INSERT INTO BOOK_GENERS_LIST (BOOK_LIST_ID,GENERS_LIST_ID) VALUES(1,2)
INSERT INTO BOOK_GENERS_LIST (BOOK_LIST_ID,GENERS_LIST_ID) VALUES(2,1)
INSERT INTO BOOK_GENERS_LIST (BOOK_LIST_ID,GENERS_LIST_ID) VALUES(3,2)

INSERT INTO BORROWER (ID,BORROWING_LIMIT,FIRST_NAME,LAST_NAME)VALUES(1,3,'Jean','Burda')
INSERT INTO BORROWER (ID,BORROWING_LIMIT,FIRST_NAME,LAST_NAME)VALUES(2,5,'Paul','Walkes')
INSERT INTO BORROWER (ID,BORROWING_LIMIT,FIRST_NAME,LAST_NAME)VALUES(3,6,'Keanu','Reeves')
INSERT INTO BORROWER (ID,BORROWING_LIMIT,FIRST_NAME,LAST_NAME)VALUES(4,7,'Sharon','Stone')


INSERT INTO LOAN_RECORD (ID,BOOK_FK,BORROWER_FK)VALUES(1,1,1)
INSERT INTO LOAN_RECORD (ID,BOOK_FK,BORROWER_FK)VALUES(2,1,2)
INSERT INTO LOAN_RECORD (ID,BOOK_FK,BORROWER_FK)VALUES(3,1,3)
INSERT INTO LOAN_RECORD (ID,BOOK_FK,BORROWER_FK)VALUES(4,2,3)
INSERT INTO LOAN_RECORD (ID,BOOK_FK,BORROWER_FK)VALUES(5,2,3)
INSERT INTO LOAN_RECORD (ID,BOOK_FK,BORROWER_FK)VALUES(6,3,4)



