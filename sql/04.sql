-- 1. INSERT thêm một phòng ban mới
INSERT INTO departments (code, name) 
VALUES ('FIN', 'Tài chính Kế toán');

-- 2. INSERT thêm một nhân viên thuộc phòng ban vừa tạo FIN
INSERT INTO employees (code, name, email, salary, hire_date, active, department_id)
VALUES (
    'E011', 
    'Hoang Van Thai', 
    'thai.hoang@company.com', 
    14000000.00, 
    CURRENT_DATE, 
    TRUE, 
    (SELECT id FROM departments WHERE code = 'FIN')
);

-- 3. UPDATE email của nhân viên theo employee code
UPDATE employees 
SET email = 'an.nguyen.new@company.com' 
WHERE code = 'E001';

-- 4. UPDATE salary tăng thêm 10% cho phòng ban DEV
UPDATE employees 
SET salary = salary * 1.10 
WHERE department_id = (SELECT id FROM departments WHERE code = 'DEV');

-- 5. UPDATE active = FALSE cho một nhân viên theo employee code
UPDATE employees 
SET active = FALSE 
WHERE code = 'E002';

-- 6. DELETE một nhân viên theo employee code
-- Bước 6.1: SELECT kiểm tra trước bản ghi sẽ bị xóa
SELECT * FROM employees WHERE code = 'E011';

-- Bước 6.2: Thực hiện DELETE có điều kiện WHERE
DELETE FROM employees WHERE code = 'E011';