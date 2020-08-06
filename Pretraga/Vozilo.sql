--<ScriptOptions statementTerminator=";"/>

insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver","slike") values('jugo', 'jugic', 'Marka', 'Model','benzin','manuelni',220,1,56,false,'slike/jugic1.jpg;slike/jugic.jpg');
insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver","slike") values('bmw', 'mercedeees', 'Marka', 'Model','dizel','automatski',220,1,56,false,'slike/crno_mece1.jpg;slike/crno_mece.jpg');
insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver","slike") values('bmw', 'mercedeees bbb', 'Marka', 'Model','dizel','automatski',210,1,56,false,'slike/crno_mece1.jpg;slike/crno_mece.jpg');

insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values ('viktorija', '111', 'violeta', 'marceta', 'ee', 'Ruma');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values ('savka', '222', 'savanka', 'savic', 'ee', 'Novi Sad');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values ('mitar', '333', 'janos', 'janic', 'ee', 'Novi Sad');

insert into "public"."cenovnik" ("cena_za_dan", "cena_vise_od30", "cena_po_kilometru_za_ogranicenu_kilometrazu") values(100, 500, 300);
insert into "public"."cenovnik" ("cena_za_dan", "cena_vise_od30", "cena_po_kilometru_za_ogranicenu_kilometrazu") values(150, 500, 300);

insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj", "vozilo_slobodno_od", "vozilo_slobodno_do", "cenovnik_identifikacioni_broj") values(1, 1, '8/1/2020', '8/9/2020', 1);
insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj", "vozilo_slobodno_od", "vozilo_slobodno_do", "cenovnik_identifikacioni_broj") values(2, 2, '8/4/2020', '8/7/2020', 1);
insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj", "vozilo_slobodno_od", "vozilo_slobodno_do", "cenovnik_identifikacioni_broj") values(3, 3, '8/3/2020', '8/20/2020', 2);

--insert into "public"."korpa" ("identifikacioni_broj") values(1)

