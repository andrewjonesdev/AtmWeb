create schema atm;
use atm;
create table CustomerATM(
	cusFirstName varchar (255),
    cusLastName varChar (255),
    cusID integer auto_increment,
    primary key (cusID)
);
create table AccountATM(
    accBalance double,
	accCus integer,
	accID integer auto_increment,
    primary key (accID)
);
create table TransactionATM(
    
    
    tranAction varChar (255), #withdrawal or deposit
    tranAmount double,
    tranReason varChar (255),
    tranAcc integer,
    tranID integer auto_increment,
    primary key (tranID)
);

SELECT CustomerATM.cusID = AccountATM.accCus
FROM CustomerATM
INNER JOIN AccountATM ON CustomerATM.cusID = AccountATM.accCus;

SELECT AccountATM.accID = TransactionATM.tranAcc
FROM AccountATM
INNER JOIN TransactionATM ON AccountATM.accID = TransactionATM.tranAcc;

show create table CustomerATM;

select* from CustomerATM;

describe CustomerATM;

show create table AccountATM;

select* from AccountATM;

describe AccountATM;

show create table TransactionATM;

select* from TransactionATM;

describe TransactionATM;
