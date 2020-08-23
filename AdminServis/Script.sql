--<ScriptOptions statementTerminator=";"/>


insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "status", "poslovni_maticni_broj") values ('viktorija', '111', 'violeta', 'marceta', 'ee', 'Ruma', 'registrovan', '123456789');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "status", "poslovni_maticni_broj") values ('savka', '222', 'savanka', 'savic', 'ee', 'Novi Sad', 'cekanje', '0');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "status", "poslovni_maticni_broj") values ('mitar', '333', 'janos', 'janic', 'ee', 'Novi Sad', 'cekanje', '0');

insert into "public"."marka_vozila" ("marka") values ('BMW');
insert into "public"."marka_vozila" ("marka") values ('Audi');
insert into "public"."marka_vozila" ("marka") values ('Mercedes');
insert into "public"."marka_vozila" ("marka") values ('Tesla');
insert into "public"."marka_vozila" ("marka") values ('Yugo');

insert into "public"."model_vozila" ("model") values ('M5');
insert into "public"."model_vozila" ("model") values ('R8');

insert into "public"."vrsta_goriva" ("gorivo") values ('benzin');
insert into "public"."vrsta_goriva" ("gorivo") values ('plin');
insert into "public"."vrsta_goriva" ("gorivo") values ('dizel');

insert into "public"."tip_menjaca" ("menjac") values ('automatski');
insert into "public"."tip_menjaca" ("menjac") values ('manuelni');
insert into "public"."tip_menjaca" ("menjac") values ('poluautomatski');

insert into "public"."klasa_automobila" ("klasa") values ('SUV');
insert into "public"."klasa_automobila" ("klasa") values ('old tajmer');
insert into "public"."klasa_automobila" ("klasa") values ('gradski auto');

insert into "public"."administrator" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values('Violeta', '111', 'Violeta', 'Marceta', 'violetamarceta1995@gmail.com', 'Ruma');