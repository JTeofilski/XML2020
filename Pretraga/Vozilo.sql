--<ScriptOptions statementTerminator=";"/>

insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver") values('jugo', 'jugic', 'Marka', 'Model','Gorivo','Menjac',220,1,56,false);
insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver") values('bmw', 'mercedeees', 'Marka', 'Model','Gorivo','Menjac',220,1,56,false);

insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values ('viktorija', '111', 'violeta', 'marceta', 'ee', 'Ruma');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values ('savka', '222', 'savanka', 'savic', 'ee', 'Novi Sad');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values ('mitar', '333', 'janos', 'janic', 'ee', 'Novi Sad');

insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj", "vozilo_slobodno_od", "vozilo_slobodno_do") values(1, 1, '8/1/2020', '8/9/2020');
insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj", "vozilo_slobodno_od", "vozilo_slobodno_do") values(2, 2, '8/4/2020', '8/7/2020');
insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj", "vozilo_slobodno_od", "vozilo_slobodno_do") values(2, 3, '10/8/2020', '11/8/2020');

