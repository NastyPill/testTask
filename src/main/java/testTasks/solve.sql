--PostgreSql 10.12
SELECT starts, number
FROM (
         SELECT *,
                nums + 1                                                 starts,
                ABS(nums - LEAD(nums, 1, nums) OVER (ORDER BY nums)) - 1 number

         FROM nums) as task4 WHERE number > 0;
--Делаем выборку из пар вида: (nums + 1 (число с которого пропуск), |nums[i] - nums[i+1]| (число пропусков))
-- и отсекаем те записи, у которых число пропусков 0.