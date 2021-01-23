DELETE
FROM employee;
ALTER SEQUENCE employee_seq RESTART WITH 100000;

INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Abigail', 'Wall', 'libero.nec@arcuacorci.ca', '35487021465', '2021-06-18 18:50:34'),
       ('Griffin', 'Hays', 'et@Donecconsectetuermauris.edu', '21876305386', '2021-12-21 16:24:30'),
       ('Blythe', 'Watts', 'nonummy.ultricies@Uttincidunt.edu', '87581396664', '2020-12-01 00:10:33'),
       ('Candice', 'Garner', 'interdum.enim.non@feugiatplaceratvelit.com', '53048958508', '2020-04-08 01:00:32'),
       ('Merritt', 'Kidd', 'amet@quisaccumsanconvallis.ca', '91888319040', '2021-06-03 06:55:14'),
       ('Brendan', 'Cunningham', 'purus.in@odio.co.uk', '34229350213', '2021-09-25 15:53:47'),
       ('Reece', 'Walsh', 'amet.nulla.Donec@ipsum.co.uk', '28792388621', '2021-09-26 00:31:38'),
       ('Russell', 'Dunn', 'tempor@Maurisvestibulumneque.net', '62942478422', '2021-01-30 15:09:36'),
       ('Upton', 'Patrick', 'enim.Mauris.quis@primisinfaucibus.co.uk', '73739474318', '2020-11-28 22:31:24'),
       ('Harrison', 'Hancock', 'laoreet.posuere.enim@dictumaugue.com', '75414360338', '2020-10-23 12:47:06');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Rahim', 'Kinney', 'eu.ultrices.sit@sodalesnisimagna.edu', '81048773939', '2020-04-22 00:12:03'),
       ('Reese', 'Zamora', 'et.rutrum.eu@Nulla.net', '33406935225', '2021-11-13 09:47:02'),
       ('Yoko', 'Elliott', 'eu.odio.tristique@afacilisis.edu', '54846842977', '2020-12-30 09:17:37'),
       ('Troy', 'David', 'scelerisque@odiotristiquepharetra.com', '74485184105', '2020-08-21 09:49:35'),
       ('Palmer', 'Johnson', 'velit.egestas@nislarcu.edu', '62637247632', '2022-01-06 10:53:05'),
       ('Warren', 'Mcgee', 'semper.pretium@pede.net', '42977853932', '2021-05-03 13:40:36'),
       ('Hayley', 'Noel', 'Integer@Proin.edu', '46315481793', '2020-11-15 10:54:31'),
       ('Libby', 'Ferrell', 'sociis@a.ca', '11716403367', '2021-07-27 14:00:56'),
       ('Ishmael', 'Dominguez', 'lorem@aliquetmagnaa.co.uk', '47682105704', '2021-06-08 19:28:10'),
       ('Dacey', 'Slater', 'et@nec.co.uk', '36623731559', '2021-07-04 10:16:48');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Gary', 'Sears', 'nibh.enim.gravida@velitegestaslacinia.ca', '89957438334', '2020-10-11 08:38:47'),
       ('Damon', 'Macdonald', 'nibh@facilisisfacilisis.net', '31019054353', '2021-05-12 18:53:22'),
       ('Simon', 'Christian', 'lectus.Nullam@rhoncus.ca', '25631613888', '2021-05-02 07:06:30'),
       ('Aimee', 'Barker', 'auctor.velit@mienimcondimentum.com', '76244836808', '2020-01-25 21:13:52'),
       ('Zahir', 'Bender', 'eros.non.enim@velitAliquam.edu', '37468725567', '2020-12-22 08:57:25'),
       ('Davis', 'Pennington', 'pellentesque.eget.dictum@cursusvestibulumMauris.edu', '35065120126',
        '2020-05-27 21:05:20'),
       ('Iola', 'Roach', 'et.ipsum@blandit.com', '12867761622', '2020-08-10 18:46:34'),
       ('Zephania', 'Potter', 'lectus.rutrum.urna@Suspendisseac.org', '13673471331', '2021-12-09 23:04:25'),
       ('Pamela', 'Beard', 'enim@sitamet.org', '87193001006', '2020-06-12 11:43:33'),
       ('Chanda', 'King', 'lacus.Quisque.purus@nonummy.edu', '62686562507', '2020-07-06 19:33:31');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Jakeem', 'Parrish', 'non.enim.commodo@imperdiet.ca', '06276109669', '2021-06-01 12:15:55'),
       ('Aurora', 'Barnett', 'consectetuer@Sednecmetus.org', '15026864180', '2020-04-12 19:39:48'),
       ('Dacey', 'Pierce', 'nibh@tortorNunccommodo.ca', '78304200954', '2021-11-13 20:17:30'),
       ('Channing', 'Marsh', 'vel.arcu@mollisnec.ca', '69351834106', '2021-12-14 01:02:07'),
       ('Benjamin', 'Hebert', 'ut.lacus@luctuslobortisClass.org', '93903528344', '2021-05-04 05:49:55'),
       ('Duncan', 'Prince', 'imperdiet.ullamcorper@acmetusvitae.org', '88833908997', '2020-03-04 05:51:21'),
       ('Halee', 'Case', 'venenatis@natoquepenatibus.com', '23392357122', '2021-09-12 04:56:36'),
       ('Donna', 'Cote', 'malesuada.vel@tincidunt.net', '11269063517', '2021-10-09 23:02:36'),
       ('Daniel', 'Lawrence', 'nisi@IncondimentumDonec.net', '87762561976', '2021-02-22 22:58:08'),
       ('Ivory', 'Barrett', 'Aenean@ut.net', '28877244202', '2021-12-25 01:49:52');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Hiram', 'Witt', 'fringilla.cursus.purus@Naminterdumenim.edu', '49095588618', '2020-08-19 22:52:48'),
       ('Timon', 'Mccoy', 'mauris.ipsum@non.co.uk', '29963303240', '2022-01-06 01:04:36'),
       ('Michelle', 'Kaufman', 'in.magna.Phasellus@odioEtiam.org', '28178214476', '2020-05-27 09:00:41'),
       ('Kendall', 'William', 'cursus@Nullamscelerisque.co.uk', '44692997396', '2020-10-30 01:17:35'),
       ('Ria', 'Owens', 'tincidunt@Aenean.com', '91122611621', '2021-02-23 17:52:32'),
       ('Karina', 'Clay', 'lobortis.risus@loremsit.edu', '32278401771', '2021-03-07 10:57:25'),
       ('Noelani', 'Miranda', 'dolor.sit.amet@consequat.ca', '46526644719', '2021-06-17 23:07:58'),
       ('Cadman', 'Slater', 'Aliquam.adipiscing@enimcommodo.edu', '83945746732', '2021-04-13 01:13:12'),
       ('Eric', 'Saunders', 'Sed.auctor@hymenaeos.co.uk', '19103697205', '2020-08-14 08:32:32'),
       ('Duncan', 'Perkins', 'pede.et.risus@odioNam.com', '17653689398', '2021-11-10 21:41:11');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Lacey', 'Reese', 'non@anteblanditviverra.edu', '82698079499', '2021-12-07 14:22:10'),
       ('Jin', 'Patterson', 'lacinia.vitae.sodales@et.ca', '75866734338', '2021-12-18 15:48:55'),
       ('Justine', 'Robles', 'ornare.tortor.at@lobortis.edu', '81229010959', '2020-10-02 03:34:29'),
       ('Duncan', 'Fuentes', 'magna.nec@seddictumeleifend.com', '83101284351', '2020-11-18 12:04:47'),
       ('Ivan', 'Alexander', 'Suspendisse.aliquet@arcuSedet.net', '64948450549', '2020-06-01 10:29:08'),
       ('Linus', 'Ortiz', 'consectetuer.mauris.id@lacus.org', '04546703064', '2021-02-10 04:16:29'),
       ('Fritz', 'Hood', 'Proin.mi@nisiCumsociis.edu', '66586120566', '2020-07-08 11:59:11'),
       ('Jasmine', 'Harrison', 'vitae.erat.Vivamus@montesnasceturridiculus.edu', '93086530421', '2021-01-06 01:16:05'),
       ('Tatum', 'Trujillo', 'Donec@aenimSuspendisse.org', '05184190822', '2020-08-13 01:43:01'),
       ('Baker', 'Raymond', 'quis.pede@id.com', '65391802052', '2021-11-18 23:50:09');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Reece', 'Ingram', 'montes@aliquamenimnec.net', '48417156402', '2020-04-10 10:09:34'),
       ('Tucker', 'Hart', 'arcu@cursusvestibulum.ca', '05603275902', '2021-11-13 01:34:45'),
       ('Mia', 'Ratliff', 'Sed@Aliquamfringilla.net', '94349518321', '2020-12-20 14:33:50'),
       ('Kuame', 'Harvey', 'sit.amet@disparturientmontes.co.uk', '93722472145', '2021-12-14 08:00:59'),
       ('Katell', 'Mayer', 'at.egestas@euelitNulla.com', '22485570659', '2021-03-31 00:35:03'),
       ('Harding', 'Lynch', 'Nullam.enim.Sed@Cras.co.uk', '82132876594', '2020-02-14 06:25:27'),
       ('Caldwell', 'Castillo', 'dictum.Proin.eget@sit.ca', '95317178943', '2021-12-24 07:24:34'),
       ('Hayley', 'Taylor', 'ipsum.Phasellus@dolorNulla.ca', '91619863139', '2020-10-12 20:18:01'),
       ('Charity', 'Barr', 'pede.et.risus@molestieSed.edu', '33207577354', '2020-02-10 01:13:32'),
       ('Irene', 'Frank', 'eu@massaMauris.edu', '64153805859', '2021-01-29 02:42:08');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Warren', 'Briggs', 'at@ligula.net', '42924973197', '2021-02-27 07:22:41'),
       ('Tatiana', 'Gonzalez', 'Nunc.lectus.pede@enimnislelementum.co.uk', '66931227352', '2021-10-11 22:52:37'),
       ('Odysseus', 'Mann', 'metus.In.lorem@pede.net', '61631587783', '2020-03-06 15:08:03'),
       ('Marshall', 'Webb', 'Praesent@quis.co.uk', '45918582300', '2020-07-20 10:33:37'),
       ('Azalia', 'Hays', 'scelerisque.neque@dui.ca', '29706221151', '2020-09-12 02:18:51'),
       ('Malcolm', 'Simpson', 'nonummy.ut@nec.ca', '46013824040', '2020-12-21 01:21:52'),
       ('Steel', 'Powers', 'Donec@vitae.ca', '12934821016', '2021-03-20 17:15:36'),
       ('Zachary', 'Hensley', 'tellus@a.org', '29637591836', '2021-04-03 04:23:21'),
       ('Honorato', 'Strickland', 'justo.Proin.non@viverraMaecenas.net', '61016702001', '2020-12-28 16:04:40'),
       ('Kathleen', 'Sykes', 'ornare.sagittis@purusactellus.net', '24197405654', '2020-05-19 09:35:14');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Pascale', 'Brennan', 'Quisque@ultrices.edu', '76335740851', '2021-02-12 21:21:51'),
       ('Hector', 'Bass', 'ullamcorper.magna@sed.co.uk', '82914620034', '2021-03-02 11:41:38'),
       ('Brady', 'Mejia', 'Donec.tempus@sedconsequatauctor.edu', '34287092059', '2021-03-15 12:05:21'),
       ('Tashya', 'Bullock', 'odio.semper.cursus@pharetra.net', '15146700999', '2021-08-21 04:59:19'),
       ('Uriel', 'Sweeney', 'bibendum@non.edu', '24071239390', '2021-08-22 19:30:41'),
       ('Imelda', 'Booth', 'rutrum.magna@eueuismodac.org', '18391411105', '2021-11-28 03:55:31'),
       ('Jorden', 'Valencia', 'mauris@pharetra.com', '46726410528', '2020-04-06 03:32:30'),
       ('Russell', 'Mueller', 'mollis@Nunc.ca', '69412998920', '2020-10-21 06:02:21'),
       ('Sophia', 'Oneill', 'Integer.aliquam.adipiscing@elitsed.co.uk', '92262606307', '2021-05-24 09:42:12'),
       ('Patrick', 'Valencia', 'Pellentesque.ultricies@Cras.ca', '16795101587', '2021-07-25 13:46:28');
