-- REVIEW [P2 - CẦN GIẢI THÍCH KHI REVIEW]: Script đang phụ thuộc ID cứng 1..4.
-- Cách này chỉ phù hợp khi database hoàn toàn mới. Hãy tìm hiểu cách seed data không phụ thuộc ID vật lý.
INSERT INTO departments (id, code, name) VALUES
(1, 'DEV', 'Phát triển phần mềm'),
(2, 'QA', 'Đảm bảo chất lượng'),
(3, 'HR', 'Nhân sự'),
(4, 'MKT', 'Marketing');


SELECT setval(pg_get_serial_sequence('departments', 'id'), 4);

INSERT INTO employees (code, name, email, salary, hire_date, active, department_id) VALUES
('E001', 'Nguyen Van An',     'an.nguyen@company.com',   22000000.00, '2022-01-15', TRUE,  1),
('E002', 'Tran Thi Bich',     'bich.tran@company.com',   18000000.00, '2022-03-01', TRUE,  1),
('E003', 'Le Hoang Cuong',    'cuong.le@company.com',    25000000.00, '2021-06-10', TRUE,  1),
('E004', 'Pham Minh Duc',     'duc.pham@company.com',    12000000.00, '2023-02-20', FALSE, 1), -- Inactive
('E005', 'Hoang Thu Giang',   'giang.hoang@company.com', 15000000.00, '2022-08-05', TRUE,  2),
('E006', 'Do Manh Hai',       'hai.do@company.com',      16500000.00, '2023-01-12', TRUE,  2),
('E007', 'Vu Thuy Linh',      'linh.vu@company.com',      9500000.00, '2023-07-01', TRUE,  3),
('E008', 'Bui Quang Nam',     'nam.bui@company.com',      8000000.00, '2023-09-15', FALSE, 3), -- Inactive
('E009', 'Ngo Thanh Phong',   'phong.ngo@company.com',   30000000.00, '2020-11-01', TRUE,  1),
('E010', 'Dang Ngoc Son',     'son.dang@company.com',    11000000.00, '2023-10-01', TRUE,  NULL);
