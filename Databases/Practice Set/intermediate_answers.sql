-- Find the number of customers for each city
SELECT C_City, COUNT(C_ID) FROM Customer
GROUP BY C_City;

-- Find the total price for all orders
SELECT O_ID, O_CustID, O_SuppID, O_PartID, O_Date, O_ShipMode, P_Price AS TotalPrice
FROM Orders INNER JOIN Part
ON O_PartID = P_ID;

-- Find the city with the most customers
SELECT C_City, COUNT(C_ID) AS CityCount FROM Customer
GROUP BY C_City
HAVING COUNT(C_ID) = (SELECT MAX(NumCustomers) FROM (
                   SELECT C_City, COUNT(C_ID) AS NumCustomers FROM Customer
                   GROUP BY C_City));

-- Find all suppliers that live in a city that has customers
SELECT * FROM Supplier
WHERE S_City IN (SELECT UNIQUE(C_City) FROM Customer);

-- Find all supplier that live in a city without customers

-- Find the average size and price for each part name

-- Find the most common part color

-- Find all shipping modes for Gremlins

-- Find the most common shipping mode for Gremlins

-- Find the customer who has ordered the most Gremlins

-- Find the supplier who has fulfilled the most orders

-- Find the city that ships the most parts by Boat to a customer's city

-- Find the average part size for each shipping mode

-- Find all customers who purchased a Gremlin

-- Find all parts with the same size-- Find the number of customers for each city

-- Find the city with the most customers

-- Find the most common part color

-- Find all suppliers that live in a city that has customers

-- Find all supplier that live in a city without customers

-- Find the average size and price for each part name

-- Find all shipping modes for Gremlins

-- Find the most common shipping mode for Gremlins

-- Find the customer who has ordered the most Gremlins

-- Find the supplier who has fulfilled the most orders

-- Find the city that ships the most parts by Boat to a customer's city

-- Find the average part size for each shipping mode

-- Find the total price for all orders

-- Find all customers who purchased a Gremlin

-- Find all parts with the same size