

DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID,
               c.Name,
               l.LoanID,
               l.InterestRate,
               FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS age
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;
BEGIN
    FOR rec IN c_customers LOOP
        IF rec.age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE('discount applied: ' || rec.Name || ' age ' || rec.age || ' new rate ' || (rec.InterestRate - 1) || '%');
        END IF;
    END LOOP;

    COMMIT;
END;
/
