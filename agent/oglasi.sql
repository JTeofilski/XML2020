insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver","slike") values('jugo', 'jugic', 'Marka', 'Model','benzin','manuelni',220,1,56,false,'slike/jugic1.jpg;slike/jugic.jpg');
insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver","slike") values('bmw', 'mercedeees', 'Marka', 'Model','dizel','automatski',220,1,56,false,'slike/crno_mece1.jpg;slike/crno_mece.jpg');
insert into "public"."vozilo" ("klasa_vozila", "naziv_klase", "naziv_marke", "naziv_modela", "naziv_vrste_goriva", "naziv_tipa_menjaca", "predjena_kilometraza","broj_sedista_za_decu", "ogranicenje_kilometraze","collisiondamage_waiver","slike") values('bmw', 'mercedeees bbb', 'Marka', 'Model','dizel','automatski',210,1,56,false,'slike/crno_mece1.jpg;slike/crno_mece.jpg');

insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "poslovni_maticni_broj") values ('viktorija', '111', 'violeta', 'marceta', 'ee', 'Ruma', 1);
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "poslovni_maticni_broj") values ('savcica', '222', 'savka', 'savic', 'ee', 'Novi Sad', 2);
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "poslovni_maticni_broj") values ('mitar', '333', 'janos', 'janic', 'ee', 'Novi Sad', 3);

insert into "public"."cenovnik" ("cena_za_dan", "cena_vise_od30", "cena_po_kilometru_za_ogranicenu_kilometrazu") values(100, 500, 300);
insert into "public"."cenovnik" ("cena_za_dan", "cena_vise_od30", "cena_po_kilometru_za_ogranicenu_kilometrazu") values(150, 500, 300);


insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj",  "cenovnik_identifikacioni_broj") values(1, 1, 1);
insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj",  "cenovnik_identifikacioni_broj") values(2, 1, 1);
insert into "public"."oglas" ("vozilo_identifikacioni_broj", "agent_identifikacioni_broj",  "cenovnik_identifikacioni_broj") values(3, 2, 2);

--insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('8/8/2020', '10/8/2020', 1);
--insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('20/8/2020', '30/8/2020', 1);
--insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('18/8/2020', '19/8/2020', 2);
--insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('1/8/2020', '15/8/2020', 3);

insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('8/8/2020', '8/10/2020', 1);
insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('8/20/2020', '8/30/2020', 1);
insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('8/18/2020', '8/19/2020', 2);
insert into "public"."rezervisani_datumi" ("datum_od", "datum_do", "oglas") values ('8/1/2020', '8/15/2020', 3);

insert into "public"."korpa" ("identifikacioni_broj") values(1);

insert into "public"."registrovani_korisnik" ("adresa", "email", "ime", "korisnicko_ime", "lozinka", "prezime", "status", "korpa_id") values ('Zrenjanin', 'ee.gmail', 'Dragana', 'draga', '1155','Misic', 'aktivan', 1);

insert into "public"."zahtev_za_iznajmljivanje" ("agent_firmaid","bundle","datumod","datumdo","registrovani_korisnkid","status_iznajmljivanja","ukupna_cena") values (1, true, '8/12/2020', '8/14/2020', 1, 'PAID', 100);

insert into "public"."poruka" ("identifikacioni_broj", "text", "zahtev_identifikacioni_broj") values(1, 'poslata poruka', 1);
