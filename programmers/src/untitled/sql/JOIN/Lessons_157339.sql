-- 특정 기간 동안 대여 가능한 자동차들의 대여 비용 구하기

-- Table
-- Car(car id, car type, daily fee, options),
-- Rental History(history id, car id, start date, end date),
-- Discount Plan(plan id, car type, duration type, discount rate)

-- 차종 : 세단, suv
-- 대여 가능 기간 : 221101 ~ 221130
-- 해당 기간 대여 금액 : 50만원 이상 200만원 미만
-- 정렬 : 대여 금액 desc, 차종 asc, 차 id desc
-- 컬럼명 : 대여 금액 (FEE)
-- 계산 : 할인율 적용 후 정수 부분만 출력

SELECT C.CAR_ID, C.CAR_TYPE, ROUND(C.DAILY_FEE*30*(100-P.DISCOUNT_RATE)/100) AS FEE
    FROM CAR_RENTAL_COMPANY_CAR C
        JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID
        JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE
    WHERE C.CAR_ID NOT IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01'
        ) AND P.DURATION_TYPE LIKE '30%'
GROUP BY C.CAR_ID
HAVING C.CAR_TYPE IN ('세단', 'SUV') AND (FEE >= 500000 AND FEE < 2000000)
ORDER BY  FEE DESC, CAR_TYPE, CAR_ID DESC