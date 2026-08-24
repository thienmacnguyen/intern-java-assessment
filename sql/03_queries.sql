-- 1. Lấy toàn bộ nhân viên
SELECT * FROM employees;

-- 2. Lấy các nhân viên đang active
SELECT * FROM employees 
WHERE active = TRUE;

-- 3. Lấy nhân viên có salary lớn hơn 10.000.000
SELECT * FROM employees 
WHERE salary > 10000000;

-- 4. Lấy nhân viên có salary từ 10.000.000 đến 20.000.000
SELECT * FROM employees 
WHERE salary BETWEEN 10000000 AND 20000000;

-- 5. Tìm nhân viên có tên chứa một từ khóa, không phân biệt hoa/thường
SELECT * FROM employees 
WHERE name ILIKE '%an%';

-- 6. Sắp xếp nhân viên theo salary giảm dần; nếu cùng salary thì name tăng dần
SELECT * FROM employees 
ORDER BY salary DESC, name ASC;

-- 7. Lấy 05 nhân viên có salary cao nhất
SELECT * FROM employees 
ORDER BY salary DESC 
LIMIT 5;

-- 8. Hiển thị employee_code, employee_name, salary và department_name
SELECT 
    e.code AS employee_code,
    e.name AS employee_name,
    e.salary,
    d.name AS department_name
FROM employees e
LEFT JOIN departments d ON e.department_id = d.id;

-- 9. Thống kê mỗi phòng: số nhân viên, lương trung bình và tổng lương
SELECT 
    d.id AS department_id,
    d.name AS department_name,
    COUNT(e.id) AS employee_count,
    COALESCE(ROUND(AVG(e.salary), 2), 0) AS avg_salary,
    COALESCE(SUM(e.salary), 0) AS total_salary
FROM departments d
LEFT JOIN employees e ON d.id = e.department_id
GROUP BY d.id, d.name
ORDER BY d.id;

-- 10. Lấy các phòng ban có ít nhất 02 nhân viên đang active
SELECT 
    d.id,
    d.name AS department_name,
    COUNT(e.id) AS active_employee_count
FROM departments d
JOIN employees e ON d.id = e.department_id
WHERE e.active = TRUE
GROUP BY d.id, d.name
HAVING COUNT(e.id) >= 2;

-- 11. Lấy danh sách nhân viên chưa thuộc phòng ban nào
SELECT * FROM employees 
WHERE department_id IS NULL;

-- 12. Lấy nhân viên có salary lớn hơn salary trung bình của toàn công ty
SELECT * FROM employees 
WHERE salary > (SELECT AVG(salary) FROM employees);