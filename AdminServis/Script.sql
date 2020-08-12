--<ScriptOptions statementTerminator=";"/>

insert into "public"."korisnici_tbl" ("id", "adresa", "email", "ime", "kime", "lozinka", "prezime", "status") values(3, 'nedodjija', '@mail', 'Perica', 'perazdera', 'pass', 'Peric', 'cekanje');
insert into "public"."korisnici_tbl" ("id", "adresa", "email", "ime", "kime", "lozinka", "prezime", "status") values(8, 'nedodjija', '@mail', 'Perica', 'perazdera', 'pass', 'Peric', 'cekanje');

insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "status", "poslovni_maticni_broj") values ('viktorija', '111', 'violeta', 'marceta', 'ee', 'Ruma', 'cekanje', '0');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "status", "poslovni_maticni_broj") values ('savka', '222', 'savanka', 'savic', 'ee', 'Novi Sad', 'cekanje', '0');
insert into "public"."agent" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa", "status", "poslovni_maticni_broj") values ('mitar', '333', 'janos', 'janic', 'ee', 'Novi Sad', 'cekanje', '0');

insert into "public"."administrator" ("korisnicko_ime", "lozinka", "ime", "prezime", "email", "adresa") values('Violeta', '111', 'Violeta', 'Marceta', 'violetamarceta1995@gmail.com', 'Ruma');