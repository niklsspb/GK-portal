INSERT INTO `support_boot_db`.`role` (`id`, `description`) VALUES
 ('2c2d80c3-23db-432f-8ca9-ce71b3b03284', 'admin'),
 ('883f9021-1899-4053-b3c7-4a26a73c5672', 'manager');

INSERT INTO `support_boot_db`.`account` (`id`, `login`, `confirmed`, `active`, `password_hash`) VALUES
('5275f748-51d3-4220-9533-0a4f1428ef0e', 'admin_login', b'1', b'1', '$2a$10$NKFyj/dcM.HCT52A2jO/k.Vq52X8F1Yhc2wC2MOaWzkztDcyM6hYu'),
('f39a293f-ae2c-4af0-b5b1-80c1529231e5', 'manager_login', b'1', b'1', '$2a$10$NKFyj/dcM.HCT52A2jO/k.Vq52X8F1Yhc2wC2MOaWzkztDcyM6hYu');

INSERT INTO `support_boot_db`.`account_role` (`account_id`, `role_id`) VALUES
('5275f748-51d3-4220-9533-0a4f1428ef0e', '2c2d80c3-23db-432f-8ca9-ce71b3b03284'),
('f39a293f-ae2c-4af0-b5b1-80c1529231e5', '883f9021-1899-4053-b3c7-4a26a73c5672');