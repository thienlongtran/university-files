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

-- Find all orders in the year 2014 that were shipped by boat

-- Find all parts related to Dr. Jones

-- Find all of the parts that have a size less than 30 and order the output by color.

-- Find the prices and colors of all Gremlins

-- Find all parts that are larger than the average size

-- Find the number of orders place by customer 1

-- Find the maximum price among all red parts

-- Find all colors for Reese's Pieces 

-- Find orders that have been repeated by the same supplier and customer pairs