INSERT INTO "employee" (name, lastname, email, phone_number, edit_time)
VALUES ('Adam', 'Lawson', 'nisi.Cum@nibhenim.co.uk', '52609185585', '2020-10-21 17:36:03'),
       ('Elijah', 'Lee', 'Donec.dignissim.magna@dictum.edu', '86024237617', '2022-01-14 03:50:47'),
       ('Willa', 'Salazar', 'urna@nec.edu', '42678294706', '2021-01-04 02:28:24'),
       ('Lyle', 'Gardner', 'mi.Aliquam@ipsumnunc.ca', '59757590665', '2021-04-04 14:49:47'),
       ('Ashely', 'Day', 'dolor.sit.amet@Uttinciduntvehicula.org', '22952256705', '2020-07-05 12:44:05'),
       ('Kelsie', 'Moore', 'fames.ac@euerosNam.com', '27224885667', '2020-04-29 06:54:15'),
       ('Zia', 'Floyd', 'vitae.erat.vel@laciniavitae.edu', '36026759346', '2020-07-11 19:59:37'),
       ('Lenore', 'Grimes', 'Aliquam.erat.volutpat@diamPellentesque.ca', '89533253861', '2020-03-11 02:36:32'),
       ('Zorita', 'Curry', 'scelerisque.mollis@egetmassaSuspendisse.org', '54972237606', '2021-01-31 20:36:45'),
       ('Neil', 'Prince', 'magna.Sed@elementum.edu', '61008024240', '2021-02-26 05:47:21');

