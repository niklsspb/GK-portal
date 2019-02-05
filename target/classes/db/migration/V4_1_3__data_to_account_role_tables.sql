INSERT INTO `support_boot_db`.`role` (`id`, `description`)
VALUES ('ebb66409-3e94-48f2-8021-b1df90f02a3b', 'user');


INSERT INTO `support_boot_db`.`contact_type` (`id`, `description`)
VALUES ('ccd7b370-47ad-473a-ab1f-d1641e096d72', 'Житель'),
       ('e99cc24d-fcc8-4bfd-803a-66554103961b', 'Собственник'),
       ('59f14283-2dcf-4065-8244-ba3232c9af30', 'Арендатор');

INSERT INTO `support_boot_db`.`contact` (`id`, `contact_type_id`, `first_name`, `middle_name`, `last_name`)
VALUES ('27fa708c-394d-43b7-8358-b58050ecfdb8',
        'ccd7b370-47ad-473a-ab1f-d1641e096d72',
        'Contact_first_name',
        'Contact_middle_name',
        'Contact_last_name');


INSERT INTO `support_boot_db`.`account` (`id`, `login`, `confirmed`, `active`, `password_hash`, `contact_id`)
VALUES ('0eee4c80-86fe-4579-9f55-c812a2f8db59',
        'habitant_login',
        b'1',
        b'1',
        '$2a$10$NKFyj/dcM.HCT52A2jO/k.Vq52X8F1Yhc2wC2MOaWzkztDcyM6hYu',
        '27fa708c-394d-43b7-8358-b58050ecfdb8');

INSERT INTO `support_boot_db`.`account_role` (`account_id`, `role_id`)
VALUES ('0eee4c80-86fe-4579-9f55-c812a2f8db59', 'ebb66409-3e94-48f2-8021-b1df90f02a3b');
