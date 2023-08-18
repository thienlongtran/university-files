-- Find the number of customers
SELECT COUNT(C_ID) FROM Customer;

-- Find all distinct customer names
SELECT DISTINCT C_Name FROM Customer;

-- Find all parts that have a price less than $500
SELECT * FROM Part
WHERE P_Price < 50;

-- Find all blue parts that have a price less than $500
SELECT * FROM PART
WHERE P_Color = 'Blue' AND P_Price < 500;

-- Find all parts that do not have a color available
SELECT * FROM Part
WHERE P_COLOR IS NULL;

-- Find all supplier phone numbers with the area code 202
SELECT * FROM Supplier
WHERE S_Phone LIKE '202%';

-- Find the average price for all green parts
SELECT AVG(P_PRice) FROM Part
WHERE P_Color = 'Green';

-- Find all customers that have the same name as a supplier
SELECT * FROM Customer
WHERE C_NAME IN (SELECT S_NAME from Supplier);

-- Find all orders in the year 2014 that were shipped by boat
SELECT * FROM Orders
WHERE O_Date LIKE '%14' AND O_Shipmode = 'Boat';

-- Find all parts related to Dr. Jones
SELECT * FROM Part
WHERE P_Name LIKE 'Dr. Jones %';

-- Find all of the parts that have a size less than 30 and order the output by color.
SELECT * FROM Part
WHERE P_Size < 30
ORDER BY P_Color;

-- Find the prices and colors of all Gremlins
SELECT P_Price, P_Color FROM Part
WHERE P_Name = 'Gremlin';

-- Find all parts that are larger than the average size
SELECT * FROM Part
WHERE P_Size > (SELECT AVG(P_Size) FROM Part);

-- Find the number of orders place by customer 1
SELECT * FROM Orders
WHERE O_CustID = 1;

-- Find the maximum price among all red parts
SELECT MAX(P_Price) FROM Part
WHERE P_Color = 'Red';

-- Find all colors for Reese's Pieces 
SELECT P_Color AS Color FROM Part
WHERE P_Name = 'Reese''s Pieces';

-- Find orders that have been repeated by the same supplier and customer pairs
SELECT O_CustID, O_SuppID, O_PartID, COUNT(*) FROM Orders