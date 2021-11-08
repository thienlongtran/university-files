-- Find the number of customers for each city
SELECT C_City, COUNT(C_ID) FROM Customer
GROUP BY C_City
ORDER BY COUNT(C_ID);

-- Find the total price for all orders
SELECT SUM(P_Price)
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
SELECT * FROM Supplier
WHERE S_City NOT IN (SELECT UNIQUE(C_City) FROM Customer);

-- Find the average size and price for each part name
SELECT P_Name, AVG(P_PRICE), AVG(P_Size) FROM Part
GROUP BY P_Name;

-- Find the most common part color
SELECT P_Color, COUNT(*) FROM Part
GROUP BY P_Color
HAVING COUNT(*) = (SELECT MAX(COUNT(*)) FROM Part
                   GROUP BY P_Color);

-- Find all shipping modes for Gremlins
SELECT DISTINCT(O_ShipMode) FROM Orders
WHERE O_PartID IN (SELECT P_ID FROM Part
                   WHERE P_Name = 'Gremlin');

-- Find the most common shipping mode for Gremlins
SELECT O_ShipMode, COUNT(*) FROM Orders
WHERE O_PartID IN (SELECT P_ID FROM Part
                   WHERE P_Name = 'Gremlin')
GROUP BY O_ShipMode
HAVING COUNT(*) =
    (SELECT MAX(COUNT(*)) FROM Orders
    WHERE O_PartID IN (SELECT P_ID FROM Part
                       WHERE P_Name = 'Gremlin')
    GROUP BY O_ShipMode);
                   
-- Find the customer who has ordered the most Gremlins
SELECT C_Name, COUNT(*) FROM Customer c, Orders o, Part p
WHERE c.C_ID = o.O_CustID
AND o.O_PartID = p.P_ID
AND p.P_Name = 'Gremlin'
GROUP BY C_Name
HAVING COUNT(*) = ( SELECT MAX(COUNT(*)) FROM Customer c, Orders o, Part p
                    WHERE c.C_ID = o.O_CustID
                    AND o.O_PartID = p.P_ID
                    AND p.P_Name = 'Gremlin'
                    GROUP BY C_Name );

-- Find the supplier who has fulfilled the most orders
SELECT s.S_ID, s.S_Name, COUNT(*) FROM Supplier s INNER JOIN Orders o
ON s.S_ID = o.O_SuppID
GROUP BY s.S_ID, s.S_Name
HAVING COUNT(*) = ( SELECT MAX(COUNT(*)) FROM Supplier s INNER JOIN Orders o
                    ON s.S_ID = o.O_SuppID
                    GROUP BY s.S_ID, s.S_Name );

-- Find the city that ships the most parts by Boat to a customer's city
SELECT C_ID, C_Name, C_City, COUNT(*) AS Orders FROM Customer INNER JOIN Orders
ON C_ID = O_CustID
WHERE O_ShipMode = 'Boat'
GROUP BY C_ID, C_Name, C_City
HAVING COUNT(*) = ( SELECT MAX(COUNT(*)) FROM Customer INNER JOIN Orders
                    ON C_ID = O_CustID
                    WHERE O_ShipMode = 'Boat'
                    GROUP BY C_ID, C_Name, C_City);

-- Find the average part size for each shipping mode
SELECT O_ShipMode, AVG(P_Size) FROM Part INNER JOIN Orders
ON P_ID = O_PartID
GROUP BY O_ShipMode;

-- Find all customers who purchased a Gremlin
SELECT C_ID, C_Name FROM Customer INNER JOIN Orders
ON O_CustID = C_ID
INNER JOIN Part
ON P_ID = O_PartID
WHERE P_Name = 'Gremlin';
                 
-- Find all parts with the same size
SELECT * FROM Part p1, Part p2
WHERE p1.P_ID != p2.P_ID
AND p1.P_Size = p2.P_Size;

-- Find the number of customers for each city

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