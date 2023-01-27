create table customer (
cID int primary key,
cName varchar(10),
cAge int
);

create table orderr (
oID int primary key,
cID int,
oDate date,
oTotalPrice int
);

create table product (
pID int primary key,
pName varchar(10),
pPrice int
);

create table orderdetail (
oID int,
pID int,
primary key(oID, pID),
foreign key (oID) references orderr (oID),
foreign key (pID) references product (pID)
);

alter table orderdetail
add column odQTY int;

select oID, oDate, oTotalPrice
from orderr;

select cName, oDate, oTotalPrice, odQTY, pName, pPrice
from customer C join orderr 		O 		on C.cID = O.cID 
				join orderdetail 	OD 		on O.oID = OD.oID 
                join product 		P 		on P.pID = OD.pID
;

select *
from customer C join orderr O on C.cID = O.cID;

select *, odQTY*pPrice as oTotalPrice
from orderr O join orderdetail OD on O.oID = OD.oID join product P on P.pID = OD.pID
;




