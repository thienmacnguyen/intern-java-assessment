-- REVIEW [P2 - CẦN GIẢI THÍCH KHI REVIEW]: Script đang phụ thuộc ID cứng 1..4.
-- Cách này chỉ phù hợp khi database hoàn toàn mới. Hãy tìm hiểu cách seed data không phụ thuộc ID vật lý.
INSERT INTO employees
(code, name, email, salary, hire_date, active, department_id)
SELECT
    e.code,
    e.name,
    e.email,
    e.salary,
    e.hire_date,
    e.active,
    d.id
FROM (
    VALUES
        ('E001', 'Nguyen Van An',   'an.nguyen@company.com',   22000000.00, '2022-01-15'::date, TRUE,  'DEV'),
        ('E002', 'Tran Thi Bich',   'bich.tran@company.com',   18000000.00, '2022-03-01'::date, TRUE,  'DEV'),
        ('E003', 'Le Hoang Cuong',  'cuong.le@company.com',    25000000.00, '2021-06-10'::date, TRUE,  'DEV'),
        ('E004', 'Pham Minh Duc',    'duc.pham@company.com',    12000000.00, '2023-02-20'::date, FALSE, 'DEV'),
        ('E005', 'Hoang Thu Giang',  'giang.hoang@company.com', 15000000.00, '2022-08-05'::date, TRUE,  'QA'),
        ('E006', 'Do Manh Hai',      'hai.do@company.com',      16500000.00, '2023-01-12'::date, TRUE,  'QA'),
        ('E007', 'Vu Thuy Linh',     'linh.vu@company.com',      9500000.00, '2023-07-01'::date, TRUE,  'HR'),
        ('E008', 'Bui Quang Nam',    'nam.bui@company.com',      8000000.00, '2023-09-15'::date, FALSE, 'HR'),
        ('E009', 'Ngo Thanh Phong',  'phong.ngo@company.com',   30000000.00, '2020-11-01'::date, TRUE,  'DEV'),
        ('E010', 'Dang Ngoc Son',    'son.dang@company.com',    11000000.00, '2023-10-01'::date, TRUE,  NULL)
) AS e(code, name, email, salary, hire_date, active, department_code)
LEFT JOIN departments d
    ON d.code = e.department_code;
