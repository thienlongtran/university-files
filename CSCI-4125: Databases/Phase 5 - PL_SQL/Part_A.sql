DECLARE
    avg_price INTEGER := 0;
    min_price INTEGER := 999999999999;
    max_price INTEGER := 0;
    row_count INTEGER := 0;
    
    temp_price INTEGER := 0;
    temp_difference INTEGER := 0;
    
    CURSOR PricePerSquareFeet IS (SELECT AskingPrice / SquareFeet AS PricePerArea FROM House);
    CURSOR HouseData IS (SELECT * FROM House);

BEGIN
    FOR Prices IN PricePerSquareFeet LOOP
        IF min_price > Prices.PricePerArea THEN
            min_price := Prices.PricePerArea;
        ELSIF max_price < Prices.PricePerArea THEN
            max_price := Prices.PricePerArea;
        END IF;
        IF Prices.PricePerArea IS NOT NULL THEN
            avg_price := avg_price + Prices.PricePerArea;
            row_count := row_count + 1;
        END IF;
    END LOOP;
    avg_price := avg_price / row_count;
    
    DBMS_OUTPUT.PUT_LINE('Minimum Price: $' || min_price || '/sqft');
    DBMS_OUTPUT.PUT_LINE('Average Price: $' || avg_price || '/sqft');
    DBMS_OUTPUT.PUT_LINE('Max Price: $' || max_price || '/sqft');
    DBMS_OUTPUT.PUT_LINE('');
    
    FOR H_Data IN HouseData LOOP
        temp_price := H_Data.AskingPrice / H_Data.SquareFeet;
        
        IF temp_price < avg_price THEN
            temp_difference := avg_price - temp_price;
            DBMS_OUTPUT.PUT_LINE(H_Data.StreetAddress || ' $' || temp_difference || ' Below Average.');
        ELSIF temp_price >= avg_price THEN
            temp_difference := temp_price - avg_price;
            DBMS_OUTPUT.PUT_LINE(H_Data.StreetAddress || ' $' || temp_difference || ' Above Average.');
        ELSE
            DBMS_OUTPUT.PUT_LINE(H_Data.StreetAddress || ' Information Unavailable.');
        END IF;
    END LOOP;
END;